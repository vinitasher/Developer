/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import arrays.ArrayUtil;

/**
 *
 * @author vasher
 */
public class QuickSort {
    
    enum PIVOT {
        FIRST,
        LAST,
        RANDOM;
    }
    
    public static void quicksort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            int left = pivotIndex - 1;
            int right = pivotIndex + 1;
            if(left > 0)
                quicksort(arr, 0, left);
            if(right<high)
                quicksort(arr, right, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high){
        int pivotIndex = high;
        int pivotBoundary = low - 1;
        for(int i = low; i < pivotIndex; i++){
            if(arr[i] < arr[pivotIndex]){
                pivotBoundary++;
                ArrayUtil.swap(arr, pivotBoundary, i);
            }
        }
        ArrayUtil.swap(arr, pivotBoundary+1, pivotIndex);
        return pivotBoundary+1;
    }
    
    public static void main(String[] args){
        int[] arr = ArrayUtil.readArray();
        //System.out.println("Pick pivot element:\nEnter 0 for first\nEnter 1 for last\nEnter 2 for random");
        if(arr != null){
            quicksort(arr, 0, arr.length-1);
        }
        ArrayUtil.outputArray(arr);
    }
    
}
