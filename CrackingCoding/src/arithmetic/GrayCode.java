/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vasher The gray code is a binary numeral system where two successive
 * values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0 01 - 1 11 - 3 10 - 2
 *
 * Note: For a given n, a gray code sequence is not uniquely defined.
 *
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 *
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 1<<n; i++) {
            result.add(i^i>>1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Enter value of n for gray code sequence:");
        GrayCode gc = new GrayCode();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(gc.grayCode(n));
    }
}
