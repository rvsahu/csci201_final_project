package fpGUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {
	public static void show(Stage stage) {
        Button btn1 = new Button();
        btn1.setText("Login");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	MainMenu.show(stage);
                System.out.println("Logged In!");
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("Register");
        Button btn3 = new Button();
        btn3.setText("Seppuku");
        
        Text txt = new Text();
        txt.setText("login!");
        
        
        GridPane root = new GridPane();
        root.add(txt, 0, 0);
        root.add(btn1, 0, 1);
        root.add(btn2, 0, 2);
        root.add(btn3, 0, 3);
        
        stage.setScene(new Scene(root, 400, 400));
    	stage.setTitle("Login!");
    	stage.show();
	}
}
