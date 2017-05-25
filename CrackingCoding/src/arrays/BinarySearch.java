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
public class BinarySearch {
    
    int[] arr;
    
    public int search(int[] arr, int low, int high, int value){
        int mid = (high + low)/2;
//        System.out.println(low+""+mid+""+high);
        if(low==high && arr[high] != value){
            return -1;
        }
        if(arr[mid] == value){
            return mid;
        }
        if(arr[high] == value){
            return high;
        }
        if(arr[low] == value){
            return low;
        }
        if(arr[mid] > value){
            return this.search(arr, low, mid-1, value);
        } else {
            return this.search(arr, mid+1, high, value);
        }
    }

    public BinarySearch() {
    }
    
    public static void main(String[] args){
        BinarySearch bs = new BinarySearch();
        bs.arr = ArrayUtil.readArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value to be searched:");
        int value = sc.nextInt();
        int position = bs.search(bs.arr, 0, bs.arr.length-1, value);
        System.out.println("Position:"+position);
    }
    
    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
