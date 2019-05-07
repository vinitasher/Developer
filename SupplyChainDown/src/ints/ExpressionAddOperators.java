//package ints;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Given a string that contains only digits 0-9 and a target value,
// * return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
// *
// * Example 1:
// *
// * Input: num = "123", target = 6
// * Output: ["1+2+3", "1*2*3"]
// * Example 2:
// *
// * Input: num = "232", target = 8
// * Output: ["2*3+2", "2+3*2"]
// * Example 3:
// *
// * Input: num = "105", target = 5
// * Output: ["1*0+5","10-5"]
// * Example 4:
// *
// * Input: num = "00", target = 0
// * Output: ["0+0", "0-0", "0*0"]
// * Example 5:
// *
// * Input: num = "3456237490", target = 9191
// * Output: []
// *
// */
//
//public class ExpressionAddOperators {
//    String num;
//    char[] numArr;
//    List<Character> operators;
//    int target;
//
//    /**
//     * Operators + addition, - subtration, * multiplication and ~ NO-OP operator which does nothing
//     * @param num
//     * @param target
//     * @return
//     */
//    public List<String> addOperators(String num, int target) {
//        this.target = target;
//        operators = new ArrayList<>();
//        operators.add('+');
//        operators.add('-');
//        operators.add('*');
//        operators.add('~');
//        numArr = num.toCharArray();
//        List<String> result = new ArrayList<>();
//        StringBuffer sb = new StringBuffer();
//        int value = 0;
//        String prev = null;
//        addOperators(result, value, prev, 0, sb);
//        return result;
//    }
//
//    public int addOperators(List<String> result, int value, int prev, int index, StringBuffer currentString){
//        int op1 = numArr[index];
//        currentString.append(num.charAt(index));
//        for(Character op: operators) {
//            switch(op) {
//                case '+':
//                    currentString.append(op1+'+');
//                    value = value + op1;
//                    prev = op1;
//                    addOperators(result, value, prev, index + 1, currentString);
//                    break;
//                case '-':
//                    currentString.append(op1+'-');
//                    value = value - op1;
//                    prev = op1;
//                    addOperators(result, value, prev, index + 1, currentString);
//                    break;
//                case '*':
//                    currentString.append(op1+'*');
//                    value = prev * value;
//                    addOperators(result, value, prev, index + 1, currentString);
//                    break;
//                case '~':
//                    currentString.append(op1+'-');
//                    value = op1 - addOperators(result, value, prev, index + 1, currentString);
//                    break;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
