package fpGame.behaviours;

//intraproject imports
import fpGame.GameUtil;
import fpModel.RoomObject;
import fpModel.DoorObject;
import fpModel.InfoObject;
import fpModel.GenericObject;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//java imports
import java.util.List;

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
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the couch but found nothing.");
			}
		};
		return behaviour;
	}
	
	
	
	public static EventHandler<MouseEvent> phoneBehaviour(GenericObject phone) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("It is a phone. The line is dead.");
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
				String message = "\"I am so over this programming assignment.\n";
				message += "I'm getting a bit hungry!\n";
				message += "I will grab some of the coins I hid in the study rooms and grab some snacks.\n";
				message += "Hope I can pass this class!\"";
				if (notebook.hasInfo()) {
					message = "You read a message in the notebook:\n" + message;
					message += "You make a note that there is some money in the study rooms.";
					GameUtil.player().addToLogbook(notebook.getInfo());
				} else {
					message = "You reread the notebook message:\n" + message;
				}
				GameUtil.setMessage(message);
			}
		};
		
		return behaviour;
	}
	
	public static void addBehaviours(List<RoomObject> objects) {
		
		for (RoomObject r : objects) {
			
		}
	}
}
