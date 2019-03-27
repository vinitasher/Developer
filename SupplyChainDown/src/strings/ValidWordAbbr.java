package strings;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 *
 * a) it                      --> it    (no abbreviation)
 *
 *      1
 *      ↓
 * b) d|o|g                   --> d1g
 *
 *               1    1  1
 *      1---5----0----5--8
 *      ↓   ↓    ↓    ↓  ↓
 * c) i|nternationalizatio|n  --> i18n
 *
 *               1
 *      1---5----0
 *      ↓   ↓    ↓
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 *
 * Example:
 *
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 *
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 */
public class ValidWordAbbr {
    Map<String, Set<String>> dictMap = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for(String s: dictionary){
            int length = s.length();
            StringBuffer sb = new StringBuffer();
            if(length > 0){
                sb.append(s.charAt(0));
            }
            if(length > 2){
                sb.append(length - 2);
            }
            if(length > 1) {
                sb.append(s.charAt(length - 1));
            }
            if(dictMap.containsKey(sb.toString())){
                dictMap.get(sb.toString()).add(s);
            } else {
                Set<String> set = new HashSet<>();
                set.add(s);
                dictMap.put(sb.toString(), set);
            }
        }

    }

    public boolean isUnique(String word) {
        StringBuffer sb = new StringBuffer();
        if(word.length() > 0) {
            sb.append(word.charAt(0));
        }
        if(word.length() > 2){
            sb.append(word.length() - 2);
        }
        if(word.length() > 1) {
            sb.append(word.charAt(word.length() - 1));
        }
        if(dictMap.containsKey(sb.toString())){
            return dictMap.get(sb.toString()).contains(word) && dictMap.get(sb.toString()).size() == 1;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String[] dict = {"deer", "door", "cake", "card"};
        ValidWordAbbr instance = new ValidWordAbbr(dict);
        System.out.println(instance.isUnique("door"));

    }
}
