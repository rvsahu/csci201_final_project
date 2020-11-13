package fpGUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu {
	public static void show(Stage stage, String name) {
		Text txt = new Text();
        txt.setText("Hello, " + name+"!\nWelcome Back!");
        
        StackPane.setAlignment(txt, Pos.TOP_CENTER);
        
        
        Button btn1 = new Button();
        btn1.setText("Resume Gameplay");
        Button btn2 = new Button();
        btn2.setText("Start New Game");
        
        
        GridPane root = new GridPane();
        root.add(txt, 0, 0);
        root.add(btn1, 0, 1);
        root.add(btn2, 0, 2);

        
        stage.setScene(new Scene(root, 400, 400));
    	stage.setTitle("Main Menu!");
    	stage.show();
	}
}
