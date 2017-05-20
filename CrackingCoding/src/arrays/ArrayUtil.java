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
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i] = sc.nextInt();
        }
        return array;
    }
    
}
