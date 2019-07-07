package matrix;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 *
 */

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0) return matrix;

        int[][] output = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                output[i][j] = Integer.MAX_VALUE/2;
            }
        }


        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    output[i][j] = 0;
                } else if(j > 0){
                    output[i][j] = output[i][j-1] + 1;
                }
            }
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(j < matrix[0].length - 1) {
                    output[i][j] = Math.min(output[i][j], output[i][j+1] + 1);
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++){
            for(int i = 0; i < matrix.length; i++){
                if(i > 0){
                    output[i][j] = Math.min(output[i][j], output[i-1][j] + 1);
                }
            }
            for(int i = matrix.length - 1; i >= 0; i--){
                if(i < matrix.length - 1){
                    output[i][j] = Math.min(output[i][j], output[i+1][j] + 1);
                }
            }
        }

        return output;
    }
}
