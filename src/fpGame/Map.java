package fpGame;

import fpGame.behaviours.*;
import fpModel.Room;

public class Map {
	
	public Map() {
		
	}
	
	/*
	 * All rooms
	 */
	public Room annex;
	public Room mainA;
	public Room mainB;
	public Room mainC;
	public Room mainD;
	public Room study1;
	public Room study2;
	public Room study3;
	public Room study4;
	public Room cove;
	public Room lab1;
	public Room hallway1;
	public Room hallway2;
	public Room mensRoom;
	public Room womensRoom;
	
	/*
	 * Methods (primarily) for deserialisation
	 */
	
	/**
	 * Given a String roomName, returns the right Room.
	 * 
	 * @param roomName  The name of the room we are looking for
	 * @return     The Room with the given name, or null if it doesn't exist
	 */
	public Room getRoom(String roomName) {
		if (annex.name().equals(roomName))
			return annex;
		if (mainA.name().equals(roomName))
			return mainA;
		if (mainB.name().equals(roomName))
			return mainB;
		if (mainC.name().equals(roomName))
			return mainC;
		if (mainD.name().equals(roomName))
			return mainD;
		if (study1.name().equals(roomName))
			return study1;
		if (study2.name().equals(roomName))
			return study2;
		if (study3.name().equals(roomName))
			return study3;
		if (study4.name().equals(roomName))
			return study4;
		if (cove.name().equals(roomName))
			return cove;
		if (lab1.name().equals(roomName))
			return lab1;
		if (hallway1.name().equals(roomName))
			return hallway1;
		if (hallway2.name().equals(roomName))
			return hallway2;
		if (mensRoom.name().equals(roomName))
			return mensRoom;
		if (womensRoom.name().equals(roomName))
			return womensRoom;
		return null;
	}
	
	/**
	 * For each room, give its internal Perspectives a reference to the containing room.
	 */
	public void addContainingRooms() {
		try {
			annex.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			mainA.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			mainB.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			mainC.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			mainD.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			study1.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			study2.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			study3.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			study4.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			cove.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			lab1.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			hallway1.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			hallway2.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			mensRoom.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
		try {
			womensRoom.addContainingRooms();
		} catch (NullPointerException npe) {
			System.err.println("Error with adding containing room reference!");
			npe.printStackTrace();
		}
	}
	
	public void resetAllDirections() {
		try {
			annex.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			mainA.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			mainB.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			mainC.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			mainD.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			study1.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			study2.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			study3.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			study4.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			cove.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			lab1.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			hallway1.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			hallway2.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			mensRoom.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
		try {
			womensRoom.resetAllDirections();
		} catch (NullPointerException npe) {
			System.err.println("Error with resetting directions!");
			npe.printStackTrace();
		}
	}
	
	public void loadAllSprites() {
		try {
			annex.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			mainA.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			mainB.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			mainC.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			mainD.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			study1.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			study2.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			study3.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			study4.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			cove.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			lab1.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			hallway1.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			hallway2.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			mensRoom.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
		try {
			womensRoom.loadAllSprites();
		} catch (NullPointerException npe) {
			System.err.println("Error with loading sprites!");
			npe.printStackTrace();
		}
	}
	
	public void rebuildAllContentsLists() {
		try {
			annex.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			mainA.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			mainB.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			mainC.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			mainD.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			study1.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			study2.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			study3.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			study4.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			cove.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			lab1.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			hallway1.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			hallway2.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			mensRoom.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
		try {
			womensRoom.rebuildAllContentsLists();
		} catch (NullPointerException npe) {
			System.err.println("Error with rebuilding contents!");
			npe.printStackTrace();
		}
	}
	
	public void tossAllDuplicates() {
		try {
			annex.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			mainA.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			mainB.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			mainC.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			mainD.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			study1.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			study2.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			study3.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			study4.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			cove.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			lab1.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			hallway1.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			hallway2.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			mensRoom.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
		try {
			womensRoom.tossDuplicates();
		} catch (NullPointerException npe) {
			System.err.println("Error with toss duplicates!");
			npe.printStackTrace();
		}
	}

	public void reassignAllBehaviours() {
		try {
			AnnexBehaviours.addBehaviours(annex.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to annex objects!");
			e.printStackTrace();
		}
		try {
			MainABehaviours.addBehaviours(mainA.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to mainA objects!");
			e.printStackTrace();
		}
		try {
			MainBBehaviours.addBehaviours(mainB.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to mainB objects!");
			e.printStackTrace();
		}
		try {
			MainCBehaviours.addBehaviours(mainC.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to mainC objects!");
			e.printStackTrace();
		}
		try {
			MainDBehaviours.addBehaviours(mainD.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to mainD objects!");
			e.printStackTrace();
		}
		try {
			Study1Behaviours.addBehaviours(study1.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to study1 objects!");
			e.printStackTrace();
		}
		try {
			Study2Behaviours.addBehaviours(study2.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to study2 objects!");
			e.printStackTrace();
		}
		try {
			Study3Behaviours.addBehaviours(study3.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to study3 objects!");
			e.printStackTrace();
		}
		try {
			Study4Behaviours.addBehaviours(study4.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to study4 objects!");
			e.printStackTrace();
		}
		try {
			CoveBehaviours.addBehaviours(cove.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to cove objects!");
			e.printStackTrace();
		}
		try {
			Lab1Behaviours.addBehaviours(lab1.getAllContents());
		} catch (Exception e) {
			System.err.println("Error reassigning behaviours to lab1 objects!");
			e.printStackTrace();
		}
	}
}
