/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example: A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 *
 * @author vasher
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        int len = nums.length;
        int maxReach = 0;
        for(int i=0; i<len; i++){
            if(maxReach < i){
                return false;
            }
            maxReach = Math.max(maxReach, nums[i] + i);
            if(maxReach >= len-1){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        JumpGame jg = new JumpGame();
        int[] arr = ArrayUtil.sampleUnsortedArray();
        ArrayUtil.outputArray(arr);
        if(jg.canJump(null)){
            System.out.println("Can Jump!");
        } else {
            System.out.println("Cannot Jump!!!");
        }
    }
}
