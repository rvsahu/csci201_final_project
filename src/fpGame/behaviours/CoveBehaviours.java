package fpGame.behaviours;

import java.util.HashSet;
//java imports
import java.util.List;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


//intraproject imports
import fpGame.GameUtil;
import fpModel.GenericObject;
import fpModel.ContainerObject;
import fpModel.DoorObject;
import fpModel.RoomObject;

public class CoveBehaviours {

	public static EventHandler<MouseEvent> doorOutBehaviour(DoorObject dOut) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(dOut.isLocked()) {
					GameUtil.setMessage("The door to the annex is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().annex);
					GameUtil.player().setCurrentPerspective(0);
					GameUtil.displayPlayerView();
				}
				
			} 
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> couchGenericBehaviour(GenericObject c) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the couch but found nothing.");
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> tableBehaviour(GenericObject t) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the table but found nothing.");
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> beanbagBehaviour(GenericObject b) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the beanbag chair but found nothing.");
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> plantBehaviour(GenericObject p) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the plant but found nothing.");
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> couchContainerBehaviour(ContainerObject c) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if (c.hasItems()) {
					GameUtil.setMessage("You picked up some items from the couch.");
					for (int i = c.getItems().size() - 1; i >= 0; i -= 1) {
						boolean added = GameUtil.player().getInventory().addItem(c.getItem(i));
						if (!added) {
							break;
						}
						c.removeItem(i);
					}
				} else {
					GameUtil.setMessage("You searched the couch but found nothing.");
				}
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> dustbinBehaviour(ContainerObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if (d.hasItems()) {
					GameUtil.setMessage("You picked up some items from the dustbin.");
					for (int i = d.getItems().size() - 1; i >= 0; i -= 1) {
						boolean added = GameUtil.player().getInventory().addItem(d.getItem(i));
						if (!added) {
							break;
						}
						d.removeItem(i);
					}
				} else {
					GameUtil.setMessage("You searched the dustbin but found nothing.");
				}
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
			if (r.name().equals("Cove To Annex")) {
				r.setBehaviour(doorOutBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("Cove Blue Couch")) {
				r.setBehaviour(couchGenericBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Couch 1")) {
				r.setBehaviour(couchGenericBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Couch 2")) {
				r.setBehaviour(couchGenericBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Couch 3")) {
				r.setBehaviour(couchGenericBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Couch 4")) {
				r.setBehaviour(couchGenericBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Couch 5")) {
				r.setBehaviour(couchGenericBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Plant 1")) {
				r.setBehaviour(plantBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Plant 2")) {
				r.setBehaviour(plantBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Beanbag")) {
				r.setBehaviour(beanbagBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Table")) {
				r.setBehaviour(tableBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Cove Dustbin")) {
				r.setBehaviour(dustbinBehaviour((ContainerObject)r));
				continue;
			}
		}
	}
}
