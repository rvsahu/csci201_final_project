package csci201.edu.usc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

import com.google.gson.JsonIOException;



public class Main {
	static Scanner input;
	/**
	 * Use user-input to create a WristCuff object.
	 */
	
	public static WristCuff getWristCuff() throws IOException {
		String filename = null;
		try {
			filename = input.nextLine();
			WristCuff mycuff = new WristCuff(filename);		
			return mycuff;
		}
		catch(IOException e)
		{
			throw e;
		}
	}
	
	/**
	 * Use user-input to create a list of supported Chiral Frequencies
	 */
	public static List<Integer> getChiralFrequencies() throws IOException {		
		System.out.println("Please provide supported Chiral frequencies: \n");
		String usernumbers = input.nextLine();
		List<String> items = new ArrayList<String>();
		items = Arrays.asList(usernumbers.split("\\W"));
		
		List<String> list = new ArrayList<String>();
		
		for (String x : items)
		{
			if (x != null && x.length() > 0)
			{
				list.add(x);
			}
		}
		
		List<Integer> intitems = list.stream()
									.map(s -> Integer.parseInt(s))
									.collect(Collectors.toList());
		System.out.println("Chiral Received: " + intitems);
		System.out.println();
		return intitems;
	}
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Welcome to Bridges Link.\n");
		System.out.println("Please provide timefall shelter data source: ");
		Boolean work = false;
		WristCuff mycuff = null;
		List<Integer> chiralfreq = null;
		while (!work)
		{
			try {
				mycuff = getWristCuff();
				work = true;
				System.out.println("=== Data accepted ===\n");
			}
			catch (IOException e)
			{
				System.out.println("File could not be read. (IO Exception). Try again.");			
			}
		}
		
		work = false;
		while(!work)
		{
			try
			{
				chiralfreq = getChiralFrequencies();
				work = true;
			}
			catch (IOException e)
			{
				System.out.println("User input in invalid format. Please give a valid input.");		
			}
		}
		work = false;
		while (!work)
		{
			try
			{
				if (mycuff.findShelter(chiralfreq) != null)
				{
					System.out.println("=== Commencing Chiral jump, see you on the beach. ===");
				}
				work = true;
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Updated list of shelters could not be saved.");	
				return;
			}
			catch(IOException e)
			{
				System.out.println("Updated list of shelters could not be saved.");	
				return;
			}
			catch(JsonIOException je)			
			{
				System.out.println("Updated list of shelters could not be saved.");	
				return;
			}
		}
	}
}

