package geometry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points,
 * with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 * Example 2:
 *
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 *
 *
 * Note:
 *
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        int minArea = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        for(int[] point: points) {
            if(!xMap.containsKey(point[0])) {
                xMap.put(point[0], new ArrayList<>());
            }
            xMap.get(point[0]).add(point[1]);
            if(!yMap.containsKey(point[1])) {
                yMap.put(point[1], new ArrayList<>());
            }
            yMap.get(point[1]).add(point[0]);
        }
        for(Integer i: xMap.keySet()) {
            if(xMap.get(i).size() < 2) {
                xMap.remove(i);
            }
        }
        for(Integer i: yMap.keySet()) {
            if(yMap.get(i).size() < 2) {
                yMap.remove(i);
            }
        }
        for(Integer i: xMap.keySet()) {
            for(Integer j: xMap.get(i)) {

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumAreaRectangle instance = new MinimumAreaRectangle();
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        instance.minAreaRect(points);
    }
}
