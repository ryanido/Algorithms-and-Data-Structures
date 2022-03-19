import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    /**
     * Check if get works
     */
    @Test
    public void testGet()
    {
    	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        int testT = testDLL.get(0);
        assertEquals( "Checking get to a list containing 3 elements at position 0", 1, testT );
        testT = testDLL.get(1);
        assertEquals( "Checking get to a list containing 3 elements at position 1", 2, testT );
        testT = testDLL.get(2);
        assertEquals( "Checking get to a list containing 3 elements at position 2", 3, testT );
        assertNull( "Checking get to a list containing 3 elements at position -1 - expected null", testDLL.get(-1) );
        assertNull( "Checking get to a list containing 3 elements at position 700 - expected null", testDLL.get(700) );
     
        
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        assertNull( "Checking get to an empty list at position 0 - expected null", testDLL.get(0));
        assertNull( "Checking get to an empty list at position 0 - expected null", testDLL.get(10));
        assertNull( "Checking get to an empty list at position 0 - expected null", testDLL.get(-10));

    }
    /**
     * Check if deleteAt works
     */
    @Test
    public void testDeleteAt()
    {
         //test non-empty list
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
         testDLL.insertBefore(0,1);
         testDLL.insertBefore(1,2);
         testDLL.insertBefore(2,3);
         testDLL.insertBefore(0,4);
         
         boolean delete =testDLL.deleteAt(2);
         assertTrue("Checking deleteAt to a list containing 4 elements at position 2 - expected return true",delete);
         assertEquals( "Checking deleteAt to a list containing 4 elements at position 2", "4,1,3", testDLL.toString() );
         delete = testDLL.deleteAt(0);
         assertTrue("Checking deleteAt to a list containing 3 elements at position 0 - expected return true",delete);
         assertEquals( "Checking deleteAt to a list containing 3 elements at position 0", "1,3", testDLL.toString() );
         delete = testDLL.deleteAt(1);
         assertTrue("Checking deleteAt to a list containing 2 elements at position 1 - expected return true",delete);
         assertEquals( "Checking deleteAt to a list containing 2 elements at position 1", "1", testDLL.toString() );
         delete = testDLL.deleteAt(-7);  
         assertFalse("Checking deleteAt to a list containing 1 element at position -7 - expected return false",delete);
         assertEquals( "Checking insertBefore to a list containing 2 element at position -7", "1", testDLL.toString() );
         delete = testDLL.deleteAt(8); 
         assertFalse("Checking deleteAt to a list containing 1 element at position 8 - expected return false",delete);
         assertEquals( "Checking insertBefore to a list containing 1 element at position 8", "1", testDLL.toString() );
         
         //test empty list
         testDLL = new DoublyLinkedList<Integer>();
         delete = testDLL.deleteAt(0);
         assertFalse("Checking deleteAt to an empty list at position 0 - expected return false",delete);
         
     
    }
    /**
     * Check if reverse works
     */
    @Test
    public void testReverse()
    {
    	//test non-empty list
   	 	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 4 elements", "4,3,2,1", testDLL.toString() );
        
      //test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.reverse();
        assertEquals( "Checking reverse to an empty list", "", testDLL.toString() );
        
        
    }
    /**
     * Check if makeUnique works
     */
    @Test
    public void testMakeUnique()
    {
    	//test non-empty, non-unique list
   	 	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,1);
        testDLL.insertBefore(3,3);
        testDLL.insertBefore(4,2);
        testDLL.insertBefore(5,2);
        testDLL.makeUnique();
        assertEquals( "Checking makeUnique to a non-unique list containing 6 elements", "1,2,3", testDLL.toString() );
        
    	//test non-empty, unique list
   	 	testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.makeUnique();
        assertEquals( "Checking makeUnique to a unique list containing 4 elements", "1,2,3,4", testDLL.toString() );
        
        //test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.makeUnique();
        assertEquals( "Checking makeUnique to an empty list", "", testDLL.toString() );
    }
    /**
     * Check if push works
     */
    @Test
    public void testPush()
    {
    	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);

        testDLL.push(4);
        assertEquals( "Checking push to a list containing 3 elements", "4,3,2,1", testDLL.toString() );
        testDLL.push(5);
        assertEquals( "Checking push to a list containing 4 elements", "5,4,3,2,1", testDLL.toString() );
        testDLL.push(6);       
        assertEquals( "Checking push to a list containing 5 elements", "6,5,4,3,2,1", testDLL.toString() );
        
        //test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);        
        assertEquals( "Checking push to an empty list - expected the element at the head of the list", "1", testDLL.toString() );
    }
    /**
     * Check if the pop works
     */
    @Test
    public void testPop()
    {
    	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);

        int testT = testDLL.pop();
        assertEquals( "Checking pop to a list containing 3 elements", 3, testT);
        assertEquals( "Checking pop to a list containing 3 elements", "2,1", testDLL.toString() );
        testT = testDLL.pop();
        assertEquals( "Checking pop to a list containing 3 elements", 2, testT);
        assertEquals( "Checking pop to a list containing 2 elements", "1", testDLL.toString() );
        testT = testDLL.pop(); 
        assertEquals( "Checking pop to a list containing 3 elements", 1, testT);
        assertEquals( "Checking pop to a list containing 1 element", "", testDLL.toString() );
        
        //test empty list
        testDLL = new DoublyLinkedList<Integer>();        
        assertNull( "Checking pop to an empty list, expected null",testDLL.pop());
        assertEquals( "Checking pop to an empty list","",testDLL.toString());
    }
    /**
     * Check if the enqueue works
     */
    @Test
    public void testEnqueue()
    {
    	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);

        testDLL.enqueue(4);
        assertEquals( "Checking enqueue to a list containing 3 elements", "4,3,2,1", testDLL.toString() );
        testDLL.enqueue(5);
        assertEquals( "Checking enqueue to a list containing 4 elements", "5,4,3,2,1", testDLL.toString() );
        testDLL.enqueue(6);       
        assertEquals( "Checking enqueue to a list containing 5 elements", "6,5,4,3,2,1", testDLL.toString() );
        
        //test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);        
        assertEquals( "Checking enqueue to an empty list - expected the element at the head of the list", "1", testDLL.toString() );
    }
    /**
     * Check if the dequeue works
     */
    @Test
    public void testDequeue()
    {
    	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);

        int testT = testDLL.dequeue();
        assertEquals( "Checking dequeue to a list containing 3 elements", 1, testT);
        assertEquals( "Checking dequeue to a list containing 3 elements", "3,2", testDLL.toString() );
        testT = testDLL.dequeue();
        assertEquals( "Checking dequeue to a list containing 3 elements", 2, testT);
        assertEquals( "Checking dequeue to a list containing 2 elements", "3", testDLL.toString() );
        testT = testDLL.dequeue(); 
        assertEquals( "Checking dequeue to a list containing 3 elements", 3, testT);
        assertEquals( "Checking dequeue to a list containing 1 element", "", testDLL.toString() );
        
        //test empty list
        testDLL = new DoublyLinkedList<Integer>();        
        assertNull( "Checking dequeue to an empty list, expected null",testDLL.dequeue());
        assertEquals( "Checking dequeue to an empty list","",testDLL.toString());
    }
    

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.

}