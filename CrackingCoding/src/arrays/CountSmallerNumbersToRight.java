/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import trees.TreeNode;

/**
 *
 * @author vasher
 */
public class CountSmallerNumbersToRight {
    
    class CountNode extends TreeNode {
        int sum=0;
        int duplicate =1;
        
        public CountNode(int value) {
            super(value);
        }
        
        public int getSum(){
            return this.sum;
        }
        
        public void setSum(int sum){
            this.sum = sum;
        }
        
        public int getDuplicate(){
            return this.duplicate;
        }
        
        public void setDuplicate(int duplicate){
            this.duplicate = duplicate;
        }
        
    }
    
    private CountNode addToBST(CountNode root, int index, int[] input, int[] result, int preSum){
        if(root == null){
            root = new CountNode(input[index]);
            result[index]= preSum;
            return root;
        }else if(root.getValue() == input[index]){
            root.setDuplicate(root.getDuplicate()+1);
            result[index] = preSum + root.getSum();
        }else if(root.getValue() > input[index]){
            root.setSum(root.getSum()+1);
            root.setLeft(addToBST((CountNode)root.getLeft(), index, input, result, preSum));
        }else if(root.getValue() < input[index]){
            root.setRight(addToBST((CountNode)root.getRight(), index, input, result, preSum+root.getDuplicate()+root.getSum()));
        }
        return root;
    }
    
    public int[] countSmallerNumbersToRight(int[] input){
        int[] result = new int[input.length];
        CountNode root = null;
        for(int i=input.length-1; i>=0; i--){
            root = addToBST(root, i, input, result, 0);
        }
        return result;
    }
    
    public static void main(String[] args){
        CountSmallerNumbersToRight csntr = new CountSmallerNumbersToRight();
        int[] input = ArrayUtil.sampleUnsortedArray();
        ArrayUtil.outputArray(input);
        int[] result = csntr.countSmallerNumbersToRight(input);
        ArrayUtil.outputArray(result);
    }
    
}
