package minsubarray;
	
import java.util.LinkedList;

	public class MinimumfromEachSubarray 
	{
	    public MinimumfromEachSubarray()
	    {
	    }
	    
	    private void printMin(int[] array, int low, int high)
	    {
	        int maxValue = Integer.MIN_VALUE;
	        for (int i = low; i <= high; i++)
	        {
	            if (array[i] > maxValue)
	            {
	                maxValue = array[i];
	            }
	        }
	        
	        System.out.println(maxValue);
	    }
	    
	    public void simplePrintMinfromEachSubarray(int[] array, int k)
	    {
	         
	        int low = 0, high = low + k - 1;
	        	        while (high < array.length)
	        {
	            printMin(array, low, high);
	            low  += 1;
	            high += 1;
	        }
	    }
	    
	    public void printMinfromEachSubarray(int[] array, int k)
	    {
	        LinkedList<Integer> list = new LinkedList();
	        
	        for (int i = 0; i < k; i++)
	        {
	             
	            while (!list.isEmpty() && array[list.getLast()] > array[i])
	            {
	                list.removeLast();
	            }
	            
	             
	            list.addLast(i);
	        }
	        
	        for (int i = k; i < array.length; i++)
	        {
	             
	            System.out.println(array[list.getFirst()]);
	            
	             
	            while (!list.isEmpty() && (list.getFirst() < (i-k+1)))
	            {
	                list.removeFirst();
	            }
	            
	             
	             
	            while (!list.isEmpty() && array[list.getLast()] < array[i])
	            {
	                list.removeLast();
	            }
	            
	             
	            list.add(i);
	        }
	        
	         
	        System.out.println(array[list.getFirst()]);
	    }
	
	    public static void main(String[] args)
	    {
	        MinimumfromEachSubarray solution = new MinimumfromEachSubarray();
	
	        int[] array = {9,6,11,8,10,5,14,13,93,14};
	        int k = 4;
	        
	        System.out.println("Maximum elements from each sub-array of specified size are - " );
	        solution.printMinfromEachSubarray(array, k);
	    }
	}