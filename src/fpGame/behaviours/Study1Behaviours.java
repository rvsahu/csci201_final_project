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
import fpModel.Table;

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
	
	public static EventHandler<MouseEvent> tableBehaviour(Table table) {
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

	public static EventHandler<MouseEvent> beanbagBehaviour(GenericObject s1Beanbag) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the beanbag but found nothing.");
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> LightSwitchBehaviour() {
		// TODO Auto-generated method stub
		return null;
	}
}
