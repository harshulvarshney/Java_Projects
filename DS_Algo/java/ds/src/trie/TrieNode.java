package trie;

public class TrieNode {

    private boolean isEnd = false;
    private final Character REF = 'a';
    private final TrieNode[] links;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public boolean contains(char c) {
        return links[c - REF] != null;
    }

    public void set(char c, TrieNode node) {
        links[c - REF] = node;
    }

    public TrieNode get(char c) {
        return links[c - REF];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
