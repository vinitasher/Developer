/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author vasher
 */
public class MedianFromDataStream {
    private static Queue<Long> small = new PriorityQueue<>();
    private static Queue<Long> large = new PriorityQueue<>();
    
    public void addNum(int num) {
        if(small.size() < large.size()){
            small.add(-large.poll());
        } 
        large.add(new Long(num));
        if(large.size() < small.size()){
            large.add(-small.poll());
        }
    }
    
    public double findMedian() {
        if(large.size() > small.size()){
            return large.peek();
        } else {
            return (large.peek()-small.peek())/2.0;
        }
    }
    
    public static void main(String[] args){
        MedianFromDataStream m = new MedianFromDataStream();
        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        m.addNum(4);
        m.addNum(5);
        m.addNum(6);
        System.out.print(m.findMedian());
    }
}
