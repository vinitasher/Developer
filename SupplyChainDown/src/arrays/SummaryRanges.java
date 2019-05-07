package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 *
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0) return result;
        if(nums.length == 1){
            result.add(range(nums[0], nums[0]));
            return result;
        }
        int rangeStart = nums[0];
        int rangeEnd = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - rangeEnd == 1) {
                rangeEnd = nums[i];
                continue;
            }
            result.add(range(rangeStart, rangeEnd));
            rangeStart = nums[i];
            rangeEnd = nums[i];
        }
        result.add(range(rangeStart, rangeEnd));
        return result;
    }

    public String range(int start, int end) {
        StringBuffer range = new StringBuffer();
        range.append(start);
        if(start != end) {
            range.append("->");
            range.append(end);
        }
        return range.toString();
    }

    public static void main(String[] args) {

    }
}
