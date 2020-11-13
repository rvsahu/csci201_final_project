package fpGUI;

import java.io.FileInputStream;
import java.io.IOException;

import fpGame.Setup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import fpModel.*;

public class TestRoom {
	public static void show(Stage stage) {
		Room room = Setup.testRoom();
		
		Pane root = new Pane();
		
		stage.setScene(new Scene(root, 1920, 1080));
    	stage.setTitle("Test Room!");
    	stage.show();
	}
}
