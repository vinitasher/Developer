package arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * <p>
 * If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */
public class NextGreaterElementII {
    public static void main(String[] args) {
        NextGreaterElementII instance = new NextGreaterElementII();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(instance.nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        int start = 0, end = nums.length * 2 - 1;
        for (int i = end; i >= 0; i--) {
            while (!stack.empty()) {
                if (nums[i % nums.length] < nums[stack.peek()]) {
                    result[i % nums.length] = nums[stack.peek()];
                    stack.push(i % nums.length);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.empty()) {
                result[i % nums.length] = -1;
                stack.push(i % nums.length);
            }
        }
        return result;
    }
}
