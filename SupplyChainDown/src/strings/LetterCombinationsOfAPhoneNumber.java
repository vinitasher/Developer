package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {
    Map<Integer, Character[]> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        StringBuilder sb = new StringBuilder();
        initMap();
        letterCombinationsHelper(digits.toCharArray(), 0, result, sb);
        return result;
    }

    public void letterCombinationsHelper(char[] digits, int index, List<String> result, StringBuilder sb){
        if(sb.length() == digits.length){
            result.add(sb.toString());
        } else {
            int number = Character.getNumericValue(digits[index]);
            Character[] cArr = map.get(number);
            for(int i=0; i<cArr.length; i++){
                sb.append(cArr[i]);
                letterCombinationsHelper(digits, index + 1, result, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void initMap(){
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber instance = new LetterCombinationsOfAPhoneNumber();
        String input = "23";
        System.out.println(instance.letterCombinations(input));
    }
}
