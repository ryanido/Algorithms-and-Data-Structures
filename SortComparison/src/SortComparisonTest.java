/* Time Experiment(in Nanoseconds)

Sorted Numbers(1000)
quicksort:1.47346E7
insertionsort:104000.0
selectionsort:8036900.0
mergesort(recursive):1670500.0
mergesort(iterative):783700.0

Numbers Reverse(1000)
quicksort:6957800.0
insertionsort:1.08731E7
selectionsort:1.25737E7
mergesort(recursive):1168400.0
mergesort(iterative):406700.0

Number Nearly Ordered (1000)
quicksort:166700.0
insertionsort:3452700.0
selectionsort:753100.0
mergesort(recursive):273900.0
mergesort(iterative):327400.0

Numbers Random (1000)
quicksort:301000.0
insertionsort:1132600.0
selectionsort:1201700.0
mergesort(recursive):926900.0
mergesort(iterative):416600.0

Numbers Random Duplicate (1000)
quicksort:128900.0
insertionsort:1040400.0
selectionsort:970500.0
mergesort(recursive):491900.0
mergesort(iterative):438600.0

Numbers Random(10000)
quicksort:1257900.0
insertionsort:8.97562E7
selectionsort:5.35985E7
mergesort(recursive):1646600.0
mergesort(iterative):3908700.0
*/
import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] test = {};
    	test = SortComparison.insertionSort(test);
    	assertEquals("Check that insertion sort works for empty arrays",0,test.length);
    	test = SortComparison.selectionSort(test);
    	assertEquals("Check that selection sort works for empty arrays",0,test.length);
    	test = SortComparison.quickSort(test);
    	assertEquals("Check that quick sort works for empty arrays",0,test.length);
    	test = SortComparison.mergeSortRecursive(test);
    	assertEquals("Check that merge sort(recursive) works for empty arrays",0,test.length);
    	test = SortComparison.mergeSortIterative(test);
    	assertEquals("Check that merge sort(iterative) works for empty arrays",0,test.length);
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    

    /**
     * Check that the methods work for sorted arrays
     */
    @Test
    public void testSorted()
    {
    	double[] test = {2,3,4,5,6}; 
    	double[] sortedTest = SortComparison.insertionSort(test);
    	assertEquals("Check that insertionSort works for sorted arrays",Arrays.toString(test),Arrays.toString(sortedTest));
    	double[] test2 = {2,3,4,5,6}; 
    	double[] sortedTest2 = SortComparison.selectionSort(test2);
    	assertEquals("Check that selectionSort works for sorted arrays",Arrays.toString(test2),Arrays.toString(sortedTest2));
    	double[] test3 = {2,3,4,5,6}; 
    	double[] sortedTest3 = SortComparison.quickSort(test3);
    	assertEquals("Check that quickSort works for sorted arrays",Arrays.toString(test3),Arrays.toString(sortedTest3));
    	double[] test4 = {2,3,4,5,6}; 
    	double[] sortedTest4 = SortComparison.mergeSortRecursive(test4);
    	assertEquals("Check that mergeSort(recursive) works for sorted arrays",Arrays.toString(test4),Arrays.toString(sortedTest4));
    	double[] test5 = {2,3,4,5,6}; 
    	double[] sortedTest5 = SortComparison.mergeSortIterative(test5);
    	assertEquals("Check that mergeSort(iterative) works for sorted arrays",Arrays.toString(test5),Arrays.toString(sortedTest5));
    }
    
    /**
     * Check that the methods work for descending order sorted arrays
     */
    @Test
    public void testDescending()
    {
    	double[] test = {6,5,4,3,2}; 
    	double[] sortedTest = SortComparison.insertionSort(test);
    	double[] expectedResult = {2,3,4,5,6};
    	assertEquals("Check that insertionSort works for descending order sorted arrays",Arrays.toString(expectedResult),Arrays.toString(sortedTest));
    	double[] test2 = {6,5,4,3,2}; 
    	double[] sortedTest2 = SortComparison.selectionSort(test2);
    	double[] expectedResult2 = {2,3,4,5,6};
    	assertEquals("Check that selectionSort works for descending order sorted arrays",Arrays.toString(expectedResult2),Arrays.toString(sortedTest2));
    	double[] test3 = {6,5,4,3,2}; 
    	double[] sortedTest3 = SortComparison.quickSort(test3);
    	double[] expectedResult3 = {2,3,4,5,6};
    	assertEquals("Check that quickSort works for descending order sorted arrays",Arrays.toString(expectedResult3),Arrays.toString(sortedTest3));
    	double[] test4 = {6,5,4,3,2}; 
    	double[] sortedTest4 = SortComparison.mergeSortRecursive(test4);
    	double[] expectedResult4 = {2,3,4,5,6};
    	assertEquals("Check that mergeSort(recursive) works for descending order sorted arrays",Arrays.toString(expectedResult4),Arrays.toString(sortedTest4));
    	double[] test5 = {6,5,4,3,2}; 
    	double[] sortedTest5 = SortComparison.mergeSortIterative(test5);
    	double[] expectedResult5 = {2,3,4,5,6};
    	assertEquals("Check that mergeSort(iterative) works for descending order sorted arrays",Arrays.toString(expectedResult5),Arrays.toString(sortedTest5));
    }
    
    /**
     * Check that the methods work for unsorted arrays
     */
    @Test
    public void testUnsorted()
    {
    	double[] test = {3,4,1,8,2,9,3,5,7,6,0}; 
    	double[] sortedTest = SortComparison.insertionSort(test);
    	double[] expectedResult = {0,1,2,3,3,4,5,6,7,8,9};
    	assertEquals("Check that insertionSort works for unsorted arrays",Arrays.toString(expectedResult),Arrays.toString(sortedTest));
    	double[] test2 = {3,4,1,8,2,9,3,5,7,6,0};
    	double[] sortedTest2 = SortComparison.selectionSort(test2);
    	double[] expectedResult2 = {0,1,2,3,3,4,5,6,7,8,9};
    	assertEquals("Check that selectionSort works for unsorted arrays",Arrays.toString(expectedResult2),Arrays.toString(sortedTest2));
    	double[] test3 = {3,4,1,8,2,9,3,5,7,6,0};
    	double[] sortedTest3 = SortComparison.quickSort(test3);
    	double[] expectedResult3 = {0,1,2,3,3,4,5,6,7,8,9};
    	assertEquals("Check that quickSort works for unsorted arrays",Arrays.toString(expectedResult3),Arrays.toString(sortedTest3));
    	double[] test4 = {3,4,1,8,2,9,3,5,7,6,0};
    	double[] sortedTest4 = SortComparison.mergeSortRecursive(test4);
    	double[] expectedResult4 = {0,1,2,3,3,4,5,6,7,8,9};
    	assertEquals("Check that mergeSort(recursive) works for unsorted arrays",Arrays.toString(expectedResult4),Arrays.toString(sortedTest4));
    	double[] test5 = {3,4,1,8,2,9,3,5,7,6,0};
    	double[] sortedTest5 = SortComparison.mergeSortIterative(test5);
    	double[] expectedResult5 = {0,1,2,3,3,4,5,6,7,8,9};
    	assertEquals("Check that mergeSort(iterative) works for unsorted arrays",Arrays.toString(expectedResult5),Arrays.toString(sortedTest5));
    }
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
    	double[] testArray = new double[1000];
    	double[] testArrayB = new double[10000];
    	File path =  new File("C:\\Users\\ryani\\Downloads\\Assignment1 2022\\numbersSorted1000.txt");
    	toArray(path,testArray);
    	System.out.println("Sorted Numbers(1000)");
    	compareTimes(testArray);
    	path = new File("C:\\Users\\ryani\\Downloads\\Assignment1 2022\\numbersReverse1000.txt");
    	toArray(path,testArray);
    	System.out.println("Numbers Reverse(1000)");
    	compareTimes(testArray);
    	path = new File("C:\\Users\\ryani\\Downloads\\Assignment1 2022\\numbersNearlyOrdered1000.txt");
    	toArray(path,testArray);
    	System.out.println("Number Nearly Ordered (1000)");
    	compareTimes(testArray);
    	path = new File("C:\\Users\\ryani\\Downloads\\Assignment1 2022\\numbers1000.txt");
    	toArray(path,testArray);
    	System.out.println("Numbers Random (1000)");
    	compareTimes(testArray);
    	path = new File("C:\\Users\\ryani\\Downloads\\Assignment1 2022\\numbers1000Duplicates.txt");
    	toArray(path,testArray);
    	System.out.println("Numbers Random Duplicate (1000)");
    	compareTimes(testArray);
    	path = new File("C:\\Users\\ryani\\Downloads\\Assignment1 2022\\numbers10000.txt");
    	toArray(path,testArrayB);
    	System.out.println("Numbers Random(10000)");
    	compareTimes(testArrayB);
    }
    
    public static void toArray(File path, double[] a)
    {
    	Scanner sc;
		try {
			sc = new Scanner(path);
			for (int i = 0; sc.hasNextDouble(); i++)
	    	{
	    		a[i] = sc.nextDouble();
	    	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    
  
    }
    public static void compareTimes(double[] a)
    {
    	long start,time;
    	start = System.nanoTime();
    	SortComparison.quickSort(a);
    	time = System.nanoTime() - start;
    	System.out.println("quicksort:" + time);
    	start = System.nanoTime();
    	SortComparison.insertionSort(a);
    	time = System.nanoTime() - start;
    	System.out.println("insertionsort:" + time);
    	start = System.nanoTime();
    	SortComparison.selectionSort(a);
    	time = System.nanoTime() - start;
    	System.out.println("selectionsort:" + time);
    	start = System.nanoTime();
    	SortComparison.mergeSortRecursive(a);
    	time = System.nanoTime() - start;
    	System.out.println("mergesort(recursive):" + time);
    	start = System.nanoTime();
    	SortComparison.mergeSortIterative(a);
    	time = System.nanoTime() - start;
    	System.out.println("mergesort(iterative):" + time + "\n");
    }

}


