package fpIO;

import com.google.gson.Gson;
import fpGame.GameUtil;

public class Saver {
	public static void main(String[] args) {

	}
	public static void save(String token, USCGameClient client) {
		StatePackage gameInfo = new StatePackage(GameUtil.map(), GameUtil.player());
		//serialise gameInfo
		Gson gson = new Gson();
		String mapToJson = gson.toJson(gameInfo.getMapSave(), fpGame.Map.class);
		String playerToJson = gson.toJson(gameInfo.getPlayerSave(), fpGame.Player.class);
		System.out.println("CRName: " + gameInfo.getPlayerSave().getCRName());
		System.out.println(mapToJson);
		System.out.println(playerToJson);
		User user = new User("", "");
		user.setToken(token);
		user.setPlayerJson(playerToJson);
		user.setMapJson(mapToJson);
		System.out.println(client.save(user));
		//push it to the server
	}
}
