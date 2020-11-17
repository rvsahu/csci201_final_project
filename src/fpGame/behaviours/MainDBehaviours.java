package fpGame.behaviours;

import fpGame.GameUtil;
import fpGame.Inventory;
import fpModel.DoorObject;
import fpModel.Perspective;
import fpModel.Room;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainDBehaviours {
	public static EventHandler<MouseEvent> VendingMachineBehavior = new EventHandler<MouseEvent>() {
		@Override public void handle(MouseEvent event) {
		 			//do stuff
			
		}
	};


	public static EventHandler<MouseEvent> Lab1DoorBehaviour(DoorObject d) 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				
				Inventory inv = GameUtil.player().getInventory();
				if(d.isLocked()) 
				{
					GameUtil.setMessage("The door is locked. Inside this lab, there is a CP waiting for your rescue");
				}
				
				if (GameUtil.player().getInventory().CheckNumberOfItem("Lab1 Key") > 0)
				{
					for (int j = 0; j < inv.getInventory().size(); j++)
					{
						if (inv.getInventory().get(j).name() == "Lab1 Key")
						{
							inv.getInventory().remove(j);
						}	
					}
					
					d.unlock();
					GameUtil.setMessage("The door unlocked!");
				}
			}
		};
		return behaviour;
	}


	public static EventHandler<MouseEvent> vendingMachineBehaviour() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static EventHandler<MouseEvent> hallwayBehaviour() {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				
			}
		};
		return behaviour;
	}
}
	