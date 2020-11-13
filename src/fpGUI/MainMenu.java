package fpGUI;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu {
	public static void show(Stage stage, String name) {
		Text txt = new Text();
        txt.setText("Hello, " + name+"!\nWelcome Back!");
        
        
        GridPane root = new GridPane();
        root.add(txt, 0, 0);
        
        stage.setScene(new Scene(root, 400, 400));
    	stage.setTitle("Main Menu!");
    	stage.show();
	}
}
