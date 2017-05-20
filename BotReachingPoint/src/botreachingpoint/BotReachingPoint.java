/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botreachingpoint;

import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class BotReachingPoint {
    
    static int analyzeSequence(){
        if(navigateX() == 0){
            
        }
    }
    
    static int navigateX(x1, y1, x2, y2)
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        
        if(x1 > x2 || y1 > y2){
            System.out.println("No");
        } else {
            int result = analyzeSequence();
            if(result == -1){
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
        
    }
    
}
