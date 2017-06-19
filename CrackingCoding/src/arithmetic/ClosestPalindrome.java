/*
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.
 */
package arithmetic;

/**
 *
 * @author vasher
 */
public class ClosestPalindrome {

    int carry = 0;

//    public char[] generatePalindrome(char[] sb, int left, int right) {
//        if (sb == null || sb.length < 2) {
//            return sb;
//        }
//        if (left >= right) {
//            return sb;
//        }
//        sb[right] += carry;
//        carry = 0;
//        int tempright = right;
//        if (Math.abs(Character.getNumericValue(sb[left]) - Character.getNumericValue(sb[right])) > 5) {
//            while (Character.getNumericValue(sb[right - 1]) == 9 && right > 0) {
//                sb[right - 1] = Character.forDigit(Character.getNumericValue(0) + 1, 10);
//                right = right - 1;
//            }
//            sb[right - 1] = Character.forDigit(Character.getNumericValue(sb[right - 1]) + 1, 10);
//        }
//        sb[tempright] = sb[left];
//        return generatePalindrome(sb, left + 1, tempright - 1);
//    }

    public String nearestPalindrome(String n) {
        int left = 0;
        int right = n.length() - 1;
        int carry = 0;
        char[] sb = n.toCharArray();
        while (left < right) {
            sb[right] += carry;
            carry = 0;
            int tempright = right;
            if (Math.abs(Character.getNumericValue(sb[left]) - Character.getNumericValue(sb[right])) > 5) {
                while (Character.getNumericValue(sb[right - 1]) == 9 && right > 0) {
                    sb[right - 1] = Character.forDigit(Character.getNumericValue(0) + 1, 10);
                    right = right - 1;
                }
                sb[right - 1] = Character.forDigit(Character.getNumericValue(sb[right - 1]) + 1, 10);
            }
            sb[tempright] = sb[left];
            left++;
            right--;
        }
        if (n.equals(new String(sb))) {
            if (n.length() % 2 == 0) {
                right = n.length() / 2;
                if (right > 0) {
                    left = right - 1;
                    if (Character.getNumericValue(sb[left]) > 0) {
                        sb[left] = Character.forDigit(Character.getNumericValue(sb[left]) - 1, 10);
                    } else {
                        sb[left] = Character.forDigit(Character.getNumericValue(sb[left]) + 1, 10);
                    }
                }
                if (Character.getNumericValue(sb[right]) > 0) {
                    sb[right] = Character.forDigit(Character.getNumericValue(sb[right]) - 1, 10);
                } else {
                    sb[right] = Character.forDigit(Character.getNumericValue(sb[right]) + 1, 10);
                }
            } else {
                right = n.length() /2;
                if (Character.getNumericValue(sb[right]) > 0) {
                    sb[right] = Character.forDigit(Character.getNumericValue(sb[right]) - 1, 10);
                } else {
                    sb[right] = Character.forDigit(Character.getNumericValue(sb[right]) + 1, 10);
                }
            }
            System.out.println("Palindrome");
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        ClosestPalindrome cp = new ClosestPalindrome();
        String str = "10";
        String out = cp.nearestPalindrome(str);
        System.out.println(out);
    }

}
