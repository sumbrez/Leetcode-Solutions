/*
208. Implement Trie (Prefix Tree)
https://leetcode.com/problems/implement-trie-prefix-tree/
*/

// 179ms
class TrieNode {
	TrieNode child[];
	boolean flag;
	public TrieNode() {
		child=new TrieNode[26];
		flag=false;
	}
}
public class Trie {
	TrieNode root;
	/** Initialize your data structure here. */
	public Trie() {
		root=new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node=root;
		int slen=word.length();
		for (int i=0;i<slen;i++)
		{
			int idx=word.charAt(i)-'a';
			if (node.child[idx]==null)
				node.child[idx]=new TrieNode();
			node=node.child[idx];
		}
		node.flag=true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node=root;
		int slen=word.length();
		for (int i=0;i<slen;i++)
		{
			int idx=word.charAt(i)-'a';
			if (node.child[idx]==null)
				return false;
			node=node.child[idx];
		}
		return node.flag;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode node=root;
		int slen=prefix.length();
		for (int i=0;i<slen;i++)
		{
			int idx=prefix.charAt(i)-'a';
			if (node.child[idx]==null)
				return false;
			node=node.child[idx];
		}
		return true;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
