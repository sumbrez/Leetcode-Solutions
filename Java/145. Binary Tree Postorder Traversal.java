/*
145. Binary Tree Postorder Traversal
https://leetcode.com/problems/binary-tree-postorder-traversal/
*/

// 2ms
public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret=new ArrayList<Integer>();
		Stack<TreeNode> stk=new Stack<TreeNode>();
		Stack<Integer> sret=new Stack<Integer>();
		stk.push(root);
		while (!stk.isEmpty())
		{
			TreeNode node=stk.pop();
			if (node==null) continue;
			stk.push(node.left);
			stk.push(node.right);
			sret.add(node.val);
		}
		while (!sret.isEmpty())
			ret.add(sret.pop());
		return ret;
    }
}
