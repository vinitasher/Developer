/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import arrays.BinarySearch;

/**
 *
 * @author vasher
 */
public class MatrixBinarySearch {
    class MatrixCellPosition {
        int row;
        int column;
    }
    
    public static void search(int[][] matrix, int value){
        int columnValue = searchColumns(matrix, 0, matrix.length-1, value);
        BinarySearch bs = new BinarySearch();
        int[] row = matrix[columnValue];
        int rowValue = bs.search(row, 0, row.length-1, value);
        if(rowValue != -1)
            System.out.println("Row: "+columnValue+"\nColumn: "+rowValue);
        else 
            System.out.println("Cannot find value");
    }
    
    private static int searchColumns(int[][] matrix, int low, int high, int value){
        if(matrix[low][0] == value){
            return low;
        }
        if(matrix[high][0] == value){
            return high;
        }
        int mid = (high+low)/2;
//        System.out.println("low:"+low+"mid:"+mid+"high:"+high);
        if(matrix[mid][0] == value){
            return mid;
        }
        if(mid==high){
            return high;
        }
        if(matrix[mid][0]<value && matrix[mid+1][0]>value){
            return mid;
        }
        if(matrix[mid][0]>value && matrix[mid-1][0]<value){
            return mid-1;
        }
        if(matrix[mid][0]>value){
            return searchColumns(matrix, low, mid, value);
        } else {
            return searchColumns(matrix, mid, high, value);
        }
    }
    
    public static void main(String[] args){
        int[][] matrix = MatrixUtil.sampleNxNMatrix();
        MatrixUtil.printMatrix(matrix);
        search(matrix, 100);
    }
    
}
