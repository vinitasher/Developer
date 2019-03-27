package arrays;

import arrays.utils.ArrayIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length-1, sum;
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<k; i++){
            k = nums.length -1;
            //duplicate check
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<k; j++){

                //duplicate check
                if(j > 0 && j-1 > i && nums[j] == nums[j-1]){
                    continue;
                }

                if(k < nums.length -1 && nums[k] == nums[k+1]){
                    k--;
                    j--;
                    continue;
                }

                //check for all positives
                if(nums[i] > 0 && nums[j] > 0 && nums[k] > 0){
                    return result;
                }

                //check for all negatives
                if(nums[i] < 0 && nums[j] < 0 && nums[k] < 0){
                    return result;
                }

                sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
//                    System.out.print("Sum zero\n");
                    List<Integer> resultEntry = new ArrayList<>();
                    resultEntry.add(nums[i]);
                    resultEntry.add(nums[j]);
                    resultEntry.add(nums[k]);
                    result.add(resultEntry);
                } else if(sum > 0){
                    k--;
                    j--;
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
//        int[] nums = ArrayIO.readInputArray();
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(instance.threeSum(nums));
    }
}
