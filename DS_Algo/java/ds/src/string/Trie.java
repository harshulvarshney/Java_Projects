package string;

import java.util.HashMap;
import java.util.Map;

/**
 * TR video of visual understanding:
 * https://www.youtube.com/watch?v=AXjmTQ8LEoI
 * 
 * Trie could be used for finding exact word or prefix.
 * It is a very fast way of searching String
 * But it takes a lot of memory.
 *
 */
public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode(false);
	}
	
	public TrieNode add(String s) {
		if(s == null)
			return null;
		
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(!node.charMap.containsKey(c)) {
				node.charMap.put(c, new TrieNode(false));
			}
			node = node.charMap.get(c);
		}
		node.isEndOfWord = true;
		
		return root;
	}
	
	public boolean findExact(String s) {
		if(root == null)
			return false;
		if(s == null)
			return false;
		
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(!node.charMap.containsKey(c))
				return false;
			node = node.charMap.get(c);
		}
		return node.isEndOfWord ? true : false;
	}
	
	public boolean findPrefix(String s) {
		if(root == null)
			return false;
		if(s == null)
			return false;
		
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(!node.charMap.containsKey(c))
				return false;
			node = node.charMap.get(c);
		}
		return true;
	}
	
	static class TrieNode {
		Map<Character, TrieNode> charMap = new HashMap<>(0);
		boolean isEndOfWord;
		
		public TrieNode(boolean isEndOfWord) {
			this.isEndOfWord = isEndOfWord;
		}
		
		public TrieNode(Character c, boolean isEndOfWord) {
			charMap.put(c, new TrieNode(isEndOfWord));
		}
		
	}

}
