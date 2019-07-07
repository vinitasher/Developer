package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
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
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        //brute force
        //return wordBreakBruteForce(s, 0, wordDict);

        //brute force optimized with memoization O(n^2)
        //Set<String> memo = new HashSet<>();
        //return wordBreakWithMemoization(s, 0, new HashSet(wordDict), memo);

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        return wordBreakBFS(s, new HashSet<>(wordDict), queue);
    }

    public boolean wordBreakBFS(String s, Set<String> wordDict, Queue<Integer> queue) {
        while (!queue.isEmpty()){
            int index = queue.poll();
            if(index == s.length()) return true;
            for (int i = index + 1; i <= s.length(); i++){
                if(wordDict.contains(s.substring(index, i))){
                    queue.add(i);
                }
            }
        }
        return false;
    }

    public boolean wordBreakWithMemoization(String s, int index, Set<String> wordDict, Set<String> memo) {
        if(index >= s.length()) return true;
        //store failures in memo as to not recurse over them.
        if(memo.contains(s.substring(index))) return false;
        for (int i = index + 1; i <= s.length(); i++){
            if (wordDict.contains(s.substring(index, i)) && wordBreakWithMemoization(s, i, wordDict, memo)){
                return true;
            }
        }
        memo.add(s.substring(index));
        return false;
    }

    public boolean wordBreakBruteForce(String s, int index, Set<String> wordDict) {
        System.out.println(s + " " + index);
        if(index >= s.length()) return true;
        for (int i = index + 1; i <= s.length(); i++){
            if (wordDict.contains(s.substring(index, i)) && wordBreakBruteForce(s, i, wordDict)){
               return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        String s = "leetcode";
        WordBreak instance = new WordBreak();
        System.out.println(instance.wordBreak(s, wordDict));
    }
}
