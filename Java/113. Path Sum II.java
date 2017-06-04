/*
113. Path Sum II
https://leetcode.com/problems/path-sum-ii/

Java 4 ms
*/

public class Solution {
	int sum;
	List<List<Integer>> ret;
	void dfs(TreeNode node,List<Integer> lst,int tsum)
	{
		if (node==null) return;
		if (node.left==null&&node.right==null&&tsum+node.val==sum)
		{
			lst.add(node.val);
			ret.add(new ArrayList<Integer>(lst));
			lst.remove(lst.size()-1);
			return;
		}
		lst.add(node.val);
		dfs(node.left,lst,tsum+node.val);
		lst.remove(lst.size()-1);
		
		lst.add(node.val);
		dfs(node.right,lst,tsum+node.val);
		lst.remove(lst.size()-1);
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		this.sum=sum;
		ret=new ArrayList<List<Integer>>();
		dfs(root,new ArrayList<Integer>(),0);
		return ret;
	}
}
