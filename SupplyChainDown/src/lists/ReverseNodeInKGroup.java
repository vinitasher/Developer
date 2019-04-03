package lists;

import lists.utils.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        ReverseNodeInKGroup instance = new ReverseNodeInKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = instance.reverseKGroup(head, 2);
        while (newHead != null) {
            System.out.println(newHead.val + "\t");
            newHead = newHead.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null, next = null;
        if (head == null || head.next == null)
            next = head.next;
        return reverseKGroup(head, k, 0);
    }

    public ListNode reverseKGroup(ListNode head, int k, int i) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseKGroup(head.next, k, i + 1 == k ? 0 : i + 1);
        if (i < k) {
            head.next.next = head;
            head.next = null;
            return temp;
        } else {
            head.next = temp;
            return head;
        }
    }
}
