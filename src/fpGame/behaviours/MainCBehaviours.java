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
	
	
	public static EventHandler<MouseEvent> FrontDoorKeypad(DoorObject d) 
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
	
	public static EventHandler<MouseEvent> CouchBehavior() 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() 
		{
			@Override public void handle(MouseEvent event) 
			{
				GameUtil.setMessage("The couch is empty");
			};
		};
		return behaviour;
	}
	
	
	
	public static EventHandler<MouseEvent> PhoneBehaviour()
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("It is a phone");
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> arrowBBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Main B is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainB);
					GameUtil.player().setCurrentPerspective(1);
					GameUtil.displayPlayerView();
				}
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> arrowDBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Main D is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainD);
					GameUtil.player().setCurrentPerspective(2);
					GameUtil.displayPlayerView();
				}
			}
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> notebookBehaviour() {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
					GameUtil.setMessage(" “I am so over this programming assignment. \n "
							+ "I’m getting a bit hungry! \n "
							+ "I will grab some of the coins I hid in the study room and grab some snacks. \n"
							+ "Hope I can pass this class!”");
			}
		};
		return behaviour;
	}
}
