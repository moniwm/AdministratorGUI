package admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Scene mainPage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void logIn(ActionEvent actionEvent) throws IOException {

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


    public void userPressed(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "users.fxml",1000,600);
    }

    public void chefsPressed(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "chefRequest.fxml",1000,600);
    }

    public void companiesPressed(ActionEvent actionEvent) throws IOException {
        changeScene(actionEvent, "companies.fxml",1000,600);

    }

    private void changeScene(ActionEvent actionEvent, String fxmlFile, int width, int height) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));

        mainPage = new Scene(root, width, height);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(mainPage);
        window.show();
        window.centerOnScreen();

    }

}
