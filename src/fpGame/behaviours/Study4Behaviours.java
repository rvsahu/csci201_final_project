package fpGame.behaviours;


//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//intraproject imports
import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.GenericObject;
import fpModel.ContainerObject;


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

	public static EventHandler<MouseEvent> tableBehaviour(ContainerObject table) {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> couchBehaviour(GenericObject couch) {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> plantBehaviour(GenericObject plant) {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> dustbinBehaviour(GenericObject dustbin) {
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> lightSwitchBehaviour(GenericObject lightSwitch) {
		// TODO Auto-generated method stub
		return null;
	}
}