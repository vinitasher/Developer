package arrays;

import arrays.utils.ArrayIO;

import java.util.Arrays;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class RangeSumQueryMutable {
    int[] tree;
    public RangeSumQueryMutable(int[] nums) {
        tree = new int[nums.length * 2];
        for(int i = nums.length, j = 0; i < nums.length * 2 && j < nums.length; i++, j++){
            tree[i] = nums[j];
        }
        for(int i = nums.length - 1; i > 0; i--){
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int i, int val) {
        i += tree.length / 2;
        tree[i] = val;

        while(i > 1){
            int left = i, right = i;
            if(i % 2 == 0){
                right++;
            } else {
                left--;
            }
            i /= 2;
            tree[i] = tree[left] + tree[right];
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        left += tree.length / 2;
        right += tree.length / 2;
        while (left <= right){
            if(right % 2 == 0){
                sum += tree[right];
                right --;
            }
            if(left % 2 == 1){
                sum += tree[left];
                left++;
            }
            left /= 2;
            right /= 2;
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = ArrayIO.readInputArray();
        int[] nums = {2, 4, 5, 7, 8, 9};
        RangeSumQueryMutable instance = new RangeSumQueryMutable(nums);
        System.out.println(Arrays.toString(instance.tree));
        instance.update(2, 6);
        System.out.println(Arrays.toString(instance.tree));
        System.out.println(instance.sumRange(2,4));
    }

}
