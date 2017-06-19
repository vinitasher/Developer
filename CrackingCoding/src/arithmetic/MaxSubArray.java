/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 *
 * @author vasher
 */
public class MaxSubArray {

    public int getMaxSubArray(int[] nums) {
        int finalMax = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            int n = nums[i];
            max = Math.max(Math.max(max * n, min * n), n);
            min = Math.min(Math.min(temp * n, min * n), n);
            finalMax = Math.max(max, finalMax);
        }
        return finalMax;
    }

    public static void main(String[] args) {
        int[] input = {};
    }
}
