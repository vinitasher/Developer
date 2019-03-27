package trees;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *
 *
 * Example:
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 *
 * Note:
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is,
 * there will be at least a next smallest number in the BST when next() is called.
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> cache = new Stack<>();
    TreeNode curretRoot;
    public BinarySearchTreeIterator(TreeNode root) {
        initialize(root);
    }

    public void initialize(TreeNode root){
        if(root == null){
            return;
        }
        initialize(root.right);
        cache.push(root);
        initialize(root.left);
    }

    /** @return the next smallest number */
    public int next() {
        int result = 0;
        if(!cache.empty()){
            TreeNode root = cache.pop();
            if(cache.empty() || root.val < cache.peek().val){
                return root.val;
            } else {
                TreeNode leftRoot = cache.pop();
                cache.push(root);
                return leftRoot.val;
            }
        }
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(cache.empty() && curretRoot == null){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        node7.right = new TreeNode(15);
        node7.right.left = new TreeNode(9);
        node7.left = new TreeNode(3);
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(node7);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

    }
}
