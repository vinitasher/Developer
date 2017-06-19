/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class StringUtil {

    public static String readInputString() {
        System.out.println("\nEnter input string:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String sampleInput() {
        //char ch = Character.
        return "geekstoo";
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static boolean isPalindromeFaster(char[] arr, int start, int end) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
