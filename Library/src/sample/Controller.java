package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane backgrid;

    @FXML
    private PasswordField passid;

    @FXML
    private TextArea pas;

    @FXML
    private TextArea em;

    @FXML
    private Button buttonid;

    @FXML
    private TextField emailid;

    @FXML
    private TextArea nameid;

    @FXML
    private Button button2id;

    @FXML
    void initialize() {

       buttonid.setOnAction(event -> {
        String loginText = emailid.getText().trim();
        String loginPassword = passid.getText().trim();

           if (!loginText.equals("") && !loginPassword.equals("")) {
               loginUser(loginText, loginPassword);
           }
           else
               alert("Email или пароль пусты.");

       });
    }

    private void loginUser(String loginText, String loginPassword) {
    DataBaseConnection dbHandler = new DataBaseConnection();

        User user = new User();
        user.setEmail(loginText);
        user.setPassword(loginPassword);

        ResultSet result = dbHandler.getUser(user);
        int counter =0;
        int id_user=0;
        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }
        if(counter>=1){
            try {
                ResultSet result12 = dbHandler.getUser(user);
                result12.next();
                id_user = result12.getInt(1);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                userController UC = fxmlLoader.getController();

                UC.userid_field.setText("ID user: "+id_user);
                UC.id=id_user;

                Stage window = (Stage) button2id.getScene().getWindow();
                window.setScene(new Scene(root, 600,400));
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (counter==0) {
            //admmin
            Admin admin = new Admin();
            admin.setEmail(loginText);
            admin.setPassword(loginPassword);

            ResultSet result1 = dbHandler.getUser(admin);
            Integer id_user1 = 0;
            while (true) {
                try {
                    if (!result1.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                counter++;
            }
            if (counter >= 1) {
                try {
                    ResultSet result11 = dbHandler.getUser(admin);
                    result11.next();
                    id_user1 = result11.getInt(1);

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainAdminWindow.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    AdminController adminC = fxmlLoader.getController();

                    adminC.id_admin_field.setText("ID admin: " + id_user1);
                    adminC.id = id_user1;


                    Stage window = (Stage) button2id.getScene().getWindow();
                    window.setScene(new Scene(root, 600, 450));
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if(counter<1){
            alert("Пользователь не найден или данные не верны.");
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

    @FXML
    public void regist() throws Exception{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Reg.fxml"));
            Stage window = (Stage) button2id.getScene().getWindow();
            window.setScene(new Scene(root, 600,400));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }

}
