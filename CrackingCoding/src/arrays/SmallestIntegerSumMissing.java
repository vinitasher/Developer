/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author vasher
 */
public class SmallestIntegerSumMissing {
    
    public int findSmallest(int[] arr){
        //prove that 1 is possible
        int smallestMissingSum = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=smallestMissingSum){
                smallestMissingSum += arr[i];
            }
        }
        return smallestMissingSum;
    }
    
    public static void main(String[] args){
        SmallestIntegerSumMissing small = new SmallestIntegerSumMissing();
        int arr1[] = {1, 3, 4, 5};
        System.out.println(small.findSmallest(arr1));
 
        int arr2[] = {1, 2, 6, 10, 11, 15};
        System.out.println(small.findSmallest(arr2));
 
        int arr3[] = {1, 1, 1, 1};
        System.out.println(small.findSmallest(arr3));
 
        int arr4[] = {1, 1, 3, 4};
        System.out.println(small.findSmallest(arr4));
 
    }
}
