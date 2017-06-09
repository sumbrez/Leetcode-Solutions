/*
133. Clone Graph
https://leetcode.com/problems/clone-graph/
*/

// 9ms
// dfs不好做，因为函数内的new似乎会被回收
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node==null) return null;
		UndirectedGraphNode ret=new UndirectedGraphNode(0);
		Queue<UndirectedGraphNode> qu=new LinkedList<UndirectedGraphNode>(),
				retqu=new LinkedList<UndirectedGraphNode>();
		qu.offer(node);
		retqu.offer(ret);
		// mp根据label记录哪些节点new过了
		Map<Integer,UndirectedGraphNode> mp=new HashMap<Integer,UndirectedGraphNode>();
		mp.put(node.label,ret); // 此处是ret
		while (!qu.isEmpty())
		{
			UndirectedGraphNode u=qu.poll(),ru=retqu.poll();
			ru.label=u.label;
			for (int i=0;i<u.neighbors.size();i++)
			{
				int label=u.neighbors.get(i).label;
				if (mp.containsKey(label)) // 如果new过了，给引用
					ru.neighbors.add(mp.get(label));
				else // 否则new
				{
					UndirectedGraphNode newnode=new  UndirectedGraphNode(label);
					ru.neighbors.add(newnode);
					qu.offer(u.neighbors.get(i));
					retqu.offer(ru.neighbors.get(i));
					mp.put(label,newnode);
				}
			}
		}
		return ret;
	}
}
