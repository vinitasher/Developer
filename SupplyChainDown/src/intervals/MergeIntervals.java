package intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for(Interval i: intervals){
            if(i.start < minValue){
                minValue = i.start;
            }
            if(i.end > maxValue){
                maxValue = i.end;
            }
        }
        //System.out.println(minValue+"\t"+maxValue+"\n");
        int[] tracker = new int[maxValue-minValue+1];
        int[] endTracker = new int[maxValue-minValue+1];
        for(Interval i: intervals){
            tracker[i.start-minValue]++;
            endTracker[i.end-minValue]++;
        }
        List<Interval> resultList = new ArrayList<>();
        int result = 0, start = -1;
        for(int i=0;i<tracker.length;i++){
            //System.out.print("\t"+tracker[i]);
            if(start == -1 && tracker[i]>0){
                start = i + minValue;
            }
            result += tracker[i];
            if(endTracker[i] > 0){
                result -= endTracker[i];
            }
            if(start > -1 && result == 0){
                resultList.add(new Interval(start, i+minValue));
                start = -1;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        MergeIntervals instance = new MergeIntervals();
        //ran directly on leetcode site since too cumbersome to write main for this
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "["+start+","+end+"]";
        }
    }

}
