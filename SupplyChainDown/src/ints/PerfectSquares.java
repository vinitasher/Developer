package ints;

import arrays.utils.ArrayIO;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 */
public class PerfectSquares {
    int count, intCount;
    public int numSquares(int n) {
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1,1);
        result = numSquaresRecursive(n, 0, result, memo);
        return result;
    }

    public int numSquaresRecursive(int n, int currentResult, int result, Map<Integer, Integer> memo) {
        count++;
        if(n == 0) {
            return 0;
        }
        if(memo.containsKey(n)) return memo.get(n);
        intCount++;
        if(currentResult < result) {
            int current = (int) Math.floor(Math.sqrt(n));
            for(int i = current; i > 0; i--) {
                memo.put(i*i, 1);
                result = Math.min(result, numSquaresRecursive(n - i*i, currentResult + 1, result, memo) + 1);
                memo.put(n, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PerfectSquares instance = new PerfectSquares();
        int n = ArrayIO.generateInput(100);
        //int n = 4;
        System.out.println("Perfect Squares of " + n + " is " + instance.numSquares(n) + " " + instance.count + " " + instance.intCount);
    }
}
