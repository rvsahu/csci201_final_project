package fpGame.behaviours;


//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.HashSet;
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

	public static EventHandler<MouseEvent> tableBehaviour(ContainerObject couch) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if (couch.hasItems())
				{
					int size = couch.getItems().size();
					GameUtil.setMessage("You searched the table and found 2 coins!");
					for (int i = 0; i<size; i++)
					{
						GameUtil.player().addToInventory(couch.getItem(0));
						couch.removeItem(0);
					}
				}
				else
				{
					GameUtil.setMessage("You searched the table but found nothing");
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

	public static EventHandler<MouseEvent> plantBehaviour(GenericObject plant) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the plant but found nothing.");
			}
		};
		return behaviour;
	}

	public static EventHandler<MouseEvent> dustbinBehaviour(GenericObject dustbin) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the dustbin but found nothing.");
			}
		};
		return behaviour;
	}

	public static EventHandler<MouseEvent> lightSwitchBehaviour(GenericObject lightSwitch) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You toggle the light switch but nothing occurs.");
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