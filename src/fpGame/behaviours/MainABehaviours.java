package fpGame.behaviours;

//java imports
import java.util.List;

//intraproject imports
import fpGame.GameUtil;
import fpGame.Inventory;
import fpModel.ContainerObject;
import fpModel.DoorObject;
import fpModel.WrapperObject;
import fpModel.RoomObject;
import fpModel.GenericObject;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainABehaviours {
	
	public static EventHandler<MouseEvent> vendingMachineBehaviour(ContainerObject vm1) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				
		                
				Inventory inv = GameUtil.player().getInventory();
				if (inv.checkNumberOfItem("Lab 1 Key") > 0) {
					if (inv.checkNumberOfItem("Chocoate") > 0)
					{
						GameUtil.setMessage("The vending machine is now empty.");
					}
					else
					{
						GameUtil.setMessage("You give the machine a swift righteous kick, and the coffee and chocolate dispense.");
						inv.addItem(vm1.removeItem(vm1.getItemIndex("Coffee")));
						inv.addItem(vm1.removeItem(vm1.getItemIndex("Chocolate")));
					}
					
					return;
				}
				
				
				if (inv.checkNumberOfItem("Quarter") >= 4) {
					int size = inv.size();
					for (int j = 0; j < size; j++)
					{
						if (inv.getItem(j).name() == "Quarter")
						inv.removeItem(j);
						size--;
						j--;
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
	
	public static EventHandler<MouseEvent> doorLab1Behaviour(DoorObject d) 
	{
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
					GameUtil.player().setCurrentPerspective((3));
					GameUtil.displayPlayerView();
				}
				
				if(d.isLocked()) 
				{
					GameUtil.setMessage("The door is locked. Inside this lab, there is a CP waiting for your rescue");
				}
			}
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> doorAnnexBehaviour(DoorObject d) 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() 
		{
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
			if (r.name().equals("Main To Annex")) {
				r.setBehaviour(doorAnnexBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("Main To Annex")) {
				r.setBehaviour(doorAnnexBehaviour((DoorObject)r));
				continue;
			}
		}
	}
}
