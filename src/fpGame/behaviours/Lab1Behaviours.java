package fpGame.behaviours;

//java imports
import java.util.List;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

//intraproject imports
import fpGame.GameUtil;
import fpGame.Inventory;
import fpModel.RoomObject;
import fpModel.GenericObject;
import fpModel.WrapperObject;
import fpModel.InfoObject;
import fpModel.ContainerObject;
import fpModel.DoorObject;

public class Lab1Behaviours {
	public static EventHandler<MouseEvent> CPBehavior(InfoObject cp) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				
			}
		};
		
		return behaviour;
	}
	
	public static void addBehaviours(List<RoomObject> objects) {
		for (RoomObject r : objects) {
			
		}
	}
}
