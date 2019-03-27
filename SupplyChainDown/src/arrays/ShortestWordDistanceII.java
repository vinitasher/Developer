package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2
 * and return the shortest distance between these two words in the list.
 *
 * Your method will be called repeatedly many times with different parameters.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 *
 * Output: 3
 *
 * Input: word1 = "makes", word2 = "coding"
 *
 * Output: 1
 *
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 */
public class ShortestWordDistanceII {

    public Map<String, List<Integer>> wordMap;
    public int[] wordIndex;
    public int arrLength;

    public ShortestWordDistanceII(String[] words) {
        arrLength = words.length;
        wordMap = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if (wordMap.containsKey(words[i])) {
                wordMap.get(words[i]).add(i);
            } else {
                wordMap.put(words[i], new ArrayList<>(i));
            }
        }
    }

    public int shortest(String word1, String word2) {
        int[] wordIndex = new int[arrLength];
        int pos1 = Integer.MIN_VALUE;
        int pos2 = Integer.MIN_VALUE;
        int minDistance = Integer.MAX_VALUE;
        for(Integer i: wordMap.get(word1)){
            wordIndex[i.intValue()] = 1;
        }
        for(Integer j: wordMap.get(word2)){
            wordIndex[j.intValue()] = -1;
        }
        //System.out.println(wordIndex);
        for(int i=0; i<wordIndex.length; i++){
            if(wordIndex[i] == 1) pos1 = i;
            if(wordIndex[i] == -1) pos2 = i;
            if(pos1 != Integer.MIN_VALUE && pos2 != Integer.MIN_VALUE){
                minDistance = Math.min(minDistance, Math.abs(pos1 - pos2));
            }
        }
        return minDistance;
    }

}
