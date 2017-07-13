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
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        return findMinRecursive(nums, 0, nums.length-1);
    }
    
    private int findMinRecursive(int[] nums, int start, int end){
        System.out.println(start+" "+end);
        if(start > end){
            return Integer.MAX_VALUE;
        }
        if(nums[start] < nums[end] || start == end){
            return nums[start];
        }
        if(nums[end] < nums[end-1]){
            return nums[end];
        }
        int mid = (start+end)/2;
        if(mid > 0 && nums[mid] < nums[mid-1]){
            return nums[mid];
        }
        if(mid != start && nums[mid] < nums[end]){
            return findMinRecursive(nums, start, mid-1);
        } else if(mid != end && nums[start] < nums[mid]){
            return findMinRecursive(nums, mid+1, end);
        } else {
            return Math.min(findMinRecursive(nums, start, mid-1), findMinRecursive(nums, mid+1, end));
        }
    }
    
    public static void main(String[] args){
        FindMinimumInRotatedSortedArray findMin = new FindMinimumInRotatedSortedArray();
        int[] nums = ArrayUtil.readArray();
        int min = findMin.findMin(nums);
        System.out.println("Minimum: "+min);
    }
}
