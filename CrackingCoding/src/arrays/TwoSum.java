/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author vasher Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                int[] result = {map.get(target-nums[i]), i};
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }
    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        int[] input = ArrayUtil.readArray();
        int[] result = ts.twoSum(input, 9);
        if(result == null){
            System.out.println("Cannot find two sum integers");
        } else {
            ArrayUtil.outputArray(result);
        }
    }
}
