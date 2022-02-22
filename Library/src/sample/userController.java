package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class userController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea nameid;

    @FXML
    private Button user_change_book;

    @FXML
    private Button chack_jurnal;

    @FXML
    public TextField userid_field;

    @FXML
    public int id;

    @FXML
    private Button back;

    @FXML
    void initialize() {
        back.setOnAction(event ->{
            back();
        } );

        chack_jurnal.setOnAction(event ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viev_users_book.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                VievUsersBook vievUsersBook = fxmlLoader.getController();

                vievUsersBook.userid_field.setText(this.userid_field.getText());

                vievUsersBook.id_user=this.id;

                Stage window = (Stage) user_change_book.getScene().getWindow();
                window.setScene(new Scene(root, 680, 400));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

        user_change_book.setOnAction(event ->{
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("user_add_book.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                UserAddBook userAddBook = fxmlLoader.getController();

                userAddBook.userid_field.setText(this.userid_field.getText());

                userAddBook.id_user=this.id;


                Stage window = (Stage) user_change_book.getScene().getWindow();
                window.setScene(new Scene(root, 700, 450));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } );

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
