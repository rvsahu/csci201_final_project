package fpGame.behaviours;


//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.List;

//intraproject imports
import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.GenericObject;
import fpModel.RoomObject;
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
	
	public static void addBehaviours(List<RoomObject> objects) {
		for (RoomObject r : objects) {
			if (r.name().equals("SR4 To Annex")) {
				r.setBehaviour(doorOutBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("SR4 Plant")) {
				r.setBehaviour(plantBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("SR4 Dustbin")) {
				r.setBehaviour(dustbinBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("SR4 Couch")) {
				r.setBehaviour(couchBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("SR4 Table")) {
				r.setBehaviour(tableBehaviour((ContainerObject)r));
				continue;
			}
			if (r.name().equals("SR4 Light Switch")) {
				r.setBehaviour(lightSwitchBehaviour((GenericObject)r));
				continue;
			}
		}
	}
}