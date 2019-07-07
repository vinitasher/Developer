package intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b} (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty,
 * or can be represented as a closed interval.  For example, the intersection of [1, 3} and [2, 4] is [2, 3].)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * NOTE: input types have been changed on April 15, 2019.
 * Please reset to default code definition to get new method signature.
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> result = new ArrayList<>();

        Queue<Integer> startQ   = new PriorityQueue<>();
        Queue<Integer> endQ     = new PriorityQueue<>();

        startQ.add(Integer.MAX_VALUE);
        endQ.add(Integer.MIN_VALUE);

        for(int[] interval: A){
            startQ.add(interval[0]);
            endQ.add(interval[1]);
        }

        for(int[] interval: B){
            startQ.add(interval[0]);
            endQ.add(interval[1]);
        }

        while(!startQ.isEmpty() && !endQ.isEmpty()) {
            int start = startQ.poll();
            int end = endQ.poll();

            if(start == Integer.MAX_VALUE || end == Integer.MIN_VALUE) continue;

            if(end >= start){
                int[] interval = new int[2];
                interval[0] = start;
                interval[1] = end;
                result.add(interval);
            }
        }

        int[][] main = new int[result.size()][2];
        int i = 0;
        for(int[] list: result){
            main[i++] = list;
        }
        return main;
    }

    public Interval[] intervalIntersectionBetter(Interval[] A, Interval[] B) {
        List<Interval> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i].start, B[j].start);
            int hi = Math.min(A[i].end, B[j].end);
            if (lo <= hi)
                ans.add(new Interval(lo, hi));

            // Remove the interval with the smallest endpoint
            if (A[i].end < B[j].end)
                i++;
            else
                j++;
        }

        return ans.toArray(new Interval[ans.size()]);
    }

    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};

        IntervalListIntersections instance = new IntervalListIntersections();
        int[][] result = instance.intervalIntersection(A, B);
    }
}
