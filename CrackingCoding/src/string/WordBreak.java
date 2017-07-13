/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author vasher Given a non-empty string s and a dictionary wordDict
 * containing a list of non-empty words, determine if s can be segmented into a
 * space-separated sequence of one or more dictionary words. You may assume the
 * dictionary does not contain duplicate words.
 *
 * For example, given s = "leetcode", dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * UPDATE (2017/1/4): The wordDict parameter had been changed to a list of
 * strings (instead of a set of strings). Please reload the code definition to
 * get the latest changes.
 * 
 */
public class WordBreak {
    HashSet<String> set = new HashSet<>();
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String dictWord: wordDict){
            set.add(dictWord);
        }
        if(set.isEmpty()){
            return false;
        }
        //this solution works but doesnt work well for really long inputs
        //return wordBreakRecursive(s);
        return workBreakDP(s);
    }
    
    public boolean wordBreakRecursive(String s){
        if(set.contains(s)){
            return true;
        }
        for(int i=1; i<s.length(); i++){
            String temp = s.substring(i, s.length());
            if(set.contains(temp)){
                if(wordBreakRecursive(s.substring(0, i))){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean workBreakDP(String s){
        boolean[] f = new boolean[s.length() + 1];
        for(int i=1; i<=s.length(); i++){
            for(int j=0;j<i;j++){
                if(f[j] && set.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
    
    public static void main(String[] args){
        WordBreak instance = new WordBreak();
        String[] arr = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        if(instance.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList(arr))){
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
        
    }
}
