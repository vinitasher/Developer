package strings;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * 2 2 3 1 2 6 1 2
 * 1 2 3
 *
 */

public class DecodeWays {

    public int numDecodings(String s) {
        if(s.length() == 0 || s.equals("0")) return 0;
        int n = s.length();
        int[] memo = new int[n+1];
        memo[n] = 1;
        memo[n-1] = s.charAt(n-1) == '0'?0:1;
        for(int i = n-2; i>= 0; i--) {
            if(s.charAt(i) == '0') continue;
            if(Integer.parseInt(s.substring(i,i+2)) <= 26) {
                memo[i] = memo[i+1] + memo[i+2];
            } else {
                memo[i] = memo[i+1];
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        DecodeWays instance = new DecodeWays();
        System.out.println(instance.numDecodings("22312612"));
    }
}
