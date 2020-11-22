package fpGame.behaviours;

import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.InfoObject;
import fpModel.GenericObject;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainCBehaviours {
	public static EventHandler<MouseEvent> dustbinBehaviour(GenericObject dustbin)  {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the dustbin but found nothing.");
			};
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> frontDoorBehaviour(DoorObject d) {
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
	
	
	public static EventHandler<MouseEvent> frontDoorKeypad(DoorObject d) {
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
	
	public static EventHandler<MouseEvent> couchBehavior(GenericObject couch) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) 
			{
				GameUtil.setMessage("You searched the couch but found nothing.");
			};
		};
		return behaviour;
	}
	
	
	
	public static EventHandler<MouseEvent> phoneBehaviour(GenericObject phone) {
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
	
	public static EventHandler<MouseEvent> notebookBehaviour(InfoObject notebook) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
					
				GameUtil.setMessage("You read a message in the notebook:"
							+ "\"I am so over this programming assignment.\n "
							+ "I'm getting a bit hungry!\n "
							+ "I will grab some of the coins I hid in the study rooms and grab some snacks.\n"
							+ "Hope I can pass this class!\"");
			}
		};
		
		return behaviour;
	}
}
