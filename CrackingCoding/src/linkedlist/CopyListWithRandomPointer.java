/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author vasher
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 *
 */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newHead = null;
        if (head != null) {
            if (!map.containsKey(head.label)) {
                newHead = new RandomListNode(head.label);
                map.put(newHead.label, newHead);
                if(head.next == null){
                    newHead.next = null;
                } else if(map.containsKey(head.next.label)){
                    newHead.next = map.get(head.next.label);
                } else {
                    newHead.next = copyRandomList(head.next);
                }
                if(head.random == null){
                    newHead.random = null;
                } else if(map.containsKey(head.random.label)){
                    newHead.random = map.get(head.random.label);
                } else {
                    newHead.random = copyRandomList(head.random);
                }
            } else {
                newHead = map.get(head.label);
            }
        }
        return newHead;
    }
    HashMap<Integer, RandomListNode> map = new HashMap<>();

    public static void main(String[] args) {
        CopyListWithRandomPointer instance = new CopyListWithRandomPointer();
    }

    class RandomListNode {

        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };

}
