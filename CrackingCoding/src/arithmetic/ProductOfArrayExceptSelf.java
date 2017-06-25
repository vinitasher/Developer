/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import arrays.ArrayUtil;

/**
 *
 * @author vasher Given an array of n integers where n > 1, nums, return an
 * array output such that output[i] is equal to the product of all the elements
 * of nums except nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    private long product(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long product = 1;
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
        }
        return product;
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        int n = nums.length;
        if (n < 2) {
            return null;
        }
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf paes = new ProductOfArrayExceptSelf();
        int[] input = ArrayUtil.readArray();
        ArrayUtil.outputArray(paes.productExceptSelf(input));

    }
}
