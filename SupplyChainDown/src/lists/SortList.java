package lists;

import lists.utils.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode slow = head, fast = head;
        if(head == null) return head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return head;
    }

    public void swap(ListNode x, ListNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
