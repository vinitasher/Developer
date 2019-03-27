package arrays;

import arrays.utils.ArrayIO;

public class FindFirstAndLastElementOfSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || (nums.length == 1 && nums[0] != target)){
            return new int[]{-1, -1};
        }
        if(nums.length == 1 && nums[0] == target){
            return new int[]{0, 0};
        }
        int startIndex = searchRangeStart(nums, target, 0, nums.length-1);
        int endIndex = searchRangeEnd(nums, target, 0, nums.length-1);
        return new int[]{startIndex, endIndex};
    }

    public int searchRangeStart(int[] nums, int target, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex)/2;
        if(nums[startIndex] == target && (startIndex == 0 || nums[startIndex-1] < target)){
            return startIndex;
        }
        if(nums[mid] == target && (mid == 0 || nums[mid-1] < target)){
            return mid;
        }
        if(nums[endIndex] == target && nums[endIndex-1] < target){
            return endIndex;
        }
        if(startIndex == mid || startIndex == endIndex){
            return -1;
        }
        if(nums[mid] < target) {
            return searchRangeStart(nums, target, mid, endIndex);
        } else if(nums[mid] > target) {
            return searchRangeStart(nums, target, startIndex, mid);
        } else if(nums[mid] == target && nums[mid-1] == target){
            return searchRangeStart(nums, target, startIndex, mid);
        }
        return -1;
    }

    public int searchRangeEnd(int[] nums, int target, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex)/2;
        if(nums[startIndex] == target && (startIndex == nums.length-1 || nums[startIndex+1] > target)){
            return startIndex;
        }
        if(nums[mid] == target && (mid == nums.length-1 ||nums[mid+1] > target)){
            return mid;
        }
        if(nums[endIndex] == target && (endIndex == nums.length -1 || nums[endIndex+1] > target)){
            return endIndex;
        }
        if(startIndex == mid || startIndex == endIndex){
            return -1;
        }
        if(nums[mid] < target) {
            return searchRangeEnd(nums, target, mid, endIndex);
        } else if(nums[mid] > target) {
            return searchRangeEnd(nums, target, startIndex, mid);
        } else if(nums[mid] == target && nums[mid+1] == target){
            return searchRangeEnd(nums, target, mid, endIndex);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastElementOfSortedArray instance = new FindFirstAndLastElementOfSortedArray();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = instance.searchRange(nums, target);
        ArrayIO.outputIntArray(result);
    }
}
