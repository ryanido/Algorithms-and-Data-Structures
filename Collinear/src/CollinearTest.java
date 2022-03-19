import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Random;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 18/09/18 12:21:26
 */

@RunWith(JUnit4.class)
public class CollinearTest
{
	public static void main(String[] args) {
		int inputSize = 5000;
		Random rd = new Random(); // creating Random object
	    int[] a1 = new int[inputSize];
	    int[] a2 = new int[inputSize];
	    int[] a3 = new int[inputSize];
	    for (int i = 0; i < a1.length; i++) {
	         a1[i] = rd.nextInt(); // storing random integers in an array
	         a2[i] = rd.nextInt(); // storing random integers in an array
	         a3[i] = rd.nextInt(); // storing random integers in an array
	    }
		 Stopwatch stopwatch = new Stopwatch();
		 System.out.println("start");
		 Collinear.countCollinearFast(a1,a2,a3);
		 double time = stopwatch.elapsedTime();
		 System.out.println("elapsed time " + time);
	}
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }
    /**
     * Check for no false positives in binarySearch for a multiple element array(should test every if statement)
     */
 
    @Test
    public void testBinary()
    {
    	boolean expectedResult = true;
    	int[] a = { 1, 4, 6, 2, 5, 3, 7};
    	assertEquals("BinarySearch(" + Arrays.toString(a) + ")",     expectedResult, Collinear.binarySearch(a,3));
    }

    

}


