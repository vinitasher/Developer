package lists;

import lists.utils.ListNode;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList instance = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode newHead = instance.reverseListIterative(head);
        System.out.println(newHead.val + " " + newHead.next.val + " " + newHead.next.next.val);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = null, next = head;
        while (head != null) {
            next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}
