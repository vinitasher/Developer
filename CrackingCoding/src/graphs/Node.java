/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author vasher
 */
public class Node {

    public Node(String value) {
        this.value = value;
    }
    
    String value;
    Node left;
    Node right;
    
}
