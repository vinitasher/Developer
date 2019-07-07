package matrix;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall
 * since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 *
 * Example:
 *
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3
 * Explanation: For the given grid,
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 * Placing a bomb at (1,1) kills 3 enemies.
 */
public class BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0) return 0;

        int[][] count = new int[grid.length][grid[0].length];
        int result = 0;
        //iterate over each row front and back
        for (int i = 0; i < grid.length; i++) {
            int countSoFar = 0;
            for (int j=0; j < grid[0].length; j++) {
                switch (grid[i][j]){
                    case 'E':
                        countSoFar++;
                        break;
                    case 'W':
                        countSoFar = 0;
                        count[i][j] = 0;
                        break;
                    case '0':
                        count[i][j] += countSoFar;
                        result = Math.max(result, count[i][j]);
                        break;
                }
            }

            countSoFar = 0;
            for (int j=grid[0].length - 1; j >= 0; j--) {
                switch (grid[i][j]){
                    case 'E':
                        countSoFar++;
                        break;
                    case 'W':
                        countSoFar = 0;
                        count[i][j] = 0;
                        break;
                    case '0':
                        count[i][j] += countSoFar;
                        result = Math.max(result, count[i][j]);
                        break;
                }
            }
        }

        //iterate over each col up and down
        for (int j = 0; j < grid[0].length; j++) {
            int countSoFar = 0;
            for (int i=0; i < grid.length; i++) {
                switch (grid[i][j]){
                    case 'E':
                        countSoFar++;
                        break;
                    case 'W':
                        countSoFar = 0;
                        count[i][j] = 0;
                        break;
                    case '0':
                        count[i][j] += countSoFar;
                        result = Math.max(result, count[i][j]);
                        break;
                }
            }

            countSoFar = 0;
            for (int i=grid.length - 1; i >= 0; i--) {
                switch (grid[i][j]){
                    case 'E':
                        countSoFar++;
                        break;
                    case 'W':
                        countSoFar = 0;
                        count[i][j] = 0;
                        break;
                    case '0':
                        count[i][j] += countSoFar;
                        result = Math.max(result, count[i][j]);
                        break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
