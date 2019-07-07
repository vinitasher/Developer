package lists;

import lists.utils.ListNode;

public class RemoveDuplicatesFromSortedLinkedList {

    public ListNode removeDuplicatesFromSortedLinkedList(ListNode head) {
        ListNode prev = head;
        while(prev != null){
            ListNode temp = prev.next;
            while(temp != null && temp.val == prev.val){
                temp = temp.next;
            }
            prev.next = temp;
            prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        RemoveDuplicatesFromSortedLinkedList instance = new RemoveDuplicatesFromSortedLinkedList();
        instance.removeDuplicatesFromSortedLinkedList(l1);
        while(l1!=null){
            System.out.println(l1.val);
            l1=l1.next;
        }

    }

}
