/*
337. House Robber III
https://leetcode.com/problems/house-robber-iii/
*/

// 9ms
import java.util.*;

public class Solution {
	Map<TreeNode,Integer> mp;
	int cnt,dp[][];
	void makeid(TreeNode node)
	{
		if (node==null) return;
		mp.put(node,cnt++);
		makeid(node.left);
		makeid(node.right);
	}
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	void dfs(TreeNode node)
	{
		if (node==null) return;
		dfs(node.left);
		dfs(node.right);
		int id=mp.get(node),left=cnt,right=cnt;
		if (node.left!=null)
			left=mp.get(node.left);
		if (node.right!=null)
			right=mp.get(node.right);
		dp[id][0]=imax(dp[left][0],dp[left][1])
				+imax(dp[right][0],dp[right][1]);
		dp[id][1]=dp[left][0]+dp[right][0]+node.val;
	}
	public int rob(TreeNode root) {
		if (root==null) return 0;
		mp=new HashMap<TreeNode,Integer>();
		cnt=0;
		makeid(root);
		dp=new int[cnt+1][2]; // 多一个用来代表null
		dfs(root);
		int rid=mp.get(root);
		return imax(dp[rid][0],dp[rid][1]);
	}
}
