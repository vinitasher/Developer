/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

import io.IOUtil;
import java.util.HashMap;
import java.util.HashSet;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 *
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 *
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 *
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 *
 * The number of ways decoding "12" is 2.
 *
 * @author vasher
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            System.out.print("\nFirst: "+first+ " Second: "+second);
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        String input = StringUtil.readInputString();
        System.out.println("\nCount: "+dw.numDecodings(input));
    }

}
