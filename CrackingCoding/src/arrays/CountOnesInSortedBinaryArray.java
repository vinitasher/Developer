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
public class CountOnesInSortedBinaryArray {
    
    public int binarySearch(int[] arr, int start, int end){
//        System.out.println(start+" "+end);
        if(arr.length == 0 || end >= arr.length){
            return -1;
        }
        if(arr[end] == 1){
            return end;
        } else if(arr[start] == 0){
            return start;
        }
        int mid = (end+start)/2;
        if(arr[mid] == 0 && arr[mid-1] == 1){
            return mid;
        } else if(arr[mid] == 1 && arr[mid+1] == 0){
            return mid+1;
        } else if(arr[mid] == 0){
            return binarySearch(arr, start, mid-1);
        } else if(arr[mid] == 1) {
            return binarySearch(arr, mid+1, end);
        }
        return -1;
    }
    
    public static void main(String[] args){
        int[] arr = new int[100];
        int ones = (int) Math.floor(Math.random()*100);
        System.out.println("Input 1s:"+ones);
        for(int i=0; i<ones; i++){
            arr[i] = 1;
        }
        CountOnesInSortedBinaryArray c = new CountOnesInSortedBinaryArray();
        System.out.println(c.binarySearch(arr, 0, arr.length-1));
    }
    
}
