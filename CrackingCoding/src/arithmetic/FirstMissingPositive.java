/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import arrays.ArrayUtil;

/**
 *
 * @author vasher
 */
public class FirstMissingPositive {
    
    public int findMissingPositive(int[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i]<=0 || arr[i] > arr.length || arr[i]== i+1){
                i++;
            } else if(arr[arr[i]-1] != arr[i]){
                ArrayUtil.swap(arr, i, arr[i]-1);
            } else {
                //when does this else part execute???
                i++;
            }
        }
        i=0;
        while(i<arr.length && arr[i]==i+1){
            i++;
        }
        return i+1;
    }
    
    public static void main(String[] args){
        int[] arr = ArrayUtil.readArray();
        FirstMissingPositive fmp = new FirstMissingPositive();
        int missing = fmp.findMissingPositive(arr);
        System.out.println(missing);
    }
}
