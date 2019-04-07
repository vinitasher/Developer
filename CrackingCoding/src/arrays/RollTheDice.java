/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author vasher
 * http://www.geeksforgeeks.org/roll-characters-string/
 * 
 */
public class RollTheDice {
    
    int MAX_CHARACTERS = 26;
    
    public String rollDice(String s, int[] roll){
        int n = 0;
        if(roll != null) {
            n = roll.length;
        }
        int[] rollCount = new int[n+1];
        for(int i=0; i<n; i++){
            rollCount[0] += 1;
            rollCount[roll[i]] -= 1;
        }
        
        for(int j=1; j<rollCount.length; j++){
            rollCount[j] += rollCount[j-1];
        }
        
        for(int k=0; k<s.length(); k++){
            
        }
        
    }
    
}
