package arrays;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class AddTwoNumbers {

    public static void main(String[] args){

    }

    public static ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2) {
        int result = 0, forward = 0;
        ListNode resultNode = null;
        int l1val = l1 == null? 0:l1.val;
        int l2val = l2 == null? 0:l2.val;
        if(l1 != null || l2 != null) {
            result = l1val + l2val;
            forward = result / 10;
            result = result % 10;
            resultNode = new ListNode(result);
            if(forward > 0){
                if (l1 != null) {
                    if (l1.next != null) {
                        l1.next.val += forward;
                    } else {
                        l1.next = new ListNode(forward);
                    }
                } else if(l2 != null) {
                    if (l2.next != null) {
                        l2.next.val += forward;
                    } else {
                        l2.next = new ListNode(forward);
                    }
                }
            }
            ListNode l1next = l1 ==null?null:l1.next;
            ListNode l2next = l2 ==null?null:l2.next;
            resultNode.next = addTwoNumbersRecursive(l1next, l2next);
        }
        return resultNode;
    }


}
