package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) {
            result.add("");
        }
        for(int i = 0; i < n; i++) {
            for(String left: generateParenthesis(i)) {
                for(String right: generateParenthesis(n - 1 - i)) {
                    result.add("(" + left + ")" + right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses instance = new GenerateParentheses();
        System.out.println(instance.generateParenthesis(3));
    }
}
