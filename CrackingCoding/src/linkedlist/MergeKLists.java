/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.PriorityQueue;

/**
 *
 * @author vasher
 */
public class MergeKLists {
    
    public Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(lists.length);
        for(Node n: lists){
            if(n != null){
                pq.add(n);
            }
        }
        Node output = new Node();
        Node current = null;
        current = output;
        while(!pq.isEmpty()){
            current.next = pq.poll();
            current = current.next;
            if(current.next != null){
                pq.add(current.next);
            }
        }
        return output.next;
    }
    
    public static void main(String[] args){
        MergeKLists mkl = new MergeKLists();
        Node[] input = new Node[2];
        input[0] = ListUtil.readInputList();
        input[1] = ListUtil.readInputList();
        ListUtil.displayNodeList(mkl.mergeKLists(input));
    }
    
}
