package fpModel;

import java.util.List;
import java.util.ArrayList;

import javafx.scene.Scene;

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
	
	/*
	 * Graphical methods
	 */
	public Scene display() {
		//to be implemented
		return null;
	}
}
