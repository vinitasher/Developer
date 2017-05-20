/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Comparator;

/**
 *
 * @author vasher
 * @param <T>
 */
public class Mergesort<T> {
    
    private static Object[] array;
    private static Object[] tempArray;
    private static int length;
    private static Comparator comparator;
    
    /**
     *
     * @param inputArr
     * @param c
     * @return
     */
    public static Object[] sort(Object[] inputArr, Comparator c) {
        Mergesort.array = inputArr;
        Mergesort.length = inputArr.length;
        Mergesort.comparator = c;
        Mergesort.tempArray = new Object[length];
        return doMergeSort(0, length - 1);
    }
 
    private static Object[] doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
        return array;
    }
 
    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempArray[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (Mergesort.comparator.compare(tempArray[i],tempArray[j]) < 0) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
 
    }
    
}
