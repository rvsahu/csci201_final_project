package csci201.edu.usc;

public class Shelter extends IntegerComparable {
	
	/**
	 * String representation of a shelter
	 */
	public String toString() {
		
		StringBuffer shelterinfo = new StringBuffer();
		shelterinfo.append("\n\n");
		shelterinfo.append("=== Matching timefall shelter found! ===\n");
		shelterinfo.append("Shelter information:\n");
		shelterinfo.append("Chiral frequency: "+this.getChiralfrequency());
		shelterinfo.append("\n");
		shelterinfo.append("Timefall: "+ this.getTimefall());
		shelterinfo.append("\n");
		shelterinfo.append("GUID: "+ this.getGuid());
		shelterinfo.append("\n");
		shelterinfo.append("Name: "+ this.getName());
		shelterinfo.append("\n");
		shelterinfo.append("Phone: "+ this.getPhone());
		shelterinfo.append("\n");
		shelterinfo.append("Address: "+ this.getAddress());
		shelterinfo.append("\n");
		
		String info = new String(shelterinfo);
		return info;
	}
	/**
	 * Returns integer value to compare on
	 */
	@Override
	public int getCompareValue() {
		return getChiralfrequency();
	}
	
	int chiralFrequency;
	boolean timefall;
	String guid;
	String name;
	String phone;
	String address;
	
	public int getChiralfrequency() {
		return chiralFrequency;
	}
	
	public boolean getTimefall() {
		return timefall;
	}
	
	public String getGuid() {
		return guid;
	}
	public String getName() {
		return name;
	}	
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}

}