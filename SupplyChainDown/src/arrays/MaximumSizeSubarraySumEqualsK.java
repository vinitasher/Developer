package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 *
 * Example 1:
 *
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 *
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 * Follow Up:
 * Can you do it in O(n) time?
 *
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] sumArr = new int[nums.length];
        int sum = 0;
        int maxLength = 0;
        int currLength = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();

        for(int i=0; i < nums.length; i++){
            sum += nums[i];
            sumArr[i] = sum;
            sumMap.put(sum, Math.min(i, sumMap.getOrDefault(sum, Integer.MAX_VALUE)));
            int left = sumArr[i] - k;
            if(sumMap.containsKey(left)){
                currLength = i - sumMap.get(left);
                maxLength = Math.max(maxLength, currLength);
            }
            if(sumArr[i] == k){
                currLength = i + 1;
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, -1};
        int k = 0;
        MaximumSizeSubarraySumEqualsK instance = new MaximumSizeSubarraySumEqualsK();
        System.out.println(instance.maxSubArrayLen(nums, 3));
    }
}
