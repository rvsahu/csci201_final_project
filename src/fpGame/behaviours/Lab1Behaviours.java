package fpGame.behaviours;

//java imports
import java.io.FileInputStream;
import java.io.IOException;

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
import fpModel.Perspective;
import fpModel.Room;
import fpModel.GenericObject;
import fpModel.WrapperObject;
import fpModel.InfoObject;
import fpModel.ContainerObject;
import fpModel.DoorObject;

public class Lab1Behaviours {
	public static EventHandler<MouseEvent> CPBehavior(ContainerObject vm1) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				Inventory inv = GameUtil.player().getInventory();
				if (inv.checkNumberOfItem("Chocolate") > 0 && inv.checkNumberOfItem("Coffee") > 0) {
					GameUtil.setMessage("Ah, is that... food I smell? and Caffeine? Oh thank god.");
					
					EventHandler<MouseEvent> nextBehaviour = new EventHandler<MouseEvent>() {
						@Override public void handle(MouseEvent event) {
							GameUtil.setMessage("You're looking to get out? If you unlock the Computer next to me the hallway should open."
									+ " I don't know the code though, maybe try checking that note over there?");
							EventHandler<MouseEvent> nextBehaviour = new EventHandler<MouseEvent>() {
								@Override public void handle(MouseEvent event) {
									//return to gameplay
									Room cR = GameUtil.player().currentRoom();
									Perspective cP = GameUtil.player().currentView();
									cR.setPerspective(cP);
									GameUtil.displayPlayerView();
								}
							};
						}
					};
					
				
					
					
					return;
				}else {
					GameUtil.setMessage("The CP is too hungry and tired to wake up.");
					return;
				} 
			}
		};
		return behaviour;
	}
}
