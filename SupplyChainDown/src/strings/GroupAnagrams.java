package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] charCountArr = new int[26];
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> strMap = new HashMap<>();
        for(String s: strs){
            Arrays.fill(charCountArr, 0);
            char[] sArr = s.toCharArray();

            for(char c: sArr){
                charCountArr[c - 'a']++;
            }

            StringBuffer sb = new StringBuffer();

            for(int i: charCountArr){
                sb.append(i);
                sb.append('#');
            }

            if(!strMap.containsKey(sb.toString())){
                strMap.put(sb.toString(), new ArrayList<String>(Arrays.asList(s)));
            } else {
                strMap.get(sb.toString()).add(s);
            }
        }

        for(List<String> anagrams: strMap.values()){
            result.add(anagrams);
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams instance = new GroupAnagrams();

    }
}
