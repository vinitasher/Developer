package arrays;

import arrays.utils.ArrayIO;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * Example:
 *
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 *
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        if(nums.length == 2){
            if(nums[0]>nums[1]){
                swap(nums, 0, 1);
            }
        }
        for(int i=0; i<nums.length-1; i++){
            //even indexes
            if(i%2 == 0){
                if(nums[i] > nums[i+1]){
                    swap(nums, i, i+1);
                }
            } else {
                if(nums[i] < nums[i+1]){
                    swap(nums, i, i+1);
                }
            }
        }
    }

    public void swap(int[] nums, int x, int y){
        if(x>=0 && y>=0 && x<nums.length && y<nums.length){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = ArrayIO.readInputArray();

    }

}
