/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import arrays.ArrayUtil;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 *
 * Example 1:
 *
 * 11110 
 * 11010 
 * 11000 
 * 00000
 * 
 * Answer: 1
 *
 * Example 2:
 *
 * 11000 
 * 11000 
 * 00100 
 * 00011
 *
 * Answer: 3
 *
 * @author vasher
 */
public class NumberOfIslands {
    int[][] visited;
    
    public int numIslands(char[][] grid) {
        int count =0;
        int m = grid.length;
        int n=0;
        if(m>0){
            n = grid[0].length;
        }
        visited = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int x, int y){
        if(grid[x][y] == '1' && visited[x][y] == 0){
            visited[x][y] = 1;
            int m = grid.length;
            int n = grid[0].length;
            if(x > 0){
                dfs(grid, x-1, y);
            }
            if(y > 0){
                dfs(grid, x, y-1);
            }
            if(x < m-1){
                dfs(grid, x+1, y);
            }
            if(y< n-1){
                dfs(grid, x, y+1);
            }
        }
    }
    
    public static void main(String[] args){
        NumberOfIslands noi = new NumberOfIslands();
        char[][] input = ArrayUtil.read2DCharArray();
        System.out.println("Number of Islands: "+noi.numIslands(input));
    }

}
