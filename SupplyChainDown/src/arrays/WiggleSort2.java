package arrays;

import arrays.utils.ArrayIO;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example 1:
 *
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 *
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSort2 {
    public void wiggleSort(int[] nums) {

        if(nums.length == 2){
            if(nums[0]>nums[1]){
                swap(nums, 0, 1);
            }
        }

        for(int i=0; i < nums.length-1; i++){
            int j = i + 1;
            while(j < nums.length - 1 && nums[j] == nums[i]) j++;
            wiggleCompare(nums, i, j);
        }

        System.out.println(Arrays.toString(nums));

        for(int i = nums.length - 1; i > 0 ; i--){
            int j = i - 1;
            while(j > 0 && nums[j] == nums[i]) j--;
            wiggleCompare(nums, i, j);
        }


    }

    public void wiggleCompare(int[] nums, int i, int j) {
        System.out.println(Arrays.toString(nums)+ " compare " + i + " " + j);
        //even indexes
        if(i%2 == 0){
            if(nums[i] > nums[j]){
                swap(nums, i, j);
            }
        } else {
            if(nums[i] < nums[j]){
                swap(nums, i, j);
            }
        }
    }

    public void swap(int[] nums, int x, int y){
        System.out.println(Arrays.toString(nums)+ " swap " + x + " " + y);
        if(nums == null || x < 0 || y < 0 || x > nums.length - 1 || y > nums.length - 1) return;
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        WiggleSort2 instance = new WiggleSort2();
        //int[] nums = ArrayIO.generatePositiveInputArray(10);
        //int[] nums = {1,2,2,1,2,1,1,1,1,2,2,2};
        int[] nums = {4,5,5,6};
        System.out.println(Arrays.toString(nums));
        instance.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
