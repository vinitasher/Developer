/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author vasher
 */
public class PuzzleSolver {

    public static String[] DICTIONARY = {"OX","CAT","TOY","AT","DOG","CATAPULT","T"};
    public static ArrayList<String> dictArray = new ArrayList<String>();
    public static char[][] puzzle = {
        "CAT".toCharArray(),
        "XZT".toCharArray(),
        "YOT".toCharArray()
        };
    public static char[][] puzzle1 = {
        "CATAPULT".toCharArray(),
        "XZTTOYOO".toCharArray(),
        "YOTOXTXX".toCharArray()
        };
    
    public static boolean isWord(String testWord){
//        System.out.println("isWord? "+testWord);
        if (dictArray.contains(testWord)){
            return true;
        }
        return false;

    }
    
    public static int findWords(){
        int count = 0;
        dictArray= new ArrayList<String>(Arrays.asList(DICTIONARY));
        int cols = puzzle1[0].length;
        int rows = puzzle1.length;
        System.out.println("Rows:"+rows);
        System.out.println("Cols:"+cols);
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                count += traverse(puzzle1, i, j, rows, cols);
            }
        }
        return count;
    }
    
    public static int traverse(char[][] array, int x, int y, int rows, int cols){
        int count = 0;
        count += traverseXPositive(array, x, y, rows, cols);
        count += traverseYNegative(array, x, y, rows, cols);
        count += traverseYPositive(array, x, y, rows, cols);
        count += traverseXNegative(array, x, y, rows, cols);
        count += traverseXPositiveYNegative(array, x, y, rows, cols);
        count += traverseXNegativeYPositive(array, x, y, rows, cols);
        count += traverseXNegativeYNegative(array, x, y, rows, cols);
        count += traverseXPositiveYPositive(array, x, y, rows, cols);
        return count;
    }
    
    public static int traverseXPositive(char[][] array, int x, int y,int rows,int cols){
        int count = 0;
        StringBuffer buff = new StringBuffer();
        for(int i=y; i<cols; i++){
            buff.append(array[x][i]);
            count = isWord(buff.toString())?++count:count;
        }
        return count;
    }
    
    public static int traverseXNegative(char[][] array, int x, int y,int rows,int cols){
        int count = 0;
        for(int i=y; i>= 0; i--){
            StringBuffer buff = new StringBuffer();
            for(int j=y; j>=i; j--){
                buff.append(array[x][j]);
            }
//            System.out.println(buff.toString());
            if(buff.toString().length() != 1){
                count = isWord(buff.toString())?++count:count;
            }
        }
        return count;
    }
    
    public static int traverseYNegative(char[][] array, int x, int y,int rows,int cols){
        int count = 0;
        for(int i=x; i<rows; i++){
            StringBuffer buff = new StringBuffer();
            for(int j=x; j<=i; j++){
                buff.append(array[j][y]);
            }
//            System.out.println(buff.toString());
            if(buff.toString().length() != 1){
                count = isWord(buff.toString())?++count:count;
            }
        }
        return count;
    }
    
    public static int traverseYPositive(char[][] array, int x, int y,int rows,int cols){
        int count = 0;
        for(int i=x; i>= 0; i--){
            StringBuffer buff = new StringBuffer();
            for(int j=x; j>=i; j--){
                buff.append(array[j][y]);
            }
//            System.out.println(buff.toString());
            if(buff.toString().length() != 1){
                count = isWord(buff.toString())?++count:count;
            }
        }
        return count;
    }
    
    public static int traverseXPositiveYNegative(char[][] array, int x, int y,int rows,int cols){
        int count = 0;
        for(int i=y, k=x; (i<cols && k<rows); i++, k++){
            StringBuffer buff = new StringBuffer();
            for(int j=y, l=x; j<=i && l<=k; j++, l++){
                buff.append(array[l][j]);
            }
//            System.out.println(buff.toString());
            if(buff.toString().length() != 1){
                count = isWord(buff.toString())?++count:count;
            }
        }
        return count;
    }
    
    public static int traverseXNegativeYPositive(char[][] array, int x, int y,int rows,int cols){
        int count = 0;
        for(int i=y, k=x; (i>=0 && k>=0); i--, k--){
            StringBuffer buff = new StringBuffer();
            for(int j=y, l=x; j>=i && l>=k; j--, l--){
                buff.append(array[l][j]);
            }
//            System.out.println(buff.toString());
            if(buff.toString().length() != 1){
                count = isWord(buff.toString())?++count:count;
            }
        }
        return count;
    }
    
    public static int traverseXNegativeYNegative(char[][] array, int x, int y,int rows,int cols){
        int count = 0;
        for(int i=y, k=x; (i>=0 && k<rows); i--, k++){
            StringBuffer buff = new StringBuffer();
            for(int j=y, l=x; j>=i && l<=k; j--, l++){
                buff.append(array[l][j]);
            }
//            System.out.println(buff.toString());
            if(buff.toString().length() != 1){
                count = isWord(buff.toString())?++count:count;
            }
        }
        return count;
    }
    
    public static int traverseXPositiveYPositive(char[][] array, int x, int y,int rows,int cols){
        int count = 0;
        for(int i=y, k=x; (i<cols && k>=0); i++, k--){
            StringBuffer buff = new StringBuffer();
            for(int j=y, l=x; j<=i && l>=k; j++, l--){
                buff.append(array[l][j]);
            }
//            System.out.println(buff.toString());
            if(buff.toString().length() != 1){
                count = isWord(buff.toString())?++count:count;
            }
        }
        return count;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(findWords());
    }
}
