package fpInitaliser;

import fpModel.*;

public class Setup {
	
	public static void setupAll() {
		Room annex = setupAnnex();
		Room cove = setupCove();
		//...
		Doorway ting = new Doorway();
		annex.addExitRight(ting);
		cove.addExitLeft(ting);
	}
	
	private static Room setupAnnex() {
		Room annex = new Room("annex");
		annex.addToFront(new Podium());
		//keep adding stuff
		return annex;
	}
	
	private static Room setupMainA() {
		return null;
	}
	
	private static Room setupMainB() {
		return null;
	}
	private static Room setupMainC() {
		return null;
	}
	private static Room setupMainD() {
		return null;
	}
	
	private static Room setupStudy1() {
		return null;
	}
	
	private static Room setupStudy2() {
		return null;
	}
	
	private static Room setupStudy3() {
		return null;
	}
	
	private static Room setupStudy4() {
		return null;
	}
	
	private static Room setupCove() {
		return null;
	}
	
	private static Room setupLab1() {
		return null;
	}
	
	private static Room setupHallway() {
		return null;
	}
	
	private static Room setupMensRoom() {
		return null;
	}
	
	private static Room setupWomensRoom() {
		return null;
	}
}
