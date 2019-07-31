package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 * count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 *
 *
 *
 * Rules for a valid pattern:
 *
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys,
 * the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 * The order of keys used matters.
 *
 *
 *
 *
 *
 * Explanation:
 *
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 *
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 *
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 *
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 *
 *
 *
 * Example:
 *
 * Input: m = 1, n = 1
 * Output: 9
 */
public class AndroidUnlockPatterns {
    int result = 0;
    public int numberOfPatterns(int m, int n) {
        Set<Integer> visited = new HashSet<>();
        if(m > 9) return 0;
        for(int i=1; i<=9; i++){
            numberOfPatternsHelper(m, n, i, 1, visited);
        }
        return result;
    }

    public void numberOfPatternsHelper(int m, int n, int index, int count, Set<Integer> visited){
        if(m <= count && count <= n) result++;
        if(count > n || count >= 9) return;

        visited.add(index);
        for(int i=1; i<=9; i++){
            if(visited.contains(i)) continue;
            else if(i % 3 == index % 3){
                //same column
                if(Math.abs(i - index) == 3){
                    //no gap
                    numberOfPatternsHelper(m, n, i, count + 1, visited);
                } else if(visited.contains(Math.min(i, index) + 3)) {
                    //gap
                    numberOfPatternsHelper(m, n, i, count + 1, visited);
                }
            } else if((i-1)/3 == (index-1)/3){
                //same row
                if(Math.abs(i - index) == 1){
                    //no gap
                    numberOfPatternsHelper(m, n, i, count + 1, visited);
                } else if(visited.contains(Math.min(index, i) + 1)) {
                    //gap
                    numberOfPatternsHelper(m, n, i, count + 1, visited);
                }

            } else if(Math.abs(i - index) == 8 && i * index == 9){
                //diagonal
                if(visited.contains(5)) numberOfPatternsHelper(m, n, i, count + 1, visited);
            } else if(Math.abs(i - index) == 4 && i * index == 21){
                //diagonal
                if(visited.contains(5)) numberOfPatternsHelper(m, n, i, count + 1, visited);
            } else {
                numberOfPatternsHelper(m, n, i, count + 1, visited);
            }
        }
        visited.remove(index);
    }

    public static void main(String[] args) {
        AndroidUnlockPatterns instance = new AndroidUnlockPatterns();
        System.out.println(instance.numberOfPatterns(2, 3));
    }
}
