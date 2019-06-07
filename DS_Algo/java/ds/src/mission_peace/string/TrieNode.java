package mission_peace.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Benefits of Trie DS:
 * 	prefix-based search
 * 	best for implementing dictionaries
 * 	lexicographic(alphabetical) sorting is easy.
 * 	takes less space then a hash-table.
 * 
 * @author harshul
 *
 */
public class TrieNode {
	
	char data;
	/*
	 * Using a map so that any Unicode char can be added
	 * if only alphabets are to be used, then an array of size 26 can also be used.
	 */
	Map<Character, TrieNode> children;
	boolean endOfWord;
	
	public TrieNode() {
		children = new HashMap<>();
		endOfWord = false;
	}

}
