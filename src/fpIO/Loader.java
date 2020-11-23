package fpIO;

//intraproject imports
import fpGame.Player;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import fpGame.Map;
import fpGame.GameUtil;

public class Loader {
	public static void load() {
		//TODO do stuff to get StatePackage from server
		StatePackage state;
		
		//next three code lines are place holders so compiler doesn't complain to me while I'm coding.
		//replace it later such that player and map are the Player and Map objects loaded from the server
		Player pN = null; //TODO remove later
		Map mN = null; //TODO remove later
		state = new StatePackage(pN, mN); //TODO replace later
		configureGame(state); //Rahul will write the configureGame method, just make sure StatePackage state is gotten from server from correct user
		
	}
	
	private static void configureGame(StatePackage state) {		
		Map map = state.getMapSave();
		map.addContainingRooms();
		map.resetAllDirections();
		map.rebuildAllContentsLists();
		map.tossAllDuplicates();
		map.loadAllSprites();
		map.reassignAllBehaviours();
		
		Player player = state.getPlayerSave();
		player.setCurrentRoom(map.getRoom(player.getCRName()));
		player.setCurrentPerspective(player.getCVIndex());
		
		GameUtil.setPlayer(player);
		GameUtil.setMap(map);
		GameUtil.stage().setTitle("USCape!");
		GameUtil.message().setFill(Color.WHITE);
		GameUtil.message().setFont(new Font(30));
		GameUtil.displayPlayerView();
	}
}
