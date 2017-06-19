/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

/**
 * to be practiced online chaap.
 *
 * @author vasher
 */
public class LongestCommonSubStringDP {

    public int getLongestCommonSubstring(String a, String b) {

        int m = a.length();
        int n = b.length();
        int max = 0;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }

            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubStringDP instance = new LongestCommonSubStringDP();
        System.out.println(instance.getLongestCommonSubstring("geeksforgeeks", "quickgeeksquiz"));
    }
}
