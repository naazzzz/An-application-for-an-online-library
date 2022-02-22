package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea nameid;

    @FXML
    private Button button_add;

    @FXML
    private Button button_jurnal;

    @FXML
    private Button batton_bd;

    @FXML
    private TextField id_admin_field1;

    @FXML
    private Button id_jurnal;

    @FXML
    private Button back;

    @FXML
    private Button Users_books;

    @FXML
    public TextField id_admin_field;;

    @FXML
    private Button IMP_EXP;

    public int id;

    @FXML
    void initialize() {

        back.setOnAction(event ->{
            back();
        } );

        IMP_EXP.setOnAction(event ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Import_and_explort_BD.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                ImportAndExplortBD IE = fxmlLoader.getController();

                IE.id_admin_field.setText(this.id_admin_field.getText());

                IE.id_user=this.id;

                Stage window = (Stage) IMP_EXP.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        Users_books.setOnAction(event ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin_view_users_books.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                AdminViewUsersBooks adminViewUsersBooks = fxmlLoader.getController();

                adminViewUsersBooks.id_admin_field.setText(this.id_admin_field.getText());

                adminViewUsersBooks.id_user=this.id;

                Stage window = (Stage) Users_books.getScene().getWindow();
                window.setScene(new Scene(root, 800, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        id_jurnal.setOnAction(event ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addition_jurnal.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                AdditionJurnalController addition_jurnal = fxmlLoader.getController();

                addition_jurnal.id_admin_field.setText(this.id_admin_field.getText());

                addition_jurnal.id_user=this.id;

                Stage window = (Stage) button_add.getScene().getWindow();
                window.setScene(new Scene(root, 600, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        button_jurnal.setOnAction(event ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addition_log.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                AdditionLogController additionLogController = fxmlLoader.getController();

                additionLogController.id_admin_field.setText(this.id_admin_field.getText());

                additionLogController.id_user=this.id;


                Stage window = (Stage) button_add.getScene().getWindow();
                window.setScene(new Scene(root, 855, 400));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );


        button_add.setOnAction(event ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_book.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                AddBook addBook = fxmlLoader.getController();

                addBook.id_admin_field.setText(this.id_admin_field.getText());

                addBook.id_user=this.id;

                Stage window = (Stage) button_add.getScene().getWindow();
                window.setScene(new Scene(root, 600, 450));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        batton_bd.setOnAction(event ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("basedate_book.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                BasedateBookController basedateBookController = fxmlLoader.getController();

                basedateBookController.id_admin_field.setText(this.id_admin_field.getText());

                basedateBookController.id_user=this.id;


                Stage window = (Stage) batton_bd.getScene().getWindow();
                window.setScene(new Scene(root, 780, 500));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );


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
    public void back() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Auth.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage window = (Stage) back.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
