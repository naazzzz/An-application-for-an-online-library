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

public class VievUsersBook {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    @FXML
    private Button search_button;

    @FXML
    private TextField search_field;

    @FXML
    public Integer id_user;

    @FXML
    private Button viewbutton;

    @FXML
    void initialize() throws SQLException {
        back.setOnAction(event ->{
            System.out.println(id_user);
            back();
        } );

        viewbutton.setOnAction(event ->{
            try {
                view();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } );

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

    @FXML
    public void view() throws SQLException {

        viewbutton.setVisible(false);
        table.setVisible(true);

        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        ResultSet resultSet = dataBaseConnection.get_users_jurnal(id_user);


        System.out.println(id_user);


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

    @FXML
    void search(ActionEvent event) throws SQLException {
        if(search_field.getText().isEmpty()) {
            try {
                if(table.getItems().isEmpty()) {
                    view();
                }
                else {
                    table.getItems().clear();
                    view();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            table.getItems().clear();
            Book book = new Book() ;
            ObservableList<Book> books = table.getItems();
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            ResultSet resultSet = dataBaseConnection.getbookname(search_field.getText());

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
                book.setIdbook(resultSet.getInt(1));
                book.setStatus(resultSet.getString(8));

                books.add(book);
                table.setItems(books);
                book = new Book();
            }

        }

    }
}

