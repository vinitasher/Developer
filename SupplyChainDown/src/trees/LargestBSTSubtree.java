package trees;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 *
 * Example:
 *
 * Input: [10,5,15,1,8,null,7]
 *
 *    10
 *    / \
 *   5  15
 *  / \   \
 * 1   8   7
 *
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the highlighted one.
 *              The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */

public class LargestBSTSubtree {
    int maxCount = Integer.MIN_VALUE;

    public int largestBSTSubtree(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int count = visitNode(root, min, max);
        return Math.max(count, maxCount);
    }

    public int visitNode(TreeNode root, int min, int max) {
        if(root == null) return 0;

        int leftCount = visitNode(root.left, Integer.MIN_VALUE, root.val);
        int rightCount = visitNode(root.right, root.val, Integer.MAX_VALUE);

        if(leftCount != -1 && rightCount != -1) {
            if(root.val > min && root.val < max) {
                return 1 + leftCount + rightCount;
            } else {
                maxCount = Math.max(1 + leftCount + rightCount, maxCount);
                return -1;
            }
        }

        maxCount = Math.max(maxCount, leftCount);
        maxCount = Math.max(maxCount, rightCount);
        return -1;
    }

    public static void main(String[] args) {
        LargestBSTSubtree instance = new LargestBSTSubtree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        System.out.println(instance.largestBSTSubtree(root));
    }
}
