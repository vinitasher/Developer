package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match,
 * such that there is a bijection between a letter in pattern and a non-empty substring in str.
 *
 * Example 1:
 *
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 * Example 2:
 *
 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 * Example 3:
 *
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 */

public class WordPattern2 {

    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> match = new HashMap<>();
        Set<String> set = new HashSet<>();
        return wordPatternMatchUtil(pattern, str, match, 0,0, set);
    }

    private boolean wordPatternMatchUtil(String pattern, String str, Map<Character, String> match,
                                         int pIndex, int sIndex, Set<String> set) {
        if(pIndex==pattern.length() && sIndex==str.length()){
            return true;
        }
        if (sIndex == str.length() || pIndex == pattern.length()) {
            return false;
        }

        Character pChar = pattern.charAt(pIndex);
        if (match.containsKey(pChar)) {
            String matchStr = match.get(pChar);
            int length = matchStr.length();
            if (sIndex+length > str.length() || !matchStr.equals(str.substring(sIndex, sIndex+length))) {
                return false;
            }
            return wordPatternMatchUtil(pattern, str, match, pIndex + 1, sIndex + length, set);
        } else {
            for(int i=sIndex; i<str.length(); i++){
                String b = str.substring(sIndex, i+1);
                if(set.contains(b)){
                    continue;
                }
                match.put(pChar, b);
                set.add(b);
                if(wordPatternMatchUtil(pattern, str, match, pIndex+1, i+1, set)){
                    return true;
                }
                match.remove(pChar);
                set.remove(b);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String pattern = "abab";
        String str = "redblueredblue";
        WordPattern2 wp2 = new WordPattern2();
        System.out.println(wp2.wordPatternMatch(pattern, str));
    }
}
