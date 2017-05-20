/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import arrays.ArrayUtil;

/**
 *
 * @author vasher
 */
public class HeapSort {
    
    public static void sort(int[] arr){
        int N = arr.length;
        int lastParentInBinaryTree = N/2 - 1;
        for(int i=lastParentInBinaryTree; i>=0; i--){
            heapify(arr, N, i);
        }
        for(int i=N-1; i>=0; i--){
            ArrayUtil.swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int[] arr, int N, int i){
        int largestIndex = i;
        int leftIndex = 2*i + 1;
        int rightIndex = 2*i + 2;
        if(leftIndex < N && arr[leftIndex] > arr[largestIndex]){
            largestIndex = leftIndex;
        }
        if(rightIndex < N && arr[rightIndex] > arr[largestIndex]){
            largestIndex = rightIndex;
        }
        if(largestIndex != i){
            ArrayUtil.swap(arr, largestIndex, i);
            heapify(arr, N, largestIndex);
        }
    }
    
    public static void main(String[] args){
        int[] arr = ArrayUtil.readArray();
        if(arr != null){
            sort(arr);
        }
        ArrayUtil.outputArray(arr);
    }
    
}
