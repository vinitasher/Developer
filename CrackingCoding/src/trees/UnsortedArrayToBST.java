/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import arrays.ArrayUtil;

/**
 *
 * @author vasher
 */
public class UnsortedArrayToBST {
    
    public TreeNode insertValue(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(root.value > value){
            root.left = insertValue(root.left, value);
        } else {
            root.right = insertValue(root.right, value);
        }
        return root;
    }
    
    public TreeNode arrayToBST(int[] arr){
        TreeNode root = null;
        for(int i: arr){
            root = insertValue(root, i);
        }
        return root;
    }
    
    public static void main(String[] args){
        UnsortedArrayToBST instance = new UnsortedArrayToBST();
        int[] input = ArrayUtil.readArray();
        TreeNode root = instance.arrayToBST(input);
        TreeTraversalIterative.inOrder(root);
    }
    
}
