/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.HashMap;

/**
 *
 * @author vasher
 */
public class LongestConsecutiveSequence {
    
    public int findConsecutiveSequence(int[] array){
        int result = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            if(!map.containsKey(array[i])){
                int left = map.containsKey(array[i]-1)?map.get(array[i]-1):0;
                int right = map.containsKey(array[i]+1)?map.get(array[i]+1):0;
                int count = left+right+1;
                result = Math.max(count, result);
                map.put(array[i]-left, count);
                map.put(array[i]+right, count);
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] input = ArrayUtil.sampleUnsortedArray();
        ArrayUtil.outputArray(input);
        int result = lcs.findConsecutiveSequence(input);
        System.out.println("\nResult:"+result);
    }
}
