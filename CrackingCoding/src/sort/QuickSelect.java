/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import arrays.ArrayUtil;
import io.IOUtil;
import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class QuickSelect {
    
    //kth smallest element
    public int quickSelect(int[] arr, int low, int high, int k){
        int partitionIndex = QuickSort.partition(arr, low, high);
        int left = partitionIndex - 1;
        int right = partitionIndex + 1;
        if(partitionIndex == k-1){
            return arr[k-1];
        } else if(partitionIndex > k-1){
            return quickSelect(arr, low, left, k);
        } else {
            return quickSelect(arr, right, high, k);
        }
    }
    
    
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args){
        //int[] arr = ArrayUtil.sampleArray();
        int[] arr = ArrayUtil.readArray();
        ArrayUtil.outputArray(arr);
        int k = IOUtil.readInteger("Enter the value of k");
        QuickSelect qs = new QuickSelect();
        int kthElement = qs.quickSelect(arr, 0, arr.length-1, k);
        System.out.println("Kth Element:"+kthElement);
    
    }
    
}
