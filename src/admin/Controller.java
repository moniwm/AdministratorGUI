package admin;

import AdminClient.AdminClient;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import AdminClient.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Scene mainPage;

    public Button btnUsers;
    public Button btnCompanies;
    public Button btnChefs;
    public Label labelTitle;
    public TextField adminEmail;
    public PasswordField adminPassword;

    private AdminClient adminClient = new AdminClient();
    public AnchorPane anchorLists;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void logIn(ActionEvent actionEvent) throws Exception {

        System.out.println(adminEmail.getText());
        System.out.println(adminPassword.getText());

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


    public void userPressed() {

        btnUsers.setStyle("-fx-background-color:  #8B77A6");
        btnChefs.setStyle("-fx-background-color: transparent");
        btnCompanies.setStyle("-fx-background-color: transparent");

        labelTitle.setText("REGISTERED USERS");

    }

    public void chefsPressed() {

        btnChefs.setStyle("-fx-background-color:  #8B77A6");
        btnUsers.setStyle("-fx-background-color: transparent");
        btnCompanies.setStyle("-fx-background-color: transparent");

        labelTitle.setText("CHEF REQUESTS");

    }


    public void companiesPressed() {

        btnCompanies.setStyle("-fx-background-color:  #8B77A6");
        btnUsers.setStyle("-fx-background-color: transparent");
        btnChefs.setStyle("-fx-background-color: transparent");

        labelTitle.setText("REGISTERED COMPANIES");

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
}
