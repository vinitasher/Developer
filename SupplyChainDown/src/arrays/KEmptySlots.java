package arrays;

import java.util.Arrays;

/**
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days.
 * In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.
 *
 * Given an array flowers consists of number from 1 to N.
 * Each number in the array represents the place where the flower will open in that day.
 *
 * For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x,
 * where i and x will be in the range from 1 to N.
 *
 * Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
 * and also the number of flowers between them is k and these flowers are not blooming.
 *
 * If there isn't such day, output -1.
 *
 * Example 1:
 *
 * Input:
 * flowers: [1,3,2]
 * k: 1
 * Output: 2
 * Explanation: In the second day, the first and the third flower have become blooming.
 *
 * Example 2:
 *
 * Input:
 * flowers: [1,2,3]
 * k: 1
 * Output: -1
 * Note:
 *
 * The given array will be in the range [1, 20000].
 */
public class KEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        int resultDay = Integer.MAX_VALUE;
        for(int i=0; i<flowers.length; i++){
            days[flowers[i]-1] = i+1;
        }
        //System.out.println(Arrays.toString(days));
        //sliding window start ---- k elements in between--- end
        int startPos = 0, endPos = startPos+k+1, currPos = startPos +1 ;
        search: while(endPos < flowers.length){
            currPos = startPos + 1;
            while (currPos < endPos){
                System.out.println("start: "+startPos+" endPos: "+endPos+" currPos: "+currPos);
                if(days[currPos] < days[startPos] || days[currPos] < days[endPos]){
                    startPos = currPos;
                    endPos = startPos + k + 1;
                    continue search;
                }
                currPos++;
            }
            resultDay = Math.min(resultDay, Math.max(days[startPos], days[endPos]));
            startPos = endPos;
            endPos = startPos + k + 1;
        }
        return resultDay == Integer.MAX_VALUE?-1:resultDay;
    }

    public static void main(String[] args) {
        KEmptySlots instance = new KEmptySlots();
        int[] nums = {1,3,2,4};
        int k = 1;
        System.out.println(instance.kEmptySlots(nums, k));
    }
}
