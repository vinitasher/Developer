package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example:
 *
 * Input: [1,2,3,4,5]
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Output: [[4,5,3],[2],[1]]
 *
 * Explanation:
 *
 * 1. Removing the leaves [4,5,3] would map in this tree:
 *
 *           1
 *          /
 *         2
 *
 *
 * 2. Now removing the leaf [2] would map in this tree:
 *
 *           1
 *
 *
 * 3. Now removing the leaf [1] would map in the empty tree:
 *
 *           []
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLeavesRecursive(root, result);
        return result;
    }

    public int findLeavesRecursive(TreeNode root, List<List<Integer>> result) {
        if(root == null){
            return -1;
        }
        if(root.left == null && root.right == null){
            if(result.size() == 0){
                result.add(new ArrayList<Integer>());
            }
            result.get(0).add(root.val);
            return 1;
        } else {
            int leftIndex = findLeavesRecursive(root.left, result);
            int rightIndex = findLeavesRecursive(root.right, result);
            int rootIndex = Math.max(leftIndex, rightIndex);
            while(rootIndex >= result.size()){
                result.add(new ArrayList<Integer>());
            }
            result.get(rootIndex).add(root.val);
            return rootIndex + 1;
        }
    }

    public static void main(String[] args) {

    }
}
