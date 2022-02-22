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

public class AdditionJurnalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextArea Text1;

    @FXML
    private TextArea Text2;

    @FXML
    private URL location;

    @FXML
    private Button backup;

    @FXML
    private Button button_back;

    @FXML
    private TableColumn<Addition_jurnal, String> date;

    @FXML
    private TableColumn<Addition_jurnal, String> date1;

    @FXML
    public TextField id_admin_field;

    @FXML
    private TableColumn<Addition_jurnal, Integer> idadmincolum;

    @FXML
    private TableColumn<Addition_jurnal, Integer> idbookcolum;

    @FXML
    private TableColumn<Addition_jurnal, Integer> idcolum;

    @FXML
    private TableColumn<Addition_jurnal, Integer> idrepresentative;

    @FXML
    private TableColumn<Addition_jurnal, Integer> idadmincolum1;

    @FXML
    private TableColumn<Addition_jurnal, Integer> idbookcolum1;

    @FXML
    private TableColumn<Addition_jurnal, Integer> idcolum1;

    @FXML
    private TableColumn<Addition_jurnal, Integer> idrepresentative1;

    @FXML
    private TextArea nameid;

    @FXML
    private TableColumn<Addition_jurnal, String> statuscolum;

    @FXML
    private TableColumn<Addition_jurnal, String> statuscolum1;

    public Integer id_user;

    @FXML
    private TableView<Addition_jurnal> table;

    @FXML
    private TableView<Addition_jurnal> table1;

    @FXML
    private Button viewbutton;

    @FXML
    void initialize() {
        button_back.setOnAction(event ->{
            back();
        } );
        viewbutton.setOnAction(event ->{
            try {
                view();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } );
        backup.setOnAction(event ->{
            int selectedID = table.getSelectionModel().getSelectedIndex();
            ObservableList<Addition_jurnal> books = table.getItems();
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            dataBaseConnection.call_ad(books.get(selectedID).getId());
            alert("Выбранное значение возвращено");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addition_jurnal.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                AdditionJurnalController additionJurnalController = fxmlLoader.getController();

                additionJurnalController.id_admin_field.setText(this.id_admin_field.getText());

                additionJurnalController.id_user=this.id_user;


                Stage window = (Stage) backup.getScene().getWindow();
                window.setScene(new Scene(root, 600, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @FXML
    private void alert(String s){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка введения публикации или издательства");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }
    @FXML
    public void back() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainAdminWindow.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            AdminController adminC = fxmlLoader.getController();
            adminC.id=id_user;
            adminC.id_admin_field.setText(this.id_admin_field.getText());
            Stage window = (Stage) button_back.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();

        }
}
    @FXML
    public void view() throws SQLException {

        viewbutton.setVisible(false);
        table.setVisible(true);
        table1.setVisible(true);
        backup.setVisible(true);
        Text1.setVisible(true);
        Text2.setVisible(true);

        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        ResultSet resultSet = dataBaseConnection.get_admin_jurnal(id_user);


        Addition_jurnal addition_jurnal = new Addition_jurnal();

        idcolum.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, Integer>("id"));
        idbookcolum.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, Integer>("idbook"));
        date.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, String>("date"));
        idadmincolum.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, Integer>("idadmin"));
        idrepresentative.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, Integer>("idrepresentative"));
        statuscolum.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, String>("status"));

        ObservableList<Addition_jurnal> books = table.getItems();

        while (true) {
            if( !resultSet.next())break;

            addition_jurnal.setId(resultSet.getInt(2));
            addition_jurnal.setIdbook(resultSet.getInt(3));
            addition_jurnal.setDate(resultSet.getString(4));
            addition_jurnal.setIdadmin(resultSet.getInt(5));
            addition_jurnal.setIdrepresentative(resultSet.getInt(6));
            addition_jurnal.setStatus(resultSet.getString(8));


            books.add(addition_jurnal);
            table.setItems(books);
            addition_jurnal = new Addition_jurnal();
        }

         dataBaseConnection = new DataBaseConnection();

         resultSet = dataBaseConnection.get_admin_jurnal1(id_user);


         addition_jurnal = new Addition_jurnal();

        idcolum1.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, Integer>("id"));
        idbookcolum1.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, Integer>("idbook"));
        date1.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, String>("date"));
        idadmincolum1.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, Integer>("idadmin"));
        idrepresentative1.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, Integer>("idrepresentative"));
        statuscolum1.setCellValueFactory(new PropertyValueFactory<Addition_jurnal, String>("status"));

        ObservableList<Addition_jurnal> books1 = table1.getItems();

        while (true) {
            if( !resultSet.next())break;

            addition_jurnal.setId(resultSet.getInt(1));
            addition_jurnal.setIdbook(resultSet.getInt(2));
            addition_jurnal.setDate(resultSet.getString(3));
            addition_jurnal.setIdadmin(resultSet.getInt(4));
            addition_jurnal.setIdrepresentative(resultSet.getInt(5));
            addition_jurnal.setStatus(resultSet.getString(6));


            books1.add(addition_jurnal);
            table1.setItems(books1);
            addition_jurnal = new Addition_jurnal();
        }
    }
}


