package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrieNode2 {
    public char value;
    public Map<Character, TrieNode2> neighbors;
    public Set<Integer> isPalindrome;

    public TrieNode2(char value) {
        this.value = value;
        neighbors = new HashMap<>();
        isPalindrome = new HashSet<>();
    }
}
