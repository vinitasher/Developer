/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 *
 * Example:
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer. Example:
 *
 * Input: "cbbd"
 *
 * Output: "bb"
 *
 * @author vasher
 */
public class LongestPalindromeSubString {

    int maxLength = 1;
    int startIndex = 0;

    public String longestPalindromeBruteForce(String s) {
        if (s == null) {
            return "";
        }
        char[] arr = s.toCharArray();
        int length = arr.length;
        int max = 0, start = 0;
        if (length < 2) {
            return s;
        }
        for (int i = 0; i < length; i++) {
            char c = arr[i];
            for (int j = i; j < length; j++) {
                if (arr[j] == c) {
                    if (StringUtil.isPalindromeFaster(arr, i, j)) {
                        if (max < j - i + 1) {
                            start = i;
                            max = j - i + 1;
                        }
                    }
                }

            }
        }
        return s.substring(start, max);
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        char[] arr = s.toCharArray();
        int length = arr.length;
        if (length < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 2; i++) {
            checkPalindrome(arr, i, i);
            checkPalindrome(arr, i, i + 1);
            System.out.print("\nstart:" + startIndex + " max:" + maxLength);
        }
        return s.substring(startIndex, maxLength);
    }

    public void checkPalindrome(char[] arr, int left, int right) {
        int length = arr.length;
        while (left > 0 && right < length) {
            if (arr[left] == arr[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        left++;
        right--;
        if (maxLength < right - left + 1) {
            maxLength = right - left + 1;
            startIndex = left;
        }
    }

    //public String extendPalindrome()
    public static void main(String[] args) {
        LongestPalindromeSubString lpss = new LongestPalindromeSubString();
        String input = StringUtil.readInputString();
        //System.out.println("\nBrute Force: " + lpss.longestPalindromeBruteForce(input));
        System.out.println("\nOptimized: " + lpss.longestPalindrome(input));
    }

}
