package string;

public class TrieTest {
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		String s1 = "abcd";
		String s2 = "abc";
		String s3 = "ijk";
		String s4 = "abz";
		
		trie.add(s1);
		trie.add(s2);
		trie.add(s3);
		trie.add(s4);
		
		System.out.println("Find Exact: abc : " + (trie.findExact("abc") ? "Found" : "NotFound"));
		System.out.println("Find Exact: ijk : " + (trie.findExact("ijk") ? "Found" : "NotFound"));
		System.out.println("Find Prefic: j : " + (trie.findPrefix("j") ? "Found" : "NotFound"));
	}

}
