/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimummoves;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class Solution {

    static int minMoves(int[] avg) {
        boolean directionAscending = true;
        int midLength = avg.length/2;
        int leftSum = Arrays.stream(Arrays.copyOfRange(avg,0,midLength-1)).sum();
        int rightSum = Arrays.stream(Arrays.copyOfRange(avg,midLength, avg.length-1)).sum();
        if(leftSum <= rightSum){
            directionAscending = true;
        } else {
            directionAscending = false;
        }
        int startIndex = 0;
        int endIndex = avg.length-1;
        int count =0;
        
        return countMoves(avg, directionAscending, startIndex, endIndex, count);
        
    }
    
    static int countMoves(int[] avg, boolean directionAscending, int startIndex, int endIndex, int count){
        if(endIndex - startIndex <= 1){
            return count;
        }
        while(avg[startIndex] == (directionAscending?0:1) && startIndex < endIndex){
            startIndex++;
        }
        while(avg[endIndex] == (directionAscending?0:1) && endIndex > startIndex){
            endIndex--;
        }
        
        startIndex++;
        count = count + endIndex - startIndex;
        
        return countMoves(Arrays.copyOfRange(avg, startIndex, endIndex), directionAscending, startIndex, endIndex, count);
    }
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _avg_size = 0;
        _avg_size = Integer.parseInt(in.nextLine().trim());
        int[] _avg = new int[_avg_size];
        int _avg_item;
        for(int _avg_i = 0; _avg_i < _avg_size; _avg_i++) {
            _avg_item = Integer.parseInt(in.nextLine().trim());
            _avg[_avg_i] = _avg_item;
        }
        
        res = minMoves(_avg);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }

}
