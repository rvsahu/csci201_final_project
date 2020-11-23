package fpIO;

import fpGame.GameUtil;

/**
 * AutoSaver thread, auto saves the game 
 */
public class AutoSaver extends Thread {
	/**
	 * The delay between auto saves in seconds
	 */
	private long saveDelay;
	private String token;
	private USCGameClient client;
	
	/**
	 * Constructor for an AutoSaver thread
	 * 
	 * @param saveDelay  Time between auto saves in seconds   
	 */
	public AutoSaver(long saveDelay, String t, USCGameClient client) {
		super();
		this.saveDelay = saveDelay;
		this.token = t;
		this.client = client;
	}
	
	@Override public void run() {
		while (GameUtil.gameIsRunning()) {
			//wait a set amount of time
			try {
				Thread.sleep(saveDelay * 1000);
			} catch (InterruptedException ie) {
				if (GameUtil.gameIsRunning() == false) {
					break;
				} else {
					System.err.println("Autosave interrupted while waiting!");
					ie.printStackTrace();
				}
			}
			//save the game
			Saver.save(token, client);
		}
	}
	public void updateToken(String token) {
		this.token = token;
	}
}
