/*
199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/
*/

// 4ms
import java.util.*;

public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> qu=new LinkedList<TreeNode>();
		Queue<Integer> dqu=new LinkedList<Integer>(); // depth
		// 利用map.put的替换更新特点直接记录每层最右的（最后出现的）
		Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
		qu.offer(root);
		dqu.offer(1); // 起始深度随便
		int maxdepth=0;
		while (!qu.isEmpty())
		{
			TreeNode node=qu.poll();
			if (node==null) continue;
			int depth=dqu.poll();
			if (depth>maxdepth) maxdepth=depth;
			mp.put(depth,node.val);
			if (node.left!=null)
			{
				qu.offer(node.left);
				dqu.offer(depth+1);
			}
			if (node.right!=null)
			{
				qu.offer(node.right);
				dqu.offer(depth+1);
			}
		}
		List<Integer> ret=new ArrayList<Integer>();
		for (int i=1;i<=maxdepth;i++)
			ret.add(mp.get(i));
		return ret;
	}
}
