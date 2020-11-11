package fpInitaliser;

import java.util.ArrayList;
import java.util.List;

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
		
		//ALL CONNECTIONS
		
		//Annex
		
		Doorway annex_cove = new Doorway();
		annex.addExitRight(annex_cove);
		cove.addExitLeft(annex_cove);
		
		/*
		 * Study Room Connections
		 * Annex-1, Annex-2, Annex-3, Annex-4
		 */
		Doorway annex_study1 = new Doorway();
		annex.addExitRight(annex_study1);
		study1.addExitLeft(annex_study1);
		Doorway annex_study2 = new Doorway();
		annex.addExitRight(annex_study2);
		study2.addExitLeft(annex_study2);
		Doorway annex_study3 = new Doorway();
		annex.addExitBack(annex_study3);
		study3.addExitFront(annex_study3);
		Doorway annex_study4 = new Doorway();
		annex.addExitBack(annex_study4);
		study4.addExitFront(annex_study4);
		
		
		Doorway annex_mainA = new Doorway();
		annex.addExitLeft(annex_mainA);
		mainA.addExitRight(annex_mainA);
		
		//Main
		
		/*
		 * main room internal connections
		 * A-D, A-B, B-C, C-D
		 */
		Doorway mainA_mainD = new Doorway();
		mainA.addExitLeft(mainA_mainD);
		mainD.addExitRight(mainA_mainD);
		Doorway mainA_mainB = new Doorway();
		mainA.addExitFront(mainA_mainB);
		mainB.addExitBack(mainA_mainB);
		Doorway mainB_mainC = new Doorway();
		mainB.addExitLeft(mainB_mainC);
		mainC.addExitRight(mainB_mainC);
		Doorway mainC_mainD = new Doorway();
		mainC.addExitBack(mainC_mainD);
		mainD.addExitFront(mainC_mainD);
		
		Doorway mainD_hallway1 = new Doorway();
		mainD.addExitBack(mainD_hallway1);
		hallway1.addExitFront(mainD_hallway1);
		
		Doorway mainD_lab1 = new Doorway();
		mainD.addExitLeft(mainD_lab1);
		lab1.addExitRight(mainD_lab1);
		
		//Hallway 1
		
		Doorway hallway1_hallway2 = new Doorway();
		hallway1.addExitRight(hallway1_hallway2);
		hallway2.addExitLeft(hallway1_hallway2);
		
		//Hallway 2
		
		Doorway hallway2_mens = new Doorway();
		hallway2.addExitBack(hallway2_mens);
		mensRoom.addExitFront(hallway2_mens);
		
		Doorway hallway2_womens = new Doorway();
		hallway2.addExitBack(hallway2_womens);
		womensRoom.addExitFront(hallway2_womens);
		
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
		Chair chair1 = new Chair();
		MainA.addToFront(chair1);
		Couch couch1 = new Couch();
		MainA.addToFront(couch1);
		Plant plant = new Plant();
	    MainA.addToFront(plant);
		Outlet outlet = new Outlet();
		MainA.addToFront(outlet);
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
		Notebook notebook = new Notebook();
		MainA.addToBack(notebook);
		List<Item> list;
		list.add(notebook);
		Table table1 = new Table(notebook);
		MainA.addToBack(table1);;
		
		
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
		Couch couch1 = new Couch();
		MainB.addToFront(couch1);
		Couch couch2 = new Couch();
		MainB.addToFront(couch2);
		Couch couch3 = new Couch();
		MainB.addToFront(couch3);

		
		Chair chair1 = new Chair();
		MainB.addToFront(chair1);
		Chair chair2 = new Chair();
		MainB.addToFront(chair2);
		Chair chair3 = new Chair();
		MainB.addToFront(chair3);
		
		Scanner scanner = new Scanner();
		MainB.addToFront(scanner);

		
		//Chair chair1 = new chair();
		//MainB.addToFront(chair1);
		//R
		Drawing drawing = new Drawing();
		MainB.addToRight(drawing);
		
		
		
		//B
		//facing Main A
		
		
		//L
		//Facing Main C
		
		return null;
	}
	private static Room setupMainC() {  //ERICA
		Room MainC = new Room("MainC");
		
		//F
		//add a door
		Computer computer1 = new Computer();
		MainC.addToFront(computer1);
		Computer computer2 = new Computer();
		MainC.addToFront(computer2);
		Table table = new Table();
		MainC.addToFront(table);
		//file cabs
		FileCabs filecab = new FileCabs();
		MainC.addToFront(filecab);
		OfficeSupplies os = new OfficeSupplies();
		MainC.addToFront(os);
		
		//R
		//view of main b
		Table table1 = new Table();
		MainC.addToFront(table1);
		Couch couch = new Couch();
		MainC.addToFront(couch);
		VendingMachine vendingmachine = new VendingMachine();
		MainC.addToFront(vendingmachine);
		
		//B
		
		Plant plant = new Plant();
	    MainC.addToBack(plant);
		Table table2 = new Table();
		MainC.addToBack(table2);
		Table table3 = new Table();
		MainC.addToBack(table3);
		Chair chair = new Chair();
		MainC.addToBack(chair);
		Chair chair1 = new Chair();
		MainC.addToBack(chair1);
		
		//L
		Dustbin dustbin = new Dustbin();
		MainC.addToLeft(dustbin);
		return MainC;
	}
	private static Room setupMainD() {  //ERICA
		Room MainD = new Room("MainD");
		
		//F
		//view of main C
		
		//R
		//view of main A
		Table table1 = new Table();
		MainD.addToFront(table1);
		Couch couch = new Couch();
		MainD.addToFront(couch);

		//B
		//exit sign
		
		
		
		//L
		//add a door
		Drawing drawing = new Drawing();
		MainD.addToLeft(drawing);
		
		return MainD;
	}
	
	private static Room setupStudy1() { //PATRICK
		//lightswitch
		Room ret = new Room("Study1");
		ret.addToRight(new Computer());
		ret.addToLeft(new Dustbin());
		return ret;
	}
	
	private static Room setupStudy2() { //PATRICK
		Room ret = new Room("Study2");
		ret.addToRight(new Computer());
		ret.addToLeft(new CoinObject());
		ret.addToLeft(new CoinObject());
		return ret;
	}
	
	private static Room setupStudy3() { //PATROCK
		Room ret = new Room("Study3");
		ret.addToFront(new Dustbin());
		ret.addToBack(new Couch());
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Coin"));
		items.add(new Item("Coin"));
		ret.addToLeft(new Wallet(items));
		return ret;
	}
	
	private static Room setupStudy4() { //PATRICK
		Room ret = new Room("Study4");
		ret.addToFront(new Dustbin());
		ret.addToRight(new Couch());
		ret.addToBack(new Computer());
		ret.addToBack(new Couch());
		ret.addToBack(new Couch());
		ret.addToLeft(new Couch());
		return ret;
	}
	
	private static Room setupCove() { //RAHUL
		return null;
	}
	
	private static Room setupLab1() { //ERICA
		return null;
	}
	
	private static Room setupHallway1() { //PATRICK
		Room ret = new Room("Hallway1");
		ret.addToFront(new Phone());
		ret.addToBack(new Keypad());
		return ret;
	}
	
	private static Room setupHallway2() { //RAHUL
		return null;
	}
	
	private static Room setupMensRoom() { //ERICA
		return null;
	}
	
	private static Room setupWomensRoom() { //PATRICK
		Room ret = new Room("WomensRoom");
		ret.addToRight(new Computer());
		return ret;
	}
}
