
package csci201.edu.usc;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FastList<AnyType extends IntegerComparable>
{
	
	//each node has between one and eight next references
	public static final int MAX_LEVEL = 7;

 /**
	*  Returns the string contents of the list
	*  The method traverses the level 0 references
	*/
	
	//0 is the lowest level
	//7 is the highest level
	public FastList()
	{
		currmax = 0;
		for (int i = 0; i < 8; i++)
		{
			Node<AnyType> temp = new Node<AnyType>(i, null); //first one would be 0
			temp.next[0] = null;
			
			for (int j = 1; j <= i; j++)
			{
				temp.next[j] = headers[i-j];
			}
			headers[i] = temp;
		}
	}
	
	public String toString()
	{
		//traverse to the lowest level
		//visit every node in the lowest level and print out its values
		String print = new String("");
		Node<AnyType> traverser = headers[0];
		
		while (traverser.next[0] != null)
		{
			print = print + ((Shelter) traverser.next[0].data).getName() + "     "; //confused about this line
			traverser = traverser.next[0];
		}
		return print;
	}

/**
	*  Returns the string contents of the list at a given level
	*  The method traverses nodes at given level
	*/
	public String toString(int level)
	{
		//traverse to the correct
		//visit every node in the level and print out its values
		String print = new String("");
		Node<AnyType> traverser = headers[level];
		
		while (traverser.next[0] != null)
		{
			print = print + ((Shelter) traverser.next[0].data).getName() + "     "; //confused about this line
			traverser = traverser.next[0];
		}
		return print;
	}


 /**
	*  Returns true if the given value is stored in the list, otherwise false.
	*  The search begins at the topmost reference of the header
	*/
	public AnyType contains(int toSearch) throws ArrayIndexOutOfBoundsException
	{
		//start at the top--which is level 7 aka headers[7]
		Node<AnyType> traverser = headers[currmax];
		int currlevel = currmax;
		
		//go down if the next item is null or is bigger than x
		//stop searching when we can't find x on the bottom level
		while (currlevel >= 0)
		{	
			while(traverser.next[0]!=null && (traverser.next[0].data).compareTo(toSearch) <= 0) 
			//traverser.next[0].data.getCompareValue();
			//if on freq 1 and target is 5, compareto would return -4 meaning it didnt pass the target
			{
				/*if ((traverser.next[0].data).compareTo(toSearch) == 0
						&& ((Shelter) (traverser.next[0].data)).getTimefall() == false)*/
				if ((traverser.next[0].data).compareTo(toSearch) == 0)
				{
					if (((Shelter) (traverser.next[0].data)).getTimefall() == false)
					{		
						System.out.println("Level "+currlevel+" - Chiral frequency match found @ "+toSearch);
					}
					return traverser.next[0].data;
				}
				traverser = traverser.next[0];
			}
			
			if (traverser != null)
			{
				if (traverser.data != null)
				{
					System.out.println("Level "+currlevel+ "   -- Chiral Frequency lower bound found @ " + traverser.data.getCompareValue());
				}
				traverser = traverser.next[1]; //go down a level if we can't find anything	
			}
			currlevel--;
		}
		return null;
	}

 /**
	*  Returns true if the given value is stored in the list, otherwise false.
	*  The search begins at the topmost reference of the header
	*/
	public AnyType contains(AnyType toSearch) throws ArrayIndexOutOfBoundsException
	{
		//start at the top--which is level 7 aka headers[7]
		Node<AnyType> traverser = headers[currmax];
		int currlevel = currmax;
		
		//go down if the next item is null or is bigger than x
		//stop searching when we can't find x on the bottom level
		while (currlevel >= 0)
		{	
			while(traverser.next[0]!=null && (traverser.next[0].data).compareTo(toSearch.getCompareValue()) <= 0) 
			//traverser.next[0].data.getCompareValue();
			//if on freq 1 and target is 5, compareto would return -4 meaning it didnt pass the target
			{
				if (traverser.next[0].data.compareTo(toSearch.getCompareValue()) == 0)
				{
					if(((Shelter) (traverser.next[0].data)).getTimefall() == false)
					{
						System.out.println("Level "+currlevel+" - Chiral frequency match found @ "+toSearch.getCompareValue());
					}
					return traverser.next[0].data;
				}
				traverser = traverser.next[0];
			}
			if (traverser.data != null)
			{
				System.out.println("Level "+currlevel+ "   -- Chiral Frequency lower bound found @ " + traverser.data.getCompareValue());	
			}
			traverser = traverser.next[1]; //go down a level if we can't find anything
			currlevel--;
		}
		
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) l.add(i);
		
		return null;
	}

 /**
	*  Inserts a given value into the list at random level
	*  In order to insert a new node into the list we must maintain an array
	*  of nodes whose next references must be updated.
	*/
	public void insert(AnyType toInsert)
	{
		//1. determine what level the node is going into
		//2. starting from the highest level, insert the node in the corresponding levels
			//a.go to the top head and traverse until you see a value bigger than toinsert using next[0]
				//remember to update the next pointer of the prev, and the currtrav(next and down)
			//b. do this for all levels below
		int level = 0;
		Random random = new Random();
		
		//heads = true
		//tail = false
		while (random.nextBoolean() && level < 7) // if true, runs, if not, doesnt run
		{
			level++;
		}
		if (currmax < level)
		{
			currmax = level;
		}
		//final (toppest) level is determined
		//now create a tower of the node to insert
		
		Node<AnyType>[] nodelist = new Node[level+1];
		
		for (int i = 0; i <= level; i++)
		{
			Node<AnyType> temp = new Node<AnyType> (i, toInsert);
			temp.next[0] = null;
			//loop to finish the next array
			for (int j = i, x = 1; j > 0; j--, x++)
			{
				temp.next[x] = nodelist[j-1];
			}
			nodelist[i] = temp;
		}
		
		//making tower finished
		//now gotta insert the tower to the list
		Node<AnyType> traverser;	
		for (int i = level; i >= 0; i--)
		{
			traverser = headers[i];
			while(traverser.next[0]!=null && traverser.next[0].data.compareTo(toInsert.getCompareValue()) < 0)
			{
				traverser = traverser.next[0];
			}
			nodelist[i].next[0] = traverser.next[0];
			traverser.next[0] = nodelist[i];	
		}	
	}

 /**
	*  Inserts a given value into the list at a given level
	*  The level must not exceed MAX_LEVEL.
	*/
	public void insert(AnyType toInsert, int level)
	{
		if (currmax < level)
		{
			currmax = level;
		}
		//final (toppest) level is determined
		//now create a tower of the node to insert
		
		Node<AnyType>[] nodelist = new Node[level+1];
		
		for (int i = 0; i <= level; i++)
		{
			Node<AnyType> temp = new Node<AnyType> (i, toInsert);
			temp.next[0] = null;
			//loop to finish the next array
			for (int j = i, x = 1; j > 0; j--, x++)
			{
				temp.next[x] = nodelist[j-1];
			}
			nodelist[i] = temp;
		}
		
		//making tower finished
		//now gotta insert the tower to the list
		Node<AnyType> traverser;	
		for (int i = level; i >= 0; i--)
		{
			traverser = headers[i];
			while(traverser.next[0]!=null && traverser.next[0].data.compareTo(toInsert.getCompareValue()) < 0)
			{
				traverser = traverser.next[0];
			}
			nodelist[i].next[0] = traverser.next[0];
			traverser.next[0] = nodelist[i];	
		}	
	}

 /**
	*  Deletes a node that contains the given value.
	*  In order to delete a node we must maintain an array
	*  of nodes whose next references must be updated.
	*/
	public void delete(AnyType toDelete)
	{
		//The deletion algorithm starts in the same way as the insertion algorithm. 
		//After deletion you must check if the level of the list needs to be lowered. 
		//Note that the list may contain duplicates. Your delete method must delete only the first occurrence.
		int currlevel = currmax;
		
		while (currlevel >= 0)
		{
			Node<AnyType> traverser = headers[currlevel];
			
			//while loop dealing with each level
			//enter the while loop if the next node isn't null and is not bigger than the value we are looking for
			while(traverser.next[0]!=null && (traverser.next[0].data).compareTo(toDelete.getCompareValue()) <= 0)
			{
				if (traverser.next[0].data.compareTo(toDelete.getCompareValue()) == 0 )
				//enter the if statement if the next value is the value we are looking for
				{	
					//updates the next of the current node
					traverser.next[0] = traverser.next[0].next[0];
					break;
				}
				traverser = traverser.next[0];
			}
			currlevel--;
		}
		
		//now update the currmax
		int checker = 0;
		while (headers[checker].next[0]!=null)
		{
			checker++;
		}
		if (checker > 0)
		{
			currmax = checker-1;
		}
		else
		{
			currmax = 0;
		}
	}
	
	private static class Node<AnyType>
	{
		public AnyType data;
		public Node<AnyType>[] next;
		
		public Node(int randLevel, AnyType data)
		{
			next = new Node[randLevel + 1];
			this.data = data;
		}
	}
	
	//added data type and methods
	private Node<AnyType>[] headers = new Node[8];
	private int currmax;
}


