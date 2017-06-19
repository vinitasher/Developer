/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author vasher
 */
public class LongestSubStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] cCount = new int[256];
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] cArr = s.toCharArray();
        int start = 0;
        int max = 0;
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            cCount[c] += 1;
            if (cCount[c] == 1) {
                max = Math.max(max, i - start + 1);
            } else {
                while(cCount[c] == 2 && start <= i){
                    cCount[cArr[start]] -= 1;
                    start++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters lsswrc = new LongestSubStringWithoutRepeatingCharacters();
        String input = StringUtil.readInputString();
        int length = lsswrc.lengthOfLongestSubstring(input);
        //int length = lsswrc.lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }

}
