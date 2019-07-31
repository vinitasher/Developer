package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array nums,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 *
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] output = new int[nums.length - k + 1];
        int maxIndex = 0;
        if(nums.length == 0 || k == 0) return null;
        for(int i=0; i<k; i++){
            dq.add(i);
            if(nums[i] > nums[maxIndex]) maxIndex = i;
        }
        output[0] = nums[maxIndex];

        for(int i = 1; i < output.length; i++){
            if(i - 1 == dq.peekFirst()) dq.removeFirst();
            while(!dq.isEmpty() && nums[i + k - 1] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.add(i + k - 1);
            output[i] = nums[dq.peekFirst()];
        }

        return output;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum instance = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(instance.maxSlidingWindow(nums, k)));
    }
}
