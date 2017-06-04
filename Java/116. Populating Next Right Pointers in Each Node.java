/*
116. Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Java 4 ms
*/

public class Solution {
	List<TreeLinkNode> nlst;
	List<Integer> ilst;
	TreeLinkNode rleft(TreeLinkNode node,int d)
	{
		if (node==null) return null;
		node=node.right;
		while (node!=null&&d-->0)
			node=node.left;
		return node;
	}
	void dfs(TreeLinkNode node)
	{
		// 叶子节点的next在其父节点的dfs中处理
		if (node==null||node.left==null) return;
		node.left.next=node.right;
		int idx=nlst.size();
		if (idx==0) node.right.next=null;
		else
		{
			while (idx>=0&&ilst.get(--idx)==1) //idx>=0和idx=-1配合使用
				if (idx==0) idx=-1; // ==0且get()==1则无法继续--idx
			if (nlst.size()==0||idx<0) node.right.next=null; // 没有找到需要的根节点
			else node.right.next=rleft(nlst.get(idx),nlst.size()-idx);
		}
		
		nlst.add(node);
		ilst.add(0);
		dfs(node.left);
		ilst.remove(ilst.size()-1);
		
		ilst.add(1);
		dfs(node.right);
		ilst.remove(ilst.size()-1);
		nlst.remove(nlst.size()-1);
	}
	public void connect(TreeLinkNode root) {
		if (root==null) return;
		root.next=null;
		nlst=new ArrayList<TreeLinkNode>();
		ilst=new ArrayList<Integer>();
		dfs(root);
	}
}
