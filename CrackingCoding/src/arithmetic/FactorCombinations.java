/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vasher
 *
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2; = 2 x 4.
 *
 * Write a function that takes an integer n and return all possible combinations
 * of its factors.
 *
 * Note: You may assume that n is always positive. Factors should be greater
 * than 1 and less than n.
 *
 * Examples:
 *
 * input: 1 output: []
 *
 * input: 37 output: []
 *
 * input: 12 output: [ [2, 6], [2, 2, 3], [3, 4] ]
 *
 * input: 32 output: [ [2, 16], [2, 2, 8], [2, 2, 2, 4], [2, 2, 2, 2, 2], [2, 4,
 * 4], [4, 8] ]
 *
 */
public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {

        int i = 2;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        while (n > 1) {
            while (n % i == 0) {
                n = n/i;
                temp.add(i);
                temp.add(n);
                result.add(temp);
            }
        }

    }
}
