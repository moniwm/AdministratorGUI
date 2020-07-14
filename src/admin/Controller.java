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
    Scene loginPage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void logIn(ActionEvent actionEvent) throws IOException {

        Parent mainPageGUI = FXMLLoader.load(getClass().getResource("mainPage.fxml"));

        mainPage = new Scene(mainPageGUI, 1280, 776);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(mainPage);
        window.show();

    }

    public void close(MouseEvent mouseEvent) {

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.close();
    }

    public void logOut(ActionEvent actionEvent) throws IOException {

        Parent loginGUI = FXMLLoader.load(getClass().getResource("loginPage.fxml"));

        loginPage = new Scene(loginGUI, 1280, 776);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(loginPage);
        window.show();
    }
}
