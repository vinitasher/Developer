package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Return first pair of mismatching nodes (first pair as in in-order) given two pre-order traversal arrays of BSTs.
 *
 * Example 1:
 *
 * Input: pre1 = [5, 4, 2, 4, 8, 6, 9], pre2 = [5, 3, 2, 4, 8, 7, 9]
 * Output: [4, 3]
 * Explanation:
 * Tree 1:
 * 	 5
 *   4     8
 * 2  4   6  9
 *
 * Tree 2:
 * 	 5
 *   3     8
 * 2  4   7  9
 *
 * inorder1 = [2, 4, 4, 5, 6, 8, 9]
 * inorder2 = [2, 3, 4, 5, 7, 8, 9]
 * Example 2:
 *
 * Input: pre1 = [2, 1, 3], pre2 = [1, 2]
 * Output: [3, null]
 * Explanation:
 * Tree 1:
 *   2
 * 1   3
 *
 * Tree 2:
 * 	1
 * 	   2
 *
 * inorder1 = [1, 2, 3]
 * inorder2 = [1, 2]
 * Example 3:
 *
 * Input: pre1 = [2, 1, 3], pre2 = [1, 2, 3]
 * Output: []
 * Explanation:
 * Tree 1:
 * 	2
 *   1   3
 *
 * Tree 2:
 * 	1
 * 	   2
 * 		  3
 *
 * inorder1 = [1, 2, 3]
 * inorder2 = [1, 2, 3]
 * There is no mismatch because the in-order sequence for both is exactly the SAME,
 * despite the trees are structurally different.
 */
public class MismatchingNodes {

    public Integer[] findPair(int[] preorder1, int[] preorder2){
        Queue<Integer> pre1 = new LinkedList<>();
        Queue<Integer> pre2 = new LinkedList<>();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(Integer i: preorder1) pre1.add(i);
        for(Integer i: preorder2) pre2.add(i);

        while(!pre1.isEmpty() && !pre2.isEmpty()){

            while(pre1.size() > 1 && pre1.peek() > ((LinkedList<Integer>) pre1).get(1)){
                stack1.push(pre1.poll());
            }

            while(pre2.size() > 1 && pre2.peek() > ((LinkedList<Integer>) pre2).get(1)){
                stack2.push(pre2.poll());
            }

            if(pre1.peek() == pre2.peek()){
                pre1.poll();
                pre2.poll();
            } else {
                return new Integer[]{pre1.poll(), pre2.poll()};
            }

            while(!stack1.isEmpty() && stack1.peek() <= pre1.peek()){
                ((LinkedList<Integer>) pre1).addFirst(stack1.pop());
            }

            while(!stack2.isEmpty() && stack2.peek() <= pre2.peek()){
                ((LinkedList<Integer>) pre2).addFirst(stack2.pop());
            }

        }
        if(!pre1.isEmpty() || !pre2.isEmpty()){
            return new Integer[]{pre1.isEmpty()?null:pre1.poll(), pre2.isEmpty()?null:pre2.poll()};
        }

        return new Integer[]{};
    }

    public static void main(String[] args) {
        int[] pre1 = {2,1,3};
        int[] pre2 = {1,2,3};
        MismatchingNodes instance = new MismatchingNodes();
        System.out.println(Arrays.toString(instance.findPair(pre1, pre2)));
    }
}
