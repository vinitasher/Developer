package trees;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 *
 */
public class LargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        largestValuesRecursive(root, result, 0);
        return result;
    }

    public void largestValuesRecursive(TreeNode root, List<Integer> result, int currentLevel){
        if(root == null) {
            return;
        }
        if(currentLevel >= result.size()) {
            result.add(root.val);
        }
        if(result.get(currentLevel) < root.val) {
            result.set(currentLevel, root.val);
        }
        largestValuesRecursive(root.left,   result, currentLevel+1);
        largestValuesRecursive(root.right,  result, currentLevel+1);
    }

    public static void main(String[] args) {

    }
}
