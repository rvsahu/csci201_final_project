package fpIO;

import fpGame.Player;
import fpGame.Map;

/**
 * A Wrapper class for the data that needs to be serialised from the game upon save, autosave, or exit.
 */
public class StatePackage {
	private Map mapSave;
	private Player playerSave;
	
	public StatePackage(Map mapSave, Player playerSave) {
		this.mapSave = mapSave;
		this.playerSave = playerSave;
	}
	
	public StatePackage(Player playerSave, Map mapSave) {
		this.mapSave = mapSave;
		this.playerSave = playerSave;
	}
	
	public Map getMapSave() {
		return mapSave;
	}
	
	public Player getPlayerSave() {
		return playerSave;
	}
}
