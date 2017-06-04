/*
117. Populating Next Right Pointers in Each Node II
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

Java 5 ms
*/


public class Solution {
	List<List<TreeLinkNode>> llst;
	int mxdepth=-1; // 根的深度为0
	// 分层放入llst中
	void dfs(TreeLinkNode node,int depth)
	{
		if (node==null) return;
		llst.get(depth).add(node);
		dfs(node.left,depth+1);
		dfs(node.right,depth+1);
	}
	// 获取最大深度
	void ddfs(TreeLinkNode node,int depth)
	{
		if (node==null) return;
		if (depth>mxdepth) mxdepth=depth;
		ddfs(node.left,depth+1);
		ddfs(node.right,depth+1);
	}
	public void connect(TreeLinkNode root) {
		ddfs(root,0);
		llst=new ArrayList<List<TreeLinkNode>>();
		for (int i=0;i<=mxdepth;i++)
			llst.add(new ArrayList<TreeLinkNode>());
		dfs(root,0);
		for (int i=0;i<=mxdepth;i++)
		{
			List<TreeLinkNode> temp=llst.get(i);
			for (int j=temp.size()-2;j>=0;j--)
				temp.get(j).next=temp.get(j+1);
			temp.get(temp.size()-1).next=null;
		}
	}
}
