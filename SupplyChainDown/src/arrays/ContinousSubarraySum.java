package arrays;

import arrays.utils.ArrayIO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
 * that is, sums up to n*k where n is also an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 *
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 *
 * Note:
 *
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 *
 */
public class ContinousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        if(nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        k = Math.abs(k);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0) sum = sum % k;
            if(!remainderMap.containsKey(sum)) {
                remainderMap.put(sum, i);
            } else if(remainderMap.get(sum) < i - 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinousSubarraySum instance = new ContinousSubarraySum();
        int[] nums = {0,1,0};
//        int[] nums = {470,161,377,184,118,91,413,73,224,167,505,413,521,5,7,372,393,523,211,479,90,516,238,467,410,51,337,31,442,297,100,75,260,33,490,477,21,374,233,41,215,87,84,153,271,241,169,275,323,358,291,176,423,426,296,175,413,423,387,416,27,266,257,136,27,155,77,142,60,335,401,443,52,153,345,71,117,443,177,238,433,464,323,79,156,429,79,327,64,335,92,147,350,480,277,335,97,317,420,453};
        //int[] nums = ArrayIO.generateInputArray(0, 100, 10);
        System.out.println(Arrays.toString(nums));
//        int k = ArrayIO.generateInput(10);
        int k = 0;
        System.out.println(k);
        System.out.println(nums.length);
        System.out.println(instance.checkSubarraySum(nums, k));
    }
}
