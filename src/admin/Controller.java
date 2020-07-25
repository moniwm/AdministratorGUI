package admin;

import AdminClient.AdminClient;
import AdminClient.Users;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Scene mainPage;

    public Button btnUsers;
    public Button btnChefs;
    public Label labelTitle;
    public TextField adminEmail;
    public PasswordField adminPassword;
    public VBox canvas;
    public Text welcome;
    public Text administratorText;

    private TableView<Users> usersTable = new TableView<Users>();
    private TableView<Users> chefsTable = new TableView<Users>();
    private AdminClient adminClient = new AdminClient();
    private boolean isChefPressed = false;
    private boolean isUsersPressed = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void logIn(ActionEvent actionEvent) throws Exception {

        System.out.println(adminEmail.getText());
        System.out.println(adminPassword.getText());
        getUpdatedUsers();

        changeScene(actionEvent, "mainPage.fxml",1260,630);

    }

    public void logOut(ActionEvent actionEvent) throws IOException {

        changeScene(actionEvent, "loginPage.fxml",1280,776);
    }

    public void goToMain(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "mainPage.fxml",1260,630);
    }

    public void close(MouseEvent mouseEvent) {

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.close();
    }


    public void userPressed() throws Exception {

        btnUsers.setStyle("-fx-background-color:  #8B77A6");
        btnChefs.setStyle("-fx-background-color: transparent");

        labelTitle.setText("REGISTERED USERS");

        removeWelcomeMessage();


        TableColumn<Users, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(350);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Users, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(335);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Users, Boolean> chefColumn = new TableColumn<>("Chef");
        chefColumn.setMinWidth(150);
        chefColumn.setCellValueFactory(new PropertyValueFactory<>("chef"));

        TableColumn<Users, Boolean> adminColumn = new TableColumn<>("Admin");
        adminColumn.setMinWidth(150);
        adminColumn.setCellValueFactory(new PropertyValueFactory<>("admin"));

        this.usersTable.setItems(this.getUpdatedUsers());
        this.usersTable.getColumns().addAll(nameColumn, emailColumn, chefColumn, adminColumn);

        canvas.getChildren().remove(usersTable);
        canvas.getChildren().add(usersTable);

    }

    public void chefsPressed() {

        btnChefs.setStyle("-fx-background-color:  #8B77A6");
        btnUsers.setStyle("-fx-background-color: transparent");

        labelTitle.setText("CHEF REQUESTS");

        removeWelcomeMessage();
        canvas.getChildren().remove(usersTable);

    }

    private void changeScene(ActionEvent actionEvent, String fxmlFile, int width, int height) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));

        mainPage = new Scene(root, width, height);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(mainPage);
        window.show();
        window.centerOnScreen();

    }

    private ObservableList<Users> getUpdatedUsers() throws Exception {
        return adminClient.getRegisteredUsers();
    }

    private void displayAlertBox() throws IOException {
        Stage alertBox = new Stage();
        alertBox.initStyle(StageStyle.TRANSPARENT);
        alertBox.centerOnScreen();

        alertBox.initModality(Modality.APPLICATION_MODAL);

        Scene alertBoxScene = new Scene(FXMLLoader.load(getClass().getResource("checkBox.fxml")),300,200);
        alertBox.setScene(alertBoxScene);

        alertBox.show();
    }

    public void closeAlert(ActionEvent actionEvent) {
        Stage alertBox= (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        alertBox.close();
    }

    public void removeWelcomeMessage(){
        canvas.getChildren().removeAll(welcome, administratorText);
    }

}
