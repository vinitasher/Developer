/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import io.IOUtil;
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
    
    public static int[] sampleArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array length:");
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i] = i;
        }
        return array;
    }
    
    public static int[] sampleUnsortedArray(){
        int length = IOUtil.readInteger("Input array length:");
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i] = (int) Math.floor(Math.random()*length);
        }
        return array;
    }
    
    public static int[] sampleSortedArray(){
        int length = IOUtil.readInteger("Input array length:");
        int sum = 0;
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            sum += (int) Math.floor(Math.random()*10);
            array[i] = sum;
        }
        return array;
    }
    
    public static void outputArray(int[] array){
        
        if(array != null){
            System.out.println("\nArray:");
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
