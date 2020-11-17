package fpGame;

import fpModel.*;

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
}
