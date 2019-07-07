package matrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine,
 * 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent
 * (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8')
 * represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'),
 * return the board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its
 * adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
 * representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 *
 * Example 1:
 *
 * Input:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 * Example 2:
 *
 * Input:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 *
 *
 * Note:
 *
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'),
 * which also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem.
 * For example, you don't need to reveal all the unrevealed mines when the game is over,
 * consider any cases that you will win the game or flag any squares.
 */
public class Minesweeper {
    int[][] neighbors = {{0,1}, {0,-1}, {1,0}, {-1, 0}, {1,1}, {1, -1}, {-1,1}, {-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<>();
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        queue.add(click);

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int mineCount = 0;
            List<int[]> neighborsToBeQueued = new LinkedList<>();
            for(int[] neighbor: getNeighbors(current)){
                if(neighbor[0] < 0 || neighbor[0] >= board.length || neighbor[1] < 0 || neighbor[1] >= board[0].length) continue;
                //System.out.println(neighbor[0] + " " + neighbor[1]);
                if(board[neighbor[0]][neighbor[1]] == 'M') mineCount++;

                if(board[neighbor[0]][neighbor[1]] == 'E') {
                    neighborsToBeQueued.add(neighbor);
                }
            }
            if(mineCount == 0) {
                board[current[0]][current[1]] = 'B';
                ((LinkedList<int[]>) queue).addAll(neighborsToBeQueued);
            }
            else board[current[0]][current[1]] = (char)(mineCount+'0');
            //printBoard(board, current);
        }
        return board;
    }

    public int[][] getNeighbors(int[] current){
        int[][] neighborsForCurrent = new int[8][2];
        for(int i = 0; i < neighbors.length; i++){
            neighborsForCurrent[i][0] = current[0] + neighbors[i][0];
            neighborsForCurrent[i][1] = current[1] + neighbors[i][1];
        }
        return neighborsForCurrent;
    }

    public void printBoard(char[][] board, int[] current){
        System.out.println("\n############## BOARD ######### for index\t" + current[0] + "\t" + current[1]);
        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Minesweeper instance = new Minesweeper();
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = {3,0};
        instance.printBoard(instance.updateBoard(board, click), click);
    }
}
