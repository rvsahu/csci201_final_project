package fpIO;

//intraproject imports
import com.google.gson.Gson;
import fpGame.Player;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import fpGame.Map;
import fpGame.GameUtil;

public class Loader {
	public static void load(String token, USCGameClient client) {
		User user = client.load(token);
		if (user.getPlayerJson().equals("") || user.getMapJson().equals("")) {
			System.out.println("received nothing");
			return;
		}
		try {
			Gson gson = new Gson();
			Map map = gson.fromJson(user.getMapJson(), Map.class);
			Player player = gson.fromJson(user.getPlayerJson(), Player.class);
			if (user.getUsername().startsWith("Error")) throw new Exception(user.getUsername());
			StatePackage state = new StatePackage(map, player);
			configureGame(state);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void configureGame(StatePackage state) {		
		Map map = state.getMapSave();
		map.addContainingRooms();
		map.resetAllDirections();
		map.tossAllDuplicates();
		map.rebuildAllContentsLists();
		map.loadAllSprites();
		map.reassignAllBehaviours();
		
		Player player = state.getPlayerSave();
		if (player.getCRName() == null) {
			player.setCurrentRoom(map.annex);
		} else {
			player.setCurrentRoom(map.getRoom(player.getCRName()));
		}
		player.setCurrentPerspective(player.getCVIndex());
		
		GameUtil.setPlayer(player);
		GameUtil.setMap(map);
		GameUtil.stage().setTitle("USCape!");
		GameUtil.message().setFill(Color.WHITE);
		GameUtil.message().setFont(new Font(30));
		GameUtil.displayPlayerView();
	}
}
