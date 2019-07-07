package arrays;

import arrays.utils.ArrayIO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an array nums of integers, you can perform operations on the array.
 *
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points.
 *  After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 *
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 *
 * Example 1:
 *
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation:
 * Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 *
 *
 * Example 2:
 *
 * Input: nums = [2, 2, 3, 3, 3, 4]
 * Output: 9
 * Explanation:
 * Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 *
 *
 * Note:
 *
 * The length of nums is at most 20000.
 * Each element nums[i] is an integer in the range [1, 10000].
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] sum  = new int[10001];
        int[] dp    = new int[10001];

        for (int i=0; i<nums.length; i++){
            sum[nums[i]] += nums[i];
        }
        dp[0] = sum[0];
        dp[1] = sum[1];
        for (int i=2; i<dp.length; i++){
            dp[i] = Math.max(sum[i] + dp[i-2], dp[i-1]);
        }
        return dp[dp.length - 1];
    }

    public int deleteAndEarn1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            if(num > max) max = num;
        }
        //instead of 10,000 array find largest number and use value of that.
        int[] sum  = new int[max + 1];
        //int[] dp    = new int[max + 1];

        for (int i=0; i<nums.length; i++){
            sum[nums[i]] += nums[i];
        }
        int oldSum  =  sum[0];
        int prev    =  sum[1];
        int result  = 0;
        for (int i=2; i<sum.length; i++){
            result = Math.max(sum[i] + oldSum, prev);
            oldSum = prev;
            prev = result;
        }
        return result;
    }

    public static void main(String[] args) {
        DeleteAndEarn instance = new DeleteAndEarn();
        //int[] nums = ArrayIO.generateInputArray(1, 10000, ArrayIO.generateInput(20000));
        int[] nums = {3,4,2};
        System.out.println(Arrays.toString(nums));
        int result = instance.deleteAndEarn1(nums);
        System.out.println(result);
    }
}
