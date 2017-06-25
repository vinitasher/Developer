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
public class BstInsertionDeletion {
    
    public TreeNode insertNode(TreeNode root, int n){
        if(root == null){
            return new TreeNode(n);
        }
        if(root.value > n){
            root.left = insertNode(root.left, n);
        } else {
            root.right = insertNode(root.right, n);
        }
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int n){
        if(root == null ){
            System.out.println("Error: Could not find input value " + n + "in BST");
            return null;
        }
        if(root.value > n){
            root.right = deleteNode(root.left, n);
        } else if(root.value < n){
            root.left =  deleteNode(root.right, n);
        } else {
            //found the n node
            //if n node is leaf node then delete direclty
            if(root.left == null && root.right == null){
                return null;
            } else if(root.left == null){
            // if n node has only right child then move sub tree up
                return root.right;
            } else if(root.right == null){
            // if n node has only right child then move sub tree up
                return root.left;
            } else {
            //if n node has both left and right child then find in order successor
                
                while(root.right.left != null){
                    root.value = root.right.left.value;
                }
                return root;
            }
        }
        return root;
    }
    
    private int findInOrderSuccessorValue(TreeNode root){
        //do later
        
    }

    public static void main(String[] args){
        BstInsertionDeletion bid = new BstInsertionDeletion();
        TreeNode root = TreeUtil.sampleBinarySearchTree();
        TreeTraversalIterative.inOrder(root);
        System.out.println("\nOutput:");
        bid.insertNode(root, 100);
        //TreeTraversalIterative tti = new TreeTraversalIterative();
        TreeTraversalIterative.inOrder(root);
    }
    
}
