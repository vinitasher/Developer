/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author vasher
 */
public class PeakAndValleys {
    public static int[] convertIntoPeakAndValley(int[] nums){
        for(int i=1; i<nums.length; i=i+2){
            if(i == nums.length-1){
                if(nums[i] < nums[i-1]){
                    ArrayUtil.swap(nums, i-1, i);
                }
            } else {
                if(nums[i] < nums[i-1] || nums[i] < nums[i+1]){
                    if(nums[i-1] > nums[i+1]){
                        ArrayUtil.swap(nums, i-1, i);
                    } else {
                        ArrayUtil.swap(nums, i+1, i);
                    }
                }
            }
        }
        return nums;
    }
    
    public static void main(String[] args){
        int[] arr = ArrayUtil.readArray();
        ArrayUtil.outputArray(convertIntoPeakAndValley(arr));
    }
    
}
