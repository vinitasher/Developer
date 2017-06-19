/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

/**
 *
 * @author vasher
 */
public class AllDistinctCharactersInOrder {
    StringBuilder output;
    
    public String generateDistinctCharactersInOrder(String s){
        output = new StringBuilder();
        LinkedHashMap<Character, Integer> outputMap = new LinkedHashMap<>();
        if(s != null && s.length() > 0){
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == ' ' || c == '\n'){
                    continue;
                }
                if(outputMap.containsKey(Character.toLowerCase(c))){
                    int count = outputMap.get(Character.toLowerCase(c));
                    outputMap.put(Character.toLowerCase(c),count+1);
                } else if(outputMap.containsKey(Character.toUpperCase(c))){
                    int count = outputMap.get(Character.toUpperCase(c));
                    outputMap.put(Character.toUpperCase(c),count+1);
                } else {
                    outputMap.put(c, 1);
                }
            }
            Iterator<Entry<Character,Integer>> i = outputMap.entrySet().iterator();
            while(i.hasNext()){
                Entry<Character, Integer> entry = i.next();
                if(entry.getValue() == 1)
                    output.append(entry.getKey());
            }
        }
        return output.toString();
    }
    
    
    public static void main(String[] args){
        AllDistinctCharactersInOrder adcio = new AllDistinctCharactersInOrder();
        String s = StringUtil.sampleInput();
        System.out.println("Distinct Characters:"+adcio.generateDistinctCharactersInOrder(s));
    }
    
}
