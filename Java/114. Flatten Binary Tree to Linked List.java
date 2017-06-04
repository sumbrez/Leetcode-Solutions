/*
114. Flatten Binary Tree to Linked List
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Java 4 ms
*/

public class Solution {
	TreeNode rightbottom(TreeNode node)
	{
		while (node.right!=null)
			node=node.right;
		return node;
	}
	void dfs(TreeNode node)
	{
		if (node==null) return;
		TreeNode rb=null;
		TreeNode left=node.left,right=node.right;
		if (node.left!=null)
		{
			rb=rightbottom(node.left);
			rb.right=node.right;
			node.right=node.left;
			node.left=null;
		}
		dfs(left);
		dfs(right);
	}
	public void flatten(TreeNode root) {
		dfs(root);
	}
}
