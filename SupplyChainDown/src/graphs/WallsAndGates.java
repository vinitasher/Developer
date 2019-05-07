package graphs;

import graphs.util.MatrixNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.MAX_VALUE;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume
 * that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example:
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {

        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j]==0){
                    wallsAndGatesUtil(rooms, i, j, 0);
                }
            }
        }
    }

    public void wallsAndGatesUtil(int[][] rooms, int i, int j, int min){
        if(rooms[i][j]==-1){
            return ;
        }

        if(min<rooms[i][j]||min==0) {
            rooms[i][j] = min;
            Set<MatrixNode> neighbors = findNeighbors(rooms, i, j);
            for (MatrixNode neighbor : neighbors) {
                wallsAndGatesUtil(rooms, neighbor.x, neighbor.y, min + 1);
            }
        }
    }
    public Set<MatrixNode> findNeighbors(int[][] rooms, int i, int j){
        Set<MatrixNode> neighbors = new HashSet<>();
        int rows = rooms.length;
        int cols = rooms[0].length;
        if(i!=0){
            neighbors.add(new MatrixNode(i-1, j));
        }
        if(i!=rows-1){
            neighbors.add(new MatrixNode(i+1, j));
        }
        if(j!=0){
            neighbors.add(new MatrixNode(i, j-1));
        }
        if(j!=cols-1){
            neighbors.add(new MatrixNode(i, j+1));
        }
        return neighbors;
    }

    public static void main(String[] args) {
        //int[][] rooms = new int[4][4];
        int[][] rooms = {{MAX_VALUE,0,MAX_VALUE,MAX_VALUE,0,MAX_VALUE,-1,MAX_VALUE}};
        WallsAndGates instance = new WallsAndGates();
        instance.wallsAndGates(rooms);
        for(int[] room: rooms)
            System.out.println(Arrays.toString(room));
    }
}
