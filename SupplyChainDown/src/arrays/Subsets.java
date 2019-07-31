package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void subsetsHelper(int[] nums, int index, List<List<Integer>> result, List<Integer> list){
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets instance = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(instance.subsets(nums));
    }
}
