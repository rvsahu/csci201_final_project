package fpGame.behaviours;


//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//intraproject imports
import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.GenericObject;

public class Study4Behaviours {
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

	public static EventHandler<MouseEvent> tableBehaviour() {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> couchBehaviour(GenericObject s4Couch) {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> plantBehaviour() {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> dustbinBehaviour() {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> lightSwitchBehaviour(GenericObject s4LightSwitch) {
		// TODO Auto-generated method stub
		return null;
	}
}