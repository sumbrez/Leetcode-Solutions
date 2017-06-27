/*
222. Count Complete Tree Nodes
https://leetcode.com/problems/count-complete-tree-nodes/
*/

// 124ms
public class Solution {
	// 找最底层的左子树（叶子）
	int ldfs(int depth,TreeNode node)
	{
		if (node==null) return depth;
		while (node!=null)
		{
			depth++;
			node=node.left;
		}
		return depth;
	}
	// 找最底层的右子树（叶子）
	int rdfs(int depth,TreeNode node)
	{
		if (node==null) return depth;
		while (node!=null)
		{
			depth++;
			node=node.right;
		}
		return depth;
	}
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	public int countNodes(TreeNode root) {
		if (root==null) return 0;
		if (root.left==null&&root.right==null) return 1;
		TreeNode node=root;
		// 先求出整个树的深度
		int maxdepth=ldfs(0,root);
		maxdepth=imax(maxdepth,rdfs(0,root));
		maxdepth=imax(maxdepth,ldfs(0,root));
		maxdepth=imax(maxdepth,rdfs(0,root));
		int leftones=0;
		for (int depth=1;true;depth++)
		{
			// 左子树的左叶子
			int leftLd=ldfs(depth,node.left);
			// 左子树的右叶子
			int rightRd=rdfs(depth,node.right);
			/* 1
			 2   3 */
			if (leftLd==rightRd)
				return leftones // 同层左边的叶子个数
					+(1<<(leftLd-depth)) // 当前满二叉树底层叶子个数
					+(1<<(maxdepth-1))-1; // 底层之上满二叉树叶子个数
			int rightLd=ldfs(depth,node.right);
			/* 1
			 2   3
			4 */
			if (leftLd>rightLd)
			{
				node=node.left;
				continue;
			}
			/* 1
			 2   3
			4 5 6 */
			int leftRd=rdfs(depth,node.left);
			if (leftRd>rightRd)
			{
				// 如果进入右子树寻找，即左侧是满的，则加上当前节点左子树的叶子个数
				leftones+=1<<(maxdepth-depth-1);
				node=node.right;
			}
		}
	}
}
