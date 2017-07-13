/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vasher
 */
public class InsertInterval {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
      
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
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int flag = 0;
        if(intervals == null || intervals.isEmpty()){
            result.add(newInterval);
            flag = 2;
        }
        for(Interval i: intervals){
            if(i.start > newInterval.end && flag != 2){
                result.add(newInterval);
                flag = 2;
            }
            if(i.end < newInterval.start || i.start > newInterval.end){
                if(flag == 1){
                    result.add(newInterval);
                    flag = 2;
                }
                result.add(i);
            } else {
                flag = 1;
                newInterval.start = Math.min(i.start, newInterval.start);
                newInterval.end = Math.max(i.end, newInterval.end);
            }
        }
        if(flag != 2){
            result.add(newInterval);
        }
        return result;
    }
    
    public static void main(String[] args){
        InsertInterval ii = new InsertInterval();
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(ii.new Interval(1,2));
//        intervals.add(ii.new Interval(3,5));
//        intervals.add(ii.new Interval(6,7));
//        intervals.add(ii.new Interval(8,10));
//        intervals.add(ii.new Interval(12,16));
        List<Interval> result = ii.insert(intervals, ii.new Interval(4,9));
        System.out.println(result);
    }
    
    
}
