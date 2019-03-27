package matrix;

import arrays.utils.ArrayIO;

import java.util.Scanner;

public class MatrixIO {
    public static int[][] readMatrix(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nRead matrix util");
        System.out.print("\nInput row count: ");
        int rows = sc.nextInt();
        System.out.print("\nInput col count: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            System.out.print("\nEnter values in row " + i + " separated by spaces: ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("[");
        for(int i = 0; i < matrix.length; i++){
            System.out.print("\t");
            ArrayIO.outputIntArray(matrix[i]);
            System.out.println(",");
        }
        System.out.println("]");
    }
}
