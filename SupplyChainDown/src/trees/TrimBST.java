package trees;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L).
 * You might need to change the root of the tree,
 * so the result should return the new root of the trimmed binary search tree.
 *
 * Example 1:
 *
 * Input:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * Output:
 *     1
 *       \
 *        2
 * Example 2:
 *
 * Input:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * Output:
 *       3
 *      /
 *    2
 *   /
 *  1
 */

public class TrimBST {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        TreeNode newRoot;
        if(root.val >= L && root.val <= R) {
            newRoot = new TreeNode(root.val);
            newRoot.left = trimBST(root.left, L, R);
            newRoot.right = trimBST(root.right, L, R);
            return newRoot;
        }
        newRoot = trimBST(root.left, L, R);
        if(newRoot != null){
            return newRoot;
        }
        newRoot = trimBST(root.right, L, R);
        return newRoot;
    }

    public static void main(String[] args) {
        TrimBST instance = new TrimBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        TreeNode result = instance.trimBST(root, 1, 2);
    }
}
