import java.util.Arrays;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	int j;
    	double[] result = Arrays.copyOf(a,a.length);
        for(int i = 1; i < a.length; i++)
        {
        	j = i;
        	while(j > 0 && result[j] < result[j - 1])
        	{
        		swap(result, j, j-1);
        		j--;
        	}
        }
        return result;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	 double[] result = Arrays.copyOf(a,a.length);
         for(int i = 0; i < result.length;i++)
         {
        	 int min = i;
        	 for(int j = i; j < result.length; j++)
        		 min = result[min] > result[j] ? j : min;
        	 swap(result, min, i);
         }
         return result;

    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	double[] result = Arrays.copyOf(a,a.length);
		qsort(result,0,result.length - 1);
		return result;
    }
    
    static void qsort(double a[],int lo,int hi) {
    	if(lo < hi)
    	{
    		int p = partition(a,lo,hi);
    		qsort(a,p+1,hi);
    		qsort(a,lo,p-1);
    	}
    }
    static int partition(double a[],int lo, int hi)
    {
    	int p = hi;
    	int l = lo;
    	for(int i = lo; i < hi; i++)
    	{
    		if(a[p] >= a[i]) 
    		{
    			swap(a,i,l);
    			l++;
    		}
    	}
    	swap(a,p,l);
    	return l;
    }
    //end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	double[] result = Arrays.copyOf(a, a.length);
		int n = result.length;
		for(int size = 1; size < n; size = size+size)
			for(int lo = 0; lo < n - size;lo += size+size)
				merge(result,lo,lo+size-1,Math.min(lo+size+size-1, n-1));
		return result;
	
    }
    

    //end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	double[] result = Arrays.copyOf(a, a.length);
    	msort(result,0,result.length-1);
    	return result;
	
    }
    static void msort(double a[], int lo,int hi)
    {
    	int mid = lo + (hi - lo)/2;
    	if(lo < hi)
    	{
    		msort(a,lo,mid);
    		msort(a,mid+1,hi);
    		merge(a,lo,mid,hi);
    	}
    }
    static void merge(double a[],int lo,int mid, int hi)
    {
    	int lh = mid - lo + 1; // size of lower half
    	int uh = hi - mid;	// size of upper half
    	double lowHalf[] = new double[lh];
    	double uppHalf[] = new double[uh];
    	for(int i = 0; i < lh; i++)
    	{
    		lowHalf[i] = a[lo+ i];
    	}
    	for(int i = 0; i < uh; i++ )
    	{
    		uppHalf[i] = a[i + mid+1];
    	}
    	int k = 0;
    	int j = 0;
    	int index = lo;
    	while(k < lh && j < uh)
    	{
    		a[index++] = lowHalf[k] >= uppHalf[j] ? uppHalf[j++] : lowHalf[k++];  
    	}
    	while(k < lh) a[index++] = lowHalf[k++];
    	while(j < uh) a[index++] = uppHalf[j++];
    		
    }
    
    //end mergeSortRecursive
    	
    public static void swap(double[] A, int i, int o)
	{
		double tmp = A[o];
		A[o] = A[i];
		A[i] = tmp;
	}


   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

 }//end class


