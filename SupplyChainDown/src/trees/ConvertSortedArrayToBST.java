package trees;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end){
        int mid = (end + start)/2;

        TreeNode root = new TreeNode(nums[mid]);

        if(start < mid) {
            root.left = sortedArrayToBST(nums, start, mid - 1);
        }

        if(mid < end) {
            root.right = sortedArrayToBST(nums, mid + 1, end);
        }
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST instance = new ConvertSortedArrayToBST();
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = instance.sortedArrayToBST(nums);
        System.out.println(root);
    }
}
