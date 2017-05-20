/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversell;

/**
 *
 * @author vasher
 */
public class Node {

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }
    
    Node next;
    int data;
    
}
