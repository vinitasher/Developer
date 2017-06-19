/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import linkedlist.ListUtil;

/**
 *
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 *
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Solution:
 * We scan the array from 0 to n-1, keep "promising" elements in the deque. The
 * algorithm is amortized O(n) as each element is put and polled once.
 *
 * At each i, we keep "promising" elements, which are potentially max number in
 * window [i-(k-1),i] or any subsequent window. This means
 *
 * If an element in the deque and it is out of i-(k-1), we discard them. We just
 * need to poll from the head, as we are using a deque and elements are ordered
 * as the sequence in the array
 *
 * Now only those elements within [i-(k-1),i] are in the deque. We then discard
 * elements smaller than a[i] from the tail. This is because if a[x] <a[i] and
 * x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other
 * subsequent window: a[i] would always be a better candidate.
 *
 * As a result elements in the deque are ordered in both sequence in array and
 * their value. At each step the head of the deque is the max element in
 * [i-(k-1),i] @author vasher
 */
public class SlidingWindowMaximum {

    public List<Integer> generateSlidingWindowMaximum(int[] arr, int k) {
        List<Integer> result = new LinkedList<Integer>();
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            dq.offer(i);
            if (i >= k - 1) {
                result.add(arr[dq.peek()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] input = ArrayUtil.readArray();
        int k = 3;
        ListUtil.displayIntegerList(swm.generateSlidingWindowMaximum(input, k));
    }

}
