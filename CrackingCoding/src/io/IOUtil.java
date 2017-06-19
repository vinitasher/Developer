/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author vasher
 */
public class IOUtil {
    
    public static int readInteger(String message){
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public static void displaySet(Set set){
        System.out.println("Set contains:");
        if(set != null){
            for(Object o: set){
                System.out.println(o);
            }
        }
    }
    
}
