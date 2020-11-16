package fpIO;

import fpGame.Player;
import fpGame.Map;
import fpGame.GameUtil;
import fpGame.Setup;

public class Loader {
	public static void load() {
		//TODO do stuff to get StatePackage from server
		StatePackage state;
		
		//next three code lines are place holders so compiler doesn't complain to me while I'm coding.
		//replace it later such that player and map are the Player and Map objects loaded from the server
		Player pN = null; //TODO remove later
		Map mN = null; //TODO remove later
		state = new StatePackage(pN, mN); //TODO replace later
		
		Player player = state.getPlayerSave();
		Map map = state.getMapSave();
		
		GameUtil.setPlayer(player);
		GameUtil.setMap(map);
	}
}
