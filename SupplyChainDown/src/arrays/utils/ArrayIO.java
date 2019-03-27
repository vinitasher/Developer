package arrays.utils;

import java.util.Scanner;

public class ArrayIO {

    public static int[] readInputArray() {
        Scanner sc = new Scanner(System.in);
        //if(length == 0){
            System.out.println("Enter input array length: ");
            int length = sc.nextInt();
        //}
        int[] inputIntArr = new int[length];
        for (int i = 0; i < length; i++) {
            inputIntArr[i] = sc.nextInt();
        }
        return inputIntArr;
    }

    public static void outputIntArray(int[] nums){
        System.out.print("[");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
            if(i != nums.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
