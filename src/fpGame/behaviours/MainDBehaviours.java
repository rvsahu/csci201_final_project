package fpGame.behaviours;

//intraproject imports
import fpGame.GameUtil;
import fpModel.DoorObject;
import fpModel.ContainerObject;
import fpModel.GenericObject;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainDBehaviours {

	public static EventHandler<MouseEvent> vendingMachineBehaviour(ContainerObject vm1) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("Seems like you need to get closer to the machine to use it.");
			}
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> doorLab1Behaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if (d.isLocked() && GameUtil.player().getInventory().checkNumberOfItem("Lab 1 Key") > 0) {
					d.unlock(GameUtil.player().getInventory().getItem("Lab 1 Key"));
					GameUtil.setMessage("You use the key you found to unlock the lab door door.");
				} else if (d.isLocked()) {
					GameUtil.setMessage("The door to Lab 1 is locked. You need the key to open the room.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().lab1);
					GameUtil.player().setCurrentPerspective(3);
					GameUtil.displayPlayerView();
				}
				
			}
		};
		
		return behaviour;
	}

	
	public static EventHandler<MouseEvent> hallwayBehaviour(DoorObject d) 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) 
				{
					GameUtil.setMessage("The door is locked. On the other side is the hallway leading out.");
				}
			}
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> dustbinBehaviour(ContainerObject dustbin) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if (dustbin.hasItems()) {
					// Add as many items to inventory as possible
					GameUtil.player().getInventory().addItems(dustbin.getItems());
				}
				GameUtil.setMessage("You searched the dustbin but found nothing.");
			}
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
					GameUtil.player().setCurrentPerspective(1);
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
					GameUtil.player().setCurrentPerspective(0);
					GameUtil.displayPlayerView();
				}
			}
		};
		return behaviour;
	}




	public static EventHandler<MouseEvent> keypadLab1Behaviour(GenericObject keypad) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public static EventHandler<MouseEvent> keypadHallwayBehaviour(GenericObject keypad) {
		// TODO Auto-generated method stub
		return null;
	}



	public static EventHandler<MouseEvent> lightswitchBehaviour(GenericObject l) {
		// TODO Auto-generated method stub
		return null;
	}



	public static EventHandler<MouseEvent> annexDoorBehaviour(DoorObject d2) {
		// TODO Auto-generated method stub
		return null;
	}


}
	