package arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        return search(nums, target, 0, nums.length -1);
    }

    public int search(int[] nums, int target, int startIndex, int endIndex){
        //System.out.println("start: "+startIndex+"\tend: "+endIndex);
        int midIndex = (endIndex - startIndex)/2 + startIndex;
        if(target == nums[startIndex]){
            return startIndex;
        }
        if(target == nums[midIndex]){
            return midIndex;
        }
        if(target == nums[endIndex]){
            return endIndex;
        }
        if(startIndex == midIndex || startIndex == endIndex){
            return -1;
        }
        if (nums[startIndex] < nums[midIndex]){
            //first half is sorted
            if (target > nums[startIndex] && target < nums[midIndex]) {
                //check if target between sorted first half boundaries
                return search(nums, target, startIndex, midIndex);
            } else {
                //if target not in first half then it is for sure in second half
                return search(nums, target, midIndex, endIndex);
            }
        } else if(nums[midIndex] < nums[endIndex]){
            //second half is sorted
            if (target > nums[midIndex] && target < nums[endIndex]) {
                //check if target between sorted second half boundaries
                return search(nums, target, midIndex, endIndex);
            } else {
                //if target not in second half then check first half
                return search(nums, target, startIndex, midIndex);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray instance = new SearchRotatedSortedArray();
        int[] nums = {4,5,6,7,8,1,2, 3};
        System.out.println(instance.search(nums, 8));
    }
}
