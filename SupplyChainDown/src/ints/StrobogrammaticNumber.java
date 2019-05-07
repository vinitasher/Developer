package ints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * Example 1:
 *
 * Input:  "69"
 * Output: true
 * Example 2:
 *
 * Input:  "88"
 * Output: true
 * Example 3:
 *
 * Input:  "962"
 * Output: false
 *
 */

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character,Character> stroboMap = init();
        char[] numArr = num.toCharArray();
        int start = 0, end = numArr.length - 1;
        while(start <= end) {
            if(!stroboMap.containsKey(numArr[start]) || !stroboMap.containsKey(numArr[end])) {
                return false;
            }
            if(stroboMap.get(numArr[start]) != numArr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public Map<Character, Character> init() {
        Map<Character,Character> stroboMap = new HashMap<>();
        stroboMap.put('0','0');
        stroboMap.put('1','1');
        stroboMap.put('6','9');
        stroboMap.put('8','8');
        stroboMap.put('9','6');
        return stroboMap;
    }

    public static void main(String[] args) {

    }
}
