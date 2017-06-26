/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author vasher
 * Serialization is the process of converting a data structure or object into a 
 * sequence of bits so that it can be stored in a file or memory buffer, or 
 * transmitted across a network connection link to be reconstructed later in the 
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no 
 * restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and 
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a 
 * binary tree. You do not necessarily need to follow this format, so please be 
 * creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. 
 * Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeDeseializeCodec {
    private static final String NULL_IDENTIFIER = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> serializedTree = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        serializedTree.add(root.value+"");
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            if(n.left != null){
                serializedTree.add(n.left.value+"");
                queue.add(n.left);
            } else {
                serializedTree.add(NULL_IDENTIFIER);
            }
            if(n.right != null){
                serializedTree.add(n.right.value+"");
                queue.add(n.right);
            } else {
                serializedTree.add(NULL_IDENTIFIER);
            }
        }
        return serializedTree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeStr = data.split(",");
        Deque<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(nodeStr));
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Deque<String> queue){
        String value = queue.poll();
        if(value.trim().equals(NULL_IDENTIFIER)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value.trim()));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
    
    public static void main(String[] args){
        SerializeDeseializeCodec sdc = new SerializeDeseializeCodec();
        String deserialize = "[1,2,3,null,null,4,5]";
        TreeNode root = TreeUtil.sampleNonBalancedTree();
        System.out.println(sdc.serialize(root));
        System.out.println(sdc.deserialize("1, 2, 3, 4, 5, 6, 7, null, null, null, null, null, null, null, 8, null, 9, null, null"));
    }
}
