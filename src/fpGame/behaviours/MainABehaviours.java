package fpGame.behaviours;

//java imports
import java.util.List;

//intraproject imports
import fpGame.GameUtil;
import fpModel.RoomObject;
import fpModel.ContainerObject;
import fpModel.DoorObject;
import fpModel.WrapperObject;
import fpModel.GenericObject;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainABehaviours {
	
	public static EventHandler<MouseEvent> vendingMachineBehaviour(ContainerObject vm1) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("Seems like you need to get closer to the machine to use it.");
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
	
	public static EventHandler<MouseEvent> CouchBehavior() 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() 
		{
			@Override public void handle(MouseEvent event) 
			{
				GameUtil.setMessage("The Couch is empty");
			};
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> doorAnnexBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.player().setCurrentRoom(GameUtil.map().annex);
				GameUtil.player().setCurrentPerspective(1);
				GameUtil.displayPlayerView();
			}
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> arrowBBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Main A is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainB);
					GameUtil.player().setCurrentPerspective(0);
					GameUtil.displayPlayerView();
				}
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> arrowDBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Main D is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainD);
					GameUtil.player().setCurrentPerspective(3);
					GameUtil.displayPlayerView();
				}
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> keyBehaviour(WrapperObject keyWrapper) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if (keyWrapper.isHidden()) {
					//do nothing
				} else {
					String itemName = keyWrapper.peekItem().name();
					GameUtil.player().getInventory().addItem(keyWrapper.removeItem()); //wrapper automatically hides itself
					GameUtil.displayPlayerView();
					GameUtil.setMessage("You picked up the " + itemName + "!");
				}
			}
		};
		
		return behaviour;
	}
	
	public static void addBehaviours(List<RoomObject> objects) {
		
		for (RoomObject r : objects) {
			if (r.name().equals("Main To Annex")) {
				r.setBehaviour(doorAnnexBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("Main A To Main B")) {
				r.setBehaviour(arrowBBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("Main A To Main D")) {
				r.setBehaviour(arrowDBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("SR1 Key")) {
				r.setBehaviour(keyBehaviour((WrapperObject)r));
				continue;
			}
			if (r.name().equals("Main A Vending Machine")) {
				r.setBehaviour(vendingMachineBehaviour((ContainerObject)r));
				continue;
			}
		}
	}
}
