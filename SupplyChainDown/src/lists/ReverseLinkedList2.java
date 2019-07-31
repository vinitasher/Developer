package lists;

import lists.utils.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ReverseLinkedList2 instance = new ReverseLinkedList2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = instance.reverseBetween(head, 2, 3);
        while (newHead != null) {
            System.out.println(newHead.val + "\t");
            newHead = newHead.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        int i = 0;
        ListNode temp = null, next, start = null;
        if (m > 1) {
            start = head;
        }
        while (head != null) {
            if (i < m || i > n) {
                temp = head;
                head = head.next;
            } else {
                next = head.next;
                head.next = temp;
                temp = head;
                head = next;
            }
            i++;
        }
        return start;
    }

    public ListNode reverseList(ListNode head, int m, int n, int i) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseList(head.next, m, n, i + 1);
        if (i >= m && i <= n) {
            head.next.next = head;
            head.next = null;
            return temp;
        } else {
            head.next = temp;
            return head;
        }
    }

    public ListNode reverseBetweenRecursive(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseList(head, m, n, 1);
    }
}
