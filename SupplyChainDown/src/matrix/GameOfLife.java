package matrix;

import java.util.Map;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules
 * (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 *
 * How would you address these problems?
 */
public class GameOfLife {
    /**
     * Value representation
     *      0  -   Old Value 0 and New Value 0
     *      2  -   Old Value 0 and New Value 1
     *      3  -   Old Value 1 and New Value 0
     *      1  -   Old Value 1 and New Value 1
     *
     *      That way value % 2 always gives old value
     * @param board
     */
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board.length > 0) {
                for (int j = 0; j < board[0].length; j++) {
                    int sum = sumOfNeighbors(board, i, j);
                    if (isDead(board[i][j])) {
                        if (sum == 3) {
                            board[i][j] = 2;
                        }
                        continue;
                    } else if(sum < 2 || sum > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board.length > 0) {
                for (int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == 2) {
                        board[i][j] = 1;
                    }
                    if(board[i][j] == 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public int sumOfNeighbors(int[][] board, int i, int j) {
        int sum = 0;
        sum += getValue(board, i - 1,j - 1);
        sum += getValue(board, i,j - 1);
        sum += getValue(board, i + 1,j - 1);
        sum += getValue(board, i - 1, j);
        sum += getValue(board, i + 1, j);
        sum += getValue(board, i - 1, j + 1);
        sum += getValue(board, i, j + 1);
        sum += getValue(board, i + 1, j + 1);
        return sum;
    }

    public int getValue(int[][] board, int i, int j) {
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return 0;
        }
        return board[i][j]%2;
    }

    public boolean isDead(int value) {
        return value % 2 == 0;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife instance = new GameOfLife();
        instance.gameOfLife(board);
    }


}
