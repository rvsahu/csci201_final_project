package fpGame.behaviours;

import java.util.HashSet;
//java imports
import java.util.List;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//intraproject imports
import fpGame.GameUtil;
import fpModel.RoomObject;
import fpModel.DoorObject;
import fpModel.GenericObject;
import fpModel.ContainerObject;

public class Study2Behaviours {
	public static EventHandler<MouseEvent> doorOutBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to the annex is locked.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().annex);
					GameUtil.player().setCurrentPerspective(3);
					GameUtil.displayPlayerView();
				}
				
			}
		};
		
		return behaviour;
	}
	
	
	
	public static EventHandler<MouseEvent> couchBehaviour(ContainerObject couch) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if (couch.hasItems()) {
					int size = couch.getItems().size();
					GameUtil.setMessage("You searched the couch and found 2 coins!");
					for (int i = 0; i<size; i++) {
						GameUtil.player().addToInventory(couch.getItem(0));
						couch.removeItem(0);
					}
				} else {
					GameUtil.setMessage("You searched the couch but found nothing");
				}
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> tableBehaviour(ContainerObject table) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if (table.hasItems()) {
					// Add as many items to inventory as possible
					GameUtil.player().getInventory().addItems(table.getItems());
				}
				GameUtil.setMessage("You searched the table but found nothing.");
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> lightSwitchBehaviour(GenericObject ls) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You toggle the switch but nothing seems to happen.");
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> plantBehaviour(GenericObject p) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You search the plant but find nothing.");
			}
		};
		
		return behaviour;
	}
	
	public static void addBehaviours(List<RoomObject> objects) {
		//seen before set, for making sure objects don't have their behaviours assigned multiple times
		HashSet<RoomObject> assigned = new HashSet<RoomObject>();
		
		for (RoomObject r : objects) {
			if (assigned.contains(r)) {
				continue;
			} else {
				assigned.add(r);
			}
			
			if (r.name().equals("SR2 To Annex")) {
				r.setBehaviour(doorOutBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("SR2 Couch")) {
				r.setBehaviour(couchBehaviour((ContainerObject)r));
				continue;
			}
			if (r.name().equals("SR2 Table")) {
				r.setBehaviour(tableBehaviour((ContainerObject)r));
				continue;
			}
			if (r.name().equals("SR2 Light Switch")) {
				r.setBehaviour(lightSwitchBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("SR2 Plant")) {
				r.setBehaviour(plantBehaviour((GenericObject)r));
				continue;
			}
		}
	}
}