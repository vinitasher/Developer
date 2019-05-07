//package arrays;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
// *
// * Note:
// *
// * The solution set must not contain duplicate quadruplets.
// *
// * Example:
// *
// * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
// *
// * A solution set is:
// * [
// *   [-1,  0, 0, 1],
// *   [-2, -1, 1, 2],
// *   [-2,  0, 0, 2]
// * ]
// */
//
//public class FourSum {
//
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        int start = 0, end = nums.length - 1, sum = 0;
//        List<List<Integer>> result = new ArrayList<>();
//        while(start + 1 < end - 1) {
//            sum = fourSum(nums, target, result, start, end);
//            if(sum > target) {
//                end--;
//            } else if(sum < target) {
//                start++;
//            }
//        }
//        return result;
//    }
//
//    public int fourSum(int[] nums, int target, List<List<Integer>> result, int start, int end) {
//        int i = start + 1, j = end - 1;
//        while(i < j) {
//            int sum = nums[start] + nums[end] + nums[i] + nums[j];
//            if(sum > target) {
//                j--;
//            } else if(sum < target) {
//                i++;
//            } else {
//                List<Integer> quad = new ArrayList<>();
//                quad.add(start);
//                quad.add(i);
//                quad.add(j);
//                quad.add(end);
//                result.add(quad);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
