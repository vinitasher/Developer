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
public class ReverseLL {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node n3 = new Node(null, 3);
        Node n2 = new Node(n3, 2);
        Node n1 = new Node(n2, 1);
        
        Node list = reverseLinkedList(n1);
        System.out.println(list.data);
        System.out.println(list.next.data);
        System.out.println(list.next.next.data);
        System.out.println(list.next.next.next);
    }
    
    public static Node reverseLinkedList(Node current){
        if(current.next == null){
            return current;
        } else {
            Node list = reverseLinkedList(current.next);
            current.next.next = current;
            current.next = null;
            return list;
        }
    }
    
}
