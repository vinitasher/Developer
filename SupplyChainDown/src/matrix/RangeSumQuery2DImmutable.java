package matrix;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 *
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 *
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 */
public class RangeSumQuery2DImmutable {
    public int[][] sumMatrix;
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sumMatrix[row2][col2];
        if(col1 > 0) {
            sum -= sumMatrix[row2][col1 - 1];
        }
        if( row1 > 0) {
            sum -= sumMatrix[row1 - 1][col2];
        }
        if(row1 > 0 && col1 > 0){
            sum += sumMatrix[row1 - 1][col1 - 1];
        }
        return sum;
    }


    public RangeSumQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows > 0){
            cols = matrix[0].length;
        }

        sumMatrix = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                sumMatrix[i][j] += matrix[i][j];
                if(i > 0 && j > 0){
                    sumMatrix[i][j] -=  sumMatrix[i-1][j-1];
                }
                if(i > 0){
                    sumMatrix[i][j] += sumMatrix[i-1][j];
                }
                if(j > 0){
                    sumMatrix[i][j] += sumMatrix[i][j-1];
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] input = MatrixIO.readMatrix();
        RangeSumQuery2DImmutable instance = new RangeSumQuery2DImmutable(input);
        //MatrixIO.printMatrix(input);
        //MatrixIO.printMatrix(instance.sumMatrix);
        System.out.println(instance.sumRegion(2, 1, 4, 3));
        System.out.println(instance.sumRegion(1, 1, 2, 2));
        System.out.println(instance.sumRegion(1, 2, 2, 4));

    }

}
