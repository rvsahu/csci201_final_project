package fpIO;

import fpGame.Player;
import fpGame.Map;
import fpGame.GameUtil;

public class Saver {
	public static void save() {
		StatePackage gameInfo = new StatePackage(GameUtil.map(), GameUtil.player());
	}
}