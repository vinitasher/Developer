/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notadjacent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author vasher
 */
public class NotAdjacent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String input = s.next();
            StringBuffer output = new StringBuffer("");
            char[] charArr = input.toCharArray();
            PriorityQueue<CharacterWithCount> queue = new PriorityQueue<CharacterWithCount>(charArr.length, new CharacterWithCountComparator());
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i=0; i< charArr.length; i++){
                if(!map.containsKey(charArr[i])){
                    map.put(charArr[i], 1);
                } else {
                    int count = map.get(charArr[i]) + 1;
                    map.put(charArr[i], count);
                }
            }
            
            Set<Character> set = map.keySet();
            Iterator<Character> iter = set.iterator();
            while(iter.hasNext()){
                Character c = iter.next();
                CharacterWithCount cwc = new CharacterWithCount(c, map.get(c));
                queue.add(cwc);
            }
            
            CharacterWithCount prev = null;
            
            if(queue.peek().count > Math.ceil(charArr.length/2.0)){
                output.append("Not Possible");
            } else {
                while(queue.peek() != null){
                    CharacterWithCount current = queue.poll();
                    output.append(current.getName().charValue());
                    if(prev != null && prev.getCount() > 0){
                        prev.count--;
                        output.append(prev.name);
                    }
                    int count = current.getCount();
                    current.setCount(--count);
                    if(prev == null || prev.count == 0){
                        prev = current;
                    } else if(current.getCount() > 0){
                        queue.add(current);
                    }
                }
            }
            
            System.out.println(output.toString());
        }
            
    }
}
