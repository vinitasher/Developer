package ints;

import arrays.utils.ArrayIO;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 *
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long dividendL = Math.abs(new Long(dividend).longValue());
        long divisorL = Math.abs(new Long(divisor).longValue());
        int sign = 1;
        if(divisor < 0) sign = sign*-1;
        if(dividend < 0) sign = sign*-1;
        long result = divideRecursive(dividendL, divisorL);
        int resultInt = 0;
        if(result > Integer.MAX_VALUE) {
            resultInt = Integer.MAX_VALUE;
        } else {
            resultInt = (int)result;
        }
        return resultInt*sign;
    }

    public long divideRecursive(long dividend, long divisor) {
        if(divisor > dividend) return 0;
        if(dividend == 0) return 0;
        long sum = divisor;
        long multiple = 1;
        while(sum+sum < dividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + divideRecursive(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        DivideTwoIntegers instance = new DivideTwoIntegers();
//        int dividend = ArrayIO.generateInput(100);
        int dividend = -2147483648;
        int divisor =         -1;
//        int divisor = ArrayIO.generateInput(dividend);
        System.out.println(dividend + " / " + divisor + " = " + instance.divide(dividend, divisor));
    }
}
