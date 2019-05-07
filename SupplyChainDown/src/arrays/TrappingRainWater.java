package arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 *
 *  |
 *  |       |
 *  |   |XXX||X|
 *  | |X||X||||||
 *  ----------------------------------
 *
 *  X -> water
 * Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0 || n == 1) return 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int water = 0;
        for(int i = 0; i < n; i++){
            if(height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int leftMax = height[0];
        for(int i = 0; i < maxIndex; i++){
            if(height[i] > leftMax){
                leftMax = height[i];
            } else {
                water += height[i] - leftMax;
            }
        }

        int rightMax = height[n - 1];
        for(int i = n - 2; i > maxIndex; i--){
            if(height[i] > rightMax){
                rightMax = height[i];
            } else {
                water += height[i] - rightMax;
            }
        }
        return  water;
    }

    public static void main(String[] args) {
        TrappingRainWater instance = new TrappingRainWater();
    }

}
