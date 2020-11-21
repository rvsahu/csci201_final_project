package fpGame.behaviours;

import fpGame.GameUtil;
import fpGame.Inventory;
import fpModel.DoorObject;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainCBehaviours {
	public static EventHandler<MouseEvent> DustbinBehavior() 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() 
		{
			@Override public void handle(MouseEvent event) 
			{
				GameUtil.setMessage("The dustbin is empty");
			};
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> FrontDoorBehaviour(DoorObject d) 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The front door is locked.");
				} else {
					
				}
				
			}
		};
		
		return behaviour;
	}
}
