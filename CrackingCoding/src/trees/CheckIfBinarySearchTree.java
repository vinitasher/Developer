/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author vasher
 * input is a binary tree output yes if BST
 */
public class CheckIfBinarySearchTree {
    
    public static void main(String[] args){
        System.out.println(isBinarySubTree(TreeUtil.sampleBinarySearchTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    
    public static boolean isBinarySubTree(TreeNode n, int min, int max){
        if(n == null){
            return true;
        }
        int left_max = Math.min(n.value, max);
        int right_min = Math.max(min, n.value);
        if(n.value < min || n.value > max){
            return false;
        }
        if(!isBinarySubTree(n.left, min, left_max)){
            return false;
        }
        if(!isBinarySubTree(n.right, right_min, max)){
            return false;
        }
        return true;
    }
    
}
