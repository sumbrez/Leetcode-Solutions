/*
230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/

// 1ms
public class Solution {
	int k,ret,left;
	boolean flag=false;
	int dfs(TreeNode node)
	{
		if (flag||node==null) return 0;
		int cnt=dfs(node.left);
		cnt++;
		left++;
		if (left==k)
		{
			ret=node.val;
			flag=true;
			return 0;
		}
		cnt+=dfs(node.right);
		return cnt;
	}
	public int kthSmallest(TreeNode root, int k) {
		if (root==null) return Integer.MIN_VALUE;
		this.k=k;
		dfs(root);
		return ret;
	}
}
