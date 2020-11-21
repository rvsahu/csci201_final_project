package fpGame.behaviours;

import fpGame.GameUtil;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MainBBehaviours {
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
	
	
	public static EventHandler<MouseEvent> TableBehavior() 
	{
		
		return null;
	}
	public static EventHandler<MouseEvent> ChairBehavior() 
	{
		
		return null;
	}
}
