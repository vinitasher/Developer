package arrays;

import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments.
 * Solution's constructor has one argument, the array w. pickIndex has no arguments.
 * Arguments are always wrapped with a list, even if there aren't any.
 */
public class RandomPickWithWeight {
    int[] prefixArray;
    Random rand = new Random();
    public int pickIndex() {
        int target = rand.nextInt(prefixArray[prefixArray.length - 1]);

        //binary search
        int low = 0;
        int high = prefixArray.length - 1;

        while(low < high) {
            int mid = (high + low)/2;
            if(prefixArray[mid] == target){
                return mid;
            } else if(prefixArray[mid] < target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }



    RandomPickWithWeight(int[] w){
        prefixArray = new int[w.length];
        prefixArray[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + w[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 14, 1, 7};
        RandomPickWithWeight instance = new RandomPickWithWeight(nums);
        instance.pickIndex();

    }
}
