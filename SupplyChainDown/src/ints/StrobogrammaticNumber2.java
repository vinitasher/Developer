package ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Find all strobogrammatic numbers that are of length = n.
 *
 * Example:
 *
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 *
 */
public class StrobogrammaticNumber2 {
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammaticRecursive(n, n);
    }

    public List<String> findStrobogrammaticRecursive(int n, int m) {
        if(n == 0) return new ArrayList<>(Arrays.asList(""));
        if(n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> list = findStrobogrammaticRecursive(n-2, m);
        List<String> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(n != m)  result.add("0"+list.get(i)+"0");
            result.add("1"+list.get(i)+"1");
            result.add("6"+list.get(i)+"9");
            result.add("8"+list.get(i)+"8");
            result.add("9"+list.get(i)+"6");
        }
        return result;
    }

}
