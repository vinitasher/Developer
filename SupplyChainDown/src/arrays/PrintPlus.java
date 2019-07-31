package arrays;

public class PrintPlus {

    public char[][] print(int[] nums){
        int max = findMax(nums);
        char[][] result = new char[max + 1][nums.length];
        int currMax = max;
        for(int j = 0; j <= max; j++){
            for(int i=0; i<nums.length; i++){
                if(nums[i] < currMax) {
                    result[j][i] = ' ';
                }
                else {
                    result[j][i] = '+';
                }
            }
            currMax--;
        }
        return result;
    }

    public int findMax(int[] nums){
        int max = Integer.MIN_VALUE;

        for(int num: nums){
            if(max < num){
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args){
        PrintPlus instance = new PrintPlus();
        int[] nums = {4,2,1,0,2,5};
        char[][] result = instance.print(nums);
        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
