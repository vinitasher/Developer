/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import arrays.ArrayUtil;
import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class CountingSort {
    int[] arr, countArr, outArr;
    int rangeLow;
    int rangeHigh;
    
    public void countArray(){
        countArr = new int[rangeHigh - rangeLow + 1];
        for(int i=0; i < arr.length; i++){
            if(arr[i] <= rangeHigh && arr[i] >= rangeLow){
                countArr[arr[i]-rangeLow]++;
            }
        }
        int sum =0;
        for(int i = 0; i< countArr.length; i++){
            sum = sum + countArr[i];
            countArr[i] = sum;
        }
        System.out.println("Count array");
        ArrayUtil.outputArray(countArr);
    }
    
    public void sortArray(){
        System.out.println("output array:");
        outArr = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            int position = countArr[arr[i]-rangeLow];
            outArr[position-1] = arr[i];
            countArr[arr[i]-rangeLow]--;
        }
        
        ArrayUtil.outputArray(outArr);
    }
    
    public void readInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input range:");
        rangeLow = sc.nextInt();
        rangeHigh = sc.nextInt();
        arr = ArrayUtil.readArray();
    }
    
    public static void main(String[] args){
        CountingSort cs = new CountingSort();
        cs.readInput();
        cs.countArray();
        cs.sortArray();
    }
    
}
