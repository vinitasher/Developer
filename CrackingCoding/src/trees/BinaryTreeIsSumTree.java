/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vasher
 */
public class BinaryTreeIsSumTree {

    public static int isBinarySumTree(TreeNode root) throws Exception {
        if (root == null) {
            return 0;
        }
        int left = isBinarySumTree(root.left);
        int right = isBinarySumTree(root.right);
        if (left == 0 && right == 0) {
            return root.value;
        }
        if (root.value != left + right) {
            throw new Exception("Not a binary sum tree");
//            return;
        }
        return root.value + left + right;
    }
    
    public static boolean isBinarySumTreeBoolean(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        boolean left = isBinarySumTreeBoolean(root.left);
        boolean right = isBinarySumTreeBoolean(root.right);
        if (!left || !right) {
            return false;
        }
        if (root.value != root.left.value*2 + root.right.value*2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            int rootValue = isBinarySumTree(TreeUtil.sampleBinarySumTree());
            System.out.println("Is a binary tree");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(isBinarySumTreeBoolean(TreeUtil.sampleBinarySumTree())){
            System.out.println("Is a binary sum tree");
        } else {
            System.out.println("Not a binary sum tree");
        }

    }
}
