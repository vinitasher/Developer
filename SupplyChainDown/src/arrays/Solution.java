package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public char[][] print(int[] nums){
        PriorityQueue<Position> queue = new PriorityQueue<>(new PositionComparator());
        for(int i=0; i<nums.length; i++){
            Position p = new Position(i, nums[i]);
            queue.add(p);
        }
        int maxHeight = queue.peek().value;
        char[][] result = new char[nums.length][maxHeight+1];
        while(!queue.isEmpty()){
            Position p = queue.poll();
            for(int j=maxHeight; j>=0; j--){
                if(j>p.value){
                    result[p.index][j]=' ';
                } else{
                    result[p.index][j]='+';
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution instance = new Solution();
        int[] nums = {4,2,1,0,2,5};
        char[][] result = instance.print(nums);
        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    public class PositionComparator implements Comparator<Position> {

        @Override
        public int compare(Position o1, Position o2) {
            return o2.value.compareTo(o1.value);
        }
    }

    public class Position{
        int index;
        Integer value;

        public Position(int index, Integer value){
            this.index = index;
            this.value = value;
        }
    }
}
