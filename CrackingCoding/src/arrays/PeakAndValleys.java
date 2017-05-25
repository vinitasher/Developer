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
public class PeakAndValleys {
    public static int[] convertIntoPeakAndValley(int[] arr){
        for(int i=1; i<arr.length; i=i+2){
            if(i == arr.length-1){
                if(arr[i] < arr[i-1]){
                    ArrayUtil.swap(arr, i-1, i);
                }
            } else {
                if(arr[i] < arr[i-1] || arr[i] < arr[i+1]){
                    if(arr[i-1] > arr[i+1]){
                        ArrayUtil.swap(arr, i-1, i);
                    } else {
                        ArrayUtil.swap(arr, i+1, i);
                    }
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args){
        int[] arr = ArrayUtil.readArray();
        ArrayUtil.outputArray(convertIntoPeakAndValley(arr));
    }
    
}
