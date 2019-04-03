package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * <p>
 * Derive the order of letters in this language.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * <p>
 * Output: "wertf"
 * Example 2:
 * <p>
 * Input:
 * [
 * "z",
 * "x"
 * ]
 * <p>
 * Output: "zx"
 * Example 3:
 * <p>
 * Input:
 * [
 * "z",
 * "x",
 * "z"
 * ]
 * <p>
 * Output: ""
 * <p>
 * Explanation: The order is invalid, so return "".
 * Note:
 * <p>
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
    public static void main(String[] args) {
        AlienDictionary instance = new AlienDictionary();
        String[] words = {
//                "z","x","z"
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        System.out.println(instance.alienOrder1(words));
    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> charMap = new HashMap<>();
        for (String w : words) {
            char[] charArr = w.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                if (!charMap.containsKey(charArr[i])) {
                    Set<Character> charSet = new HashSet<>();
                    charMap.put(charArr[i], charSet);
                }
                if (i > 0 && charArr[i] != charArr[i - 1]) {
                    charMap.get(charArr[i]).add(charArr[i - 1]);
                }
            }
        }
        return "";
    }

    public String alienOrder1(String[] words) {
        Set<Character> characters = new LinkedHashSet<>();
        List<Character> charList = new ArrayList<>();
        for (int j = 0; j < words.length - 1; j++) {
            char[] cArr1 = words[j].toCharArray();
            char[] cArr2 = words[j + 1].toCharArray();
            int length = Math.min(cArr1.length, cArr2.length);
            for (int i = 0; i < length; i++) {
                int lastIndex = charList.size();
                lastIndex = processCharacter(charList, characters, cArr1[i], cArr2[i], lastIndex);
                if (lastIndex == -1) {
                    return "";
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character c : charList) {
            sb.append(c);
        }
        return sb.toString();
    }

    public int processCharacter(List<Character> charList, Set<Character> characters, char a, char b, Integer lastIndex) {
        if (!characters.contains(a)) {
            characters.add(a);
            charList.add(lastIndex, a);
        } else {
            lastIndex = charList.indexOf(a);
        }
        lastIndex += 1;
        if (a == b) {
            return lastIndex;
        }
        if (!characters.contains(b)) {
            characters.add(b);
            charList.add(lastIndex, b);
        } else {
            int index = charList.indexOf(b);
            if (index >= lastIndex) {
                lastIndex = index;
            } else {
                return -1;
            }
        }
        return lastIndex;
    }

    public String alienOrderSolution(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree = new HashMap<Character, Integer>();
        String result = "";
        if (words == null || words.length == 0) return result;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<Character>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<Character>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) q.add(c);
        }
        while (!q.isEmpty()) {
            char c = q.remove();
            result += c;
            if (map.containsKey(c)) {
                for (char c2 : map.get(c)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) q.add(c2);
                }
            }
        }
        if (result.length() != degree.size()) return "";
        return result;
    }
}
