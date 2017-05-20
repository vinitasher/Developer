/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayprocessor;

import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class ArrayProcessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            boolean ruleApplied = false;
            array[i] = sc.nextInt();
            if(i > 0 && i % 2 == 0){
                array[i] = array[i] + array[i-1];
                ruleApplied = true;
            }
            if(i > 0 && i % 3 == 0 && i + 1 < length){
                int tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;
                ruleApplied = true;
            }
            if(i > 0 && i % 5 == 0){
                array[i] = array[i] * 2;
                ruleApplied = true;
            }
            if(!ruleApplied || i % 7 ==0){
                array[i] = array[i] - 1; 
            }
        }
        
    }
    
}
