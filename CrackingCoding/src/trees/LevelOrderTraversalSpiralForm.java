/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author vasher
 */
public class LevelOrderTraversalSpiralForm {
    
    Stack<TreeNode> ltr, rtl;
    
    public void spiralTraverse(TreeNode root){
        if(root==null){
            return;
        }
        ltr.add(root);
        while(!ltr.isEmpty() || !rtl.isEmpty()){
            while(!ltr.isEmpty()){
                TreeNode n = ltr.pop();
                if(n == null){
                    continue;
                }
                System.out.print(n.value+" ");
                rtl.push(n.left);
                rtl.push(n.right);
            }
            
            while(!rtl.isEmpty()){
                TreeNode n = rtl.pop();
                if(n == null){
                    continue;
                }
                System.out.print(n.value+" ");
                ltr.push(n.right);
                ltr.push(n.left);
            }
        }
    }
    
    public static void main(String[] args){
        LevelOrderTraversalSpiralForm obj = new LevelOrderTraversalSpiralForm();
        obj.ltr = new Stack<>();
        obj.rtl = new Stack<>();
        TreeNode root = TreeUtil.sampleInput();
        obj.spiralTraverse(root);
    }
}
