package fpGame.behaviours;

import fpGame.GameUtil;
import fpGame.Inventory;
import fpModel.DoorObject;
import fpModel.Perspective;
import fpModel.Room;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainDBehaviours 
{
	public static EventHandler<MouseEvent> VendingMachineBehavior() 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() 
		{
			@Override public void handle(MouseEvent event) {
				
				Inventory inv = GameUtil.player().getInventory();
				if (GameUtil.player().getInventory().CheckNumberOfItem("coin") >= 4)
				{
					int remover = 4;
					for (int j = 0; j < inv.getInventory().size(); j++)
					{
						if (inv.getInventory().get(j).name() == "Lab1 Key")
						{
							remover--;
							inv.getInventory().remove(j);
							
							if (remover == 0)
							{
								break;
							}
						}	
					}
					
					GameUtil.setMessage("You have earned a lab1 key");
				}
			}
		};
		return behaviour;
	}


	public static EventHandler<MouseEvent> Lab1DoorBehaviour(DoorObject d) 
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				
				Inventory inv = GameUtil.player().getInventory();
				
				
				if (GameUtil.player().getInventory().CheckNumberOfItem("Lab1 Key") > 0)
				{
					for (int j = 0; j < inv.getInventory().size(); j++)
					{
						if (inv.getInventory().get(j).name() == "Lab1 Key")
						{
							inv.getInventory().remove(j);
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

	
	public static EventHandler<MouseEvent> HallwayBehaviour(DoorObject d)
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
}
	