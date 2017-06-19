/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import arrays.*;

/**
 *
 * @author vasher
 */
public class WiggleSort {

    public int threeMax(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > c) {
            return b;
        } else {
            return c;
        }
    }

    public int[] wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length - 1; i = i + 2) {
            if (nums[i] <= nums[i - 1] || nums[i] <= nums[i + 1]) {
                int j = i+1;
                while (nums[j] <= nums[i - 1] || nums[j] <= nums[i + 1]) {
                    j++;
                    ArrayUtil.swap(nums, i, j);
                    j += 1;
                    if (j >= nums.length) {
                        break;
                    }
                }
            }

        }
        if (nums[nums.length - 1] < nums[nums.length - 2]) {
            ArrayUtil.swap(nums, nums.length - 1, nums.length - 2);
        }
        return nums;
    }

    public static void main(String[] args) {
        WiggleSort ws = new WiggleSort();
        int[] arr = ArrayUtil.readArray();
        ArrayUtil.outputArray(ws.wiggleSort(arr));
    }

}
