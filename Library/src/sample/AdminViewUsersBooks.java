package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminViewUsersBooks {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Book, String> authortable;

    @FXML
    private Button back;

    @FXML
    private Button choose_button;

    @FXML
    private TableColumn<User, String> email;

    @FXML
    private TableColumn<User, String> firstname;

    @FXML
    public TextField id_admin_field;

    @FXML
    private TableColumn<User, Integer> idusers;

    @FXML
    private TableColumn<User, String> lastname;

    @FXML
    private TextArea nameid;

    @FXML
    private TableColumn<Book, String> nametable;

    @FXML
    private TableColumn<Book, String> naz_table;

    @FXML
    private TableColumn<User, String> password;

    @FXML
    private TableColumn<Book, String> pred_table;

    @FXML
    private TableColumn<Book, String> pubtable;

    @FXML
    private TableColumn<User, String> status;

    @FXML
    private TableView<Book> table;

    @FXML
    private TableView<User> table1;

    @FXML
    private TableColumn<Book, String> type_of_content_table;

    public int id_user;

    @FXML
    void initialize() throws SQLException {
        back.setOnAction(event ->{
            back();
        } );

        choose_button.setOnAction(event ->{
            try {
                table.getItems().clear();
                select();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } );

        User user = new User() ;

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        ResultSet resultSet = dataBaseConnection.getUser();

        idusers.setCellValueFactory(new PropertyValueFactory<User, Integer>("idusers"));
        firstname.setCellValueFactory(new PropertyValueFactory<User, String>("firstName"));
        lastname.setCellValueFactory(new PropertyValueFactory<User, String>("lastName"));
        email.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        password.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        status.setCellValueFactory(new PropertyValueFactory<User, String>("status"));


        ObservableList<User> users = table1.getItems();

        while (true) {
            if( !resultSet.next())break;

            user.setIdusers(resultSet.getInt(1));
            user.setFirstName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setPassword(resultSet.getString(5));
            user.setStatus(resultSet.getString(6));

            users.add(user);
            table1.setItems(users);
            user = new User();
        }
    }
    @FXML
    public void back() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainAdminWindow.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            AdminController adminC = fxmlLoader.getController();
            adminC.id=id_user;
            adminC.id_admin_field.setText(this.id_admin_field.getText());
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    void select() throws SQLException {
        int selectedID = table1.getSelectionModel().getSelectedIndex();
        ObservableList<User> users = table1.getItems();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        ResultSet resultSet = dataBaseConnection.get_users_jurnal(users.get(selectedID).getIdusers());
        Book book = new Book() ;

        nametable.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        authortable.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        pubtable.setCellValueFactory(new PropertyValueFactory<Book, String>("viewpublication"));
        pred_table.setCellValueFactory(new PropertyValueFactory<Book, String>("viewrepresentative"));
        naz_table.setCellValueFactory(new PropertyValueFactory<Book, String>("purpose"));
        type_of_content_table.setCellValueFactory(new PropertyValueFactory<Book, String>("type_of_content"));

        ObservableList<Book> books = table.getItems();

        while (true) {
            if( !resultSet.next())break;
            ResultSet resultSet1 =dataBaseConnection.getbook_only_id(resultSet.getInt(1));

            resultSet1.next();
            book.setName(resultSet1.getString(2));
            book.setAuthor(resultSet1.getString(3));

            ResultSet resultSet2 = dataBaseConnection.get_publication(resultSet1.getInt(4));
            resultSet2.next();

            String pub = resultSet2.getString(2)+" "+resultSet2.getString(3)+" "+resultSet2.getString(4);

            book.setViewpublication(pub);

            ResultSet resultSet3 = dataBaseConnection.get_representative(resultSet1.getInt(5));
            resultSet3.next();

            String rep = resultSet3.getString(2)+" "+resultSet2.getString(3);


            book.setViewrepresentative(rep);

            book.setPurpose(resultSet1.getString(6));
            book.setType_of_content(resultSet1.getString(7));


            books.add(book);
            table.setItems(books);
            book = new Book();
        }

    }

}
