/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author vasher
 * Lowest common ancestor of a binary tree not a BST
 */
public class LowestCommonAncestor {
    public static void main(String[] args){
        Node lca = containsNodes(TreeUtil.sampleInput(), 18, 20);
        System.out.println(lca.value);
    }
    
    public static Node containsNodes(Node root, int n1, int n2){
        if(root == null){
            return root;
        }
        if(root.value == n1 || root.value == n2){
            return root;
        }
        Node leftLCA = containsNodes(root.left, n1, n2);
        Node rightLCA = containsNodes(root.right, n1, n2);
        if(leftLCA != null && rightLCA != null){
            return root;
        }
        if(leftLCA != null){
            return leftLCA;
        }
        if(rightLCA != null){
            return rightLCA;
        }
        return null;
    }
}
