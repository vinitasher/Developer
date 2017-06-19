/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 *
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. For example,
 *
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"] As one shortest transformation is "hit"
 * -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 *
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters. You
 * may assume no duplicates in the word list. You may assume beginWord and
 * endWord are non-empty and are not the same. UPDATE (2017/1/20): The wordList
 * parameter had been changed to a list of strings (instead of a set of
 * strings). Please reload the code definition to get the latest changes.
 *
 * @author vasher
 */
public class WordLadder {
    
    public int shortestTransformationSequence(String beginWord, String endWord, HashSet<String> dict){
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(beginWord);
        queue.add(null);
        // level = 1represents starting from beginword
        int level = 1;
        while(!queue.isEmpty()){
            String word = queue.poll();
            if(word != null){
                char[] chArr = word.toCharArray();
                for(int i=0; i<word.length(); i++){
                   for(char c='a';c<='z'; c++){
                       char temp = chArr[i];
                       chArr[i] = c;
                       String tempWord = String.valueOf(chArr);
                       if(tempWord.equals(endWord)){
//                           System.out.println("End: "+tempWord+level);
                           return level+1;
                       } else if(dict.contains(tempWord) && !visited.contains(tempWord)){
//                           System.out.println("Found: "+tempWord+level);
                           queue.add(tempWord);
                           visited.add(tempWord);
                       }
                       chArr[i] = temp;
                    } 
                }
            } else {
                /**
                 * Fucking dope logic
                 * null represents completion of all possibilities for a particular node
                 * 
                 * hit -> null -> hot -> null ->dot  -> null -> dog -> null -> cog
                 *                            ->lot          -> log
                 */
                level++;
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }
        }
        return level;
    }

    public static void main(String[] args){
        WordLadder wl = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        String[] dict = {"hot","dot","dog","lot","log","cog"};
        System.out.println(wl.shortestTransformationSequence(beginWord, endWord, new HashSet<String>(Arrays.asList(dict))));
    }
}
