package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

 */
public class TwoSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] arr = {2, 7, 11, 15};
        int[] result = calculateTwoSum(arr, target);
        System.out.println(result[0]+" "+ result[1]);
    }

    private static int[] calculateTwoSum(int[] arr, int target){
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] result = null;
        for(int i=0; i<arr.length; i++){
            if(!indexMap.containsKey(target - arr[i])){
                indexMap.put(arr[i], i);
            } else {
                result = new int[]{i, indexMap.get(target - arr[i])};
                break;
            }
        }
        return result;
    }
}
