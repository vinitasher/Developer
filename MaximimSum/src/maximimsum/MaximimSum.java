/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximimsum;

import java.util.Scanner;

/**
 *
 * @author vasher
 */
public class MaximimSum {

    public static int maximumSum(int[] array, int T){
        int maxValue = 0;
        int sum = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        while(firstIndex < array.length){

            if(sum > maxValue && sum <= T){
                maxValue = sum;
            }
            if(sum <= T && lastIndex < array.length){
                sum += array[lastIndex];
                lastIndex += 1;
            }
            else{
                sum -= array[firstIndex];
                firstIndex+= 1;
            }
        }
        return maxValue;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int T = scanner.nextInt();
//        int[] array = new int[N];
//        int i=0;
//        while(scanner.hasNext()){
//            array[i] = scanner.nextInt();
//        }
        int N = 5, T = 10;
        int[] array = {3, 3, 14, 1, 7};
        System.out.println(maximumSum(array, T));
    }
    
}
