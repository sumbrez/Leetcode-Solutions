/*
129. Sum Root to Leaf Numbers
https://leetcode.com/problems/sum-root-to-leaf-numbers/

Java 3 ms
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int e10(int e)
	{
		int ret=1;
		while (--e>0) ret*=10;
		return ret;
	}
	List<List<Integer>> llst;
	void dfs(TreeNode node,List<Integer> lst)
	{
		if (node==null) return;
		if (node.left==null&&node.right==null)
		{
			List<Integer> temp=new ArrayList<Integer>(lst);
			temp.add(node.val);
			llst.add(temp);
			return;
		}
		lst.add(node.val);
		dfs(node.left,lst);
		dfs(node.right,lst);
		lst.remove(lst.size()-1);
	}
	public int sumNumbers(TreeNode root) {
		if (root==null) return 0;
		llst=new ArrayList<List<Integer>>();
		dfs(root,new ArrayList<Integer>());
		int sum=0;
		for (int i=llst.size()-1;i>=0;i--)
		{
			List<Integer> lst=llst.get(i);
			int len=lst.size();
			for (int j=0;j<len;j++)
				sum+=lst.get(j)*e10(len-j);
		}
		return sum;
	}
}
