package fpGame.behaviours;

import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.GenericObject;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


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
	
	
	public static EventHandler<MouseEvent> chairBehavior(GenericObject chair) {
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
}

