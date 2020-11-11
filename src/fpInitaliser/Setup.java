package fpInitaliser;

import fpModel.*;

public class Setup {
	
	public static void setupAll() { //RAHUL
		Room annex = setupAnnex();
		Room cove = setupCove();
		//...
		Doorway ting = new Doorway();
		annex.addExitRight(ting);
		cove.addExitLeft(ting);
	}
	
	private static Room setupAnnex() { //RAHUL
		Room annex = new Room("annex");
		annex.addToFront(new Podium());
		//keep adding stuff
		return annex;
	}
	
	private static Room setupMainA() { //ERICA
		return null;
	}
	
	private static Room setupMainB() { //ERICA
		return null;
	}
	private static Room setupMainC() {  //ERICA
		return null;
	}
	private static Room setupMainD() {  //ERICA
		return null;
	}
	
	private static Room setupStudy1() { //PATRICK
		return null;
	}
	
	private static Room setupStudy2() { //PATRICK
		return null;
	}
	
	private static Room setupStudy3() { //PATROCK
		return null;
	}
	
	private static Room setupStudy4() { //PATRICK
		return null;
	}
	
	private static Room setupCove() { //RAHUL
		return null;
	}
	
	private static Room setupLab1() { //ERICA
		return null;
	}
	
	private static Room setupHallway() { //PATRICK
		return null;
	}
	
	private static Room setupMensRoom() { //ERICA
		return null;
	}
	
	private static Room setupWomensRoom() { //PATRICK
		return null;
	}
}
