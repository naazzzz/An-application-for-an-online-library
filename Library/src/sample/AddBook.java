package sample;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class AddBook {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_back;

    @FXML
    private TextArea nameid;

    @FXML
    private TextField name;

    @FXML
    private TextField author;

    @FXML
    private TextField publication;

    @FXML
    private TextField representative;

    @FXML
    private TextField purpose;

    @FXML
    private TextField type_of_content;

    @FXML
    private Button button_adding;

    @FXML
    private TextField price;

    @FXML
    public TextField id_admin_field;

    @FXML
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @FXML
    public int id_user;

    public int getId_user() {
        return id_user;
    }

    @FXML
    void initialize() {

        button_back.setOnAction(event ->{
            back();
        } );
        button_adding.setOnAction(event ->{
            try {
                add_book();
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
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
    @FXML
    public void add_book() throws SQLException, IOException {
        //добавление книги
        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        Book book = new Book();
        book.setName(name.getText());
        book.setAuthor(author.getText());
        book.setStatus("valid");

        book.setPurpose(purpose.getText());
        book.setType_of_content(type_of_content.getText());

        String Publication = publication.getText();

        try {


            String[] words = Publication.split(" ");


            Publication PUBlication = new Publication();
            PUBlication.setName(words[0]);
            PUBlication.setDate(words[1]);
            PUBlication.setPlace(words[2]);
            PUBlication.setStatus("valid");
            ResultSet result = dataBaseConnection.getPublication(PUBlication);



        int counter =0;

        while(true){
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }
        if(counter>=1){
            ResultSet result00 = dataBaseConnection.getPublication(PUBlication);
            result00.next();
            int a=result00.getInt(1);
            book.setPublication(a);
        }
        else{
            dataBaseConnection.set_publication(PUBlication);
            ResultSet result1 = dataBaseConnection.getPublication(PUBlication);
            result1.next();
            int a=result1.getInt(1);
            book.setPublication(a);
        }

        String Representative = representative.getText();
        String[] words1 = Representative.split(" ");


        Representative REPresentative = new Representative();
        REPresentative.setName(words[0]);
        REPresentative.setFooting(words[1]);
        REPresentative.setStatus("valid");

        ResultSet result2 = dataBaseConnection.getRepresentative(REPresentative);

        int counter1 =0;

        while(true){
            try {
                if (!result2.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter1++;
        }

        if(counter1>=1){
            ResultSet result01 = dataBaseConnection.getRepresentative(REPresentative);
            result01.next();
            int a=result01.getInt(1);
            book.setRepresentative(a);
        }
        else{
            dataBaseConnection.set_representative(REPresentative);
            ResultSet result3 = dataBaseConnection.getRepresentative(REPresentative);
            result3.next();
            int a=result3.getInt(1);
            book.setRepresentative(a);
        }
        dataBaseConnection.add_book(book);


        Addition_jurnal addition_jurnal = new Addition_jurnal();
        addition_jurnal.setStatus("valid");
        addition_jurnal.setDate();
        addition_jurnal.setIdadmin(id_user);

        ResultSet resultSet22 = dataBaseConnection.getbookid(book);

        resultSet22.next();

        addition_jurnal.setIdbook(resultSet22.getInt(1));

        addition_jurnal.setIdrepresentative(resultSet22.getInt(5));

            dataBaseConnection.set_addition_jurnal(addition_jurnal);

            alert("Книга добавлена!");
            back();
        }catch (ArrayIndexOutOfBoundsException error){
            alert("Для корректного введения необходимо ввести все данные через пробел. Например: Эксмо 2021 Москва.");
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
