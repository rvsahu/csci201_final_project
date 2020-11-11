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
		Room hallway1 = setupHallway1();
		Room hallway2 = setupHallway2();
		Room mensRoom = setupMensRoom();
		Room womensRoom = setupWomensRoom();
		//Doorways
		Doorway annex_cove = new Doorway();
		annex.addExitRight(annex_cove);
		cove.addExitLeft(annex_cove);
		
		Doorway test = new Doorway();
	}
	
	private static Room setupAnnex() { //RAHUL
		Room annex = new Room("annex");
		annex.addToFront(new Podium());
		//keep adding stuff
		return annex;
	}
	
	private static Room setupMainA() { //ERICA
		
		Room MainA = new Room("MainA");
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
		
		Whiteboard whiteboard = new Whiteboard();
		MainA.addToFront(whiteboard);
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
		Table table = new Table();
		MainA.addToRight(table);
		
		//back
		Table table1 = new Table();
		Table table2 = new Table();
		MainA.addToBack(table1);
		MainA.addToBack(table2);
		
		//left
		//add a doorway
		return MainA;
	}
	
	private static Room setupMainB() { //ERICA
		
		Room MainB = new Room("MainB");
		//F
		Whiteboard whiteboard = new Whiteboard();
		MainB.addToFront(whiteboard);
		
		Table table1 = new Table();
		MainB.addToFront(table1);
		Computer computer1 = new Computer();
		MainB.addToFront(computer1);
		Computer computer2 = new Computer();
		MainB.addToFront(computer2);
		Computer computer3 = new Computer();
		MainB.addToFront(computer3);
		
		//R
		
		//B
		
		//L
		
		
		return null;
	}
	private static Room setupMainC() {  //ERICA
		Room MainC = new Room("MainC");
		
		//F
		
		//R
		
		//B
		
		//L
		
		return null;
	}
	private static Room setupMainD() {  //ERICA
		Room MainD = new Room("MainD");
		
		//F
		
		//R
		
		//B
		
		//L
		return null;
	}
	
	private static Room setupStudy1() { //PATRICK
		//lightswitch
		Room ret = new Room("Study1");
		ret.addToRight(new Computer());
		ret.addToLeft(new Dustbin());
		return null;
	}
	
	private static Room setupStudy2() { //PATRICK
		Room ret = new Room("Study2");
		ret.addToRight(new Computer());
		ret.addToLeft(new CoinObject());
		ret.addToLeft(new CoinObject());
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
	
	private static Room setupHallway1() { //PATRICK
		return null;
	}
	
	private static Room setupHallway2() { //RAHUL
		return null;
	}
	
	private static Room setupMensRoom() { //ERICA
		return null;
	}
	
	private static Room setupWomensRoom() { //PATRICK
		return null;
	}
}
