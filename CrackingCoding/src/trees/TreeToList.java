/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vasher
 * Convert tree of depth N into N linked list with nodes at each depth
 */
public class TreeToList {
    
    public static void main(String[] args){
        TreeNode root = TreeUtil.sampleInput();
        List<List<TreeNode>> output = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        boolean nextLevel = false;
        int depth = 0;
        if(root== null){
            output.add(list);
        } else {
            list.add(root);
            output.add(list);
            nextLevel = true;
        }
        while(nextLevel){
            nextLevel = false;
            List<TreeNode> currentList = output.get(depth);
            list = new LinkedList<>();
            for(TreeNode n: currentList){
                if(n.left != null){
                    list.add(n.left);
                    nextLevel = true;
                }
                if(n.right != null){
                    list.add(n.right);
                    nextLevel = true;
                }
            }
            if(nextLevel){
                output.add(list);
                depth++;
            }
        }
        linkedlist.ListUtil.displayList(output);
    }
}
