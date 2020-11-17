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
	
	/**
	 * Constructor for an AutoSaver thread
	 * 
	 * @param saveDelay  Time between auto saves in seconds   
	 */
	public AutoSaver(long saveDelay) {
		super();
		this.saveDelay = saveDelay;
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
			Saver.save();
		}
	}
}
