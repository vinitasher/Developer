/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicstring;

import java.util.Arrays;

/**
 *
 * @author vasher
 */
public class MagicString {
    int[] dp;
    
    public int magicalStrings(int n){
        dp = new int[n+1];
       return magicalStringCount(n, "aeiou");
    }
    
    public int magicalStringCount(int n, String s){
        char[] arr = s.toCharArray();
        //int count = new int[n+1];
        if(n == 0){
            dp[0] = 1;
        }
        if(n == 1){
            dp[1] = 5;
        }
        for(int j=2; j <= n; j++) {
            dp[j] = dp[j-1];
            for(int i=0; i<arr.length; i++){
                switch(arr[i]){
                    case 'a':
                        dp[j] = dp[j] + 1;
                        //System.out.println(count);
                        break;
                    case 'e': 
                        dp[j] = dp[j] + 2;
                        //System.out.println(count);
                        break;
                    case 'i':
                        dp[j] = dp[j] + 4;
                        //System.out.println(count);
                        break;
                    case 'o':
                        dp[j] = dp[j] + 2;
                        //System.out.println(count);
                        break;
                    case 'u': 
                        dp[j] = dp[j] + 1;
                        break;
                }
            }
        }
        return dp[n];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MagicString instance = new MagicString();
        System.out.println(instance.magicalStrings(3));
    }
    
}
