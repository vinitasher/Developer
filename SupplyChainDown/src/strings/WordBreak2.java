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
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class WordBreak2 {
    List<String> resultList = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {

        //brute force optimized with memoization O(n^2)
        Set<String> memo = new HashSet<>();
        wordBreakWithMemoization(s, 0, new HashSet(wordDict), memo, new StringBuffer());
        return resultList;
    }

    public void wordBreakWithMemoization(String s, int index, Set<String> wordDict, Set<String> memo, StringBuffer result) {
        if(index >= s.length()){
            resultList.add(result.toString());
            return;
        }
        //store failures in memo as to not recurse over them.
        if(memo.contains(s.substring(index))) return;
        for (int i = index + 1; i <= s.length(); i++){
            if (!wordDict.contains(s.substring(index, i))){
                continue;
            }
            if(result.length() > 0) {
                result.append(" ");
            }
            result.append(s.substring(index, i));
            wordBreakWithMemoization(s, i, wordDict, memo, result);
            result = new StringBuffer();
        }
        memo.add(s.substring(index));
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        String s = "leetcode";
        WordBreak2 instance = new WordBreak2();
        System.out.println(instance.wordBreak(s, wordDict));
    }
}
