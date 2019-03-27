package intervals;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 */

public class MeetingRooms2 {
    public int minMeetingRooms(Interval[] intervals) {
        int minInterval = Integer.MAX_VALUE, maxInterval = Integer.MIN_VALUE;
        for(Interval i: intervals){
            if(i.start < minInterval)
                minInterval = i.start;
            if(i.end > maxInterval)
                maxInterval = i.end;
        }

        int[] rooms = new int[maxInterval-minInterval+1];
        for(Interval i: intervals){
            rooms[i.start-minInterval]+=1;
            rooms[i.end-minInterval]-=1;
        }

        int maxRooms = 0, currentRoomCount = 0;
        for(int i:rooms){
            currentRoomCount+=i;
            if(currentRoomCount > maxRooms){
                maxRooms = currentRoomCount;
            }
        }
        return maxRooms;
    }

    public static void main(String[] args) {

    }
}
