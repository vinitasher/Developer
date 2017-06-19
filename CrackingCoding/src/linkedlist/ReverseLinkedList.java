/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author vasher
 */
public class ReverseLinkedList {
    
    public Node reverse(Node head){
        Node current = head;
        Node prev = null, next = head.next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public Node reverseRecursive(Node node){
        if(node == null){
            return null;
        }
        if(node.next == null){
            return node;
        }
        Node next = node.next;
        node.next = null;
        Node reverse = reverseRecursive(next);
        next.next = node;
        return reverse;
    }
    
    public static void main(String[] args){
        ReverseLinkedList rll = new ReverseLinkedList();
        Node head = ListUtil.readInputList();
        ListUtil.displayNodeList(rll.reverseRecursive(head));
    }
}
