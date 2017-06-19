/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 * Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 *
 * @author vasher
 */
public class SearchForRange {

    public int binarySearch(int[] nums, int start, int end, int n) {
        if(start == end && nums[start] != n){
            return -1;
        }
        if(end < start || start < 0 || end >=nums.length){
            return -1;
        }
        if (nums[start] == n) {
            return start;
        }
        if (nums[end] == n) {
            return end;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == n) {
            return mid;
        } else if (nums[mid] < n && nums[end] > n) {
            return binarySearch(nums, mid+1, end, n);
        } else if(nums[mid] > n && nums[start] < n){
            return binarySearch(nums, start, mid-1, n);
        } else {
            return -1;
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if(nums == null || nums.length == 0){
            return result;
        }
        int position = binarySearch(nums, 0, nums.length - 1, target);
        if (position == -1) {
            return result;
        }
        result[1] = position;
        while (position > 0 && nums[position - 1] == target) {
            position = position - 1;
            position = binarySearch(nums, 0, position, target);
        }
        result[0] = position;
        while (position < nums.length - 1 && nums[position + 1] == target) {
            position = position + 1;
            position = binarySearch(nums, position, nums.length - 1, target);
        }
        result[1] = position;
        return result;
    }

    public static void main(String[] args) {
        SearchForRange sfr = new SearchForRange();
        int[] input = {5, 7, 7, 8, 8, 8, 10};
        System.out.println(sfr.searchRange(input, 8)[0]);
        System.out.println(sfr.searchRange(input, 8)[1]);
    }
}
