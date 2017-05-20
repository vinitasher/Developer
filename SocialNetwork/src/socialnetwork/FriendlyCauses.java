/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FriendlyCauses {

	public static void main(String[] args) throws Exception {
		FriendlyCauses s = new FriendlyCauses();
		s.find();
	}

	TrieNode[] root = new TrieNode[26];

	public void find() throws Exception {
		long timeBefore = System.currentTimeMillis();
		File wordList = new File("wordlist2.txt");
		BufferedReader reader = new BufferedReader(new FileReader(wordList));

		int wordsAdded = buildTrie(reader);
		System.out.println("Done building the Trie; " + wordsAdded + " words added.");
		findFriends("listy");
		System.out.println("Amount of friends found: " + countWords(root));
		System.out.println("Total time: " + (System.currentTimeMillis() - timeBefore) + "ms");
	}

	/**
* This method builds the complete trie with all the words.
*/
	public int buildTrie(BufferedReader reader) throws IOException {
		int wordsAdded = 0;
		while (reader.ready()) {
			String next = reader.readLine().toLowerCase();
			int start = next.charAt(0) - 97;
			TrieNode current = root[start];
			if (current == null) {
				root[start] = current = new TrieNode();
			}
			for (int i = 1; i < next.length(); i++) {
				int nextIndex = next.charAt(i) - 97;
				if (current.children == null) {
					current.children = new TrieNode[26];
				}
				if (current.children[nextIndex] == null) {
					TrieNode deeper = new TrieNode();
					current.children[nextIndex] = deeper;
				}
				current = current.children[nextIndex];
			}
			current.word = next;
			wordsAdded++;
		}
		return wordsAdded;
	}

	private class TrieNode {
		// The children:
		TrieNode[] children;
		// If this node is the end of a word, store the word here:
		String word;
		// This boolean indicates that the current node is a friend.
		boolean isFriend;
	}

	// Temporary buffer of friends to investigate further:
	public List<String> friendsToFind = new LinkedList<String>();

	public void findFriends(String word) {
		friendsToFind.add(word);

		while (friendsToFind.size() > 0) {
			String friend = friendsToFind.remove(0);

			int size = friend.length();

			byte[] currentRow = new byte[size + 1];
			for (int i = 0; i <= size; i++) {
				currentRow[i] = (byte) i;
			}

			// Search the Trie for the given friend:
			for (int i = 0; i < 26; i++) {
				if (root[i] != null) {
					searchTrieForWord(root[i], i + 97, friend, currentRow);
				}
			}
		}
	}

	/**
* Walk the complete Trie again finding all the friends
*/
	private int countWords(TrieNode[] ts) {
		int amount = 0;
		for (int i = 0; i < 26; i++) {
			TrieNode t = ts[i];
			if (t != null) {
				if (t.isFriend) {
					amount++;
					// Print/add t.word
				}
				if (t.children != null) {
					amount += countWords(t.children);
				}
			}
		}
		return amount;
	}

	/**
* Recursively walk the Trie calculating the Levenshtein distance to the
* given word. When a friend is found, mark it and add it to a list. The new
* friend needs to be processed further on.
*/
	private void searchTrieForWord(TrieNode node, int letter, String word, byte[] previousRow) {

		int size = previousRow.length;
		byte[] currentRow = new byte[size];
		currentRow[0] = (byte) (previousRow[0] + 1);

		int minElement = currentRow[0];

		for (int i = 0; i < size - 1; i++) {
			int newCurrentRowValue = currentRow[i] + 1;
			newCurrentRowValue = Math.min(newCurrentRowValue,
					previousRow[i + 1] + 1);

			if (word.charAt(i) == letter) {
				newCurrentRowValue = Math.min(newCurrentRowValue,
						previousRow[i]);
			} else {
				newCurrentRowValue = Math.min(newCurrentRowValue,
						previousRow[i] + 1);
			}
			if (newCurrentRowValue < minElement) {
				minElement = newCurrentRowValue;
			}
			currentRow[i + 1] = (byte) newCurrentRowValue;
		}

		// If the Levenshtein distance is 1 and the node at current depth is a
		// word (and not yet friend):
		if (currentRow[size - 1] == 1 && node.word != null && !node.isFriend) {
			node.isFriend = true;
			friendsToFind.add(node.word);
		}

		if (minElement <= 1 && node.children != null) {
			for (int i = 0; i < node.children.length; i++) {
				TrieNode child = node.children[i];
				if (child != null) {
					searchTrieForWord(child, i + 97, word, currentRow);
				}
			}
		}
	}
}
