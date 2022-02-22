package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private TextArea nameid;

    @FXML
    private TextField emailregid;

    @FXML
    private TextField passregid;

    @FXML
    private TextField nameregid;

    @FXML
    private TextField pastnameid;

    @FXML
    private Button button2id;

    @FXML
    private TextField codeid;

    @FXML
    private CheckBox checkid;

    @FXML
    private Button buttonbackid1;

    @FXML
    private PasswordField codefield;

    @FXML
    void initialize() {
        button2id.setOnAction(event ->{
            signUpNewUser();
        } );
        checkid.setOnMouseClicked(event ->{
            if (checkid.isSelected()){
                codefield.setVisible(true);
            }
            if (!checkid.isSelected()){
                codefield.setVisible(false);
            }
        });


    }


    @FXML
    public void back() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Auth.fxml"));
            Stage window = (Stage) button2id.getScene().getWindow();
            window.setScene(new Scene(root, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private  void signUpNewUser(){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        String firstName = nameregid.getText();
        String pastName = pastnameid.getText();
        String email = emailregid.getText();
        String password = passregid.getText();


        String a="0000";
        if(checkid.isSelected()){

                Admin admin = new Admin(firstName, pastName, email, password);
                admin.setStatus("valid");
                dataBaseConnection.signUpUser(admin);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Регистрация завершена");
                alert.showAndWait();
                back();
            }

        if(!checkid.isSelected()) {
            User user = new User(firstName, pastName, email, password);
            user.setStatus("valid");
            dataBaseConnection.signUpUser(user);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Регистрация завершена");
            alert.showAndWait();
            back();
        }
    }
    @FXML
    private void alert(String s){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }
}