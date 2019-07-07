package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */

public class WordSearch {
    public class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    Set<Point> visited = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                visited = new HashSet<>();
                if(exist(board, new int[]{i,j}, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int[] boardIndex, String word, int wordIndex) {
        int x = boardIndex[0];
        int y = boardIndex[1];
        System.out.println(x + "\t" + y + "\t" + wordIndex);
        if(x < 0 || y < 0) return false;
        if(x >= board.length || y >= board[0].length) return false;
        if(visited.contains(new Point(x, y))){
            return false;
        } else {
            visited.add(new Point(x, y));
        }
        if(wordIndex == word.length()) {
            return true;
        }
        if(word.charAt(wordIndex) != board[x][y]) {
            //visited.remove(new Point(x,y));
            return false;
        } else {
            if(wordIndex == word.length()) {
                return true;
            }
        }
        wordIndex++;
        if(exist(board, new int[]{x-1, y}, word, wordIndex)) return true;
        if(exist(board, new int[]{x+1, y}, word, wordIndex)) return true;
        if(exist(board, new int[]{x, y-1}, word, wordIndex)) return true;
        if(exist(board, new int[]{x, y+1}, word, wordIndex)) return true;
        //visited.remove(new Point(x,y));
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','a'}};
        String word = "aaa";
        WordSearch instance = new WordSearch();
        System.out.println(instance.exist(board, word));
    }
}
