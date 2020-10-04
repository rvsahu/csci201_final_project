package csci201.edu.usc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;


public class WristCuff {	
	/**
	 * Loads shelters specified in path (JSON file)
	 */
	public WristCuff(String path) throws IOException {
		//initialization
		filename = path;
		Gson gson = new Gson();
		//try opening the json file and setting br to it and converting it
		//add try later && catch
		home = gson.fromJson(new FileReader(path), Shelter[].class);
		shelterlist = new ArrayList<Shelter>(Arrays.asList(home));
		fastlist = new FastList<Shelter>();
		for(int i = 0; i < home.length; i++)
		{
			fastlist.insert(home[i]);
		}
		System.out.println(fastlist.toString());
	}
	
	/**
	 * Finds an available shelter that matches one of the provided Chiral Frequencies
	 * @throws IOException 
	 */
	public Shelter findShelter(List<Integer> chiralFrequencies) throws IOException {
		int[] array = chiralFrequencies.stream().mapToInt(i->i).toArray();
		Shelter shelterfound = null;
		for (int i = 0; i < array.length; i++)
		{
			System.out.println("=== Commencing timefall shelter search ===");
			try
			{
				shelterfound = fastlist.contains(array[i]);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Index "+i+" provided does not exist");
			}
			
			if (shelterfound != null && shelterfound.getTimefall() == false)
			{
				printer(shelterfound);
				return shelterfound;
			}
			else if (shelterfound != null && shelterfound.getTimefall() == true)
			{
				//remove from the json file by...
				//call delete function and call save on the fastlist
				printer(shelterfound);
				System.out.println("=== Target shelter Chiral signal unstable, Chiral jump unavailable. ===");
				System.out.println("=== Removing target shelter from the list of shelters and saving updated ===");
				for (int z = 0; z < shelterlist.size(); z++)
				{
					if (shelterlist.get(z).getName() == shelterfound.getName())
					{
						shelterlist.remove(z);
					}
				}
				fastlist.delete(shelterfound);
				try
				{
					this.save();	
				}
				catch (JsonIOException e) {
				throw e;
				}
				catch (IOException e) {
				throw e;
				}
			}
		}
		System.out.println("No available shelters");
		return null;
	}
	
	public void printer(Shelter shelterfound)
	{
		System.out.println(shelterfound.toString());
	}
	
		
	/**
	 * Saves the updated list of shelters to disk
	 * @throws IOException 
	 */
	public void save() throws IOException
	{
	    Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
		try 
		{
			FileWriter filewriter = new FileWriter(filename);
			gson.toJson(shelterlist, filewriter);
			filewriter.flush();
			filewriter.close();
			
		} catch (JsonIOException e) {
			//e.printStackTrace();
			throw e;
		} catch (IOException e) {
			//e.printStackTrace();
			throw e;
		}
	}
	
	
	//added methods & data members
	private Shelter[] home;
	private FastList<Shelter> fastlist;
	private List<Shelter> shelterlist;
	private String filename;
	
}
