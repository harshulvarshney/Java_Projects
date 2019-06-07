package mission_peace.string;

/**
 * Trie DS implementation.
 * 
 * @author harshul
 *
 */
public class Trie {
	
	public static void main(String[] args) {
		
		TrieNode root = new TrieNode();
		
		Trie obj = new Trie();
		obj.insertIterative("abcd", root);
		obj.insertIterative("abc", root);
		obj.insertIterative("cxyz", root);
		obj.insertRecursive("xyz", 0, root);
		
		//System.out.println("Prefix search: Key : " + "ab >> " + (obj.prefixSearchIterative("ab", root) ? "found" : "not-found"));
		//System.out.println("Prefix search: Key : " + "cxy >> " + (obj.prefixSearchIterative("cxy", root) ? "found" : "not-found"));
		
		System.out.println("Whole word search: " + "abc >> " + (obj.findWord("abc", 0, root)? "found" : "not-found"));
		System.out.println("Whole word search: " + "cxyzl >> " + (obj.findWord("cxyzl", 0, root) ? "found" : "not-found"));
		
		if(obj.delete("abc", 0, root))
			System.out.println("abc deleted");
		System.out.println("Whole word search: " + "abc >> " + (obj.findWord("abc", 0, root)? "found" : "not-found"));
		
	}
	
	
	private void insertIterative(String word, TrieNode root) {
		
		char[] arr = word.toCharArray();
		TrieNode curr = root;
		for(int i = 0; i < arr.length; i++) {
			TrieNode child = curr.children.get(arr[i]);
			if(child == null) {
				child = new TrieNode();
				curr.children.put(arr[i], child);
			}
			curr = child;
		}
		curr.endOfWord = true;
	}
	
	private void insertRecursive(String word, int index, TrieNode root) {
		if(index == word.length()) {
			root.endOfWord = true;
			return;
		}
		char c = word.charAt(index);
		TrieNode node = root.children.get(c);
		
		if(node == null) {
			node = new TrieNode();
			root.children.put(c, node);
		}
		insertRecursive(word, ++index, node);
	}
	
	private boolean prefixSearchIterative(String prefix, TrieNode root) {
		char[] c = prefix.toCharArray();
		if(root == null) return false;
		
		for(int i = 0; i < c.length; i++) {
			char a = c[i];
			if(root.children.containsKey(a)) {
				root = root.children.get(a);
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * returns true if whole word is found else false.
	 * @param word
	 * @param index
	 * @param root
	 * @return
	 */
	private boolean findWord(String word, int index, TrieNode root) {
		if(index == word.length() && root.endOfWord) {
			return true;
		}
		char c = word.charAt(index);
		TrieNode node = root.children.get(c);
		if(node != null) {
			return findWord(word, ++index, node);
		}
		return false;
	}
	
	private boolean delete(String word, int index, TrieNode root) {
		if(index == word.length()) {
			if(!root.endOfWord) {
				return false;
			}
			root.endOfWord = false;
			return root.children.size() == 0;
		}
		
		char c = word.charAt(index);
		TrieNode node = root.children.get(c);
		if(node == null) {
			return false;
		}
		boolean deleteNode = delete(word, ++index, node);
		
		if(deleteNode) {
			root.children.remove(c);
			return root.children.size() == 0;
		}
		return false;
	}

}
