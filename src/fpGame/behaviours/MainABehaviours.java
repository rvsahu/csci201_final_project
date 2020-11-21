package fpGame.behaviours;

import fpGame.GameUtil;
import fpGame.Inventory;
import fpModel.ContainerObject;
import fpModel.DoorObject;
import fpModel.GenericObject;
import fpModel.InfoObject;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainABehaviours {

	public static EventHandler<MouseEvent> vendingMachineBehavior(ContainerObject vm1) {
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
	
	public static EventHandler<MouseEvent> DustbinBehavior() 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() 
		{
			@Override public void handle(MouseEvent event) 
			{
				GameUtil.setMessage("The dustbin is empty");
			};
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> CouchBehavior() 
	{
		
		return null;
	}
	
	public static EventHandler<MouseEvent> AnnexBehaviour(DoorObject d) 
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
				}
				
				if(d.isLocked()) 
				{
					GameUtil.setMessage("The door is locked. Inside this lab, there is a CP waiting for your rescue");
				}
			}
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> KeypadBehaviour(DoorObject d) 
	{
		
		return null;
	}
	
	public static EventHandler<MouseEvent> LightswitchBehaviour(DoorObject d) 
	{
		
		return null;
	}
	
	public static EventHandler<MouseEvent> CouchBehaviour(DoorObject d) 
	{
		
		return null;
	}


	
	
}
