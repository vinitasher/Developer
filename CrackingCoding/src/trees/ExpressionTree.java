/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vasher
 */
public class ExpressionTree {
    Map<Integer, String> pathMap;
    
    private void _buildPaths(Node root){
        if(root != null){
            if(!pathMap.containsKey(root.value)){
                pathMap.put(root.value, root.value+"");
            }
            if(root.left != null || root.right != null){
                String path = pathMap.remove(root.value);
                if(root.left != null){
                    pathMap.put(root.left.value, path+"-"+root.left.value);
                    _buildPaths(root.left);
                }
                if(root.right != null){
                    pathMap.put(root.right.value, path+"-"+root.right.value);
                    _buildPaths(root.right);
                }
            } 
        }
    }
    
    public void printPaths(Node root){
        _buildPaths(root);
        for(Map.Entry<Integer, String> entry : pathMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }
    public static void main(String[] args){
        ExpressionTree object = new ExpressionTree();
        object.pathMap = new HashMap<>();
        object.printPaths(TreeUtil.sampleInput());
    }
    
}
