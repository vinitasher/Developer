
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

import java.io.*;
import java.util.*;

public class MinSubString {
    
    public static void main(String[] args){
        String input = "cabbbabbcabba";
        System.out.println(getShortestSubString(input));
    }

    //
    // k = 2    aaabbaaccbba
    // k = 3    aabbccdd
    // k = 2    aabbccbbba
    // k = 2    aaaaaaaaaab
    //

    /**
    The method calculates shortest substring for the input string which includes all its unique characters.
    <p>
    This method iterates over the input string and calculates the longest substring with k unique characters. 
    </p>
    @param input The input String. Input string should not be null, length of the input string should be greater than or equal to k 
    @param k Number of Unique characters required in output String. k should be in the range of 1 to length of the input string
    @return Longest substring with K unique characters
    @exception IllegalArgumentException if a param is not valid
    */
    public static String getShortestSubString(String input){
//        if(input==null || input.length()==0){
//            return null;
//        }

        HashMap<Character, Integer> hash = new HashMap<>();
        HashSet<Character> minStringCharSet = new HashSet<>();

        int startIndex=0;
        int minLength=Integer.MAX_VALUE;
        String minString = "";
        for(int i=0; i<input.length(); i++){
            System.out.println(minString);
            char ch = input.charAt(i);
            if(hash.containsKey(ch)){
              hash.put(ch, hash.get(ch)+1);
            }
            else{
                hash.put(ch, 1);
            }
            if(minStringCharSet.size() < hash.size()){
                System.out.println("new Char added:"+ch);
                minString = input.substring(startIndex, i+1);
                minStringCharSet.add(ch);
            } else {
                System.out.println("Char skipped:"+ch);
            }
            while(hash.get(input.charAt(startIndex))>1){
                char temp = input.charAt(startIndex);
                hash.put(temp, hash.get(temp)-1);
                startIndex++;
                minString = input.substring(startIndex, i+1);
            }
        }
        return minString;
    }
}
