/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.Comparator;

/**
 *
 * @author vasher
 */
public class Node implements Comparable<Node> {
    Integer value;
    Node next;

    public int compareTo(Node o) {
        return value.compareTo(o.value);
    }
}
