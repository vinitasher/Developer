package strings;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .
 * A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord {
    TrieNode root;
    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode('$');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] wordArr = word.toCharArray();
        addWordRecursive(wordArr, 0, root);
    }

    public void addWordRecursive(char[] word, int index, TrieNode root) {
        boolean isEnd = false;
        TrieNode newRoot;
        if(index == word.length - 1) isEnd = true;
        if(!root.neighbors.containsKey(word[index])) {
            newRoot = new TrieNode(word[index]);
            root.neighbors.put(word[index], newRoot);
        } else {
            newRoot = root.neighbors.get(word[index]);
        }
        if(isEnd){
            newRoot.isEnd = isEnd;
        }
        if(index < word.length - 1) {
            addWordRecursive(word, index + 1, newRoot);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] wordArr = word.toCharArray();
        return searchRecursive(wordArr, 0, root);
    }

    public boolean searchRecursive(char[] word, int index, TrieNode root) {
        boolean isEnd = false;
        if(index == word.length) return true;
        if(index == word.length - 1) isEnd = true;
        if(word[index] != '.'){
            if(!root.neighbors.containsKey(word[index])) return false;
            if(isEnd && !root.neighbors.get(word[index]).isEnd) return false;
            return searchRecursive(word, index + 1, root.neighbors.get(word[index]));
        } else {
            for(Character key: root.neighbors.keySet()) {
                if(isEnd && root.neighbors.get(key).isEnd) {
                    return true;
                }
                if(index <= word.length - 1 && searchRecursive(word, index + 1, root.neighbors.get(key))) {
                    //return true if any one neighbor return true ignore otherwise
                    return true;
                }
            }
            //return false if no match
            return false;
        }
    }

    public static void main(String[] args) {
        AddAndSearchWord instance = new AddAndSearchWord();
        instance.addWord("at");
        instance.addWord("and");
        instance.addWord("an");
        instance.addWord("add");
        System.out.println(instance.search("a"));
        System.out.println(instance.search(".at"));
        System.out.println(instance.search("bat"));
        System.out.println(instance.search(".at"));
        System.out.println(instance.search("an."));
        System.out.println(instance.search("a.d."));
        System.out.println(instance.search("b."));
        System.out.println(instance.search("a.d"));
        System.out.println(instance.search("."));
    }
}
