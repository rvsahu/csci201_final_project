package fpModel;

import fpGame.*;

public class CP extends InfoObject{
	
	private boolean awake = false;
	private boolean labcleared = false;
	
	public String wakeup(Player p)
	{
		Boolean state = false;
		if (p.getInventory().checkNumberOfItem("coffee") >= 1
				&& p.getInventory().checkNumberOfItem("chocolate") >= 1)
		{
			awake = true;
			return "The CP has woken up";
		}
		return "Bring him energy source so he could wake up";
	}
	
	/*public String giveLab()
	{
		//
	}*/
	
	/*public String giveCheckOffQ()
	{
		//
	}*/
	
	

}
