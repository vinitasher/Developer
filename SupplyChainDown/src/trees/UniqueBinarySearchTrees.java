package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

public class UniqueBinarySearchTrees {
    Map<Integer, Integer> map = new HashMap<>();
    //int sum;
    public int numTrees(int n) {
        int sum = 0;
        if( n == 0){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        for(int i = 0; i < n; i++){
            System.out.print(" "+ i);
            int x = numTrees(i);
            map.put(i, x);
            int y = numTrees(n - 1 - i);
            map.put(n - 1 - i, y);
            sum += x*y;
        }
        map.put(n, sum);
        return sum;
    }

    public int numTreesDP(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {

            for (int j = 1; j <= i; ++j) {
                System.out.print(" " + j);
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees instance = new UniqueBinarySearchTrees();
        System.out.println(" " + instance.numTrees(10));
        System.out.println(" "+instance.numTreesDP(10));
    }
}
