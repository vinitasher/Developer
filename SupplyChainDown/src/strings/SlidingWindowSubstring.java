package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string S and a string T,
 * find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */

public class SlidingWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return "";
        int minWindow = Integer.MAX_VALUE;
        int startMin=0, endMin=0;
        char[] tArr = t.toCharArray();
        Set<Character> tSet = new HashSet<>();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> refMap = new HashMap<>();
        for(int i=0; i<tArr.length; i++) {
            tSet.add(tArr[i]);
            refMap.put(tArr[i], refMap.getOrDefault(tArr[i], 0) + 1);
        }
        char[] sArr = s.toCharArray();
        int start = 0;
        loop: for(int i=0; i<sArr.length; i++) {
            if(!tSet.contains(sArr[i])) continue;
            if(!tMap.containsKey(sArr[i])) {
                tMap.put(sArr[i], 1);
            } else {
                tMap.put(sArr[i], tMap.get(sArr[i])+1);
            }
            if(tMap.size() != tSet.size()) continue;

            //if map size == set size
            while(start <= i) {

                if (!tMap.containsKey(sArr[start])) {
                    start++;
                    continue;
                }

                if (tMap.get(sArr[start]) > refMap.get(sArr[start])) {
                    tMap.put(sArr[start], tMap.get(sArr[start]) - 1);
                    start++;
                    continue;
                }

                for(Character key: tMap.keySet()) {
                    if(tMap.get(key) < refMap.get(key)) continue loop;
                }

                if (i - start < minWindow) {
                    minWindow = i - start;
                    startMin = start;
                    endMin = i;
                }
                break;
            }
        }
        if(minWindow == Integer.MAX_VALUE) return "";
        return s.substring(startMin, endMin + 1);
    }

    public static void main(String[] args) {
        SlidingWindowSubstring instance = new SlidingWindowSubstring();
        String s = "a";
        String t = "aa";
        System.out.println(instance.minWindow(s, t));
    }
}
