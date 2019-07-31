package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 *
 * S was sorted in some custom order previously.
 * We want to permute the characters of T so that they match the order that S was sorted. More specifically,
 * if x occurs before y in S, then x should occur before y in the returned string.
 *
 * Return any permutation of T (as a string) that satisfies this property.
 *
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 *
 *
 * Note:
 *
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        char[] tArr = T.toCharArray();
        char[] sArr = S.toCharArray();
        for(int i=0; i<tArr.length; i++){
            map.put(tArr[i], map.getOrDefault(tArr[i], 0) + 1);
        }

        StringBuffer result = new StringBuffer();
        for(int i=0; i<sArr.length; i++){
            int count = map.getOrDefault(sArr[i], 0);
            while(count > 0){
                result.append(sArr[i]); count--;
            }
            map.remove(sArr[i]);
        }

        for(Character c: map.keySet()){
            int count = map.getOrDefault(c, 0);
            while(count > 0){
                result.append(c); count--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
