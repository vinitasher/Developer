package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {
    int[][] neighbors = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
//                    System.out.println("Main " + i + " " + j);
                    count++;
                    grid[i][j] = '2';
                    numIslandsHelper(grid, i, j);
                }
            }
        }
        return count;
    }

    public void numIslandsHelper(char[][] grid, int x, int y){
//        System.out.println("Helper " + x + " " + y);
        for(int i=0; i<neighbors.length; i++){
            int newX = x + neighbors[i][0];
            int newY = y + neighbors[i][1];
            if(newX < 0 || newX >= grid.length) continue;
            if(newY < 0 || newY >= grid[0].length) continue;
            if(grid[newX][newY] == '1'){
                grid[newX][newY] = '3';
                numIslandsHelperBFS(grid, newX, newY);
            }
        }
    }

    public void numIslandsHelperBFS(char[][] grid, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            x = cell[0];
            y = cell[1];
            for(int i=0; i<neighbors.length; i++){
                int newX = x + neighbors[i][0];
                int newY = y + neighbors[i][1];
                if(newX < 0 || newX >= grid.length) continue;
                if(newY < 0 || newY >= grid[0].length) continue;
                if(grid[newX][newY] == '1'){
                    grid[newX][newY] = '3';
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

    }

    public static void main(String[] args) {
        //char[][] input = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] input = {{'1'},{'1'}};
        System.out.println(new NumberOfIslands().numIslands(input));
    }
}
