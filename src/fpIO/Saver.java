package fpIO;

import fpGame.GameUtil;

public class Saver {
	public static void save() {
		StatePackage gameInfo = new StatePackage(GameUtil.map(), GameUtil.player());
		//serialise gameInfo
		//push it to the server
	}
}
