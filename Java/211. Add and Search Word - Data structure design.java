/*
211. Add and Search Word - Data structure design
https://leetcode.com/problems/add-and-search-word-data-structure-design/
*/

// 250ms
import java.util.*;

class TrieNode {
	TrieNode child[]=new TrieNode[26];
	// 记录这个节点之后可行的子串的长度
	Set<Integer> tailLen=new HashSet<Integer>();
	boolean flag=false;
}
class Trie {
	TrieNode root=new TrieNode();
	void insert(String word)
	{
		TrieNode node=root;
		int slen=word.length();
		root.tailLen.add(slen);
		for (int i=0;i<slen;i++)
		{
			int idx=word.charAt(i)-'a';
			if (node.child[idx]==null)
				node.child[idx]=new TrieNode();
			node=node.child[idx];
			node.tailLen.add(slen-i-1);
		}
		node.flag=true;
	}
	boolean find(String word)
	{
		return dfsfind(word,root);
	}
	boolean dfsfind(String word,TrieNode node)
	{
		boolean flag;
		int slen=word.length();
		for (int i=0;i<slen;i++)
		{
			int idx=word.charAt(i)-'a';
			if (idx>=0)
			{
				if (node.child[idx]==null)
					return false;
				node=node.child[idx];
			}
			else // '.'
			{
				int tlen=slen-i-1;
				for (TrieNode child:node.child) // 这个节点的child中
					// 非空且长度匹配（跳过的是当前节点的某个child，child指针代表字符）
					if (child!=null&&child.tailLen.contains(tlen))
					{
						flag=dfsfind(word.substring(i+1),child);
						// 如果长度匹配且为0，则是跳过最后一个字符
						if (tlen==0||flag) return true;
					}
				return false;
			}
		}
		return node.flag;
	}
}
public class WordDictionary {

	Trie trie;
	/** Initialize your data structure here. */
	public WordDictionary() {
		trie=new Trie();
	}

    /** Adds a word into the data structure. */
	public void addWord(String word) {
		trie.insert(word);
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return trie.find(word);
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
