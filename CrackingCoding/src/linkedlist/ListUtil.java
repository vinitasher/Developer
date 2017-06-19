/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class ListUtil {
    
    public static Node readInputList(){
        Scanner sc = new Scanner(System.in);       
        int size = sc.nextInt();
        Node head = null;
        Node current = head;
        while(size > 0 && sc.hasNext()){
            Node n = new Node();
            n.value = sc.nextInt();
            if(head == null){
                head = n;
                current = head;
            }else {
                current.next = n;
                current = current.next;
            }
            size--;
        }
        return head;
    }
    
    public static void displayNodeList(Node n){
        while(n != null){
            System.out.println(n.value);
            n = n.next;
        }
    }
    
    public static LinkedList readLinkedList(){
        Scanner sc = new Scanner(System.in);       
        int size = sc.nextInt();
        LinkedList list = new LinkedList();
        while(sc.hasNext() && size > 0){
            list.add(sc.nextInt());
            size--;
        }
        return list;
    }
    
    public static void displayList(List list){
        for(Object o: list){
            if(o instanceof List){
                displayList((List) o);
            }else {
                trees.Node n = (trees.Node)o;
                System.out.print(n.getValue()+" ");
            }
        }
        System.out.println("\n");
    }
    
    public static void displayIntegerList(List list){
        for(Object o: list){
            if(o instanceof List){
                displayIntegerList((List) o);
            } else {
                System.out.print(o);
            }
        }
        System.out.print("\n");
    }
    
}
