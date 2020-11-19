package fpGame.behaviours;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//intraproject imports
import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.GenericObject;
import fpModel.ContainerObject;
import fpModel.WrapperObject;
import fpModel.InfoObject;

public class Study3Behaviours {
	public static EventHandler<MouseEvent> doorOutBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to the annex is locked.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().annex);
					GameUtil.player().setCurrentPerspective(0);
					GameUtil.displayPlayerView();
				}
				
			}
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> couchBehaviour(GenericObject couch) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("It is a couch. Seeems like a good couch to fall asleep after an all nighter at SAL. You searched the couch but found nothing.");
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> tableBehaviour() {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("It is an ordinary table. In the corner, you see a scribble that reads: ");
				GameUtil.setMessage("I..... want...to go to sleep");
			}
		};
			return behaviour;
	}

	public static EventHandler<MouseEvent> dustbinBehaviour() {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> plantBehaviour() {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> lightSwitchBehaviour(GenericObject s3LightSwitch) {
		// TODO Auto-generated method stub
		return null;
	};
}