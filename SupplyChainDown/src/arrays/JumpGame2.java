package arrays;

/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 */
public class JumpGame2 {
    public int canJump2(int[] nums) {
        int jumps = 0, currEnd = 0, currFar = 0;
        for(int i = 0; i < nums.length; i++){
            currFar = Math.max(currFar, i + nums[i]);
            if(i == currEnd){
                jumps++;
                currEnd = currFar;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGame2 jg = new JumpGame2();
        int[] nums = {1, 1, 1, 1};
        System.out.println(jg.canJump2(nums));
    }
}
