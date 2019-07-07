package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 *
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees,
 * also in sorted order.
 *
 * Example 1:
 *
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation:
 * There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 *
 *
 * Example 2:
 *
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 *
 *
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays.
 * For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)
 *
 * Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 *
 * Note:
 *
 * schedule and schedule[i] are lists with lengths in range [1, 50].
 * 0 <= schedule[i].start < schedule[i].end <= 10^8.
 * NOTE: input types have been changed on April 15, 2019.
 * Please reset to default code definition to get new method signature.
 */
public class EmployeeFreeTime {
    public int[][] employeeFreeTime(int[][][] schedule) {
        PriorityQueue<Integer> startPQ = new PriorityQueue<>();
        PriorityQueue<Integer> endPQ = new PriorityQueue<>();

        startPQ.add(Integer.MAX_VALUE);
        endPQ.add(Integer.MIN_VALUE);

        List<List<Integer>> resultList = new ArrayList<>();

        for(int i=0; i<schedule.length; i++){
            for(int j=0;j<schedule[i].length; j++){
                int start = schedule[i][j][0];
                int end = schedule[i][j][1];
                startPQ.add(start);
                endPQ.add(end);
            }
        }

        while(!startPQ.isEmpty()) {
            int start = startPQ.poll();
            int end = endPQ.poll();

            // to ignore the first start value and last end value
            if(start == Integer.MAX_VALUE || end == Integer.MIN_VALUE) continue;

            if(end < start) {
                List<Integer> result = new ArrayList<>();
                result.add(end);
                result.add(start);
                resultList.add(result);
            }
        }

        return resultList.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
    }

    public static void main(String[] args) {

    }
}
