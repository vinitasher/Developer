package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */
public class PalindromePairs2 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode2 root = new TrieNode2('$');

        for(int i=0; i<words.length; i++){
            char[] cArr = new StringBuffer(words[i]).reverse().toString().toCharArray();
            addWord(root, cArr, 0, i);
        }

        for(int i=0; i<words.length; i++){
            char[] cArr = words[i].toCharArray();
            Set<Integer> isPalindrome = traverseWord(root, cArr, 0);
            if(isPalindrome == null) continue;
            for(Integer pair: isPalindrome){
                if(pair.intValue() != i){
                    result.add(Arrays.asList(pair.intValue(), i));
                }
            }
        }
        return result;
    }

    public Set<Integer> traverseWord(TrieNode2 root, char[] cArr, int index){
        if(index >= cArr.length) {
            return root.isPalindrome;
        }
        if(!root.neighbors.containsKey(cArr[index])){
            return null;
        }
        return traverseWord(root.neighbors.get(cArr[index]), cArr, index + 1);
    }

    public void addWord(TrieNode2 root, char[] cArr, int index, int wordIndex){
        if(index >= cArr.length) return;
        if(!root.neighbors.containsKey(cArr[index])){
            TrieNode2 trieNode = new TrieNode2(cArr[index]);
            char[] subArr = Arrays.copyOfRange(cArr, index, cArr.length);
            if(palindromeCheck(subArr)) trieNode.isPalindrome.add(wordIndex);
            trieNode.isPalindrome.add(wordIndex);
            root.neighbors.put(cArr[index], trieNode);
        }
        addWord(root.neighbors.get(cArr[index]), cArr, index + 1, wordIndex);
    }

    public boolean palindromeCheck(char[] cArr){
        if(cArr == null) return false;
        if(cArr.length == 1) return true;
        for(int i=0,j=cArr.length-1; i<j; i++, j--){
            if(cArr[i] != cArr[j]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs2 palindromePairs = new PalindromePairs2();
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> result = palindromePairs.palindromePairs(words);
    }

}
