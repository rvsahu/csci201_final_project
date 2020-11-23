package fpGame.behaviours;

import fpGame.GameUtil;
import fpModel.RoomObject;
import fpModel.DoorObject;
import fpModel.GenericObject;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.HashSet;
//java imports
import java.util.List;

public class MainBBehaviours {
	public static EventHandler<MouseEvent> dustbinBehaviour(GenericObject dustbin) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the dustbin but found nothing.");
			};
		};
		return behaviour;
	}
	
	
	public static EventHandler<MouseEvent> arrowBBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Annex is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainA);
					GameUtil.player().setCurrentPerspective(1);
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
	
	public static EventHandler<MouseEvent> tableBehaviour(GenericObject table) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the table but found nothing.");
			}
		};
		return behaviour;
	}
	
	
	public static EventHandler<MouseEvent> chairBehaviour(GenericObject chair) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("The chair is empty");
			};
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> arrowABehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Main A is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainA);
					GameUtil.player().setCurrentPerspective(2);
					GameUtil.displayPlayerView();
				}
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> arrowCBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Main C is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainC);
					GameUtil.player().setCurrentPerspective(3);
					GameUtil.displayPlayerView();
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
			if (r.name().equals("Main B to Main A")) {
				r.setBehaviour(arrowABehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("Main B to Main C")) {
				r.setBehaviour(arrowCBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("Main B Blue Couch")) {
				r.setBehaviour(couchBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Main B Green Couch")) {
				r.setBehaviour(couchBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Main B Table")) {
				r.setBehaviour(tableBehaviour((GenericObject)r));
				continue;
			}
			if (r.name().equals("Main B Chair")) {
				r.setBehaviour(chairBehaviour((GenericObject)r));
				continue;
			}
		}
	}
}

