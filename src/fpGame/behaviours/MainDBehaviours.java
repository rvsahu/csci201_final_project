package fpGame.behaviours;

//intraproject imports
import fpGame.GameUtil;
import fpGame.Inventory;
import fpModel.DoorObject;
import fpModel.ContainerObject;
import fpModel.InfoObject;
import fpModel.GenericObject;
import fpModel.WrapperObject;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainDBehaviours {

	public static EventHandler<MouseEvent> vendingMachineBehaviour(ContainerObject vm1) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				Inventory inv = GameUtil.player().getInventory();
				if (inv.checkNumberOfItem("Lab 1 Key") > 0) {
					GameUtil.setMessage("You already have bought the key from the vending machine.");
					return;
				}
				if (inv.checkNumberOfItem("Quarter") >= 4) {
					GameUtil.setMessage("You put four coins into the vending machine and pay for the key to Lab 1.\n"
							          + "The machine dispenses the key. You pick it up and add it to your inventory.");
					int remover = 4;
					for (int j = 0; j < inv.size(); j++) {
						if (inv.getItem(j).name() == "Quarter") {
							inv.removeItem(j);
							remover -= 1;
							if (remover == 0) {
								break;
							}
						}	
					}
					inv.addItem(vm1.removeItem(vm1.getItemIndex("Lab 1 Key")));
				} else {
					GameUtil.setMessage("You look at the vending machine and see the key to Lab 1. It costs $1.00\n"
					          + "You have " + inv.checkNumberOfItem("Quarter") + " quarter(s).");
				}
			}
		};
		return behaviour;
	}
	


	public static EventHandler<MouseEvent> lab1DoorBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				
				Inventory inv = GameUtil.player().getInventory();
				
				
				if (GameUtil.player().getInventory().checkNumberOfItem("Lab1 Key") > 0)
				{
					for (int j = 0; j < inv.size(); j++)
					{
						if (inv.getItem(j).name() == "Lab1 Key")
						{
							inv.removeItem(j);
						}	
					}
					
					d.unlock();
					GameUtil.setMessage("The door unlocked!");
					GameUtil.player().setCurrentRoom(GameUtil.map().lab1);
					GameUtil.player().setCurrentPerspective(3);
					GameUtil.displayPlayerView();
				}
				
				if(d.isLocked()) 
				{
					GameUtil.setMessage("The door is locked. Inside this lab, there is a CP waiting for your rescue");
				}else {
					GameUtil.player().setCurrentRoom(GameUtil.map().lab1);
					GameUtil.player().setCurrentPerspective(3);
					GameUtil.displayPlayerView();
				}
			}
		};
		return behaviour;
	}

	
	public static EventHandler<MouseEvent> hallwayBehaviour(DoorObject d) {
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
	
	public static EventHandler<MouseEvent> arrowDBehaviour(DoorObject d) {
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
}
	