package permutation;

import arrays.utils.ArrayIO;

/**
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }

        int i = nums.length - 2;
        while(i >= 0){
            if(nums[i] < nums[i+1]){
                swap(nums, i, findMinFromIndex(nums, i+1, nums[i]));
                reverse(nums, i+1, nums.length -1);
                break;
            }
            i-=1;
        }
        if(i==-1){
            //reverse whole array
            reverse(nums, 0, nums.length -1);
        }
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start += 1;
            end -= 1;
        }
    }

    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public int findMinFromIndex(int[] nums, int startIndex, int minValue){
        int nextMin = Integer.MAX_VALUE, nextMinIndex = -1;
        for(int i=startIndex; i<nums.length; i++){
            if(nums[i] > minValue && nums[i] < nextMin){
                nextMinIndex = i;
            }
        }
        return nextMinIndex;
    }

    public static void main(String[] args) {
        int[] nums = ArrayIO.readInputArray();
    }
}
