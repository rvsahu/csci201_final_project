package fpGame.behaviours;

import java.util.HashSet;
//java imports
import java.util.List;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//intraproject imports
import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.GenericObject;
import fpModel.ContainerObject;
import fpModel.RoomObject;

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
				GameUtil.setMessage("You searched the couch but found nothing.");
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> tableBehaviour(ContainerObject table) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You search the table but find nothing.");
			}
		};
		return behaviour;
	}

	public static EventHandler<MouseEvent> dustbinBehaviour(GenericObject dustbin) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You search the dustbin but find nothing.");
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> plantBehaviour(GenericObject plant) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You search the plant but find nothing.");
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> lightSwitchBehaviour(GenericObject s3LightSwitch) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You toggle the switch but nothing seems to happen.");
			}
		};
		
		return behaviour;
	};
	
	public static void addBehaviours(List<RoomObject> objects) {
		//seen before set, for making sure objects don't have their behaviours assigned multiple times
		HashSet<RoomObject> assigned = new HashSet<RoomObject>();
		
		for (RoomObject r : objects) {
			if (assigned.contains(r)) {
				continue;
			} else {
				assigned.add(r);
			}
			
			if (r.name().equals("SR3 To Annex")) {
				r.setBehaviour(doorOutBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("SR3 Plant")) {
				r.setBehaviour(plantBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("SR3 Dustbin")) {
				r.setBehaviour(dustbinBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("SR3 Couch")) {
				r.setBehaviour(couchBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("SR3 Table")) {
				r.setBehaviour(tableBehaviour((ContainerObject)r));
				continue;
			}
			if (r.name().equals("SR3 Light Switch")) {
				r.setBehaviour(lightSwitchBehaviour((GenericObject)r));
				continue;
			}
		}
	}
}