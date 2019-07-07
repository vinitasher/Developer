package lists;

import lists.utils.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 */

public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null, current = null, next = null;
        current = head;
        boolean repeat = false;
        while(current != null) {
            next = current.next;
            repeat = false;
            while(next != null && current != null && next.val == current.val) {
                repeat = true;
                current = current.next;
            }
            if(repeat) continue;
            if(prev != null){
                prev.next = current;
            } else {
                head = current;
            }
            prev = current;
            current = current.next;
        }
        if(prev == null) return prev;
        if(current == null) prev.next = current;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
    }

}
