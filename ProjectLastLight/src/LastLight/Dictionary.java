package LastLight;


import java.util.Arrays;
import java.util.Queue;

/**
 *
 * Implementation of an Amortized Array-Based Dictionary data structure.
 *
 * This data structure supports duplicates and does not support storage of
 * null references.
 *
 *
 *****************************************************************************/



public class Dictionary<AnyType extends Comparable<AnyType>>  implements DictionaryInterface<AnyType>
{
	/*
	 * Keeps track of the number of elements in the dictionary.
	 * Take a look at the implementation of size()
	 */
	private int size;
	/*
	 * The head reference to the linked list of Nodes.
	 * Take a look at the Node class.
	 */
	private Node head;

	/**
	 * Creates an empty dictionary.
	 */
	public Dictionary()
	{
		size = 0;
		head = null;
	}

	/**
	 * Adds e to the dictionary, thus making contains(e) true.
	 * Increments size so as to ensure size() is correct.
	 */
	@SuppressWarnings("unchecked")
	public void add(AnyType e)
	{
		if(e == null)
		{
			return;
		}
		//1. add a new array with power 0 and insert e to it
		Comparable<AnyType>[] arr = new Comparable[1];
		arr[0] = e;
		Node node = new Node(0, arr, head);
		head = node;
		size++;
		//2.merge down
		mergeDown();
	}

	/**
	 * Removes e from the dictionary.  If contains(e) was formerly false,
	 * it is still false.
	 * Otherwise, decrements size so as to ensure size() is correct.
	 */
	@SuppressWarnings("rawtypes")
	public void remove(AnyType e)
	{
		if(e == null)
		{
			return;
		}
		if (contains(e) == false)
		{
			return;
		}
		
		Node current = head;
		int index = -1;
		
		//case 2
		index = current.indexOf(e);
		if (index < 0)
		{
			current = current.next;
		}
		else
		{
			size--;
			current.array[index]  = head.array[head.array.length-1];
			Arrays.sort(current.array);
			if (head.power == 0)
			{
				head = head.next;
				//Arrays.sort(head.array);
				return;
			}
			Queue<Comparable[]> queue = splitUp(head.array, head.power);
			for (int i = 1; i <= queue.size()-1; i++)
			{
				Comparable[] data = queue.poll();
				Arrays.sort(data);
				Node node = new Node(head.power-i, data, head.next);
			}
			Comparable[] data = queue.poll();
			Node node = new Node(0, data, head.next);
			head = node;	
		}
		
		//case 3
		while (current != null)
		{
			index = current.indexOf(e);
			if (index < 0)
			{
				current = current.next;
			}
			else
			{
				size--;
				current.array[index]  = head.array[head.array.length-1];
				Arrays.sort(current.array);
				
				if (head.power == 0)
				{
					head = head.next;
					//Arrays.sort(head.array);
					
					return;
				}
				Queue<Comparable[]> queue = splitUp(head.array, head.power);
				for (int i = 1; i <= queue.size(); i++)
				{
					Comparable[] data = queue.poll();
					Arrays.sort(data);
					Node node = new Node(head.power-i, data, head.next);
				}
			}
		}
		mergeDown();
	}

