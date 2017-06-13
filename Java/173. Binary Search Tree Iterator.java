/*
173. Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/
*/

// 10ms
public class BSTIterator {
	// 中序遍历，vstk栈则相反
	TreeNode cur;
	Stack<TreeNode> stk;
	Stack<Integer> vstk;
	public BSTIterator(TreeNode root) {
		stk=new Stack<TreeNode>();
		vstk=new Stack<Integer>();
		TreeNode node=root;
		while(node!=null||!stk.empty())
		{
			if(node!=null)
			{
				stk.push(node);
				node=node.right;
			}
			else
			{
				node=stk.pop();
				vstk.push(node.val);
				node=node.left;
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !vstk.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (!vstk.isEmpty())
			return vstk.pop();
		return 0;
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
