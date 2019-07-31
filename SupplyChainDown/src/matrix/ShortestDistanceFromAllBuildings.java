package matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 *
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 *
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 *
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * Output: 7
 *
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 *              the point (1,2) is an ideal empty land to build a house, as the total
 *              travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class ShortestDistanceFromAllBuildings {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Set<Integer> obstacles = new HashSet<>();
    public int minTotalDistance(int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        if(grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    queue.add(new Point(i*n + j, i*n+j));
                    Set<Integer> set = new HashSet<>();
                    set.add(i*n+j);
                    map.put(i*n+j, set);
                } else if(grid[i][j] == 2){
                    obstacles.add(i*n+j);
                }
            }
        }

        int index = getIndex(queue, m, n);
        int minTotalDistance = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    minTotalDistance += getManhattanDistance(index, i * m + j, m, n);
                }
            }
        }
        return minTotalDistance;
    }

    //get manhattan distance only works for 7/50 test cases in leetcode
    public int getManhattanDistance(int index1, int index2, int m, int n){
        int x1 = index1 / n;
        int y1 = index1 % n;

        int x2 = index2 / n;
        int y2 = index2 % n;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int getIndex(Queue<Point> queue, int m, int n){
        int numberOfOnes = queue.size();

        while(!queue.isEmpty()){
            Point point = queue.poll();
            List<Integer> neighbors = getNeighbors(point.index, m, n);
            for(Integer neighbor: neighbors){
                Set<Integer> set = map.getOrDefault(neighbor, new HashSet<>());
                if(!set.contains(point.source) && !obstacles.contains(neighbor)) {
                    set.add(point.source);
                    queue.add(new Point(neighbor, point.source));
                }
                map.put(neighbor, set);
                if(set.size() == numberOfOnes){
                    return neighbor;
                }
            }
        }
        return -1;
    }

    public List<Integer> getNeighbors(int index, int m, int n){
        List<Integer> neighbors = new ArrayList<>();
        if(m == 0) return neighbors;
        if(index - n >= 0) neighbors.add(index - n);
        if(index + n < m * n) neighbors.add(index + n);
        if(index % n != 0) neighbors.add(index - 1);
        if(index % n != n - 1) neighbors.add(index + 1);
        return neighbors;
    }

    class Point {
        int index;
        int source;

        public Point(int index, int source){
            this.index = index;
            this.source = source;
        }
    }

    public static void main(String[] args) {
        ShortestDistanceFromAllBuildings instance = new ShortestDistanceFromAllBuildings();
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(instance.minTotalDistance(grid));
    }
}
