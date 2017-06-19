/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import arrays.ArrayUtil;
import sort.QuickSort;

/**
 *
 * @author vasher
 */
public class PythagoreanTriplet {
    public boolean checkPythagoreanTriplet(int[] arr){
        arr = squareArray(arr);
        QuickSort.quicksort(arr, 0, arr.length-1);
        for(int i=arr.length-1; i>1; i--){
            int start=0, end=i-1;
            while(start<end){
                if(arr[start]+arr[end]<arr[i]){
                    start++;
                } else if(arr[start]+arr[end]>arr[i]){
                    end--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int[] squareArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=arr[i]*arr[i];
        }
        return arr;
    }
    
    public static void main(String[] args){
        int[] arr = ArrayUtil.readArray();
        PythagoreanTriplet pt = new PythagoreanTriplet();
        if(pt.checkPythagoreanTriplet(arr)){
            System.out.println("Array contains a pythagorean triplet");
        } else {
            System.out.println("Array does not contain a pythagorean triplet");
        }
    }
    
}
