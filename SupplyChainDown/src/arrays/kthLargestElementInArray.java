package arrays;

import arrays.utils.ArrayIO;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class kthLargestElementInArray {

    public int findKthLargest(int[] nums, int k, int start, int end) {
        if(end == start){
            return nums[start];
        }
        if(k == 0) k = 1;
        int median = start + ArrayIO.generateInput(end - start);
        swap(nums, start, median);
        for(int i = start, j = end; i < end && j >= i; i++) {
            while(nums[i] > nums[start] && i <= j) {
                swap(nums, i, j);
                j--;
            }
            median = j;
        }

        swap(nums, start, median);
        if(nums.length - median == k) {
            return nums[median];
        }
        if(nums.length - k > median) {
            return findKthLargest(nums, k, median + 1, end);
        } else {
            return findKthLargest(nums, k, start, median - 1);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        kthLargestElementInArray instance = new kthLargestElementInArray();
        //System.out.println(instance.findKthLargest(ArrayIO.generatePositiveInputArray(10), ArrayIO.generateInput(10)));
        System.out.println(instance.findKthLargest(nums, k));
    }
}
