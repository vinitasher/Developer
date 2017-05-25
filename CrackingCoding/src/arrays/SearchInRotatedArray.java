/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class SearchInRotatedArray {
    BinarySearch bsearch;
    public int search(int[] arr, int low, int high, int value){
        if(arr[low]<arr[high]){
            return bsearch.search(arr, low, high, value);
        } else {
            int mid = (high + low)/2;
            if(arr[mid] == value){
                return mid;
            }
            if(arr[high] == value){
                return high;
            }
            if(arr[low] == value){
                return low;
            }
            if(arr[low]<arr[mid]){
                if(value>arr[low] && value<arr[mid]){
                    return search(arr, low, mid-1, value);
                } else {
                    return search(arr, mid+1, high, value);
                }
            } else {
                if(value>arr[mid] && value<arr[high]){
                    return search(arr, mid+1, high, value);
                } else {
                    return search(arr, low, mid-1, value);
                }
            }
                
        }
    }
    
    public static void main(String[] args){
        SearchInRotatedArray bs = new SearchInRotatedArray();
        bs.bsearch = new BinarySearch();
        int[] arr = ArrayUtil.readArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value to be searched:");
        int value = sc.nextInt();
        int position = bs.search(arr, 0, arr.length-1, value);
        System.out.println("Position:"+position);
    }
    
}
