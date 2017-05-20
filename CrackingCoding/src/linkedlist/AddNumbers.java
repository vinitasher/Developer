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
public class AddNumbers {
    
    public static void main(String[] args){
        Node x = ListUtil.readInputList();
//        Node x = new Node();
//        x.value =7;x.next= new Node();
//        x.next.value =1;x.next.next= new Node();
//        x.next.next.value =6;x.next.next.next= new Node();
//        x.next.next.next.value =9;
//        head1.getNext().setNext(new Node(6));
        Node y = ListUtil.readInputList();
//        Node y = new Node();
//        y.value =5;y.next= new Node();
//        y.next.value =9;y.next.next= new Node();
//        y.next.next.value =5;
        Node resultHead = null;
        Node resultTail = null;
        int overflow = 0;
        while(x != null || y != null){
            int a=0;
            int b=0;
            if(x!=null){
                a = x.value;
            } 
            if(y!=null){
                b = y.value;
            } 
            int result = a + b + overflow;
                overflow = result/10;
            if(resultHead == null){
                Node n = new Node();
                n.value = result%10;
                n.next = null;
                resultHead = n;
                resultTail = resultHead;
            } else {
                Node n = new Node();
                n.value = result%10;
                n.next = null;
                resultTail.next = n;
                resultTail = resultTail.next;
            }
            x = x!=null?x.next:null;
            y = y!=null?y.next:null;
        }
        if(overflow>0){
            Node n = new Node();
            n.value = overflow;
            n.next = null;
            resultTail.next = n;
            resultTail = resultTail.next;
        }
        ListUtil.displayNodeList(resultHead);
    }
}
