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

public class Study1Behaviours {
	public static EventHandler<MouseEvent> doorOutBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door is to the annex locked.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().annex);
					GameUtil.player().setCurrentPerspective(3);
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
	
	public static EventHandler<MouseEvent> tableBehaviour(ContainerObject s1Table) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if (s1Table.hasItems()) {
					// Add as many items to inventory as possible
					GameUtil.player().getInventory().addItems(s1Table.getItems());
				}
				GameUtil.setMessage("You searched the table but found nothing.");
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> beanbagBehaviour(GenericObject s1Beanbag) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the beanbag chair but found nothing.");
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> messageBehaviour(InfoObject hiddenMessage) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if (hiddenMessage.hasInfo()) {
					GameUtil.setMessage("You write the passcode from the hidden message into your logbook.");
					GameUtil.player().addToLogbook(hiddenMessage.getInfo());
				} else {
					GameUtil.setMessage("You have already written down the passcode from the hidden message.");
				}
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> lightSwitchBehaviour(InfoObject hiddenMessage) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.map().study1.flipLights();
				if (hiddenMessage.isHidden()) {
					hiddenMessage.display();
					GameUtil.displayPlayerView();
					GameUtil.setMessage("You just flipped the switch, and the lights went out in the room.");
				} else {
					hiddenMessage.hide();
					GameUtil.displayPlayerView();
					GameUtil.setMessage("You turn the lights back on.");
				}
			}
		};
		
		return behaviour;
	}
}
