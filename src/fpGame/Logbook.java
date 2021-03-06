package fpGame;

import java.util.List;
import java.util.ArrayList;

/**
 * Instead of being a container for Items, like the inventory, the logbook is
 * a container of information
 *
 */
public class Logbook {
	private List<String> allInfo;
	
	public Logbook() {
		allInfo = new ArrayList<String>();
	}
	
	public void addInfo(String info) {
		allInfo.add(info);
	}
	
	public void removeInfo(int index) {
		allInfo.remove(index);
	}
	
	/**
	 * Generates and returns a string representation of the logbook.
	 * 
	 * @return     A string representation of the information list.
	 */
	public String stringRep() {
		String rep = "";
		for (String info : allInfo) {
			rep += info + '\n';
		}
		return rep;
	}
}
