package fpGame;

//java imports
import java.util.ArrayList;
import java.util.List;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//intraproject imports
import fpModel.*;
import fpGame.behaviours.*;

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
	 * c.loadSprites();
	 * 
	 * 4. Write behaviour in Behaviours.java static method
	 * 
	 *  EventHandler<MouseEvent> exampleBehaviour = new EventHandler<MouseEvent>() {
	 *		@Override public void handle(MouseEvent event) {
	 *			//do stuff
	 *		}
	 *  };
	 * 
	 * 5. Submit behaviour to RoomObject
	 * 
	 * c.setBehaviour(Behaviours.annexComputer5Behaviour());
	 * 
	 * 6. Add to Room perspectives, possibly multiple or all
	 * 
	 * annex.addToRight(c);
	 * annex.addToFront(c);
	 * 
	 * 7. Set layer values on the object for specific perspectives.
	 * c.setLayerRight(2);
	 * c.setLayerFront(3);
	 * 
	 */
	
	/* EXAMPLE OF DOOR FORMAT
	DoorObject doorOut = new DoorObject();
	doorOut.setFrontSpritePath("www.google.com/search/toasterinbathtub");
	EventHandler<MouseEvent> doorOutBehaviour = new EventHandler<MouseEvent>() {
		@Override public void handle(MouseEvent event) {
			if (doorOut.isLocked()) {
				// do nothing
			} else {
				GameUtil.player().setCurrentRoom(GameUtil.map().cove);
				GameUtil.player().setCurrentPerspective(2); //facing back
				GameUtil.map().cove.generateScene(GameUtil.stage());
			}
		}
	};
	*/
	
	public static void setupAll() { /* would return GameMap */
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
		
		/*
		 * Create a map of the game, initialise all its fields to the Rooms we just set up.
		 */
		
		Map map = new Map();
		
		map.annex = annex;
		map.mainA = mainA;
		map.mainB = mainB;
		map.mainC = mainC;
		map.mainD = mainD;
		map.study1 = study1;
		map.study2 = study2;
		map.study3 = study3;
		map.study4 = study4;
		map.cove = cove;
		map.lab1 = lab1;
		map.hallway1 = hallway1;
		map.hallway2 = hallway2;
		map.mensRoom = mensRoom;
		map.womensRoom = womensRoom;
		
		GameUtil.setMap(map);
		
		//initialise GameUtil.message()
		GameUtil.message().setFill(Color.WHITE);
		GameUtil.message().setFont(new Font(30));
		
		//start the game facing forwards in the annex
		GameUtil.player().setCurrentRoom(GameUtil.map().annex);
		GameUtil.player().setCurrentPerspective(0); 
		GameUtil.displayPlayerView(); //use this as a template for all other room displays
	}
	
	private static Room setupAnnex() { //RAHUL
		
		String annexFolder = "./graphics/game_graphics/rooms/annex/";
		Room annex = new Room("annex");
		
		String frontPaths[] = {annexFolder + "front/layer0/annex_front_0.png", annexFolder + "front/layer1/annex_front_1.png",
				annexFolder + "front/layer2/annex_front_2.png"};
		
		String rightPaths[] = {annexFolder +  "right/layer0/annex_right_0.png", annexFolder +  "right/layer1/annex_right_1.png", 
				annexFolder + "right/layer2/annex_right_2.png"};
		
		String backPaths[] = {annexFolder +  "back/layer0/Annex_back_0.png"};
		
		String leftPaths[] = {annexFolder +  "left/layer0/annex_left_0.png", annexFolder + "left/layer1/annex_left_1.png"};

		annex.setLayerBackgroundsFront(frontPaths);
		annex.setLayerBackgroundsRight(rightPaths);
		annex.setLayerBackgroundsBack(backPaths);
		annex.setLayerBackgroundsLeft(leftPaths);
		
		InfoObject c2 = new InfoObject("Annex Computer 2");
		String compFrontSpritePath = annexFolder + "front/layer1/mon1.png";
		c2.setFrontSpritePath(compFrontSpritePath);
		//add remaining sprite paths
		c2.loadSprites();		
		c2.setBehaviour(AnnexBehaviours.annexComputer2Behaviour(c2));
		annex.addToFront(c2);
		c2.setLayerFront(1);
		
		//computer 5 loads up an image of a cat 
		InfoObject c5 = new InfoObject("Annex Computer 5");
		c5.setFrontSpritePath(annexFolder + "front/layer2/mon5.png");
		c5.loadSprites();
		c5.setBehaviour(AnnexBehaviours.annexComputer5Behaviour(c5));
		annex.addToFront(c5);
		c5.setLayerFront(2);
		
		//computer 7 -- write down the correct word then type enter
		InfoObject c7 = new InfoObject("Annex Computer 8", "The passcode to the annex-main door is 5147.");
		c7.setFrontSpritePath(annexFolder + "front/layer2/mon6.png");
		c7.loadSprites();
		c7.setBehaviour(AnnexBehaviours.annexComputer7Behaviour(c7));
		annex.addToFront(c7);
		c7.setLayerFront(2);
		
		/*
		//computer 8 -- write down the correct word then type enter
		Computer c8 = new Computer();
		c8.setFrontSpritePath(annexFolder + "front/layer2/mon7.png");
		c8.loadSprites();
		annex.addToFront(c8);
		c8.setLayerFront(2);
		*/
		
		//projector
		GenericObject proj = new GenericObject("Annex Projector");
		proj.setFrontSpritePath(annexFolder + "front/layer0/projSwitch.png");
		proj.setLeftSpritePath(annexFolder + "left/layer0/projSwitch.png");
		proj.loadSprites();
		proj.setBehaviour(AnnexBehaviours.projectorBehaviour(proj));
		annex.addToFront(proj);
		annex.addToLeft(proj);
		proj.setLayerFront(0);
		proj.setLayerLeft(0);
		
		/*Table table = new Table("Annex Pink Table");
		table.setFrontSpritePath(annexFolder + "front/layer0/pinkTable.png");
		table.loadSprites();
		table.setBehaviour(Behaviours.projectorBehaviour(table));
		annex.addToFront(table);
		table.setLayerFront(0);*/
		
		//Door
		DoorObject annexToMain = new DoorObject("Annex To Main");
		annexToMain.setLeftSpritePath(annexFolder + "left/layer0/doorMainA.png");
		annexToMain.loadSprites();
		annexToMain.setBehaviour(AnnexBehaviours.doorMainBehaviour(annexToMain));
		annex.addToLeft(annexToMain);
		annexToMain.setLayerLeft(0);
		annexToMain.lock();
		
		//Keypad
		GenericObject annexToMainKeypad = new GenericObject("Annex to Main Keypad");
		annexToMainKeypad.setLeftSpritePath(annexFolder + "left/layer1/keypad.png");
		annexToMainKeypad.loadSprites();
		//AnnexBehaviours.keypadBehavour IS supposed to take the door and not the keypad, it isn't a mistake.
		annexToMainKeypad.setBehaviour(AnnexBehaviours.keypadBehaviour(annexToMain));
		annex.addToLeft(annexToMainKeypad);
		annexToMainKeypad.setLayerLeft(1);
		
		//Door to study room 1
		DoorObject annexToStudy1 = new DoorObject("Annex To Study Room 1");
		annexToStudy1.setRightSpritePath(annexFolder + "right/layer0/leftDoor.png");
		annexToStudy1.loadSprites();
		annexToStudy1.setBehaviour(AnnexBehaviours.doorStudy1Behaviour(annexToStudy1));
		annex.addToRight(annexToStudy1);
		annexToStudy1.setLayerRight(0);
		
		//Door to study room 2
		DoorObject annexToStudy2 = new DoorObject("Annex To Study Room 2");
		annexToStudy2.setRightSpritePath(annexFolder + "right/layer0/rightDoor.png");
		annexToStudy2.loadSprites();
		annexToStudy2.setBehaviour(AnnexBehaviours.doorStudy2Behaviour(annexToStudy2));
		annex.addToRight(annexToStudy2);
		annexToStudy2.setLayerRight(0);
		
		//Door to study room 3
		DoorObject annexToStudy3 = new DoorObject("Annex To Study Room 3");
		annexToStudy3.setBackSpritePath(annexFolder + "back/layer0/leftDoor.png");
		annexToStudy3.loadSprites();
		annexToStudy3.setBehaviour(AnnexBehaviours.doorStudy3Behaviour(annexToStudy3));
		annex.addToBack(annexToStudy3);
		annexToStudy3.setLayerBack(0);
		
		DoorObject annexToStudy4 = new DoorObject("Annex To Study Room 4");
		annexToStudy4.setBackSpritePath(annexFolder + "back/layer0/rightDoor.png");
		annexToStudy4.loadSprites();
		annexToStudy4.setBehaviour(AnnexBehaviours.doorStudy4Behaviour(annexToStudy4));
		annex.addToBack(annexToStudy4);
		annexToStudy4.setLayerBack(0);
		
		DoorObject annexToCove = new DoorObject("Annex To Cove");
		annexToCove.setBackSpritePath(annexFolder + "back/layer0/coveArrow.png");
		annexToCove.setRightSpritePath(annexFolder + "right/layer0/coveArrow.png");
		annexToCove.loadSprites();
		annex.addToBack(annexToCove);
		annex.addToRight(annexToCove);
		annexToCove.setLayerBack(0);
		annexToCove.setLayerRight(0);
		
		//keep adding stuff
		return annex;
	}
	
	private static Room setupMainA() { //ERICA
		Room mainA = new Room("mainA");

		String mainAFolder = "./graphics/game_graphics/rooms/MainA/";
		
		String frontPaths[] = {mainAFolder  + "front/layer0/mainA_front_0.png"};
		String rightPaths[] = {mainAFolder +  "right/layer0/mainA_right_0.png"};
		String backPaths[] = {mainAFolder+  "back/layer0/mainA_back_0.png"};
		String leftPaths[] = {mainAFolder +  "left/layer0/mainA_left_0.png"};

		mainA.setLayerBackgroundsFront(frontPaths);
		mainA.setLayerBackgroundsRight(rightPaths);
		mainA.setLayerBackgroundsBack(backPaths);
		mainA.setLayerBackgroundsLeft(leftPaths);
		
		
		//right
		//Door door = new Door();
		//MainA.addToRight(door);
		GenericObject couch2 = new GenericObject("Main A Couch");
		mainA.addToRight(couch2);
		Table table = new Table();
		mainA.addToRight(table);
		
		//back
		InfoObject notebook = new InfoObject("I am so over this programming assignment. I'm getting a bit hungry!"
				+ "I will grab some of the coins I hid in the study room  and grab some snacks."
				+ " Hope I can pass this class!");
		mainA.addToBack(notebook); //TODO finish notebook creation
		
		WrapperObject lab1key = new WrapperObject("Study 1 Key Object", new Item("Study 1 Key"));
		mainA.addToBack(lab1key); //TODO finish key creation
		
		
		//left
		//add a doorway
		return mainA;
	}
	
	private static Room setupMainB() { //ERICA
		
		Room MainB = new Room("mainB");
		
		//F
		GenericObject whiteboard = new GenericObject("Main B Whiteboard"); //TODO finish setting up whiteboard
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
		
		
		//B
		//facing Main A
		
		
		//L
		//Facing Main C
		
		return MainB;
	}
	private static Room setupMainC() {  //ERICA
		Room mainC = new Room("mainC");
		
		String mainCFolder = "./graphics/game_graphics/rooms/MainC/";
		
		String frontPaths[] = {mainCFolder  + "front/layer0/mainC_front_0.png"};
		String rightPaths[] = {mainCFolder +  "right/layer0/mainC_right_0.png"};
		String backPaths[] = {mainCFolder+  "back/layer0/mainC_back_0.png"};
		String leftPaths[] = {mainCFolder +  "left/layer0/mainC_left_0.png"};
		
		mainC.setLayerBackgroundsFront(frontPaths);
		mainC.setLayerBackgroundsRight(rightPaths);
		mainC.setLayerBackgroundsBack(backPaths);
		mainC.setLayerBackgroundsLeft(leftPaths);
		
		DoorObject d1 = new DoorObject("MainC to Front Door");
		d1.setLeftSpritePath(mainCFolder + "left/layer0/frontDoor.png");
		d1.setFrontSpritePath(mainCFolder + "front/layer0/FrontDoor.png");
		d1.loadSprites();
		//d1.setBehaviour(behaviour);
		mainC.addToLeft(d1);
		mainC.addToFront(d1);
		
		return mainC;
	}
	
	private static Room setupMainD() {  //ERICA
		Room mainD = new Room("mainD");
		
		String mainDFolder = "./graphics/game_graphics/rooms/MainD/";
		
		String frontPaths[] = {mainDFolder  + "front/layer0/mainD_front_0.png"};
		
		String rightPaths[] = {mainDFolder +  "right/layer0/mainD_right_0.png"};
		
		String backPaths[] = {mainDFolder+  "back/layer0/mainD_back_0.png"};
		
		String leftPaths[] = {mainDFolder +  "left/layer0/mainD_left_0.png"};

		mainD.setLayerBackgroundsFront(frontPaths);
		mainD.setLayerBackgroundsRight(rightPaths);
		mainD.setLayerBackgroundsBack(backPaths);
		mainD.setLayerBackgroundsLeft(leftPaths);
		
		//Vending Machine
		ContainerObject vm1 = new ContainerObject("MainD Vending Machine"); //TODO implement vending machine behaviour
		vm1.setRightSpritePath(mainDFolder + "right/layer0/vend.png");
		vm1.setBackSpritePath(mainDFolder + "back/layer0/vending.png");
		vm1.loadSprites();
		vm1.setBehaviour(MainDBehaviours.vendingMachineBehavior(vm1));
		mainD.addToBack(vm1);
		vm1.setLayerFront(0);
		
		//LabDoor
		DoorObject d1 = new DoorObject("MainD to Lab");
		d1.setLeftSpritePath(mainDFolder + "left/layer0/Lab1Door.png");
		d1.loadSprites();
		d1.setBehaviour(MainDBehaviours.Lab1DoorBehaviour(d1));
		mainD.addToLeft(d1);
		d1.setLayerLeft(0);
		
		//HallwayDoor
		DoorObject d2 = new DoorObject("MainD to Hallway");
		d2.setLeftSpritePath(mainDFolder + "left/layer0/HallwayDoor.png");
		d2.setBackSpritePath(mainDFolder + "back/layer0/hallwayDoor.png");
		d2.loadSprites();
		d2.setBehaviour(MainDBehaviours.HallwayBehaviour(d2));
		mainD.addToBack(d2);
		mainD.addToLeft(d2);
		d2.setLayerBack(0);
		d2.setLayerLeft(0);
		
		//AnnexDoor
		DoorObject d3 = new DoorObject("MainD to Annex");
		d3.setRightSpritePath(mainDFolder + "right/layer0/AnnexDoor.png");
		d3.loadSprites();
		mainD.addToRight(d3);
		d3.setLayerBack(0);
		
		//dustbins
		ContainerObject db1 = new ContainerObject("MainD Dustbin1");
		db1.setRightSpritePath(mainDFolder + "right/layer0/dustbin.png");
		db1.setBackSpritePath(mainDFolder + "back/layer0/dustbin.png");
		db1.setLeftSpritePath(mainDFolder + "left/layer0/dustbin.png");
		db1.loadSprites();
		db1.setBehaviour(MainDBehaviours.DustbinBehavior());
		mainD.addToBack(db1);
		mainD.addToRight(db1);
		mainD.addToLeft(db1);
		db1.setLayerBack(0);
		db1.setLayerRight(0);
		db1.setLayerLeft(0);

		ContainerObject db2 = new ContainerObject("MainD Dustbin2");
		db2.setRightSpritePath(mainDFolder + "right/layer0/dustbin2.png");
		db2.setBehaviour(MainDBehaviours.DustbinBehavior());
		mainD.addToRight(db2);
		db2.setLayerRight(0);
		
		return mainD;
	}
	
	private static Room setupStudy1() {
		String study1folder = "./graphics/game_graphics/rooms/study1/";
		String[] rightLayerPaths = {study1folder + "right/layer0/study1_right_0.png"};
		String[] leftLayerPaths = {study1folder + "left/layer0/study1_left_0.png"};
		
		Room study1;
		try {
			study1 = new Room("Study Room 1", false, true, false, true);

		} catch (Exception e) {
			//this will never happen, but added some code here to get compiler to stop complaining
			System.err.println("Error creating study1!");
			e.printStackTrace();
			study1 = new Room("study1");
		}
		
		study1.setLayerBackgroundsRight(rightLayerPaths);
		study1.setLayerBackgroundsLeft(leftLayerPaths);
		
		DoorObject doorOut = new DoorObject("Study1_To_Annex");
		doorOut.setLeftSpritePath(study1folder + "left/layer0/door.png");
		doorOut.loadSprites();
		doorOut.setBehaviour(Study1Behaviours.doorOutBehaviour(doorOut));
		study1.addToLeft(doorOut);
		doorOut.setLayerLeft(0);
		
		//add beanbag
		GenericObject s1Beanbag = new GenericObject("SR1 Beanbag");
		s1Beanbag.setRightSpritePath(study1folder + "right/layer0/beanbag.png");
		s1Beanbag.loadSprites();
		s1Beanbag.setBehaviour(Study1Behaviours.beanbagBehaviour(s1Beanbag));
		study1.addToRight(s1Beanbag);
		s1Beanbag.setLayerRight(0);
		
		//add couch
		GenericObject s1Couch = new GenericObject("SR1 Couch");
		s1Couch.setLeftSpritePath(study1folder + "left/layer0/couch.png");
		s1Couch.setRightSpritePath(study1folder + "right/layer0/couch.png");
		s1Couch.loadSprites();
		s1Couch.setBehaviour(Study1Behaviours.couchBehaviour(s1Couch));
		study1.addToLeft(s1Couch);
		study1.addToRight(s1Couch);
		s1Couch.setLayerLeft(0);
		s1Couch.setLayerRight(0);
		
		//add table
		Table s1Table = new Table("SR1 Table");
		s1Table.setLeftSpritePath(study1folder + "left/layer0/table.png");
		s1Table.setRightSpritePath(study1folder + "right/layer0/table.png");
		s1Table.loadSprites();
		s1Table.setBehaviour(Study1Behaviours.tableBehaviour(s1Table));
		study1.addToLeft(s1Table);
		study1.addToRight(s1Table);
		s1Table.setLayerLeft(0);
		s1Table.setLayerRight(0);
		
		//add lightswitch
		GenericObject s1LightSwitch = new GenericObject("SR1 Light Switch");
		s1LightSwitch.setLeftSpritePath(study1folder + "left/layer0/switch.png");
		s1LightSwitch.loadSprites();
		s1LightSwitch.setBehaviour(Study1Behaviours.LightSwitchBehaviour());
		study1.addToLeft(s1LightSwitch);
		s1LightSwitch.setLayerLeft(0);
		
		return study1;
	}
	
	private static Room setupStudy2() {
		String study2folder = "./graphics/game_graphics/rooms/study2/";
		String[] rightLayerPaths = {study2folder + "right/layer0/study2_right_0.png"};
		String[] leftLayerPaths = {study2folder + "left/layer0/study2_left_0.png"};
		
		Room study2;
		
		try {
			study2 = new Room("Study Room 2", false, true, false, true);
		} catch (Exception e) {
			//this will never happen, but added some code here to get compiler to stop complaining
			System.err.println("Error creating study2!");
			e.printStackTrace();
			study2 = new Room("Study Room 2");
		}
		
		study2.setLayerBackgroundsRight(rightLayerPaths);
		study2.setLayerBackgroundsLeft(leftLayerPaths);
		
		//add door
		DoorObject doorOut = new DoorObject("Study2_To_Annex");
		doorOut.setLeftSpritePath(study2folder + "left/layer0/door.png");
		doorOut.loadSprites();
		doorOut.setBehaviour(Study2Behaviours.doorOutBehaviour(doorOut));
		study2.addToLeft(doorOut);
		doorOut.setLayerLeft(0);
		
		//add couch
		GenericObject s2Couch = new GenericObject("SR2 Couch");
		s2Couch.setLeftSpritePath(study2folder + "left/layer0/couch.png");
		s2Couch.setRightSpritePath(study2folder + "right/layer0/couch.png");
		s2Couch.loadSprites();
		s2Couch.setBehaviour(Study2Behaviours.couchBehaviour(s2Couch));
		study2.addToLeft(s2Couch);
		study2.addToRight(s2Couch);
		s2Couch.setLayerLeft(0);
		s2Couch.setLayerRight(0);
		
		//add plant
		GenericObject s2Plant = new GenericObject("S2 Plant");
		s2Plant.setRightSpritePath(study2folder + "right/layer0/plant.png");
		s2Plant.loadSprites();
		s2Plant.setBehaviour(Study2Behaviours.plantBehaviour(s2Plant));
		study2.addToRight(s2Plant);
		s2Plant.setLayerRight(0);
				
		
		//add table
		Table s2Table = new Table("SR2 Table");
		s2Table.setLeftSpritePath(study2folder + "left/layer0/table.png");
		s2Table.setRightSpritePath(study2folder + "right/layer0/table.png");
		s2Table.loadSprites();
		s2Table.setBehaviour(Study2Behaviours.tableBehaviour(s2Table));
		study2.addToLeft(s2Table);
		study2.addToRight(s2Table);
		s2Table.setLayerLeft(0);
		s2Table.setLayerRight(0);
		
		//switch
		GenericObject s2LightSwitch = new GenericObject("SR2 Light Switch");
		s2LightSwitch.setLeftSpritePath(study2folder + "left/layer0/switch.png");
		s2LightSwitch.loadSprites();
		s2LightSwitch.setBehaviour(Study2Behaviours.lightSwitchBehaviour(s2LightSwitch));
		study2.addToLeft(s2LightSwitch);
		s2LightSwitch.setLayerLeft(0);
		
		
		return study2;
	}
	
	private static Room setupStudy3() {
		
		String study3folder = "./graphics/game_graphics/rooms/study3/";
		String[] frontLayerPaths = {study3folder + "front/layer0/study3_front_0.png"};
		String[] backLayerPaths = {study3folder + "back/layer0/study3_back_0.png"};
		
		Room study3;
		try {
			study3 = new Room("Study Room 3", true, false, true, false);
			study3.setLayerBackgroundsFront(frontLayerPaths);
			study3.setLayerBackgroundsBack(backLayerPaths);		
		}  catch (Exception e) {
			//this will never happen, but added some code here to get compiler to stop complaining
			System.err.println("Error creating study3!");
			e.printStackTrace();
			study3 = new Room("Study Room 3");
		}
		
		//add door
		DoorObject doorOut = new DoorObject("Stud3_To_Annex");
		doorOut.setFrontSpritePath(study3folder + "front/layer0/door.png");
		doorOut.loadSprites();
		doorOut.setBehaviour(Study3Behaviours.doorOutBehaviour(doorOut));
		study3.addToFront(doorOut);
		doorOut.setLayerFront(0);
		
		//add plant --back
		GenericObject plant = new GenericObject("SR3 Plant");
		plant.setFrontSpritePath(study3folder + "front/layer0/plant.png");
		plant.loadSprites();
		plant.setBehaviour(Study3Behaviours.plant());
		study3.addToFront(plant);
		plant.setLayerBack(0);
		
		//add couch
		GenericObject s3Couch = new GenericObject("SR3 Couch");
		s3Couch.setBackSpritePath(study3folder + "back/layer0/couch.png");
		s3Couch.setFrontSpritePath(study3folder + "front/layer0/couch.png");
		s3Couch.loadSprites();
		s3Couch.setBehaviour(Study3Behaviours.couchBehaviour(s3Couch));
		study3.addToBack(s3Couch);
		study3.addToFront(s3Couch);
		s3Couch.setLayerBack(0);
		s3Couch.setLayerFront(0);
		
		//add table
		Table s3Table = new Table("SR3 Table");
		s3Table.setFrontSpritePath(study3folder + "front/layer0/table.png");
		s3Table.setBackSpritePath(study3folder + "back/layer0/table.png");
		s3Table.loadSprites();
		s3Table.setBehaviour(Study3Behaviours.tableBehaviour());
		study3.addToBack(s3Table);
		study3.addToFront(s3Table);
		s3Table.setLayerBack(0);
		s3Table.setLayerFront(0);
		
		
		
		return study3;
	}
	
	private static Room setupStudy4() {
		String study4folder = "./graphics/game_graphics/rooms/study4/";
		String[] frontLayerPaths = {study4folder + "front/layer0/study4_front_0.png"};
		String[] backLayerPaths = {study4folder + "back/layer0/study4_back_0.png"};
		
		Room study4;
		try {
			study4 = new Room("Study Room 4", true, false, true, false);
			study4.setLayerBackgroundsFront(frontLayerPaths);
			study4.setLayerBackgroundsBack(backLayerPaths);
			
		}
		catch (Exception e) {
			//this will never happen, but added some code here to get compiler to stop complaining
			System.err.println("Error creating study4!");
			e.printStackTrace();
			study4 = new Room("Study Room 4");
		}
		return study4;
	}
	
	
	private static Room setupCove() { //RAHUL
		Room cove;
		try {
			cove = new Room("Cove", true, true, false, false);
		} catch (Exception e) {
			//this will never happen, but added some code here to get compiler to stop complaining
			System.err.println("Error creating cove!");
			e.printStackTrace();
			cove = new Room("Cove");
		}
		
		
		
		return cove;
	}
	
	private static Room setupLab1() { //ERICA
		Room Lab1 = new Room("lab1");
		
		//F
		//R

		//B
		//L
		//CP cp = new CP();
		//Lab1.addToLeft(cp);
		InfoObject computer1 = new InfoObject("Lab 1 Computer");
		Lab1.addToLeft(computer1); //new 
		
		
		return Lab1;
	}
	
	private static Room setupHallway1() { //PATRICK
		Room ret = new Room("hallway1");
		return ret;
	}
	
	private static Room setupHallway2() { //RAHUL
		Room room = new Room("hallway2");
		return room;
	}
	
	private static Room setupMensRoom() { //ERICA
		Room ret = new Room("mensRoom");
		
		return ret;
	}
	
	private static Room setupWomensRoom() { //PATRICK
		Room ret = new Room("womensRoom");
		return ret;
	}
}


/* old connections code:

//ALL CONNECTIONS

		//Annex
		
		Doorway annex_cove = new Doorway();
		annex.addExitRight(annex_cove);
		cove.addExitLeft(annex_cove);
		
		 *
		 * Study Room Connections
		 * Annex-1, Annex-2, Annex-3, Annex-4
		 *
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
		
		 *
		 * main room internal connections
		 * A-D, A-B, B-C, C-D
		 *
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
*/