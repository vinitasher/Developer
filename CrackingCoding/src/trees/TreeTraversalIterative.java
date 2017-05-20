/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author vasher
 */
public class TreeTraversalIterative {
    
    public static void inOrderDestructive(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node n = stack.pop();
            Node left = n.getLeft();
            if(left != null){
                n.setLeft(null);
                stack.push(n);
                stack.push(left);
            } else {
                System.out.println(n.getValue());
                Node right = n.getRight();
                if(right != null){
                    stack.push(right);
                }
            }
        }
    }
    
    public static void inOrderNonDestructive(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        HashSet<Node> visited = new HashSet<>();
        while(!stack.empty()){
            Node n = stack.pop();
            Node left = n.getLeft();
            if(left != null && !visited.contains(left)){
                stack.push(n);
                stack.push(left);
            } else {
                System.out.println(n.getValue());
                visited.add(n);
                Node right = n.getRight();
                if(right != null){
                    stack.push(right);
                }
            }
        }
    }
    
    public static void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null){
            stack.push(current);
            current = current.left;
        }
        while(!stack.empty()){
            current = stack.pop();
            System.out.println(current.value);
            current = current.getRight();
            while(current != null){
                stack.push(current);
                current = current.getLeft();
            }
        }
    }
    
    public static void preOrderDestructive(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node n = stack.pop();
            if(n.getValue() != -1){
                System.out.println(n.getValue());
            }
            n.setValue(-1);
            Node left = n.getLeft();
            if(left != null){
                n.setLeft(null);
                stack.push(n);
                stack.push(left);
            } else {
                Node right = n.getRight();
                if(right != null){
                    stack.push(right);
                } 
            }
        }
    }
    
    public static void postOrderDestructive(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            Node n = stack.pop();
            Node left = n.getLeft();
            if(left != null){
                n.setLeft(null);
                stack.push(n);
                stack.push(left);
            } else {
                Node right = n.getRight();
                if(right != null){
                    n.setRight(null);
                    stack.push(n);
                    stack.push(right);
                } else {
                    System.out.println(n.getValue());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("In order traversal");
        inOrder(TreeUtil.sampleInput());
//        System.out.println("Pre order traversal");
//        preOrderDestructive(root);
//        System.out.println("Post order traversal");
//        postOrderDestructive(root);
        
    }
    
}
