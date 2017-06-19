/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 *
 * @author vasher
 */
public class MergeIntervals {
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()){
            return intervals;
        }
        intervals.sort(new IntervalComparator());
        List<Interval> result = new ArrayList<>();
        Iterator<Interval> it = intervals.iterator();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        while(it.hasNext()){
            Interval i = it.next();
            if(i.start > end){
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            } else {
                end = Math.max(end, i.end);
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
    
    public static void main(String[] args){
        MergeIntervals mi = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(mi.new Interval(1,3));
        intervals.add(mi.new Interval(2,6));
        intervals.add(mi.new Interval(8,10));
        intervals.add(mi.new Interval(15,18));
        System.out.println(intervals);
        System.out.println(mi.merge(intervals));
    }

    public class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
        
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder("[");
            sb.append(start);
            sb.append(",");
            sb.append(end);
            sb.append("]");
            return sb.toString();
        }
    }

    private class IntervalComparator implements Comparator<Interval> {

        public IntervalComparator() {
        }

        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

}
