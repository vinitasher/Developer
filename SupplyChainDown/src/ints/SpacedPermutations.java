package ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer n, create an array such that each value is repeated twice.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: [1, 1, 2, 2, 3, 3]
 * Example 2:
 *
 * Input: n = 4
 * Output: [1, 1, 2, 2, 3, 3, 4, 4]
 *
 * Follow up 1: After creating it, find a permutation such that each number is spaced in such a way,
 * they are at a "their value" distance from the second occurrence of the same number.
 *
 * Return any 1 permutation if it exists. Empty array if no permutation exists.
 *
 * Example 1:
 *
 * Input: n = 3 --> This is the array - [1, 1, 2, 2, 3, 3]
 * Output: [3, 1, 2, 1, 3, 2]
 * Explanation:
 * The second 3 is 3 digits away from the first 3.
 * The second 2 is 2 digits away from the first 2.
 * The second 1 is 1 digit away from the first 1.
 *
 * Follow up 2: Return all possible permutations.
 *
 */
public class SpacedPermutations {

    public List<List<Integer>> spacedPermutations(int n){
        int[] output = new int[n*2];
        List<List<Integer>> result = new ArrayList<>();
        helper(output, n, result);
        return result;
    }

    public void helper(int[] output, int i, List<List<Integer>> result){
        if(i == 0){
            result.add(new ArrayList(Arrays.asList(Arrays.copyOf(output, output.length))));
            return;
        }
        for(int k=0; k+i+1 < output.length; k++){
            if(output[k] == 0 && output[k+i+1] == 0){
                output[k] = i;
                output[k + i + 1] = i;
                helper(output, i-1, result);
                output[k] = 0;
                output[k + i + 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SpacedPermutations().spacedPermutations(4));
    }
}
