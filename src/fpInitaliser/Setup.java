package fpInitaliser;

import fpModel.*;

public class Setup {
	
	public static void setupAll() { //RAHUL
		Room annex = setupAnnex();
		Room mainA = setupMainA();
		Room mainB = setupMainB();
		Room mainC = setupMainC();
		Room mainD = setupMainD();
		Room study1 = setupStudy1();
		Room study2 = setupStudy2();
		Room study3 = setupStudy3();
		Room study4 = setupStudy4();
		Room cove = setupCove();
		Room lab1 = setupLab1();
		Room hallway = setupHallway();
		Room mensRoom = setupMensRoom();
		Room womensRoom = setupWomensRoom();
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
