import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{
    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:Only contains a statement which takes constant time
     *  
     */
    public boolean isEmpty()
    {
      
      return (head == null);
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     *  In the worst case the pos would be at the end of the list so the for loop is executed aswell as the statements of running time theta(1) 
     *  Each instance of the for loop has a constant running time of theta(1) and in the worst case the loop runs for n times.
     *  Keeping the highest order terms the total running time is theta(n)
     */
    public void insertBefore( int pos, T data ) 
    {
      DLLNode newNode;
      if(isEmpty())
      {
    	  newNode = new DLLNode (data,null,null);
    	  head = newNode;
    	  tail = newNode;
      }
      else if(pos <= 0)
      {
    	  newNode = new DLLNode(data,null,head);
    	  head.prev = newNode;
    	  head = newNode;
    	 
      }
      else if(get(pos) == null)
      {
    	  newNode = new DLLNode(data,tail,null);
    	  tail.next = newNode;
    	  tail = newNode;
      }
      else
      {
    	  newNode = new DLLNode(data,null,null);
    	  DLLNode nextNode = head;
    	  for(int i = 0; i < pos; i++)
    	  {
    		  nextNode = nextNode.next;
    	  }
    	  newNode.prev = nextNode.prev;
    	  (nextNode.prev).next = newNode;
    	  newNode.next = nextNode;
    	  nextNode.prev = newNode;
      }
     
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(n)
     *
     * Justification:
     * In the worst case the DoublyLinkedList is not empty and the for loop is executed for the length of the list N aswell as simple statements of running time theta(1)
     * The for loop itself is made up of simple statements of a running time of theta(1)
     * these statements executed N times makes for a running time of theta(N)
     * keeping only high order terms the total running time is theta(n)
     */
    public T get(int pos) 
    {
      if(!isEmpty() && pos >= 0)
      {
    	  DLLNode tempNode = head;
    	  for(int i = 0; i < pos; i++)
      	  {
    		  if(tempNode.next != null)
    		  {
    			  tempNode = tempNode.next;
    		  }
    		  else 
    		  {
    			  return null;
    		  }
      	  }
    	  return tempNode.data;
      	  
      }
      else
      {
    	  return null;
      }
    
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  In the worst case the pos would not be out of bounds of the list so the for loop is executed aswell as the statements of running time theta(1). 
     *  Each instance of the for loop has a constant running time of theta(1) and in the worst case the loop runs for n times.
     *  Keeping the highest order terms the running time is theta(n)
     */
    public boolean deleteAt(int pos) 
    {
      if(get(pos) != null)
      {
    	  DLLNode tempNode = head;
    	  for(int i = 0; i < pos; i++)
    	  {
    		  tempNode = tempNode.next;
    	  }
    	  if(tail == head)
    	  {
    		  tail = null;
    		  head = null;
    	  }
    	  else if(tempNode == tail)
    	  {
    		  (tempNode.prev).next = null;
    		  tail = tempNode.prev;
    	  }
    	  else if(tempNode == head)
    	  {
    		  (tempNode.next).prev = null;
    		  head = tempNode.next;
    	  }
    	  else
    	  {
    		  (tempNode.prev).next = tempNode.next;
    		  (tempNode.next).prev = tempNode.prev;
    	  }
    	  tempNode.prev = null;
		  tempNode.next = null;
    	  
    	  return true;
      }
      else
      {
    	  return false;
      }
    }
      

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification: in everycase the while loop ,of simple statements amounting to a running time of theta(1), runs n times
     * the total running time totals to theta(n)
     */
    public void reverse()
    {
      DLLNode tempNode = head;
      DLLNode intermediaryNode = tail;
      tail = head;
      head = intermediaryNode;
      while(tempNode != null)
      {
    	  intermediaryNode = tempNode.prev;
    	  tempNode.prev = tempNode.next;
    	  tempNode.next = intermediaryNode;
    	  tempNode = tempNode.prev;
      }
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: theta(n^2)
     *
     * Justification:
     * 	In the worst case the list is already unique so the first while loop happens N-1 times
     * 	There are simple statements in the first while loop of running time theta(1) 
     * 	There is also another while loop,containing simple statements and comparisons of running time theta(1), that in the worst case happens N-1 times also
     *  The nested while loop happens N-1*N-1 times so collecting only highest order terms the methods running time is theta(n^2)
     */
     public void makeUnique()
    {
      DLLNode tempNode = head;
      int count = 0;
      while(!isEmpty() && tempNode.next != null)
      {
    	  
    	  DLLNode tempNode2 = tempNode.next;
    	  while(tempNode2 != null)
    	  {
    		  if(tempNode.data == tempNode2.data)
    		  {
    			  if(tempNode2 == tail)
    	    	  {
    	    		  (tempNode2.prev).next = null;
    	    		  tail = tempNode2.prev;
    	    	  }
    	    	  else
    	    	  {
    	    		  (tempNode2.prev).next = tempNode2.next;
    	    		  (tempNode2.next).prev = tempNode2.prev;
    	    	  }
    		  }
    		  tempNode2 = tempNode2.next;
    	  }
    	  if(tempNode.next != null)
    	  {
    		  tempNode = tempNode.next;
    	  }
      }
    
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification: The method calls insertBefore which in this case would call an if statement of running time theta(1)
     *  TODO
     */
    public void push(T item) 
    {
      insertBefore(-1,item);
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: theta(1)
     *
     * Justification:
     *  the method is made up of simple statements each of running time theta(1), including deleteAt which executes a simple if statement
     */
    public T pop() 
    {
      if(!isEmpty())
      {
    	  T tempData = head.data;
    	  deleteAt(0);
    	  return tempData;
      }
      else
      {
    	  return null;
      }
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: theta(1)
     *
     * Justification:
     *  The method calls insertBefore which in this case would call an if statement of running time theta(1)
     */
    public void enqueue(T item) 
    {
    	insertBefore(-1,item);
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: theta(1)
     *
     * Justification: In everycase there is simple statements of running time theta(1), 
     *
     */
    public T dequeue() 
    {
    	if(!isEmpty())
    	{
    		T tempData = tail.data;
    		if(head == tail)
    		{
    			head = null;
    			tail = null;
    		}
    		else
    		{
    			
    			DLLNode tempNode = tail;
    			tail = tempNode.prev;
    			tail.next = null;
    			tempNode.prev = null;
    		}
    		return tempData;
    	}
    	else
    	{
    		return null;
    	}
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



