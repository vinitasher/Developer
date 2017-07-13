/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import io.IOUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 *
 * For example, Given n = 3, there are a total of 5 unique BST's.
 *
 * 1 3 3 2 1
 * \ / / /\ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * 
 * Part 2 
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 *
 * @author vasher
 */
public class NumberOfUniqueBST {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++){
                //System.out.println("dp ["+j+"]: "+dp[j]);
                int temp = i-1-j;
                //System.out.println("dp ["+temp+"]: "+dp[temp]);
                dp[i] += Math.max(dp[j], 1) * Math.max(dp[temp], 1);
            }
        }
        return dp[n];
    }
    
    public List<TreeNode> generateTrees(int n){
        HashMap<Integer,List<TreeNode>> dpMap = new HashMap<>();
        dpMap.put(0, null);
        for(int i = 1; i <= n; i++){
            List<TreeNode> result = new ArrayList<>();
            for( int j=0; j<i; j++){
                //j represents number of nodes in left subTree
                
                if(j != 0){
                    //left sub tree is not empty
                    for(TreeNode left: dpMap.get(j)){
                        if(dpMap.get(i-j-1) != null){
                            //right sub tree is not empty
                            for(TreeNode right: dpMap.get(i-j-1)){
                                TreeNode root = new TreeNode(j+1);
                                root.left = left;
                                root.right = offsetTree(right,j);
                                result.add(root);
                            }
                        } else {
                            //right sub tree is empty
                            TreeNode root = new TreeNode(j+1);
                            root.right = null;
                            root.left = left;
                            result.add(root);
                        }
                    }
                } else {
                    //left sub tree is empty
                    if(i-j-1 != 0){
                        for(TreeNode right: dpMap.get(i-j-1)){
                            TreeNode root = new TreeNode(j+1);
                            root.left = null;
                            root.right = offsetTree(right, j+1);
                            result.add(root);
                        }
                    } else {
                        TreeNode root = new TreeNode(j+1);
                        root.left = null;
                        root.right = null;
                        result.add(root);
                    }
                }
            }
            dpMap.put(i, result);
        }
        return dpMap.get(n);
    }
    
    public TreeNode offsetTree(TreeNode subTree, int offset){
        TreeNode copy = null;
        if(subTree != null){
            copy = new TreeNode(subTree.value + offset);
            copy.left = offsetTree(subTree.left, offset);
            copy.right = offsetTree(subTree.right, offset);
        }
        return copy;
    }
    
    
    
    
//    public List<TreeNode> generateTrees(int n) {
//        HashMap<Integer,List<TreeNode>> dpMap = new HashMap<>();
//        dpMap.put(0, new ArrayList<>());
//        TreeNode one = new TreeNode(1);
//        List<TreeNode> oneList = new ArrayList<>();
//        oneList.add(one);
//        dpMap.put(1, oneList);
//        List<TreeNode> result = new ArrayList<>();
//        for (int i = 2; i <= n; i++) {
//            List<TreeNode> tempList = new ArrayList<>();
//            for(int j = 1; j <= i; j++){
//                dpMap.get(j-1); // left subtree
//                dpMap.get(j+1); // right subtree
//                
//                int temp = i-1-j;
//                for(TreeNode leftTree : dpMap.get(j)){
//                    for(TreeNode rightTree: dpMap.get(temp)){
//                        TreeNode iNode = new TreeNode(j+1);//vertex
//                        iNode.left = leftTree;
//                        iNode.right = rightTree;
//                        tempList.add(iNode);
//                    }
//                }
//            }
//            dpMap.put(i, tempList);
//        }
//        return dpMap.get(n);
//    }

    public static void main(String[] args) {
        NumberOfUniqueBST instance = new NumberOfUniqueBST();
        while (true) {
            int input = IOUtil.readInteger("Enter value of n: ");
            //int output = instance.numTrees(input);
            List<TreeNode> resultNode = instance.generateTrees(input);
            System.out.println("Numer of unique BST possible: " + resultNode);
        }
    }
}
