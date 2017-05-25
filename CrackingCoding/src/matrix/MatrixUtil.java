/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class MatrixUtil {
    
    public static int[][] sampleNxNMatrix(){
        System.out.println("Enter matrix size n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                matrix[i][j]=i*n+j;
            }
        }
        return matrix;
    }
    
    public static void printMatrix(int[][] matrix){
        int length = matrix.length;
        for(int i=0;i<length;i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    
}
