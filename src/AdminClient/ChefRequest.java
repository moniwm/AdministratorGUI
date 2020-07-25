package AdminClient;

import javafx.scene.control.Button;

public class ChefRequest {

    String email;
    String text;
    Button button;

    public ChefRequest(String email, String text){
        this.email = email;
        this.text = text;
        this.button = new Button("Accept");
    }
}
