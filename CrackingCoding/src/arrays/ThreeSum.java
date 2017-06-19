/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import linkedlist.ListUtil;

/**
 *
 * @author vasher
 */
public class ThreeSum {

    //
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> resultArr = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        if (!set.contains(result)) {
                            resultArr.add(result);
                            set.add(result);
                        }
                    }
                }
            }
        }
        return resultArr;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultArr = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int start = 0;
            int end = i - 1;
            //if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                while (start < end) {
                    if (nums[start] + nums[end] + num > 0) {
                        end--;
                    } else if (nums[start] + nums[end] + num < 0) {
                        start++;
                    } else {
                        resultArr.add(Arrays.asList(nums[start], nums[end], nums[i]));
                        while(start<end && nums[start] == nums[start+1])start++;
                        while(start<end && nums[end] == nums[end-1])end--;
                        start++;
                        end--;
                    }
                }
            //}
        }
        return resultArr;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        //int[] input = ArrayUtil.readArray();
        int[] input = {0,0,0, 0};
        //ListUtil.displayIntegerList(ts.threeSumBruteForce(input));
        System.out.println("\nBrute Force: " + ts.threeSumBruteForce(input));
        System.out.println("\nSort: " + ts.threeSum(input));
    }

}
