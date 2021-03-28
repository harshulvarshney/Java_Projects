package trie;

/**
 * A Trie class will have a root node.
 *
 * main methods:
 *      void insertWord(String word)
 *      boolean search(String word)
 *      boolean startsWith(String prefix)
 *
 *
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!node.contains(c)) {
                node.set(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /**
     * returns true if word is present in Trie
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(node.contains(c))
                node = node.get(c);
            else
                return null;
        }
        return node;
    }

    /**
     * returns true if any word in TRie start with prefix
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
