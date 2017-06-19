/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import io.IOUtil;

/**
 *
 * @author vasher
 */
public class ClosestPair {
    
    public class Pair{
        int num1, num2;
        public String toString(){
            return "Numbers are:"+num1+" "+num2;
        }
    }
    
    public Pair searchClosestPair(int[] arr1, int[] arr2, int k){
        int left = 0, right = arr2.length-1;
        int minDifference = Integer.MAX_VALUE;
        Pair p = null;
        while(left < arr1.length && right >= 0){
            int currentDiff = arr1[left] + arr2[right] - k;
            if(Math.abs(currentDiff) < minDifference){
                p = new Pair();
                p.num1 = arr1[left];
                p.num2 = arr2[right];
                minDifference = Math.abs(currentDiff);
            }
            if(currentDiff == 0){
                return p;
            } else if(currentDiff > 0){
                right--;
            } else {
                left++;
            }
        }
        return p;
    }
    
    public static void main(String[] args){
        int[] arr1 = ArrayUtil.sampleSortedArray();
        int[] arr2 = ArrayUtil.sampleSortedArray();
        ArrayUtil.outputArray(arr1);
        ArrayUtil.outputArray(arr2);
        int k = IOUtil.readInteger("\nEnter number to search pair:");
        ClosestPair c = new ClosestPair();
        Pair p = c.searchClosestPair(arr1, arr2, k);
        System.out.println(p);
    }
    
}
