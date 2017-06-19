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
public class BinaryTreeMaxPathSum {
    
    private int maxPathSum = Integer.MIN_VALUE;
    
    private int calculateCurrentSum(Node n){
        if(n == null){
            return 0;
        }
        int leftSum = calculateCurrentSum(n.left);
        int rightSum = calculateCurrentSum(n.right);
        int maxSum = leftSum + rightSum + n.value;
        maxPathSum = Math.max(maxSum, maxPathSum);
        int currentSum = n.value + Math.max(leftSum, rightSum);
        if(currentSum<0){
            return 0;
        }
        return currentSum;
    }
    
    public int calculateMaxPathSum(Node root){
        int leftSum = calculateCurrentSum(root.left);
        int rightSum = calculateCurrentSum(root.right);
        int rootSum = leftSum + rightSum + root.value;
        maxPathSum = Math.max(rootSum, maxPathSum);
        return maxPathSum;
    }
    
    public static void main(String[] args){
        Node root = TreeUtil.sampleInput();
        BinaryTreeMaxPathSum btmps = new BinaryTreeMaxPathSum();
        System.out.println(btmps.calculateMaxPathSum(root));
    }
    
}
