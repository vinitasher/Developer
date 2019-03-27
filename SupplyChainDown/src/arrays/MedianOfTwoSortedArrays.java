package arrays;

import arrays.utils.ArrayIO;

/**
 *There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args){
        int[] nums1 = ArrayIO.readInputArray();
        int[] nums2 = ArrayIO.readInputArray();
        MedianOfTwoSortedArrays instance = new MedianOfTwoSortedArrays();
        if(nums1.length > nums2.length){
            System.out.println("Median of two sorted arrays: " +  instance.findMedianSortedArrays(nums2, nums1));
        } else {
            System.out.println("Median of two sorted arrays: " +  instance.findMedianSortedArrays(nums1, nums2));
        }
    }

    public double findMedianSortedArrays(int[] A, int[] B){
        int i = A.length/2;
        int j = (A.length + B.length + 1)/2 - i;
        return calculateMedianOfTwoSortedArrays(A, B, i, j);
    }

    public static double calculateMedianOfTwoSortedArrays(int[] A, int[] B, int i, int j){
        System.out.println("i: "+ i);
        System.out.println("j: "+ j);
        if((i == 0 || j == B.length || A[i-1] < B[j]) &&
                (j == 0 || i == A.length || B[j-1] < A[i])){
            int maxLeft, minRight;
            maxLeft = calculateMaxLeft(A, B, i, j);
            if( (A.length + B.length) % 2 == 0) {
                return maxLeft;
            }  else {
                minRight = calculateMinRight(A, B, i, j);
                return (maxLeft + minRight)/2.0;
            }
        }
        else if(j > 0 && B[j-1] > A[i] && i < A.length) {
            i++;
            j = (A.length + B.length + 1)/2 - i;
            return calculateMedianOfTwoSortedArrays(A, B, i, j);
        } else if(i > 0 && A[i-1] > B[j] && j < B.length) {
            i--;
            j = (A.length + B.length + 1)/2 - i;
            return calculateMedianOfTwoSortedArrays(A, B, i, j);
        }
        return 0.0;
    }

    public static int calculateMaxLeft(int[] A, int[] B, int i, int j){
        if(i == 0){
            return B[j-1];
        } else if(j == 0){
            return A[i-1];
        } else {
            return Math.max(A[i-1], B[j-1]);
        }
    }

    public static int calculateMinRight(int[] A, int[] B, int i, int j){
        if(i == A.length){
            return B[j];
        } else if(j == B.length){
            return A[i];
        } else {
            return Math.min(A[i], B[j]);
        }
    }



//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        return findMedianSortedArrays(nums1, nums2, 0, nums1.length, 0, nums2.length, isOdd(nums1.length+nums2.length));
//    }
//
//    public double findMedianSortedArrays(int[] nums1, int[] nums2, int num1Start, int num1End, int num2Start, int num2End, boolean isOdd) {
//        if(num1End - num1Start <= 2 && num2End - num2Start <= 2){
//            if(!isOdd){
//                return Math.max(nums1[num1Start],nums2[num2Start]) + Math.min(nums1[num1End-1], nums2[num2End-1])/2.0;
//            } else if(Math.max(nums1[num1Start],nums2[num2Start]) == Math.min(nums1[num1End-1], nums2[num2End-1])){
//                return nums1[num1Start];
//            } else {
//                return nums2[num2Start];
//            }
//        }
//        if(findMedian(nums1) > findMedian(nums2)){
//            return findMedianSortedArrays(nums1, nums2, nums1.length/2, nums1.length, 0, (int)Math.ceil(nums2.length/2), isOdd);
//        } else if(findMedian(nums1) < findMedian(nums2)){
//            return findMedianSortedArrays(nums1, nums2, 0, (int)Math.ceil(nums1.length/2), nums2.length/2, nums2.length, isOdd);
//        } else {
//            return findMedian(nums1);
//        }
//    }
//
//    public double findMedian(int[] nums) {
//        if(nums.length == 1){
//            return nums[0];
//        }
//
//        if(nums.length == 2){
//            return (nums[0]+nums[1])/2.0;
//        }
//        if(nums.length % 2 == 0){
//            return nums[nums.length/2-1] + nums[nums.length/2]/2.0;
//        }
//        return nums[nums.length/2];
//    }
//
//    public boolean isOdd(int num){
//        if(num % 2 == 0){
//            return true;
//        }
//        return false;
//    }

}
