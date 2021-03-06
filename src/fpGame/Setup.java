package fpGame;

//java imports
import java.util.ArrayList;
import java.util.List;

//javafx imports
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
	
	public static void setupAll() { 
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
		GameUtil.stage().setTitle("USCape!");
		GameUtil.displayPlayerView(); //use this as a template for all other room displays
	}
	
	private static Room setupAnnex() { //RAHUL
		String annexFolder = "./graphics/game_graphics/rooms/annex/";
		Room annex = new Room("annex");
		
		String frontPaths[] = {annexFolder + "front/layer0/annex_front_0.png", annexFolder + "front/layer1/annex_front_1.png",
				annexFolder + "front/layer2/annex_front_2.png"};
		
		String rightPaths[] = {annexFolder +  "right/layer0/annex_right_0.png", annexFolder +  "right/layer1/annex_right_1.png", 
				annexFolder + "right/layer2/annex_right_2.png"};
		
		String backPaths[] = {annexFolder +  "back/layer0/annex_back_0.png"};
		
		String leftPaths[] = {annexFolder +  "left/layer0/annex_left_0.png", annexFolder + "left/layer1/annex_left_1.png"};

		annex.setLayerBackgroundsFront(frontPaths);
		annex.setLayerBackgroundsRight(rightPaths);
		annex.setLayerBackgroundsBack(backPaths);
		annex.setLayerBackgroundsLeft(leftPaths);
		
		InfoObject c1 = new InfoObject("Annex Computer 1");
		c1.setFrontSpritePath(annexFolder + "front/layer1/mon0.png");
		c1.loadSprites();
		c1.setBehaviour(AnnexBehaviours.annexWrongComputerBehaviour(c1));
		annex.addInfoFront(c1);
		c1.setLayerFront(1);
		
		InfoObject c2 = new InfoObject("Annex Computer 2");
		c2.setFrontSpritePath(annexFolder + "front/layer1/mon1.png");
		//add remaining sprite paths
		c2.loadSprites();		
		c2.setBehaviour(AnnexBehaviours.annexComputer2Behaviour(c2));
		annex.addInfoFront(c2);
		c2.setLayerFront(1);
		
		InfoObject c3 = new InfoObject("Annex Computer 3");
		c3.setFrontSpritePath(annexFolder + "front/layer1/mon2.png");
		c3.loadSprites();
		c3.setBehaviour(AnnexBehaviours.annexWrongComputerBehaviour(c3));
		annex.addInfoFront(c3);
		c3.setLayerFront(1);
		
		InfoObject c4 = new InfoObject("Annex Computer 4");
		c4.setFrontSpritePath(annexFolder + "front/layer1/mon3.png");
		c4.loadSprites();
		c4.setBehaviour(AnnexBehaviours.annexWrongComputerBehaviour(c4));
		annex.addInfoFront(c4);
		c4.setLayerFront(1);
		
		//computer 5 loads up an image of a cat 
		InfoObject c5 = new InfoObject("Annex Computer 5");
		c5.setFrontSpritePath(annexFolder + "front/layer2/mon4.png");
		c5.loadSprites();
		c5.setBehaviour(AnnexBehaviours.annexComputer5Behaviour(c5));
		annex.addInfoFront(c5);
		c5.setLayerFront(2);
		
		InfoObject c6 = new InfoObject("Annex Computer 6");
		c6.setFrontSpritePath(annexFolder + "front/layer2/mon5.png");
		c6.loadSprites();
		c6.setBehaviour(AnnexBehaviours.annexWrongComputerBehaviour(c6));
		annex.addInfoFront(c6);
		c6.setLayerFront(2);
		
		//computer 7 -- write down the correct word then type enter
		InfoObject c7 = new InfoObject("Annex Computer 7", "The passcode to the annex-main door is 5417.");
		c7.setFrontSpritePath(annexFolder + "front/layer2/mon6.png");
		c7.loadSprites();
		c7.setBehaviour(AnnexBehaviours.annexComputer7Behaviour(c7));
		annex.addInfoFront(c7);
		c7.setLayerFront(2);
		
		InfoObject c8 = new InfoObject("Annex Computer 8");
		c8.setFrontSpritePath(annexFolder + "front/layer2/mon7.png");
		c8.loadSprites();
		c8.setBehaviour(AnnexBehaviours.annexWrongComputerBehaviour(c8));
		annex.addInfoFront(c8);
		c8.setLayerFront(2);
		
		GenericObject projection = new GenericObject("Annex Projection");
		projection.setFrontSpritePath("./graphics/game_graphics/rooms/annex/front/layer0/projMess.png");
		projection.loadSprites();
		projection.setBehaviour(AnnexBehaviours.projectionBehaviour(projection));
		annex.addGenericFront(projection);
		projection.setLayerFront(0);
		projection.hide();
		
		//projector
		GenericObject proj = new GenericObject("Annex Projector");
		proj.setFrontSpritePath(annexFolder + "front/layer0/projSwitch.png");
		proj.setLeftSpritePath(annexFolder + "left/layer0/projSwitch.png");
		proj.loadSprites();
		proj.setBehaviour(AnnexBehaviours.projectorBehaviour(projection));
		annex.addGenericFront(proj);
		annex.addGenericLeft(proj);
		proj.setLayerFront(0);
		proj.setLayerLeft(0);
		
		//Door
		DoorObject annexToMain = new DoorObject("Annex To Main");
		annexToMain.setLeftSpritePath(annexFolder + "left/layer0/doorMainA.png");
		annexToMain.loadSprites();
		annexToMain.setBehaviour(AnnexBehaviours.doorMainBehaviour(annexToMain));
		annex.addDoorLeft(annexToMain);
		annexToMain.setLayerLeft(0);
		annexToMain.lock();
		
		//Keypad
		GenericObject annexToMainKeypad = new GenericObject("Annex to Main Keypad");
		annexToMainKeypad.setLeftSpritePath(annexFolder + "left/layer1/keypad.png");
		annexToMainKeypad.loadSprites();
		//AnnexBehaviours.keypadBehavour IS supposed to take the door and not the keypad, it isn't a mistake.
		annexToMainKeypad.setBehaviour(AnnexBehaviours.keypadMainBehaviour(annexToMain));
		annex.addGenericLeft(annexToMainKeypad);
		annexToMainKeypad.setLayerLeft(1);
		
		//Door to study room 1
		DoorObject annexToStudy1 = new DoorObject("Annex To Study Room 1");
		annexToStudy1.setFrontSpritePath(annexFolder + "front/layer0/door.png");
		annexToStudy1.setRightSpritePath(annexFolder + "right/layer0/leftDoor.png");
		annexToStudy1.loadSprites();
		annexToStudy1.setBehaviour(AnnexBehaviours.doorStudy1Behaviour(annexToStudy1));
		annex.addDoorRight(annexToStudy1);
		annex.addDoorFront(annexToStudy1);
		annexToStudy1.setLayerRight(0);
		annexToStudy1.setLayerFront(0);
		annexToStudy1.lock();
		
		//Door to study room 2
		DoorObject annexToStudy2 = new DoorObject("Annex To Study Room 2");
		annexToStudy2.setRightSpritePath(annexFolder + "right/layer0/rightDoor.png");
		annexToStudy2.loadSprites();
		annexToStudy2.setBehaviour(AnnexBehaviours.doorStudy2Behaviour(annexToStudy2));
		annex.addDoorRight(annexToStudy2);
		annexToStudy2.setLayerRight(0);
		
		//Door to study room 3
		DoorObject annexToStudy3 = new DoorObject("Annex To Study Room 3");
		annexToStudy3.setBackSpritePath(annexFolder + "back/layer0/leftDoor.png");
		annexToStudy3.loadSprites();
		annexToStudy3.setBehaviour(AnnexBehaviours.doorStudy3Behaviour(annexToStudy3));
		annex.addDoorBack(annexToStudy3);
		annexToStudy3.setLayerBack(0);
		
		DoorObject annexToStudy4 = new DoorObject("Annex To Study Room 4");
		annexToStudy4.setBackSpritePath(annexFolder + "back/layer0/rightDoor.png");
		annexToStudy4.loadSprites();
		annexToStudy4.setBehaviour(AnnexBehaviours.doorStudy4Behaviour(annexToStudy4));
		annex.addDoorBack(annexToStudy4);
		annexToStudy4.setLayerBack(0);
		annexToStudy4.lock();
		
		GenericObject annexToStudy4Keypad = new GenericObject("Annex to Study Room 4 Keypad");
		annexToStudy4Keypad.setBackSpritePath(annexFolder + "back/layer0/keypad.png");
		annexToStudy4Keypad.loadSprites();
		annexToStudy4Keypad.setBehaviour(AnnexBehaviours.keypadStudyBehaviour(annexToStudy4));
		annex.addGenericBack(annexToStudy4Keypad);
		annexToStudy4Keypad.setLayerBack(0);
		
		DoorObject annexToCove = new DoorObject("Annex To Cove");
		annexToCove.setBackSpritePath(annexFolder + "back/layer0/coveArrow.png");
		annexToCove.setRightSpritePath(annexFolder + "right/layer0/coveArrow.png");
		annexToCove.loadSprites();
		annexToCove.setBehaviour(AnnexBehaviours.doorCoveBehaviour(annexToCove));
		annex.addDoorBack(annexToCove);
		annex.addDoorRight(annexToCove);
		annexToCove.setLayerBack(0);
		annexToCove.setLayerRight(0);
		
		//keep adding stuff
		return annex;
	}
	
	private static Room setupMainA() {
		Room mainA = new Room("mainA");

		String mainAFolder = "./graphics/game_graphics/rooms/mainA/";
		
		String frontPaths[] = {mainAFolder  + "front/layer0/mainA_front_0.png"};
		String rightPaths[] = {mainAFolder +  "right/layer0/mainA_right_0.png"};
		String backPaths[] = {mainAFolder+  "back/layer0/mainA_back_0.png"};
		String leftPaths[] = {mainAFolder +  "left/layer0/mainA_left_0.png", mainAFolder + "left/layer1/mainA_left_1.png"};

		mainA.setLayerBackgroundsFront(frontPaths);
		mainA.setLayerBackgroundsRight(rightPaths);
		mainA.setLayerBackgroundsBack(backPaths);
		mainA.setLayerBackgroundsLeft(leftPaths);
		
		DoorObject mainToAnnex = new DoorObject("Main To Annex");
		mainToAnnex.setRightSpritePath(mainAFolder + "right/layer0/annexDoor.png");
		mainToAnnex.setBackSpritePath(mainAFolder + "back/layer0/annexDoor.png");
		mainToAnnex.loadSprites();
		mainToAnnex.setBehaviour(MainABehaviours.doorAnnexBehaviour(mainToAnnex));
		mainA.addDoorRight(mainToAnnex);
		mainA.addDoorBack(mainToAnnex);
		mainToAnnex.setLayerBack(0);
		mainToAnnex.setLayerRight(0);
		
		DoorObject mainBArrow = new DoorObject("Main A To Main B");
		mainBArrow.setFrontSpritePath(mainAFolder + "front/layer0/MainB_arrow.png");
		mainBArrow.setRightSpritePath(mainAFolder + "right/layer0/MainB_arrow.png");
		mainBArrow.setBackSpritePath(mainAFolder + "back/layer0/MainB_arrow.png");
		mainBArrow.setLeftSpritePath(mainAFolder + "left/layer0/MainB_arrow.png");
		mainBArrow.loadSprites();
		mainBArrow.setBehaviour(MainABehaviours.arrowBBehaviour(mainBArrow));
		mainA.addDoorFront(mainBArrow);
		mainA.addDoorRight(mainBArrow);
		mainA.addDoorBack(mainBArrow);
		mainA.addDoorLeft(mainBArrow);
		mainBArrow.setLayerFront(0);
		mainBArrow.setLayerRight(0);
		mainBArrow.setLayerBack(0);
		mainBArrow.setLayerLeft(0);
		
		DoorObject mainDArrow = new DoorObject("Main A To Main D");
		mainDArrow.setFrontSpritePath(mainAFolder + "front/layer0/MainD_arrow.png");
		mainDArrow.setRightSpritePath(mainAFolder + "right/layer0/MainD_arrow.png");
		mainDArrow.setBackSpritePath(mainAFolder + "back/layer0/MainD_arrow.png");
		mainDArrow.setLeftSpritePath(mainAFolder + "left/layer0/MainD_arrow.png");
		mainDArrow.loadSprites();
		mainDArrow.setBehaviour(MainABehaviours.arrowDBehaviour(mainDArrow));
		mainA.addDoorFront(mainDArrow);
		mainA.addDoorRight(mainDArrow);
		mainA.addDoorBack(mainDArrow);
		mainA.addDoorLeft(mainDArrow);
		mainDArrow.setLayerFront(0);
		mainDArrow.setLayerRight(0);
		mainDArrow.setLayerBack(0);
		mainDArrow.setLayerLeft(0);
		
		Item study1Key = new Item("SR1 Key");
		WrapperObject keyWrapper = new WrapperObject("SR1 Key", study1Key);
		keyWrapper.setFrontSpritePath(mainAFolder + "front/layer0/key.png");
		keyWrapper.setRightSpritePath(mainAFolder + "right/layer0/key.png");
		keyWrapper.setBackSpritePath(mainAFolder + "back/layer0/key.png");
		keyWrapper.setLeftSpritePath(mainAFolder + "left/layer0/key.png");
		keyWrapper.loadSprites();
		keyWrapper.setBehaviour(MainABehaviours.keyBehaviour(keyWrapper));
		mainA.addWrapperFront(keyWrapper);
		mainA.addWrapperRight(keyWrapper);
		mainA.addWrapperBack(keyWrapper);
		mainA.addWrapperLeft(keyWrapper);
		keyWrapper.setLayerFront(0);
		keyWrapper.setLayerRight(0);
		keyWrapper.setLayerBack(0);
		keyWrapper.setLayerLeft(0);
		
		ContainerObject vendingMachine = new ContainerObject("Main A Vending Machine");
		vendingMachine.setBackSpritePath(mainAFolder + "back/layer0/vending.png");
		vendingMachine.setLeftSpritePath(mainAFolder + "left/layer0/vending.png");
		vendingMachine.loadSprites();
		vendingMachine.setBehaviour(MainABehaviours.vendingMachineBehaviour(vendingMachine));
		mainA.addContainerBack(vendingMachine);
		mainA.addContainerLeft(vendingMachine);
		vendingMachine.setLayerBack(0);
		vendingMachine.setLayerLeft(0);
		
		/*
		GenericObject couch2 = new GenericObject("Main A Couch");
		mainA.addGenericRight(couch2);
		*/
		
		return mainA;
	}
	
	private static Room setupMainB() { 
		String mainBFolder = "./graphics/game_graphics/rooms/mainB/";
		
		Room mainB = new Room("mainB");
		
		String frontPaths[] = {mainBFolder  + "front/layer0/mainB_front_0.png"};
		String rightPaths[] = {mainBFolder +  "right/layer0/mainB_right_0.png"};
		String backPaths[] = {mainBFolder+  "back/layer0/mainB_back_0.png"};
		String leftPaths[] = {mainBFolder +  "left/layer0/mainB_left_0.png"};

		mainB.setLayerBackgroundsFront(frontPaths);
		mainB.setLayerBackgroundsRight(rightPaths);
		mainB.setLayerBackgroundsBack(backPaths);
		mainB.setLayerBackgroundsLeft(leftPaths);
		
		DoorObject mainAArrow = new DoorObject("Main B to Main A");
		mainAArrow.setFrontSpritePath(mainBFolder + "front/layer0/MainA_arrow.png");
		mainAArrow.setRightSpritePath(mainBFolder + "right/layer0/MainA_arrow.png");
		mainAArrow.setBackSpritePath(mainBFolder + "back/layer0/MainA_arrow.png");
		mainAArrow.setLeftSpritePath(mainBFolder + "left/layer0/MainA_arrow.png");
		mainAArrow.loadSprites();
		mainAArrow.setBehaviour(MainBBehaviours.arrowABehaviour(mainAArrow));
		mainB.addDoorFront(mainAArrow);
		mainB.addDoorRight(mainAArrow);
		mainB.addDoorBack(mainAArrow);
		mainB.addDoorLeft(mainAArrow);
		mainAArrow.setLayerFront(0);
		mainAArrow.setLayerRight(0);
		mainAArrow.setLayerBack(0);
		mainAArrow.setLayerLeft(0);
		
		DoorObject mainCArrow = new DoorObject("Main B to Main C");
		mainCArrow.setFrontSpritePath(mainBFolder + "front/layer0/MainC_arrow.png");
		mainCArrow.setRightSpritePath(mainBFolder + "right/layer0/MainC_arrow.png");
		mainCArrow.setBackSpritePath(mainBFolder + "back/layer0/MainC_arrow.png");
		mainCArrow.setLeftSpritePath(mainBFolder + "left/layer0/MainC_arrow.png");
		mainCArrow.loadSprites();
		mainCArrow.setBehaviour(MainBBehaviours.arrowCBehaviour(mainCArrow));
		mainB.addDoorFront(mainCArrow);
		mainB.addDoorRight(mainCArrow);
		mainB.addDoorBack(mainCArrow);
		mainB.addDoorLeft(mainCArrow);
		mainCArrow.setLayerFront(0);
		mainCArrow.setLayerRight(0);
		mainCArrow.setLayerBack(0);
		mainCArrow.setLayerLeft(0);
				
		GenericObject blueCouch = new GenericObject("Main B Blue Couch");
		blueCouch.setFrontSpritePath(mainBFolder + "front/layer0/couch.png");
		blueCouch.setRightSpritePath(mainBFolder + "right/layer0/couch.png");
		blueCouch.loadSprites();
		blueCouch.setBehaviour(MainBBehaviours.couchBehaviour(blueCouch));
		mainB.addGenericFront(blueCouch);
		mainB.addGenericRight(blueCouch);
		blueCouch.setLayerFront(0);
		blueCouch.setLayerRight(0);
		
		GenericObject greenCouch = new GenericObject("Main B Green Couch");
		greenCouch.setRightSpritePath(mainBFolder + "right/layer0/greenCouch.png");
		greenCouch.setBackSpritePath(mainBFolder + "back/layer0/greenCouch.png"); //TODO add graphics file
		greenCouch.loadSprites();
		greenCouch.setBehaviour(MainBBehaviours.couchBehaviour(greenCouch));
		mainB.addGenericRight(greenCouch);
		mainB.addGenericBack(greenCouch);
		greenCouch.setLayerRight(0);
		greenCouch.setLayerBack(0);
		
		GenericObject table = new GenericObject("Main B Table");
		table.setRightSpritePath(mainBFolder + "right/layer0/table.png");
		//table.setBackSpritePath(mainBFolder + "back/layer0/table.png"); //TODO add graphics file
		table.loadSprites();
		table.setBehaviour(MainBBehaviours.tableBehaviour(table));
		mainB.addGenericRight(table);
		mainB.addGenericBack(table);
		table.setLayerRight(0);
		table.setLayerBack(0);
		
		GenericObject chair = new GenericObject("Main B Chair");
		chair.setFrontSpritePath(mainBFolder + "front/layer0/chair.png");
		chair.setRightSpritePath(mainBFolder + "right/layer0/chair.png");
		chair.setBackSpritePath(mainBFolder + "back/layer0/chair.png");
		chair.loadSprites();
		chair.setBehaviour(MainBBehaviours.chairBehaviour(chair));
		mainB.addGenericBack(chair);
		mainB.addGenericFront(chair);
		mainB.addGenericRight(chair);
		chair.setLayerRight(0);
		chair.setLayerBack(0);
		chair.setLayerFront(0);

		
		
		return mainB;
	}
	private static Room setupMainC() { 
		Room mainC = new Room("mainC");
		
		String mainCFolder = "./graphics/game_graphics/rooms/mainC/";
		
		String frontPaths[] = {mainCFolder  + "front/layer0/mainC_front_0.png"};
		String rightPaths[] = {mainCFolder +  "right/layer0/mainC_right_0.png"};
		String backPaths[] = {mainCFolder+  "back/layer0/mainC_back_0.png"};
		String leftPaths[] = {mainCFolder +  "left/layer0/mainC_left_0.png"};
		
		mainC.setLayerBackgroundsFront(frontPaths);
		mainC.setLayerBackgroundsRight(rightPaths);
		mainC.setLayerBackgroundsBack(backPaths);
		mainC.setLayerBackgroundsLeft(leftPaths);
		
		DoorObject mainBArrow = new DoorObject("Main C to Main B");
		mainBArrow.setFrontSpritePath(mainCFolder + "front/layer0/MainB_arrow.png");
		mainBArrow.setRightSpritePath(mainCFolder + "right/layer0/MainB_arrow.png");
		mainBArrow.setBackSpritePath(mainCFolder + "back/layer0/MainB_arrow.png");
		mainBArrow.setLeftSpritePath(mainCFolder + "left/layer0/MainB_arrow.png");
		mainBArrow.loadSprites();
		mainBArrow.setBehaviour(MainCBehaviours.arrowBBehaviour(mainBArrow));
		mainC.addDoorFront(mainBArrow);
		mainC.addDoorRight(mainBArrow);
		mainC.addDoorBack(mainBArrow);
		mainC.addDoorLeft(mainBArrow);
		mainBArrow.setLayerFront(0);
		mainBArrow.setLayerRight(0);
		mainBArrow.setLayerBack(0);
		mainBArrow.setLayerLeft(0);
		
		DoorObject mainDArrow = new DoorObject("Main C to Main D");
		mainDArrow.setFrontSpritePath(mainCFolder + "front/layer0/mainD_arrow.png");
		mainDArrow.setRightSpritePath(mainCFolder + "right/layer0/mainD_arrow.png");
		mainDArrow.setBackSpritePath(mainCFolder + "back/layer0/mainD_arrow.png");
		mainDArrow.setLeftSpritePath(mainCFolder + "left/layer0/mainD_arrow.png");
		mainDArrow.loadSprites();
		mainDArrow.setBehaviour(MainCBehaviours.arrowDBehaviour(mainDArrow));
		mainC.addDoorFront(mainDArrow);
		mainC.addDoorRight(mainDArrow);
		mainC.addDoorBack(mainDArrow);
		mainC.addDoorLeft(mainDArrow);
		mainDArrow.setLayerFront(0);
		mainDArrow.setLayerRight(0);
		mainDArrow.setLayerBack(0);
		mainDArrow.setLayerLeft(0);
		
		DoorObject d1 = new DoorObject("Main C Front Door");
		d1.setLeftSpritePath(mainCFolder + "left/layer0/frontDoor.png");
		d1.setFrontSpritePath(mainCFolder + "front/layer0/FrontDoor.png");
		d1.loadSprites();
		d1.setBehaviour(MainCBehaviours.frontDoorBehaviour(d1));
		mainC.addDoorLeft(d1);
		mainC.addDoorFront(d1);
		d1.setLayerLeft(0);
		d1.setLayerFront(0);
		d1.lock();
		
		GenericObject couch = new GenericObject("Main C Couch");
		couch.setRightSpritePath(mainCFolder + "right/layer0/blueCouch.png");
		//couch.setBackSpritePath(mainCFolder + "back/layer0/blueCouch.png"); 
		couch.setLeftSpritePath(mainCFolder + "left/layer0/blueCouch.png");
		couch.loadSprites();
		couch.setBehaviour(MainCBehaviours.couchBehaviour(couch));
		mainC.addGenericRight(couch);
		mainC.addGenericBack(couch);
		mainC.addGenericLeft(couch);
		couch.setLayerRight(0);
		//couch.setLayerBack(0);
		couch.setLayerLeft(0);
		
		InfoObject notebook = new InfoObject("Main C Notebook", "There is change hidden in the study rooms.");
		notebook.setRightSpritePath(mainCFolder + "right/layer0/notebook.png");
		notebook.setBackSpritePath(mainCFolder + "back/layer0/notebook.png");
		notebook.loadSprites();
		notebook.setBehaviour(MainCBehaviours.notebookBehaviour(notebook));
		mainC.addInfoRight(notebook);
		mainC.addInfoBack(notebook);
		notebook.setLayerRight(0);
		notebook.setLayerBack(0);
		
		GenericObject phone = new GenericObject("Main C Phone");
		phone.setBackSpritePath(mainCFolder + "back/layer0/phone.png");
		phone.loadSprites();
		phone.setBehaviour(MainCBehaviours.phoneBehaviour(d1));
		mainC.addGenericBack(phone);
		phone.setLayerBack(0);
		
		return mainC;
	}
	
	private static Room setupMainD() {  //ERICA
		Room mainD = new Room("mainD");
		
		String mainDFolder = "./graphics/game_graphics/rooms/mainD/";
		
		String frontPaths[] = {mainDFolder  + "front/layer0/mainD_front_0.png"};
		
		String rightPaths[] = {mainDFolder +  "right/layer0/mainD_right_0.png"};
		
		String backPaths[] = {mainDFolder+  "back/layer0/mainD_back_0.png"};
		
		String leftPaths[] = {mainDFolder +  "left/layer0/mainD_left_0.png"};

		mainD.setLayerBackgroundsFront(frontPaths);
		mainD.setLayerBackgroundsRight(rightPaths);
		mainD.setLayerBackgroundsBack(backPaths);
		mainD.setLayerBackgroundsLeft(leftPaths);
		
		DoorObject mainAArrow = new DoorObject("Main D to Main A");
		mainAArrow.setFrontSpritePath(mainDFolder + "front/layer0/MainA_arrow.png");
		mainAArrow.setRightSpritePath(mainDFolder + "right/layer0/MainA_arrow.png");
		mainAArrow.setBackSpritePath(mainDFolder + "back/layer0/MainA_arrow.png");
		mainAArrow.setLeftSpritePath(mainDFolder + "left/layer0/MainA_arrow.png");
		mainAArrow.loadSprites();
		mainAArrow.setBehaviour(MainDBehaviours.arrowABehaviour(mainAArrow));
		mainD.addDoorFront(mainAArrow);
		mainD.addDoorRight(mainAArrow);
		mainD.addDoorBack(mainAArrow);
		mainD.addDoorLeft(mainAArrow);
		mainAArrow.setLayerFront(0);
		mainAArrow.setLayerRight(0);
		mainAArrow.setLayerBack(0);
		mainAArrow.setLayerLeft(0);
		
		DoorObject mainCArrow = new DoorObject("Main D to Main C");
		mainCArrow.setFrontSpritePath(mainDFolder + "front/layer0/MainC_arrow.png");
		mainCArrow.setRightSpritePath(mainDFolder + "right/layer0/MainC_arrow.png");
		mainCArrow.setBackSpritePath(mainDFolder + "back/layer0/MainC_arrow.png");
		mainCArrow.setLeftSpritePath(mainDFolder + "left/layer0/MainC_arrow.png");
		mainCArrow.loadSprites();
		mainCArrow.setBehaviour(MainDBehaviours.arrowCBehaviour(mainCArrow));
		mainD.addDoorFront(mainCArrow);
		mainD.addDoorRight(mainCArrow);
		mainD.addDoorBack(mainCArrow);
		mainD.addDoorLeft(mainCArrow);
		mainCArrow.setLayerFront(0);
		mainCArrow.setLayerRight(0);
		mainCArrow.setLayerBack(0);
		mainCArrow.setLayerLeft(0);
		
		
		
		//Vending Machine
		List<Item> vendingItems = new ArrayList<Item>();
		Item lab1Key = new Item("Lab 1 Key");  
		vendingItems.add(lab1Key);
		vendingItems.add(new Item("Chocolate"));
		vendingItems.add(new Item("Coffee"));
		ContainerObject vm1 = new ContainerObject("MainD Vending Machine", vendingItems);
		vm1.setRightSpritePath(mainDFolder + "right/layer0/vend.png");
		vm1.setBackSpritePath(mainDFolder + "back/layer0/vending.png");
		vm1.loadSprites();
		vm1.setBehaviour(MainDBehaviours.vendingMachineBehaviour(vm1));
		mainD.addContainerBack(vm1);
		mainD.addContainerRight(vm1);
		vm1.setLayerBack(0);
		vm1.setLayerRight(0);
		
		
		//LabDoor
		DoorObject d1 = new DoorObject("Main D To Lab 1");
		d1.setLeftSpritePath(mainDFolder + "left/layer0/Lab1Door.png");
		d1.setBackSpritePath(mainDFolder + "back/layer0/Lab1Door.png");
		d1.loadSprites();
		d1.setBehaviour(MainDBehaviours.doorLab1Behaviour(d1));
		mainD.addDoorLeft(d1);
		mainD.addDoorBack(d1);
		d1.setLayerLeft(0);
		d1.setLayerBack(0);
		d1.lock();
		
		//HallwayDoor
		DoorObject d2 = new DoorObject("MainD to Hallway");
		d2.setLeftSpritePath(mainDFolder + "left/layer0/HallwayDoor.png");
		d2.setBackSpritePath(mainDFolder + "back/layer0/halldoor.png");
		
		d2.loadSprites();
		d2.setBehaviour(MainDBehaviours.hallwayBehaviour(d2));
		mainD.addDoorBack(d2);
		mainD.addDoorLeft(d2);
		d2.setLayerBack(0);
		d2.setLayerLeft(0);

		//dustbins
		ContainerObject db1 = new ContainerObject("MainD Dustbin1");
		db1.setRightSpritePath(mainDFolder + "right/layer0/dustbin.png");
		db1.setBackSpritePath(mainDFolder + "back/layer0/dustbin.png");
		db1.setLeftSpritePath(mainDFolder + "left/layer0/dustbin.png");
		db1.loadSprites();
		db1.setBehaviour(MainDBehaviours.dustbinBehaviour(db1));
		mainD.addContainerBack(db1);
		mainD.addContainerRight(db1);
		mainD.addContainerLeft(db1);
		db1.setLayerBack(0);
		db1.setLayerRight(0);
		db1.setLayerLeft(0);
		

		ContainerObject db2 = new ContainerObject("MainD Dustbin2");
		db2.setRightSpritePath(mainDFolder + "right/layer0/dustbin2.png");
		db2.loadSprites();
		db2.setBehaviour(MainDBehaviours.dustbinBehaviour(db2));
		mainD.addContainerRight(db2);
		db2.setLayerRight(0);
		
		//keypad
		GenericObject keypad = new GenericObject("MainD Keypad to Lab1");
		keypad.setLeftSpritePath(mainDFolder + "left/layer0/Lab1Keypad.png");
		keypad.setBackSpritePath(mainDFolder + "back/layer0/Lab1Keypad.png");
		keypad.loadSprites();
		keypad.setBehaviour(MainDBehaviours.keypadLab1Behaviour(keypad));
		mainD.addGenericLeft(keypad);
		mainD.addGenericBack(keypad);
		keypad.setLayerLeft(0);
		keypad.setLayerBack(0);		
		
		
		return mainD;
	}
	
	private static Room setupStudy1() {
		String study1folder = "./graphics/game_graphics/rooms/study1/";
		String[] rightLayerPaths = {study1folder + "right/layer0/study1_right_0.png"};
		String[] leftLayerPaths = {study1folder + "left/layer0/study1_left_0.png"};
		String[] unlitRightLayerPaths = {study1folder + "right/layer0/study1_right_0_lightsout.png"};
		String[] unlitLeftLayerPaths = {study1folder + "left/layer0/study1_left_0_lightsout.png"};
		
		Room study1;
		try {
			study1 = new Room("Study Room 1", false, true, false, true);

		} catch (Exception e) {
			//this will never happen, but added some code here to get compiler to stop complaining
			System.err.println("Error creating study1!");
			e.printStackTrace();
			study1 = new Room("Study Room 1");
		}
		
		study1.setLayerBackgroundsRight(rightLayerPaths);
		study1.setLayerBackgroundsLeft(leftLayerPaths);
		study1.setUnlitLayerBackgroundsRight(unlitRightLayerPaths);
		study1.setUnlitLayerBackgroundsLeft(unlitLeftLayerPaths);
		
		
		//
		DoorObject doorOut = new DoorObject("SR1 To Annex");
		doorOut.setLeftSpritePath(study1folder + "left/layer0/door.png");
		doorOut.loadSprites();
		doorOut.setBehaviour(Study1Behaviours.doorOutBehaviour(doorOut));
		study1.addDoorLeft(doorOut);
		doorOut.setLayerLeft(0);
		
		//add beanbag
		GenericObject s1Beanbag = new GenericObject("SR1 Beanbag");
		s1Beanbag.setRightSpritePath(study1folder + "right/layer0/beanbag.png");
		s1Beanbag.loadSprites();
		s1Beanbag.setBehaviour(Study1Behaviours.beanbagBehaviour(s1Beanbag));
		study1.addGenericRight(s1Beanbag);
		s1Beanbag.setLayerRight(0);
		
		//add couch
		GenericObject s1Couch = new GenericObject("SR1 Couch");
		s1Couch.setLeftSpritePath(study1folder + "left/layer0/couch.png");
		s1Couch.setRightSpritePath(study1folder + "right/layer0/couch.png");
		s1Couch.loadSprites();
		s1Couch.setBehaviour(Study1Behaviours.couchBehaviour(s1Couch));
		study1.addGenericLeft(s1Couch);
		study1.addGenericRight(s1Couch);
		s1Couch.setLayerLeft(0);
		s1Couch.setLayerRight(0);
		
		//add table
		ContainerObject s1Table = new ContainerObject("SR1 Table");
		s1Table.setLeftSpritePath(study1folder + "left/layer0/table.png");
		s1Table.setRightSpritePath(study1folder + "right/layer0/table.png");
		s1Table.loadSprites();
		s1Table.setBehaviour(Study1Behaviours.tableBehaviour(s1Table));
		study1.addContainerLeft(s1Table);
		study1.addContainerRight(s1Table);
		s1Table.setLayerLeft(0);
		s1Table.setLayerRight(0);
		
		InfoObject hiddenMessage = new InfoObject("SR1 Hidden Message", "The passcode to Study Room 4 is 0582");
		hiddenMessage.setRightSpritePath(study1folder + "right/layer0/message.png");
		hiddenMessage.loadSprites();
		hiddenMessage.setBehaviour(Study1Behaviours.messageBehaviour(hiddenMessage));
		study1.addInfoRight(hiddenMessage);
		hiddenMessage.setLayerRight(0);
		hiddenMessage.hide();
		
		//add lightswitch
		GenericObject s1LightSwitch = new GenericObject("SR1 Light Switch");
		s1LightSwitch.setLeftSpritePath(study1folder + "left/layer0/switch.png");
		s1LightSwitch.loadSprites();
		s1LightSwitch.setBehaviour(Study1Behaviours.lightSwitchBehaviour(hiddenMessage));
		study1.addGenericLeft(s1LightSwitch);
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
		DoorObject doorOut = new DoorObject("SR2 To Annex");
		doorOut.setLeftSpritePath(study2folder + "left/layer0/door.png");
		doorOut.loadSprites();
		doorOut.setBehaviour(Study2Behaviours.doorOutBehaviour(doorOut));
		study2.addDoorLeft(doorOut);
		doorOut.setLayerLeft(0);
		
		//add couch
		List<Item> coins = new ArrayList<Item>();
		coins.add(new Item("Quarter"));
		coins.add(new Item("Quarter"));
		ContainerObject s2Couch = new ContainerObject("SR2 Couch", coins);
		s2Couch.setLeftSpritePath(study2folder + "left/layer0/couch.png");
		s2Couch.setRightSpritePath(study2folder + "right/layer0/couch.png");
		s2Couch.loadSprites();
		s2Couch.setBehaviour(Study2Behaviours.couchBehaviour(s2Couch));
		study2.addContainerLeft(s2Couch);
		study2.addContainerRight(s2Couch);
		s2Couch.setLayerLeft(0);
		s2Couch.setLayerRight(0);
		
		
		//add plant
		GenericObject s2Plant = new GenericObject("S2 Plant");
		s2Plant.setRightSpritePath(study2folder + "right/layer0/plant.png");
		s2Plant.loadSprites();
		s2Plant.setBehaviour(Study2Behaviours.plantBehaviour(s2Plant));
		study2.addGenericRight(s2Plant);
		s2Plant.setLayerRight(0);
				
		
		//add table
		ContainerObject s2Table = new ContainerObject("SR2 Table");
		s2Table.setLeftSpritePath(study2folder + "left/layer0/table.png");
		s2Table.setRightSpritePath(study2folder + "right/layer0/table.png");
		s2Table.loadSprites();
		s2Table.setBehaviour(Study2Behaviours.tableBehaviour(s2Table));
		study2.addContainerLeft(s2Table);
		study2.addContainerRight(s2Table);
		s2Table.setLayerLeft(0);
		s2Table.setLayerRight(0);
		
		//switch
		GenericObject s2LightSwitch = new GenericObject("SR2 Light Switch");
		s2LightSwitch.setLeftSpritePath(study2folder + "left/layer0/switch.png");
		s2LightSwitch.loadSprites();
		s2LightSwitch.setBehaviour(Study2Behaviours.lightSwitchBehaviour(s2LightSwitch));
		study2.addGenericLeft(s2LightSwitch);
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
		DoorObject doorOut = new DoorObject("SR3 To Annex");
		doorOut.setFrontSpritePath(study3folder + "front/layer0/door.png");
		doorOut.loadSprites();
		doorOut.setBehaviour(Study3Behaviours.doorOutBehaviour(doorOut));
		study3.addDoorFront(doorOut);
		doorOut.setLayerFront(0);
		
		//add plant
		GenericObject p = new GenericObject("SR3 Plant");
		p.setFrontSpritePath(study3folder + "front/layer0/plant.png");
		p.loadSprites();
		p.setBehaviour(Study3Behaviours.plantBehaviour(p));
		study3.addGenericFront(p);
		p.setLayerFront(0);
		
		//add dustbin--back
		GenericObject db = new GenericObject("SR3 Dustbin");
		db.setBackSpritePath(study3folder + "back/layer0/dustbin.png");
		db.loadSprites();
		db.setBehaviour(Study3Behaviours.dustbinBehaviour(db));
		study3.addGenericBack(db);
		db.setLayerBack(0);
		
		
		
		//add couch
		GenericObject s3Couch = new GenericObject("SR3 Couch");
		s3Couch.setBackSpritePath(study3folder + "back/layer0/couch.png");
		s3Couch.setFrontSpritePath(study3folder + "front/layer0/couch.png");
		s3Couch.loadSprites();
		s3Couch.setBehaviour(Study3Behaviours.couchBehaviour(s3Couch));
		study3.addGenericBack(s3Couch);
		study3.addGenericFront(s3Couch);
		s3Couch.setLayerBack(0);
		s3Couch.setLayerFront(0);
		
		//add table
		ContainerObject s3Table = new ContainerObject("SR3 Table");
		s3Table.setFrontSpritePath(study3folder + "front/layer0/table.png");
		s3Table.setBackSpritePath(study3folder + "back/layer0/table.png");
		s3Table.loadSprites();
		s3Table.setBehaviour(Study3Behaviours.tableBehaviour(s3Table));
		study3.addContainerBack(s3Table);
		study3.addContainerFront(s3Table);
		s3Table.setLayerBack(0);
		s3Table.setLayerFront(0);
		
		
		
		//switch
		GenericObject s3LightSwitch = new GenericObject("SR3 Light Switch");
		s3LightSwitch.setFrontSpritePath(study3folder + "front/layer0/switch.png");
		s3LightSwitch.loadSprites();
		s3LightSwitch.setBehaviour(Study3Behaviours.lightSwitchBehaviour(s3LightSwitch));
		study3.addGenericFront(s3LightSwitch);
		s3LightSwitch.setLayerFront(0);
		
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
		//add door
		DoorObject doorOut = new DoorObject("SR4 To Annex");
		doorOut.setFrontSpritePath(study4folder + "front/layer0/door.png");
		doorOut.loadSprites();
		doorOut.setBehaviour(Study4Behaviours.doorOutBehaviour(doorOut));
		study4.addDoorFront(doorOut);
		doorOut.setLayerFront(0);
		
		
		//add dustbin
		GenericObject db = new GenericObject("SR4 Dustbin");
		db.setFrontSpritePath(study4folder + "Front/layer0/dustbin.png");
		db.loadSprites();
		db.setBehaviour(Study4Behaviours.dustbinBehaviour(db));
		study4.addGenericFront(db);
		db.setLayerFront(0);
		
		//add couch
		GenericObject s4Couch = new GenericObject("SR4 Couch");
		s4Couch.setBackSpritePath(study4folder + "back/layer0/couch.png");
		s4Couch.setFrontSpritePath(study4folder + "front/layer0/couch.png");
		s4Couch.loadSprites();
		s4Couch.setBehaviour(Study4Behaviours.couchBehaviour(s4Couch));
		study4.addGenericBack(s4Couch);
		study4.addGenericFront(s4Couch);
		s4Couch.setLayerBack(0);
		s4Couch.setLayerFront(0);
		
		
		//add table
		List<Item> coins = new ArrayList<Item>();
		coins.add(new Item("Quarter"));
		coins.add(new Item("Quarter"));
		ContainerObject s4Table = new ContainerObject("SR4 Table", coins);
		s4Table.setFrontSpritePath(study4folder + "front/layer0/table.png");
		s4Table.setBackSpritePath(study4folder + "back/layer0/table.png");
		s4Table.loadSprites();
		s4Table.setBehaviour(Study4Behaviours.tableBehaviour(s4Table));
		study4.addContainerBack(s4Table);
		study4.addContainerFront(s4Table);
		s4Table.setLayerBack(0);
		s4Table.setLayerFront(0);
		
		//add plant
		GenericObject p = new GenericObject("SR4 Plant");
		p.setBackSpritePath(study4folder + "back/layer0/plant.png");
		p.loadSprites();
		p.setBehaviour(Study4Behaviours.plantBehaviour(p));
		study4.addGenericBack(p);
		p.setLayerBack(0);
		
		//switch
		GenericObject s4LightSwitch = new GenericObject("SR4 Light Switch");
		s4LightSwitch.setFrontSpritePath(study4folder + "front/layer0/switch.png");
		s4LightSwitch.loadSprites();
		s4LightSwitch.setBehaviour(Study4Behaviours.lightSwitchBehaviour(s4LightSwitch));
		study4.addGenericFront(s4LightSwitch);
		s4LightSwitch.setLayerFront(0);
		
		return study4;
	}
	
	
	private static Room setupCove() {
		Room cove;
		try {
			cove = new Room("Cove", true, false, false, false);
		} catch (Exception e) {
			//this will never happen, but added some code here to get compiler to stop complaining
			System.err.println("Error creating cove!");
			e.printStackTrace();
			cove = new Room("Cove");
		}
		
		String coveFolder = "./graphics/game_graphics/rooms/cove/";
		
		String[] frontPaths = {coveFolder + "front/layer0/cove_front_0.png"};
		
		cove.setLayerBackgroundsFront(frontPaths);
		
		
		//cove graphics
		
		//door out
		DoorObject coveToAnnex = new DoorObject("Cove To Annex");
		coveToAnnex.setFrontSpritePath(coveFolder + "front/layer0/arrowAnnex.png");
		coveToAnnex.loadSprites();
		coveToAnnex.setBehaviour(CoveBehaviours.doorOutBehaviour(coveToAnnex));
		cove.addDoorFront(coveToAnnex);
		coveToAnnex.setLayerFront(0);
		
		//couch1
		GenericObject c1 = new GenericObject("Cove Blue Coach");
		c1.setFrontSpritePath(coveFolder + "front/layer0/blueCouch.png");
		c1.loadSprites();
		c1.setBehaviour(CoveBehaviours.couchGenericBehaviour(c1));
		cove.addGenericFront(c1);
		c1.setLayerFront(0);
		
		//couch2
		GenericObject c2 = new GenericObject("Cove Couch 1");
		c2.setFrontSpritePath(coveFolder + "front/layer0/greenCouchCenter.png");
		c2.loadSprites();
		c2.setBehaviour(CoveBehaviours.couchGenericBehaviour(c2));
		cove.addGenericFront(c2);
		c2.setLayerFront(0);
		
		//beanbag
		GenericObject b = new GenericObject("Cove Beanbag");
		b.setFrontSpritePath(coveFolder + "front/layer0/beanBag.png");
		b.loadSprites();
		b.setBehaviour(CoveBehaviours.beanbagBehaviour(b));
		cove.addGenericFront(b);
		b.setLayerFront(0);
		
		//dustbin
		ContainerObject d = new ContainerObject("Cove Dustbin");
		d.setFrontSpritePath(coveFolder + "front/layer0/dustbin.png");
		d.loadSprites();
		d.setBehaviour(CoveBehaviours.dustbinBehaviour(d));
		cove.addContainerFront(d);
		d.setLayerFront(0);
		
		//chair3
		GenericObject c3 = new GenericObject("Cove Couch 2");
		c3.setFrontSpritePath(coveFolder + "front/layer0/greenchairLeft.png");
		c3.loadSprites();
		c3.setBehaviour(CoveBehaviours.couchGenericBehaviour(c3));
		cove.addGenericFront(c3);
		c3.setLayerFront(0);
		
		//chair4
		GenericObject c4 = new GenericObject("Cove Couch 3");
		c4.setFrontSpritePath(coveFolder + "front/layer0/greenchairRight.png");
		c4.loadSprites();
		c4.setBehaviour(CoveBehaviours.couchGenericBehaviour(c4));
		cove.addGenericFront(c4);
		c4.setLayerFront(0);
		
		//chair5
		GenericObject c5 = new GenericObject("Cove Couch 4");
		c5.setFrontSpritePath(coveFolder + "front/layer0/greenCouchLowerLeft.png");
		c5.loadSprites();
		c5.setBehaviour(CoveBehaviours.couchGenericBehaviour(c5));
		cove.addGenericFront(c5);
		c5.setLayerFront(0);
		
		//chair6
		GenericObject c6 = new GenericObject("Cove Couch 5");
		c6.setFrontSpritePath(coveFolder + "front/layer0/greenCouchLowerRight.png");
		c6.loadSprites();
		c6.setBehaviour(CoveBehaviours.couchGenericBehaviour(c6));
		cove.addGenericFront(c6);
		c6.setLayerFront(0);
		
		//plant
		GenericObject p1 = new GenericObject("Cove Plant 1");
		p1.setFrontSpritePath(coveFolder + "front/layer0/plantleft.png");
		p1.loadSprites();
		p1.setBehaviour(CoveBehaviours.plantBehaviour(p1));
		cove.addGenericFront(p1);
		p1.setLayerFront(0);
		
		//plant
		/*
		GenericObject p2 = new GenericObject("Cove Plant 2");
		p2.setFrontSpritePath(coveFolder + "front/layer0/plant2.png");
		p2.loadSprites();
		p2.setBehaviour(CoveBehaviours.plantBehaviour(p2));
		cove.addGenericFront(p2);
		p2.setLayerFront(0);
		*/
		
		//table
		GenericObject t1 = new GenericObject("Cove Table");
		t1.setFrontSpritePath(coveFolder + "front/layer0/rightTable.png");
		t1.loadSprites();
		t1.setBehaviour(CoveBehaviours.tableBehaviour(t1));
		cove.addGenericFront(t1);
		t1.setLayerFront(0);
		
		return cove;
	}
	
	private static Room setupLab1() { //ERICA
		String labFolder = "./graphics/game_graphics/rooms/lab1/";
		Room lab;
		try {
			lab = new Room("Lab 1", true, true, true, true);
		} catch (Exception e) {
			//this will never happen, but added some code here to get compiler to stop complaining
			System.err.println("Error creating lab1!");
			e.printStackTrace();
			lab = new Room("Lab 1");
		}
		
		String frontPaths[] = {labFolder + "front/layer0/lab1_front_0.png"};	
		String rightPaths[] = {labFolder +  "right/layer0/lab1_right_0.png"};
		String backPaths[] = {labFolder +  "back/layer0/lab1_back_0.png"};
		String leftPaths[] = {labFolder +  "left/layer0/lab1_left_0.png"};

		lab.setLayerBackgroundsFront(frontPaths);
		lab.setLayerBackgroundsRight(rightPaths);
		lab.setLayerBackgroundsBack(backPaths);
		lab.setLayerBackgroundsLeft(leftPaths);

		
		/*
		GenericObject t1 = new GenericObject("Cove Table");
		t1.setFrontSpritePath(coveFolder + "front/layer0/rightTable.png");
		t1.loadSprites();
		t1.setBehaviour(CoveBehaviours.tableBehaviour(t1));
		cove.addGenericFront(t1);
		t1.setLayerFront(0);
		//R
		 * */
		 

		//B
		
		DoorObject d1 = new DoorObject("Lab 1 to Main D");
		d1.setRightSpritePath(labFolder + "right/layer0/door.png");
		d1.setFrontSpritePath(labFolder + "front/layer0/door.png");
		d1.loadSprites();
		d1.setBehaviour(Lab1Behaviours.doorMainDBehaviour(d1));
		lab.addDoorRight(d1);
		lab.addDoorFront(d1);
		d1.setLayerFront(0);
		d1.setLayerRight(0);
		
		//L
		InfoObject labCP = new InfoObject("Lab 1 CP", "asleep");
		labCP.setBackSpritePath(labFolder + "back/layer0/CP_sleeping.png");
		labCP.loadSprites();
		labCP.setBehaviour(Lab1Behaviours.cpBehaviour(labCP));
		lab.addInfoBack(labCP);
		labCP.setLayerBack(0);
		
		
		GenericObject shelf103 = new GenericObject("103 Shelf");
		shelf103.setBackSpritePath(labFolder + "back/layer0/102shelf.png");  //TODO update these graphics
		shelf103.setFrontSpritePath(labFolder + "front/layer0/102shelf.png"); 
		shelf103.setRightSpritePath(labFolder + "right/layer0/102shelf.png");
		shelf103.loadSprites();
		
		lab.addGenericRight(shelf103);
		lab.addGenericFront(shelf103);
		shelf103.setLayerRight(0);
		shelf103.setLayerFront(0);
		
		GenericObject shelf104= new GenericObject("104 Shelf");
		shelf104.setBackSpritePath(labFolder + "back/layer0/103shelf.png"); //TODO update these graphics
		shelf104.setFrontSpritePath(labFolder + "front/layer0/103shelf.png");
		shelf104.setRightSpritePath(labFolder + "right/layer0/103shelf.png");
		shelf104.loadSprites();
		lab.addGenericRight(shelf104);
		lab.addGenericFront(shelf104);
		shelf104.setLayerRight(0);
		shelf104.setLayerFront(0);
		
		GenericObject shelf170 = new GenericObject("170 Shelf");
		shelf170.setBackSpritePath(labFolder + "back/layer0/170shelf.png"); 
		shelf170.setRightSpritePath(labFolder + "right/layer0/170shelf.png"); //TODO update this graphics
		shelf170.loadSprites();
		lab.addGenericRight(shelf170);
		shelf170.setLayerRight(0);
		
		GenericObject shelf201 = new GenericObject("201 Shelf");
		shelf201.setBackSpritePath(labFolder + "back/layer0/201shelf.png"); 
		shelf201.setRightSpritePath(labFolder + "right/layer0/201shelf.png"); //TODO update this graphic
		shelf201.loadSprites();
		lab.addGenericRight(shelf201);
		shelf201.setLayerRight(0);
		
		
		//shelves added different from the back to make sure shelves appear in the right order.
		lab.addGenericBack(shelf201);
		lab.addGenericBack(shelf170);
		lab.addGenericBack(shelf104);
		lab.addGenericBack(shelf103);	
		shelf201.setLayerBack(0);
		shelf170.setLayerBack(0);
		shelf104.setLayerBack(0);
		shelf103.setLayerBack(0);
		
		
		GenericObject book103 = new GenericObject("103 Book");
		book103.setRightSpritePath(labFolder + "right/layer0/103book.png");
		book103.loadSprites();
		lab.addGenericRight(book103);
		book103.setLayerRight(0);
		book103.setBehaviour(Lab1Behaviours.CSCI103Behaviour(book103));
		
		GenericObject book104 = new GenericObject("104 Book");
		book104.setRightSpritePath(labFolder + "right/layer0/104book.png");
		book104.loadSprites();
		lab.addGenericRight(book104);
		book104.setLayerRight(0);
		book104.setBehaviour(Lab1Behaviours.CSCI104Behaviour(book104));
		
		GenericObject book170 = new GenericObject("170 Book");
		book170.setRightSpritePath(labFolder + "right/layer0/170book.png");
		book170.loadSprites();
		lab.addGenericRight(book170);
		book170.setLayerRight(0);
		book170.setBehaviour(Lab1Behaviours.CSCI170Behaviour(book170));
		
		GenericObject book201 = new GenericObject("201 Book");
		book201.setRightSpritePath(labFolder + "right/layer0/201book.png");
		book201.loadSprites();
		lab.addGenericRight(book201);
		book201.setLayerRight(0);
		book201.setBehaviour(Lab1Behaviours.CSCI201Behaviour(book201));
		
		
		GenericObject message = new GenericObject("Message");
		message.setFrontSpritePath(labFolder + "front/layer0/labMess.png");
		message.loadSprites();
		lab.addGenericFront(message);
		message.setLayerFront(0);
		
		
		return lab;
	}
	
	/*
	 * Below are unfortunately unimplemented
	 */
	
	private static Room setupHallway1() {
		Room ret = new Room("hallway1");
		return ret;
	}
	
	private static Room setupHallway2() {
		Room room = new Room("hallway2");
		return room;
	}
	
	private static Room setupMensRoom() { 
		Room ret = new Room("mensRoom");
		
		return ret;
	}
	
	private static Room setupWomensRoom() { 
		Room ret = new Room("womensRoom");
		return ret;
	}
}
