package ints;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        long[] memo = new long[amount+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for(int i = 1; i < memo.length; i++) {
            for(int j = coins.length - 1; j >= 0; j--) {
                if(i - coins[j] < 0) continue;
                if(memo[i - coins[j]] != -1) {
                    memo[i] = Math.min(memo[i - coins[j]] + 1, memo[i]);
                }
            }
        }
        if(memo[amount] == Integer.MAX_VALUE) return -1;
        return (int)memo[amount];
    }

    public static void main(String[] args) {
        CoinChange instance = new CoinChange();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        //int amount = 11;
        System.out.println(instance.coinChange(coins, amount));
    }
}
