package trees;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalancedCheckHeight(root) == -1 ? false : true;
    }

    public int isBalancedCheckHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = isBalancedCheckHeight(root.left);
        int right = isBalancedCheckHeight(root.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree instance = new BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
//        root.left.left = ne` = new TreeNode(4);
        System.out.println(instance.isBalanced(root));
    }
}
