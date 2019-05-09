package trees;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumRecursive(root);
        return maxSum;
    }

    public int maxPathSumRecursive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSum = maxPathSumRecursive(root.left);
        int rightSum = maxPathSumRecursive(root.right);
        int rootSum = root.val + Math.max(Math.max(Math.max(leftSum + rightSum, leftSum), rightSum), 0);
        if(maxSum < rootSum) maxSum = rootSum;
        return root.val + Math.max(Math.max(leftSum, rightSum), 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.left = new TreeNode(-6);
        root.right.right.left.right = new TreeNode(-6);
        root.right.right.left.left.left = new TreeNode(-6);
        BinaryTreeMaximumPathSum instance = new BinaryTreeMaximumPathSum();
        int result = instance.maxPathSum(root);
        System.out.println(result);
    }
}
