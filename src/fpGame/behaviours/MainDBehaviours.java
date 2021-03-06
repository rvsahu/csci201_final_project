package fpGame.behaviours;

//intraproject imports
import fpGame.GameUtil;
import fpGame.Inventory;
import fpModel.RoomObject;
import fpModel.DoorObject;
import fpModel.ContainerObject;
import fpModel.GenericObject;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.HashSet;
//java imports
import java.util.List;

public class MainDBehaviours {

	public static EventHandler<MouseEvent> vendingMachineBehaviour(ContainerObject vm1) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				
		                
				Inventory inv = GameUtil.player().getInventory();
				if (inv.contains("Lab 1 Key")) {
					if (inv.contains("Chocolate")) {
						GameUtil.setMessage("The vending machine is now empty.");
					}
					else {
						GameUtil.setMessage("You give the machine a swift righteous kick, and the coffee and chocolate dispense.");
						inv.addItem(vm1.removeItem(vm1.getItemIndex("Coffee")));
						inv.addItem(vm1.removeItem(vm1.getItemIndex("Chocolate")));
					}
					
					return;
				}
				
				
				if (inv.checkNumberOfItem("Quarter") >= 4) {
					for (int j = 0; j < inv.size(); j++) {
						if (inv.getItem(j).name().equals("Quarter")) {
							inv.removeItem(j);
							j -= 1;
						}
					}
					inv.addItem(vm1.removeItem(vm1.getItemIndex("Lab 1 Key")));
					
					GameUtil.setMessage("You put four coins into the vending machine and pay for the key to Lab 1.\n"
					          + "The machine dispenses the key. You pick it up and add it to your inventory.");
			
					return;
				} 
				
				GameUtil.setMessage("You look at the vending machine and see the key to Lab 1. It costs $1.00\n"
					                + "You have " + inv.checkNumberOfItem("Quarter") + " quarter(s).\n"
					                + "The vending machine also has coffee and chocolate within.");
					  
			}
			
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> doorLab1Behaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if (d.isLocked() && GameUtil.player().getInventory().contains("Lab 1 Key")) {
					d.unlock();
					GameUtil.setMessage("You use the key you bought from the vending machine to unlock the lab door door.");
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

	
	public static EventHandler<MouseEvent> hallwayBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door is locked.");
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
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("The keypad is unresponsive.");
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
			if (r.name().equals("Main D to Main A")) {
				r.setBehaviour(arrowABehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("Main D to Main C")) {
				r.setBehaviour(arrowCBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("MainD Vending Machine")) {
				r.setBehaviour(vendingMachineBehaviour((ContainerObject)r));
				continue;
			}
			if (r.name().equals("Main D To Lab 1")) {
				r.setBehaviour(doorLab1Behaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("MainD Dustbin1")) {
				r.setBehaviour(dustbinBehaviour((ContainerObject)r));
				continue;
			}
			if (r.name().equals("MainD Dustbin2")) {
				r.setBehaviour(dustbinBehaviour((ContainerObject)r));
				continue;
			}
			if (r.name().equals("MainD Keypad to Lab1")) {
				r.setBehaviour(keypadLab1Behaviour((GenericObject)r));
				continue;
			}
		}
	}
}
	