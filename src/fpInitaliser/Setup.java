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
		
		Room MainA = new Room("mainA");
		//front -- add more computers, chairs, couches, outlets, and dustbins as necessary
		//row of computers
		Computer comp1 = new Computer();
		MainA.addToFront(comp1);
		Computer comp2 = new Computer();
		MainA.addToFront(comp2);
		Computer comp3 = new Computer();
		MainA.addToFront(comp3);
		Computer comp4 = new Computer();
		MainA.addToFront(comp4);
		Computer comp5 = new Computer();
		MainA.addToFront(comp5);
		Computer comp6 = new Computer();
		MainA.addToFront(comp6);
		Computer comp7 = new Computer();
		MainA.addToFront(comp7);
		
		//Whiteboard whiteboard = new Whiteboard();
		//Chair chair1 = new chair();
		//MainA.addtoFront(chair1);
		Couch couch1 = new Couch();
		MainA.addToFront(couch1);
		//Plant plant = new Plant();
		//MainA.addToFront(plant);
		//Outlet outlet = new Outlet();
		//MainA.addToFront(outlet);
		Dustbin dustbin = new Dustbin();
		MainA.addToFront(dustbin);
		
		
		//right
		
		//Door door = new Door();
		//MainA.addToRight(door);
		
		Couch couch2 = new Couch();
		MainA.addToRight(couch2);
		//Table table = new Table();
		//MainA.addToRight(table);
		
		//back
		
		//left
		
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
