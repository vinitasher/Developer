package ints;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        lexicalOrderRecursive(n, 1, result);
        return result;
    }

    public void lexicalOrderRecursive(int n, int current, List<Integer> result){
        if(current > n){
            return;
        }
        result.add(current);
        lexicalOrderRecursive(n, current * 10, result);
        current++;
        if(current % 10 != 0){
            lexicalOrderRecursive(n, current, result);
        }

    }
}
