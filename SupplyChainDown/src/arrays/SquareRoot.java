package arrays;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class SquareRoot {
    public int mySqrt(int x) {
        //System.out.println("x: " + x);
        //int j = 1;
        double i = 2;
        while(i * i < x) {
            //System.out.println("1st Loop: " + i);
            i = i * i;
            //j++;
            //if(j > 10)
            //    break;
        }
        //j = 0;
        while(i * i > x){
            //System.out.println("2nd Loop: " + i);
            i=i/2;
            //j++;
            //if(j > 10)
            //    break;
        }
        while(i*i<x) {
            i=i+1;
        }
        if(i*i != x) {
            i--;
        }
        return (int)i;
    }

    public static void main(String[] args) {
        SquareRoot instance = new SquareRoot();
        System.out.println(instance.mySqrt(4));
//        System.out.println(instance.mySqrt(2147395599));
    }
}