	/**
	 * Returns true iff the dictionary contains an element equal to e.
	 */
	public boolean contains(AnyType e)
	{
		
		int returned = -1;
		Node current = head;
		
		if(e == null)
		{
			return false;
		}
		
		while (current != null)
		{
			returned = binarySearch(current.array, e);
			
			if (returned < 0)
			{
				current = current.next;
			}
			else if (returned >= 0)
			{
				break;
			}
		}
		
		if (returned < 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Returns the number of elements in the dictionary equal to e.
	 * This is logically equivalent to the number of times remove(e) needs to be performed
	 * in order for contains(e) to be false.
	 */
	public int frequency(AnyType e)
	{
		
		Node current = head;
		int counter = 0;
		
		if(e == null)
		{
			return counter;
		}
		
		while (current != null)
		{
			counter = counter + frequency(current.array, e);
			current = current.next;
		}
		return counter;
	}

	/**
	 * Returns the size of the dictionary.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Combines with the other AAD using the algorithm discussed in lecture.
	 *
	 * Formally, the following need to be true after combining an AAD with another AAD:
	 * 		-the resulting dictionary contains an item iff it was contained in either of the two dictionaries
	 * 		-the resulting frequency of any item is the sum of its frequency in the two dictionaries
	 * 		-the resulting size is the sum of the two sizes
	 */
	@SuppressWarnings("unused")
	public void combine(Dictionary<AnyType> other)
	{
		if(other == null)
		{
			return;
		}
		
		if (this == other)
		{
			return;
		}

		
		//1. this is empty, other is not empty
		//then just point to other and return?
		if (this == null && other!=null)
		{
			this.head = other.head;
			return;
		}
		//2. other is empty, this is not empty
		//just return without adding anything
		if (this !=null && other == null)
		{
			return;
		}
		
		//3. this and other are both not empty
		Node othercurrent = other.head;
		Node thiscurrent = head;
		
		//for (int i = 0; i < other.size; i++)
		while (othercurrent != null)
		{
			//reinitialize to the begining node
			thiscurrent = head;
			boolean inserted = false;
			while (inserted == false)
			{	
				//if OC is >= to TC
				//&& OC <= TC.N insert
				// then change inserted to true
				if ((thiscurrent.next == null || 
						thiscurrent.next.power >= othercurrent.power) && othercurrent.power >= thiscurrent.power)
				{
					Node tempnext = thiscurrent.next;
					Node temp = new Node(othercurrent.power, othercurrent.array, tempnext);
					thiscurrent.next = temp;
					temp.next = tempnext;
					size = size + othercurrent.array.length;
					inserted = true;
				}
				
				else if (othercurrent.power < thiscurrent.power)
				{
					//other's value is smaller than all values in this
					Node tempnext = head;
					Node temp = new Node(othercurrent.power, othercurrent.array, tempnext);
					head = temp;
					size = size + othercurrent.array.length;
					inserted = true;
				}
				//if here, othercurr is bigger than thiscurr but smaller than thiscurr's next values,
				//so traverse to the right
				thiscurrent = thiscurrent.next;
			}
			othercurrent = othercurrent.next;
		}
		mergeDown();
	}

	/**
	 * Returns a helpful string representation of the dictionary.
	 */
	public String toString()
	{
		String toreturn = "";
		Node current = head;
		while (current != null)
		{
			toreturn =toreturn + current.power + ": " + current.toString() + "\n";
			current = current.next;
		}
		return toreturn;
	}


	/**
	 * Starting with the smallest array, mergeDown() merges arrays of the same size together until
	 * all the arrays have different size.
	 *
	 * This is very useful for implementing add(e)!!!  See the lecture notes for the theory behind this.
	 */
	private void mergeDown()
	{
		Node current = head;
		head = mergeDownHelper(current);
	}
	
	private Node mergeDownHelper(Node current)
	{
		if (current == null)
		{
			return null;
		}
		if (current.next == null)
		{
			return current;
		}
		//if the size of the two arrays are equal,
		//merge them together
		//if (current.next.array.length == current.array.length)
		if (current.next.array.length == current.array.length
				&& (current.next.next == null ||
				current.next.array.length != current.next.next.array.length))
		{
			//should take care of the pointers, etc
			//1. prev is the head
			//2. prev has an item before it --should update that thing's next
			@SuppressWarnings("rawtypes")
			Comparable[] refresh = new Comparable[current.array.length + current.next.array.length];
			refresh = merge(current.array, current.next.array);
			// merge the arrays together and have current store it
			current.next = current.next.next;
			current.array = refresh;
			//current.power = (int) Math.ceil(Math.log(current.array.length));
			current.power++;
		}
		
		if (current.next != null) {
			
			//if (current.array.length == current.next.array.length)
			if (current.array.length == current.next.array.length
					&& (current.next.next == null ||
						current.next.array.length != current.next.next.array.length))
			{
				current = mergeDownHelper(current);
			}
			
			current.next = mergeDownHelper(current.next);
		}
		return current;
	}

	/**
	 * Assumes a is sorted.
	 *
	 * contains(a, item) 	= -1, if there is no element of a equal to item
	 * 						= k, otherwise, where a[k] is equal to item
	 *
	 * This is needed for Node's indexOf(e)
	 *
	 * O(log(a.length))
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int binarySearch(Comparable[] a, Comparable item)
	{
		/*
		 * Your code goes here...
		 */
		return Arrays.binarySearch(a, item);
	}

	/**
	 * Assumes a is sorted.
	 *
	 * Returns the number of elements of a equal to item.
	 *
	 * This is needed for Node's frequency(e).
	 *
	 * O(log(a.length) + frequency(item))
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int frequency(Comparable[] a, Comparable item)
	{
		int count = 0;
		int x = binarySearch(a, item);
		
		if (x > -1)
		{
			count++;
			for (int i = x -1 ; i > -1; i--)
			{
				if (a[i].compareTo(item) == 0)
				{
					count++;
				}
				else
				{
					break;
				}
			}
			for (int i = x+1 ; i < a.length; i++)
			{
				if (a[i].compareTo(item) == 0)
				{
					count++;
				}
				else
				{
					break;
				}
			}
		}
		return count;
	}

	/**
	 * When a and b are sorted arrays, merge(a,b) returns a sorted array
	 * that has length (a.length+b.length) than contains the elements
	 * of a and the elements of b.
	 *
	 * This is useful for implementing the mergeDown() method.
	 *
	 * O(a.length + b.length)
	 */
	
public static Comparable[] merge(Comparable[] a, Comparable[] b)	
{
	
	Comparable[] merged = new Comparable[a.length + b.length];
	int length = merged.length;
	
	//the bigger forloop looks at the entire merge
	for(int i = 0, j = 0, x = 0; x < length; x++)
	{
		//if there is no more a to add, just add b
		if(i >= a.length)
		{
			for(int k = j; k < b.length; ++k, ++x)
			{
				merged[x] = b[k];
			}
			break;
		}
		
		//if there is no more a to add, just add b
		else if(j >= b.length)
		{
			for(int k = i; k < a.length; ++k, ++x)
			{
				merged[x] = a[k];
			}
			break;
		}
		
		//if b is smaller than a, then add a then increment
		if(a[i].compareTo(b[j]) > 0)
		{
			merged[x] = b[j];
			j++;
		}
		//if a is smaller than b, then add a then increment
		else if(a[i].compareTo(b[j]) <= 0)
		{
			merged[x] = a[i];
			i++;
		}
	
	}
	return merged;
}


	/**
	 * Returns base^exponent.  This is useful for implementing splitUp(a,k)
	 */
	private static int power(int base, int exponent)
	{
		return (int)(Math.pow(base, exponent));
	}

	/**
	 * Assumes a.length >= 2^k - 1, for the given k.
	 *
	 * Splits the first (2^k -1) elements of a up into k-1 sorted arrays of
	 * length 2^(k-1), 2^(k-2), ..., 2, 1.
	 * Returns a Queue of these arrays (in the above order, i.e. the one with
	 * length 2^(k-1) is at the front).
	 *
	 * This is useful for implementing remove(e) using the algorithm discussed in class.
	 *
	 * O(a.length)
	 */
	@SuppressWarnings("unchecked")
	public static java.util.Queue<Comparable[]> splitUp(Comparable[] a, int k)
	{
		/*
		 * We'll just use a LinkedList as a Queue in this fashion.  Take a look at the
		 * API for the java.util.Queue interface.
		 */

		java.util.Queue<Comparable[]> q = new java.util.LinkedList<Comparable[]>();

		/*
		 * Your code goes here...
		 */
		int x = 0;
		
		for (int i = k-1; i >= 0; i--)
		{
			Comparable[] toadd = new Comparable[power(2, i)];
			for (int j = 0; j < power(2,i); j++)
			{
				toadd[j] = a[x];
				x++;
			}
			q.add(toadd);
		}
		
		return q;
	}

	/**
	 * Implementation of the underlying array-based data structure.
	 *
	 * AnyTypeach Node:
	 * 			-knows k, its "power"
	 * 			-has myArray, a sorted array of 2^k elements
	 * 			-knows myNext, the next Node in the linked list of Nodes
	 */
	@SuppressWarnings("unchecked")
	private static class Node
	{
		private int power;
		private Comparable[] array;
		private Node next;

		/**
		 * Creates an Node with the specified parameters.
		 */
		public Node(int power, Comparable[] array, Node next)
		{
			this.power = power;
			this.array = array;
			this.next = next;
		}

		/**
		 * Returns 	-1, if there is no element in the array equal to e
		 * 			 k, otherwise, where array[k] is equal to e
		 */
		public int indexOf(Comparable e)
		{
			return Dictionary.binarySearch(array, e);
		}

		/**
		 * Returns	true, if there is an element in the array equal to e
		 * 			false, otherwise
		 */
		public boolean contains(Comparable e)
		{
			return indexOf(e) > -1;
		}

		/**
		 * Returns the number of elements in the array equal to e
		 */
		public int frequency(Comparable e)
		{
			return Dictionary.frequency(array, e);
		}

		/**
		 * Returns a useful representation of this Node.  (Note how this is used by Dictionary's toString()).
		 */
		public String toString()
		{
			return java.util.Arrays.toString(array);
		}
	}

}


