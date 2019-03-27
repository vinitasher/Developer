package arrays;

import arrays.utils.ArrayIO;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
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
        MaximumProductSubarray instance = new MaximumProductSubarray();
        int[] nums = ArrayIO.readInputArray();
//        int[] nums = {2,-5,-2,-4,3};
//        int[] nums = {-1,-2,-9,-6};
        int result = instance.maxProduct(nums);
        System.out.println(result);
    }
}
