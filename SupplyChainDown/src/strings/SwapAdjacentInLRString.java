package strings;

/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
 * a move consists of either replacing one occurrence of "XL" with "LX",
 * or replacing one occurrence of "RX" with "XR".
 *
 * Given the starting string start and the ending string end,
 * return True if and only if there exists a sequence of moves to transform one string to the other.
 *
 * Example:
 *
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * Note:
 *
 * 1 <= len(start) = len(end) <= 10000.
 * Both start   and end will only consist of characters in {'L', 'R', 'X'}.
 */
public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        char[] startArr = start.toCharArray();
        char[] endArr   = end.toCharArray();
        int i = 0, j = 0, N = start.length();

        while(i < N || j < N) {
            if(i < N && startArr[i] == 'X') {
                i++;
                continue;
            }
            if(j < N && endArr[j] == 'X') {
                j++;
                continue;
            }

            if(i == N || j == N) return false;

            //L can only go backward
            if(i < j && startArr[i] == 'L') return false;

            //R can only go forward
            if(i > j && startArr[i] == 'R') return false;

            if(startArr[i] != endArr[j]) return false;
            i++;
            j++;
        }


        if( i != N || j != N) return false;

        return true;
    }

    public static void main(String[] args) {
        SwapAdjacentInLRString instance = new SwapAdjacentInLRString();
        String start    = "XXXXXXXXXX";
        String end      = "XXXXXXXXXX";
        System.out.println(instance.canTransform(start, end));
    }
}
