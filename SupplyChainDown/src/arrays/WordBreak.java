package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
 * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 *
 */

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        Set<String> failureSet = new HashSet<>();
        return wordBreak(s, dictSet, failureSet);
    }

    public boolean wordBreak(String s, Set<String> dictSet, Set<String> failureSet){
        if(dictSet.contains(s)){
            return true;
        }
        if(failureSet.contains(s)){
            return false;
        }
        for(int i=1; i<s.length(); i++){
            boolean preResult = wordBreak(s.substring(0, i), dictSet, failureSet);
            if(preResult == false){
                failureSet.add(s.substring(0, i));
                continue;
            }
            boolean postResult = wordBreak(s.substring(i, s.length()), dictSet, failureSet);
            if(postResult == false){
                failureSet.add(s.substring(i, s.length()));
                continue;
            }
            if(preResult && postResult){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak instance = new WordBreak();
        String input = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(instance.wordBreak(input, wordDict));
    }
}
