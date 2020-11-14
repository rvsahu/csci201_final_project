package fpGame;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import fpModel.*;

public class Setup {
	/*
	 * ROOM OBJECT CREATION PROCEDURE:
	 * Example: Computer in annex viewable from right, front
	 * 
	 * 0. (if using container/info) Create items/info
	 * 
	 * 1. Instantiate (and pass in items/info if applicable)
	 * 
	 * Computer c = new Computer();
	 * 
	 * 2. Add sprite paths
	 * 
	 * c.setRightViewSprite(rightFilePath);
	 * c.setFrontViewSprite(frontFilePath);
	 * 
	 * 3. Load sprites
	 * 
	 * c.loadImages();
	 * 
	 * 4. Write behaviour
	 * 
	 *  EventHandler<MouseEvent> exampleBehaviour = new EventHandler<MouseEvent>() {
	 *		@Override public void handle(MouseEvent event) {
	 *			//do stuff
	 *		}
	 *  };
	 * 
	 * 5. Submit behaviour to RoomObject
	 * 
	 * c.setBehaviour(exampleBehaviour);
	 * 
	 * 6. Add to Room perspectives, possibly multiple or all
	 * 
	 * annex.addToRight(c);
	 * annex.addToFront(c);
	 * 
	 */
		
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
		
		Computer c1 = new Computer();
		String Annexfolder = "./graphics/game_graphics/rooms/annex/roomObjects/";
		c1.setFrontViewSprite(Annexfolder + "front/mon1.png");
		
		//keep adding stuff
		return annex;
	}
	
	private static Room setupMainA() { //ERICA
		Room MainA = new Room("mainA");
		//row of computers
		/*Computer comp1 = new Computer();
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
		MainA.addToFront(comp7);*/
		
		
		/*Whiteboard whiteboard = new Whiteboard();
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
		MainA.addToFront(dustbin);*/
		
		
		//right
		//Door door = new Door();
		//MainA.addToRight(door);
		Couch couch2 = new Couch();
		MainA.addToRight(couch2);
		Table table = new Table();
		MainA.addToRight(table);
		
		//back
		Notebook notebook = new Notebook("I am so over this programming assignment. I'm getting a bit hungry!"
				+ "I will grab some of the coins I hid in the study room  and grab some snacks."
				+ " Hope I can pass this class!");
		MainA.addToBack(notebook);
		KeyObject lab1key = new KeyObject("study_1_key_obj", "study_1_key");
		MainA.addToBack(lab1key);	
		
		
		//left
		//add a doorway
		return MainA;
	}
	
	private static Room setupMainB() { //ERICA
		
		Room MainB = new Room("mainB");
		
		//F
		Whiteboard whiteboard = new Whiteboard();
		MainB.addToFront(whiteboard);
		
		/*Table table1 = new Table();
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
		MainB.addToFront(scanner);*/
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
		Room MainC = new Room("mainC");
		
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
		Room MainD = new Room("mainD");
		
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
		VendingMachine vm = new VendingMachine();
		MainD.addToLeft(vm);
		
		Drawing drawing = new Drawing();
		MainD.addToLeft(drawing);
		
		return MainD;
	}
	
	private static Room setupStudy1() { //PATRICK
		//lightswitch
		Room ret = new Room("study1");
		ret.addToRight(new Computer());
		ret.addToLeft(new Dustbin());
		return ret;
	}
	
	private static Room setupStudy2() { //PATRICK
		Room ret = new Room("study2");
		ret.addToRight(new Computer());
		ret.addToLeft(new CoinObject());
		ret.addToLeft(new CoinObject());
		return ret;
	}
	
	private static Room setupStudy3() { //PATROCK
		Room ret = new Room("study3");
		ret.addToFront(new Dustbin());
		ret.addToBack(new Couch());
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("coin"));
		items.add(new Item("coin"));
		ret.addToLeft(new Wallet(items));
		return ret;
	}
	
	private static Room setupStudy4() { //PATRICK
		Room ret = new Room("study4");
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
		Room Lab1 = new Room("lab1");
		
		//F
		//R
		Drawing drawing = new Drawing();
		Lab1.addToRight(drawing);
		//B
		//L
		CP cp = new CP();
		Lab1.addToLeft(cp);
		Computer comp = new Computer();
		Lab1.addToLeft(comp);
		
		
		
		
		
		return null;
	}
	
	private static Room setupHallway1() { //PATRICK
		Room ret = new Room("hallway1");
		ret.addToFront(new Phone());
		ret.addToBack(new Keypad());
		return ret;
	}
	
	private static Room setupHallway2() { //RAHUL
		Room room = new Room("hallway2");
		return room;
	}
	
	private static Room setupMensRoom() { //ERICA
		Room ret = new Room("mensRoom");
		ret.addToLeft(new Drawing());
		ret.addToBack(new Computer());
		
		return null;
	}
	
	private static Room setupWomensRoom() { //PATRICK
		Room ret = new Room("womensRoom");
		ret.addToRight(new Computer());
		return ret;
	}
	
	/*
	 * Testing Stuff
	 */
	
	public static Room testRoom() {
		Room testRoom = new Room("test_room");
		
		//dustbin with key
		Key testkey = new Key("test_key");
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(testkey);
		
		Dustbin testbin = new Dustbin(itemList);
		
		EventHandler<MouseEvent> testbinBehaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				testbin.hide();
				//what a doorway implementation might look like
				//CurrentRoom.getExit().getAdjacentRoom()
				//Room.generateScene(GameInfo.stage);
			}
		};
		
		testbin.setBehaviour(testbinBehaviour);
		
		testRoom.addToFront(testbin); //dustbin w/ key added to front
		
		return testRoom;
	}
}
