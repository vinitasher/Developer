package arrays;

import arrays.utils.StringIO;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 *
 *         p n
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        String input = StringIO.inputString();
        int output = longestSubstringWithoutRepeatingCharacters(input);
        System.out.println("Longest substring without repeating characters: "+output);
    }

    public static int longestSubstringWithoutRepeatingCharacters(String input){
        int start = 0, end = 0, resultLocation = 0;
        Set<Character> uniqueCharacters = new HashSet<>();
        int length =0, maxLength = 0;
        char[] inputArr = input.toCharArray();
        while(start <= end && end < inputArr.length){
            if(!uniqueCharacters.contains(inputArr[end])){
                uniqueCharacters.add(inputArr[end]);
                end++;
            } else {
                uniqueCharacters.remove(inputArr[start]);
                start++;
            }
            if(uniqueCharacters.size() > maxLength){
                maxLength = uniqueCharacters.size();
            }
        }
        return maxLength;
    }
}
