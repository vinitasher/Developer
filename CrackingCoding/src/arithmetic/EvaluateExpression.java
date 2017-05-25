/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import java.util.Scanner;

/**
 *
 * @author vasher
 * for an input string evaluate the expression using BODMAS
 */
public class EvaluateExpression {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression:");
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    }
    
}
