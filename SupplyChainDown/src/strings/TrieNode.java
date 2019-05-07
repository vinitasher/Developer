package strings;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public char value;
    public Map<Character, TrieNode> neighbors;
    public boolean isEnd;

    public TrieNode(char value) {
        this.value = value;
        neighbors = new HashMap<>();
    }
}
