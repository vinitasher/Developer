package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1,
 * then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 *
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 *
 *
 * Note:
 *
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 */
public class FruitIntoBaskets {

    final int BASKET_COUNT = 2;

    public int totalFruit(int[] tree) {
        final int START = 0, END = 1;
        int maxFruits = 0;
        Map<Integer, List<Integer>> baskets = new HashMap<>(2);
        if(tree.length <= 2){
            return tree.length;
        }
        for(int i=0; i<tree.length; i++){
            if(baskets.containsKey(tree[i])){
                //basket contains number
                baskets.get(tree[i]).set(END, i);
            } else if(baskets.size() < 2){
                //basket does not contain number but is still empty
                baskets.put(tree[i], new ArrayList<>(Arrays.asList(i, i)));
            } else {
                int minEnd = Integer.MAX_VALUE, minEndType = Integer.MAX_VALUE;
                //basket does not contain number but is full
                for(Integer key: baskets.keySet()){
                    if(minEnd > baskets.get(key).get(END)){
                        minEnd = baskets.get(key).get(END);
                        minEndType = key;
                    }
                }
                baskets.remove(minEndType);
                baskets.entrySet().iterator().next().getValue().set(START, minEnd+1);
                baskets.put(tree[i], new ArrayList<>(Arrays.asList(i , i)));
            }
            int currentStart = Integer.MAX_VALUE, currentEnd = Integer.MIN_VALUE;
            for(Integer key: baskets.keySet()){
                currentStart = Math.min(currentStart, baskets.get(key).get(START));
                currentEnd = Math.max(currentEnd, baskets.get(key).get(END));
            }
            maxFruits = Math.max(maxFruits, currentEnd - currentStart + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        FruitIntoBaskets instance = new FruitIntoBaskets();
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(instance.totalFruit(fruits));
    }
}
