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
public class CheckBalancedTree {
    
    public static void main(String[] args){
//        Node root = TreeUtil.sampleNonBalancedTree();
        Node root = TreeUtil.sampleInput();
        
        System.out.println(isBinaryTree(root));
    }
    
    public static int depthOfSubTree(Node n){
        if(n == null){
            return 0;
        }
        return Math.max(depthOfSubTree(n.left), depthOfSubTree(n.right)) + 1;
    }
    
    public static boolean isBinaryTree(Node n){
        if(n == null){
            return true;
        }
        if(!isBinaryTree(n.left)||!isBinaryTree(n.right)){
            return false;
        }
        return Math.abs(depthOfSubTree(n.left)-depthOfSubTree(n.right))<=1;
    }
    
}
