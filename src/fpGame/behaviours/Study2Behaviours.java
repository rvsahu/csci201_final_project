package fpGame.behaviours;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

//intraproject imports
import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.GenericObject;
import fpModel.ContainerObject;
import fpModel.InfoObject;
import fpModel.WrapperObject;

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
				if (couch.hasItems())
				{
					int size = couch.getItems().size();
					GameUtil.setMessage("You searched the couch and found 2 coins!");
					for (int i = 0; i<size; i++)
					{
						GameUtil.player().addToInventory(couch.getItem(0));
						couch.removeItem(0);
					}
				}
				else
				{
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
		// TODO Auto-generated method stub
		return null;
	}

	public static EventHandler<MouseEvent> plantBehaviour(GenericObject p) {
		// TODO Auto-generated method stub
		return null;
	}
}