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

    public String getEmail(){
        return this.email;
    }

    public String getText(){
        return this.text;
    }

   public Button getButton(){
        return this.button;
   }

    @Override
    public String toString() {
        return "ChefRequest{" +
                "email='" + email + '\'' +
                ", text='" + text + '\'' +
                ", button=" + button +
                '}';
    }
}
