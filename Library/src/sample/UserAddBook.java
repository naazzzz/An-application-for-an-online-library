package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
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

public class UserAddBook {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_button;

    @FXML
    private TableColumn<Book, String> authortable;

    @FXML
    private Button back;

    @FXML
    private TextArea nameid;

    @FXML
    private TableColumn<Book, String> nametable;

    @FXML
    private TableColumn<Book, String> naz_table;

    @FXML
    private TableColumn<Book, String> pred_table;

    @FXML
    private TableColumn<Book, String> pubtable;

    @FXML
    private TableView<Book> table;

    @FXML
    private TableColumn<Book, String> type_of_content_table;

    @FXML
    public TextField userid_field;

    public Integer id_user;

    @FXML
    void initialize() throws SQLException {
        back.setOnAction(event ->{
            back();
        } );

        add_button.setOnAction(event ->{
            int selectedID = table.getSelectionModel().getSelectedIndex();
            ObservableList<Book> books = table.getItems();
            DataBaseConnection dataBaseConnection = new DataBaseConnection();

            ResultSet resultSet =dataBaseConnection.getbookid(books.get(selectedID));
            try {
                resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Users_jurnal users_jurnal = new Users_jurnal();
        users_jurnal.setDate();
            try {
                users_jurnal.setIdbook(resultSet.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            users_jurnal.setIduser(id_user);

            dataBaseConnection.add_users_jurnal(users_jurnal);
        } );


        Book book = new Book() ;

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        ResultSet resultSet = dataBaseConnection.getbook();

        nametable.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        authortable.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        pubtable.setCellValueFactory(new PropertyValueFactory<Book, String>("viewpublication"));
        pred_table.setCellValueFactory(new PropertyValueFactory<Book, String>("viewrepresentative"));
        naz_table.setCellValueFactory(new PropertyValueFactory<Book, String>("purpose"));
        type_of_content_table.setCellValueFactory(new PropertyValueFactory<Book, String>("type_of_content"));

        ObservableList<Book> books = table.getItems();

        while (true) {
            if( !resultSet.next())break;

            book.setName(resultSet.getString(2));
            book.setAuthor(resultSet.getString(3));
            ResultSet resultSet2 = dataBaseConnection.get_publication(resultSet.getInt(4));
            resultSet2.next();

            String pub = resultSet2.getString(2)+" "+resultSet2.getString(3)+" "+resultSet2.getString(4);

            book.setViewpublication(pub);

            ResultSet resultSet3 = dataBaseConnection.get_representative(resultSet.getInt(5));
            resultSet3.next();

            String rep = resultSet3.getString(2)+" "+resultSet2.getString(3);


            book.setViewrepresentative(rep);
            book.setPurpose(resultSet.getString(6));
            book.setType_of_content(resultSet.getString(7));


            books.add(book);
            table.setItems(books);
            book = new Book();
        }

    }
    @FXML
    public void back() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            userController userController = fxmlLoader.getController();
            userController.id=id_user;
            userController.userid_field.setText(this.userid_field.getText());
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
