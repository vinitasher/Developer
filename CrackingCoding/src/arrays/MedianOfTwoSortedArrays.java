/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;

/**
 *
 * @author vasher
 */
public class MedianOfTwoSortedArrays {
    
    public float[] findMedian(int[] arr){
        int len = arr.length;
        float[] median = new float[2];
        if(len % 2 == 0){
            median[0] = (arr[len/2] + arr[len/2+1])/2f;
            median[1] = ((float)len)/2.0f;
        }
        return median;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        float[] median1 = findMedian(nums1);
        float[] median2 = findMedian(nums2);
        if(median1[0] > median2[0]){
            nums1 = Arrays.copyOfRange(nums1, (int)Math.ceil(median1[1]), m);
            nums2 = Arrays.copyOfRange(nums2, 0, (int)Math.ceil(median2[1]));
        } else {
            nums1 = Arrays.copyOfRange(nums1, 0, (int)Math.ceil(median1[1]));
            nums2 = Arrays.copyOfRange(nums2, (int)Math.ceil(median2[1]), n);
        }
        return findMedianSortedArrays(nums1, nums2);
    }
    public static void main(String[] args){
        
    }
}
