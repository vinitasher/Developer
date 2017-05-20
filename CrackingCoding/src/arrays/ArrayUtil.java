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
public class ArrayUtil {
    
    public static int[] readArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array length:");
        int length = sc.nextInt();
        System.out.println("Enter array elements:");
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i] = sc.nextInt();
        }
        return array;
    }
    
    public static void outputArray(int[] array){
        
        if(array != null){
            System.out.println("Array:");
            for(int i=0; i<array.length; i++){
                System.out.print(array[i]+" ");
            }
        } else {
            System.out.println("Array is null");
        }
    }
    
    public static void swap(int[] array, int i, int j){
        if(array == null){
            System.out.println("Array is null");
            return;
        }
        int N = array.length;
        if(i < N && j < N){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        } else {
            System.out.println("Swap indexs incorrect");
        }
    }
    
}
