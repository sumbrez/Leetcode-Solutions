/*
236. Lowest Common Ancestor of a Binary Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

// tarjan不适合这种单次询问……普通思路就是分别找到p、q并记录路径，然后比较路径
// 11ms
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root==null||p==root||q==root) return root;
		TreeNode left=lowestCommonAncestor(root.left,p,q);
		TreeNode right=lowestCommonAncestor(root.right,p,q);
		if (left!=null&&right!=null) return root; // 一个在左子树一个在右子树
		return left!=null?left:right; // 在同一个子树
	}
}
