/*
144. Binary Tree Preorder Traversal
https://leetcode.com/problems/binary-tree-preorder-traversal/
*/

// 1ms
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret=new ArrayList<Integer>();
		Stack<TreeNode> stk=new Stack<TreeNode>();
		stk.push(root);
		while (!stk.isEmpty())
		{
			TreeNode node=stk.pop();
			if (node==null) continue;
			ret.add(node.val);
			stk.push(node.right);
			stk.push(node.left);
		}
		return ret;
	}
}
