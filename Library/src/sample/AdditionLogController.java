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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdditionLogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnid;

    @FXML
    private TextArea nameid;

    @FXML
    private TableColumn<book_backup, String> status;

    @FXML
    private TableView<book_backup> table;

    @FXML
    private TableColumn<book_backup, Integer> price;

    @FXML
    private TableColumn<book_backup, String> purpose;

    @FXML
    private TableColumn<book_backup, String> idrepresetive;

    @FXML
    private TableColumn<book_backup, Integer> idbook;

    @FXML
    private TableColumn<book_backup, String> idpublication;

    @FXML
    private TableColumn<book_backup, String> name;

    @FXML
    private TableColumn<book_backup, Integer> id;

    @FXML
    private TableColumn<book_backup, String> action;

    @FXML
    private TableColumn<book_backup, String> Type_of_content;

    @FXML
    private TableColumn<book_backup, String> author;

    public int id_user;

    @FXML
    private Button returnMore;

    @FXML
    private Button back;

    @FXML
    public TextArea id_admin_field;

    @FXML
    void initialize() throws SQLException {
        returnMore.setOnAction(event ->{

            int selectedID = table.getSelectionModel().getSelectedIndex();
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            ObservableList<book_backup> books = table.getItems();
            ResultSet resultSet = dataBaseConnection.getbook_backupidW(books.get(selectedID).getId());

            try {
                resultSet.afterLast();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            while(true) {
                try {
                    resultSet.previous();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (resultSet.isBeforeFirst()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    dataBaseConnection.call_backup(resultSet.getInt(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addition_log.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                AdditionLogController additionLogController = fxmlLoader.getController();

                additionLogController.id_admin_field.setText(this.id_admin_field.getText());

                additionLogController.id_user=this.id_user;


                Stage window = (Stage) returnid.getScene().getWindow();
                window.setScene(new Scene(root, 855, 400));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        returnid.setOnAction(event ->{
            int selectedID = table.getSelectionModel().getSelectedIndex();
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            book_backup book_back = new book_backup();
            ObservableList<book_backup> books = table.getItems();

            dataBaseConnection.call_backup(books.get(selectedID).getId());
            alert("Выбранное значение возвращено");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addition_log.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                AdditionLogController additionLogController = fxmlLoader.getController();

                additionLogController.id_admin_field.setText(this.id_admin_field.getText());

                additionLogController.id_user=this.id_user;


                Stage window = (Stage) returnid.getScene().getWindow();
                window.setScene(new Scene(root, 855, 400));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        back.setOnAction(event ->{
            back();
        } );

        book_backup book_back = new book_backup();

        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        ResultSet resultSet = dataBaseConnection.getbook_backup();

            id.setCellValueFactory(new PropertyValueFactory<book_backup, Integer>("id"));
            idbook.setCellValueFactory(new PropertyValueFactory<book_backup, Integer>("id_book"));
            name.setCellValueFactory(new PropertyValueFactory<book_backup, String>("name"));
            author.setCellValueFactory(new PropertyValueFactory<book_backup, String>("author"));
            idpublication.setCellValueFactory(new PropertyValueFactory<book_backup, String>("viewpublication"));
            idrepresetive.setCellValueFactory(new PropertyValueFactory<book_backup, String>("viewrepresentative"));
            purpose.setCellValueFactory(new PropertyValueFactory<book_backup, String>("purpose"));
            Type_of_content.setCellValueFactory(new PropertyValueFactory<book_backup, String>("Type_of_content"));
            action.setCellValueFactory(new PropertyValueFactory<book_backup, String>("action"));
            status.setCellValueFactory(new PropertyValueFactory<book_backup, String>("status"));



            ObservableList<book_backup> book_backups = table.getItems();
            while (true) {
               if( !resultSet.next())break;

                book_back.setId(resultSet.getInt(1));
                book_back.setId_book(resultSet.getInt(2));
                book_back.setName(resultSet.getString(3));
                book_back.setAuthor(resultSet.getString(4));
                ResultSet resultSet2 = dataBaseConnection.get_publication(resultSet.getInt(5));
                resultSet2.next();

                String pub = resultSet2.getString(2)+" "+resultSet2.getString(3)+" "+resultSet2.getString(4);

                book_back.setViewpublication(pub);

                ResultSet resultSet3 = dataBaseConnection.get_representative(resultSet.getInt(6));
                resultSet3.next();

                String rep = resultSet3.getString(2)+" "+resultSet2.getString(3);


                book_back.setViewrepresentative(rep);
                book_back.setPurpose(resultSet.getString(7));
                book_back.setType_of_content(resultSet.getString(8));
                book_back.setAction(resultSet.getString(9));
                book_back.setStatus(resultSet.getString(10));


                book_backups.add(book_back);
                table.setItems(book_backups);
                book_back = new book_backup();
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
    @FXML
    private void alert(String s){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка введения публикации или издательства");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

}
