package LastLight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.google.gson.Gson;

public class Main {
	static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		Gson gson = new Gson();
		String filename = new String();
		Dictionary<String> dictionary = new Dictionary<String>();
		Codes[] codearray = null;
		boolean quit = false;
		int input = 0;
		
		System.out.println("Enter an input file");
		filename = scanner.nextLine();
		
		//in a while loop try to parse gson
		while(quit == false)
		{
			try {
					codearray = gson.fromJson(new FileReader(filename), Codes[].class);
					break;
				}
				
			catch(FileNotFoundException e)
				{
					System.out.println("File not found, enter a new input file");
					filename = scanner.nextLine();
				}		
		}
		
		
		
		
		//if there are stuff in the gson file,
		//then add it into the dictionary 
		if(codearray != null)
		{
			for(int i = 0; i < codearray.length; i++)
			{
				String[] codestring = codearray[i].getCodes();
				for(int j = 0; j < codestring.length; j++)
				{
					String string = codestring[j]; 
					dictionary.add(string);
				}
			}
		}
		//the entire system
		while(quit==false)
		{
			System.out.println("What would you like to do with your database of codes?");
			System.out.println("1) Get frequency of a code");
			System.out.println("2) Check if a code was guessed");
			System.out.println("3) Remove a code");
			System.out.println("4) Quit");
			System.out.println();
			
			boolean validinput = false;
			//repeat until the user gives the right input
			while(false==validinput)
			{
				try 
				{
					input = scanner.nextInt();
					break;
				}
				catch(InputMismatchException ex)
				{
					scanner.nextLine();
					System.out.println("Invalid input. Try again with an appropriate number between 1-4.");
				}
			}
			if (input == 1) 
			{
				System.out.println("Enter a code to check its frequency");
				
				scanner.nextLine(); //considering clearing buffer / scanner
				//scanner.flush();
				String code = scanner.nextLine();
				int guess = dictionary.frequency(code);
				if(guess == 1) 
				{
					System.out.println(code + " was guessed by a teammate");
				}
				else
				{
					System.out.println(code + " was guessed by " + guess + " teammates");
				}
			}
					
			else if (input == 2) 
			{
				System.out.println("Enter a code to check if it was guessed by a teammate");
				scanner.nextLine();
				String code = scanner.nextLine();
				boolean found = dictionary.contains(code);
				
				if(found)
				{
					System.out.println(code+" was guessed by a teammate");
				}
				
				else
				{
					System.out.println(code+" was not guessed by a teammate");
				}
			}
					
			else if (input == 3) 
			{
				System.out.println("Enter a code to remove");
				scanner.nextLine();
				String remove = scanner.nextLine();
				int num = dictionary.frequency(remove);
				
				if(num == 0)
				{
					System.out.println("Code to remove not found. Try again.");
					continue;
				}
				for(int i = 0; i < num; ++i)
				{
					dictionary.remove(remove);
				}					
				System.out.println(remove + " was removed from your database");
			}
	
			else if (input == 4)
			{
				quit = true;
				System.out.println("Quitting, have a nice day!");
				break;
			}
			else
			{
				System.out.println("Invalid input. Try again with an appropriate number between 1-4.");
			}
			
		}
	}
}
