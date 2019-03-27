package arrays;

import arrays.utils.ArrayIO;

import java.util.Arrays;

/**
 * Count the number of possible triangles
 *
 * Given an unsorted array of positive integers. Find the number of triangles that can be formed with three different
 * array elements as three sides of triangles. For a triangle to be possible from 3 values, the sum of any two
 * values (or sides) must be greater than the third value (or third side).
 *
 * For example, if the input array is {4, 6, 3, 7}, the output should be 3.
 *
 * There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. Note that {3, 4, 7} is not a possible triangle.
 * As another example, consider the array {10, 21, 22, 100, 101, 200, 300}.
 *
 * There can be 6 possible triangles:
 * {10, 21, 22}, {21, 100, 101}, {22, 100, 101}, {10, 100, 101}, {100, 101, 200} and {101, 200, 300}
 */

public class CountTheNumberOfTriangles {

    public int countTriangles(int[] nums){
        int count = 0;
        if(nums == null || nums.length < 3){
            return count;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){

            int  k = i+2;
            for(int j=i+1; j<nums.length-1; j++){
                if(j == k){
                    k++;
                }
//                System.out.println(Arrays.toString(nums));
                while(k<nums.length && nums[i] + nums[j] > nums[k]){
                    count++;
                    k++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = ArrayIO.readInputArray();
        CountTheNumberOfTriangles instance = new CountTheNumberOfTriangles();
        System.out.println("Number of triangles = " + instance.countTriangles(nums));
    }
}
