package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class ImportAndExplortBD {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button export;

    @FXML
    private Button imp;

    @FXML
    private Button button_back;

    @FXML
    public TextField id_admin_field;

    @FXML
    private TextArea nameid;

    public int id_user;

    @FXML
    void initialize() {
        button_back.setOnAction(event ->{
            back();
        } );

        imp.setOnAction(event ->{
            File file = new File("C:\\Users\\Artyom\\Desktop\\import.exe");
            ProcessBuilder processBuilder = new ProcessBuilder(file.getAbsolutePath());
            processBuilder.directory(file.getParentFile());
            try {
                processBuilder.start();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } );

        export.setOnAction(event ->{
            File file = new File("C:\\Users\\Artyom\\Desktop\\export.exe");
            ProcessBuilder processBuilder = new ProcessBuilder(file.getAbsolutePath());
            processBuilder.directory(file.getParentFile());
            try {
                processBuilder.start();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } );
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
}