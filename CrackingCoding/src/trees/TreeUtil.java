/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author vasher
 */
public class TreeUtil {

    public static TreeNode sampleInput() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(10);

        root.left.left = new TreeNode(105);
        root.left.left.left = new TreeNode(106);
        root.left.left.right = new TreeNode(104);

        root.right = new TreeNode(1);

        root.right.left = new TreeNode(55);

        root.right.right = new TreeNode(77);
        return root;
    }

    public static TreeNode sampleBinarySearchTree() {
        TreeNode root = new TreeNode(50);

        root.left = new TreeNode(30);
        root.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(35);
        root.left.right.right = new TreeNode(60);

        root.left.left = new TreeNode(20);
//        root.left.left.right = new TreeNode(31);
        //root.left.right = new TreeNode(40);
        root.right = new TreeNode(70);

        root.right.right = new TreeNode(90);
        return root;
    }

    public static TreeNode sampleBinarySumTree() {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        return root;
    }

    public static TreeNode sampleNonBalancedTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);

        root.right.left = new TreeNode(6);

        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.right.right.right.right = new TreeNode(9);
        return root;
    }
}
