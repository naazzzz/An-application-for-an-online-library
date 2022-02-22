package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class BasedateBookController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea nameid;

    @FXML
    private TextField search_field;

    @FXML
    private TableView<Book> table;

    @FXML
    private TableColumn<Book, String> nametable;

    @FXML
    private TableColumn<Book, String> authortable;

    @FXML
    private TableColumn<Book, String> pubtable;

    @FXML
    private TableColumn<Book, String> pred_table;

    @FXML
    private TableColumn<Book, String> naz_table;

    @FXML
    private TableColumn<Book, String> type_of_content_table;

    @FXML
    private TableColumn<Book, Integer> id_table;

    @FXML
    private TableColumn<Book, String> statusid;

    @FXML
    public TextArea id_admin_field;

    @FXML
    private Button change_button;

    @FXML
    private Button search_button;

    @FXML
    private Button back;

    public int id_user;

    @FXML
    void initialize() throws SQLException {
        change_button.setOnAction(event ->{
            try {
                change_book();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } );

        back.setOnAction(event ->{
            back();
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
        id_table.setCellValueFactory(new PropertyValueFactory<Book, Integer>("idbook"));
        statusid.setCellValueFactory(new PropertyValueFactory<Book, String>("status"));


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
            book.setIdbook(resultSet.getInt(1));
            book.setStatus(resultSet.getString(8));

            books.add(book);
            table.setItems(books);
            book = new Book();
        }

        nametable.setCellFactory(
                TextFieldTableCell.forTableColumn());
        nametable.setOnEditCommit(
                (TableColumn.CellEditEvent<Book, String> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue())
        );

        authortable.setCellFactory(
                TextFieldTableCell.forTableColumn());
        authortable.setOnEditCommit(
                (TableColumn.CellEditEvent<Book, String> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setAuthor(t.getNewValue())
        );

        naz_table.setCellFactory(
                TextFieldTableCell.forTableColumn());
        naz_table.setOnEditCommit(
                (TableColumn.CellEditEvent<Book, String> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPurpose(t.getNewValue())
        );

        type_of_content_table.setCellFactory(
                TextFieldTableCell.forTableColumn());
        type_of_content_table.setOnEditCommit(
                (TableColumn.CellEditEvent<Book, String> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPurpose(t.getNewValue())
        );

        pubtable.setCellFactory(
                TextFieldTableCell.forTableColumn());
        pubtable.setOnEditCommit(
                (TableColumn.CellEditEvent<Book, String> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPurpose(t.getNewValue())
        );
        pred_table.setCellFactory(
                TextFieldTableCell.forTableColumn());
        pred_table.setOnEditCommit(
                (TableColumn.CellEditEvent<Book, String> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPurpose(t.getNewValue())
        );



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
    public void change_book() throws SQLException {
        int selectedID = table.getSelectionModel().getSelectedIndex();
        ObservableList<Book> books = table.getItems();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        String str =books.get(selectedID).getViewpublication();
        String[] words = str.split(" ");
        Publication pb = new Publication();
        pb.setName(words[0]);
        pb.setDate(words[1]);
        pb.setPlace(words[2]);
        ResultSet resultSet = dataBaseConnection.getPublication(pb);
        resultSet.next();
        books.get(selectedID).setPublication(resultSet.getInt(1));

         str =books.get(selectedID).getViewrepresentative();
         words = str.split(" ");
        Representative rp = new Representative();
        rp.setName(words[0]);
        rp.setFooting(words[1]);

        ResultSet resultSet1 = dataBaseConnection.getRepresentativeN(rp);
        resultSet1.next();
        books.get(selectedID).setRepresentative(resultSet1.getInt(1));

        dataBaseConnection.change_book(books.get(selectedID));
        alert("Данные изменены");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("basedate_book.fxml"));
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BasedateBookController basedateBookController = fxmlLoader.getController();

        basedateBookController.id_admin_field.setText(this.id_admin_field.getText());

        basedateBookController.id_user=this.id_user;


        Stage window = (Stage) change_button.getScene().getWindow();
        window.setScene(new Scene(root, 780, 500));
    }

    @FXML
    private void alert(String s){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

    @FXML
    void search(ActionEvent event) throws SQLException {
        if(search_field.getText().isEmpty()) {
            try {
                if(table.getItems().isEmpty()) {
                    initialize();
                }
                else {
                    table.getItems().clear();
                    initialize();
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
            ResultSet resultSet11 = dataBaseConnection.getPublicationName(search_field.getText());
            ResultSet resultSet12 = dataBaseConnection.getRepresentativeName(search_field.getText());

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
