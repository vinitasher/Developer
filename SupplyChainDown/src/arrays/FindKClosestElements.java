package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 *
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int xIndex = findElement(arr, x, 0, arr.length - 1);

        int startIndex  = Math.max(xIndex - (k-1)/2 - (k-1)%2, 0);
        int endIndex    = Math.min(startIndex + k - 1, arr.length - 1);
        startIndex = endIndex - k + 1;

        //move left
        while(startIndex > 0 && x - arr[startIndex - 1] <= arr[endIndex] - x){
            startIndex--;
            endIndex--;
        }

        //move right
        while(endIndex < arr.length - 1 && x - arr[startIndex] > arr[endIndex + 1] - x){
            startIndex++;
            endIndex++;
        }

        //int[] resultArr =  Arrays.copyOfRange(arr, startIndex, endIndex + 1);
        List<Integer> result = new ArrayList<>();
        for(int i = startIndex; i <= endIndex; i++) result.add(arr[i]);
        //return Arrays.stream(resultArr).boxed().collect(Collectors.toList());
        return result;
    }

    public int findElement(int[] arr, int x, int start, int end){
        int mid = (end + start)/2;
        if(start == mid) return mid;
        if(arr[mid] < x) {
            return findElement(arr, x, mid, end);
        } else if(arr[mid] > x) {
            return findElement(arr, x, start, mid);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        FindKClosestElements instance = new FindKClosestElements();
        int[] input = {1};
        int x = 1;
        int k = 1;
        instance.findClosestElements(input, k, x);
    }

}
