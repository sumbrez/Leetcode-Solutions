/*
310. Minimum Height Trees
https://leetcode.com/problems/minimum-height-trees/#
*/

// 按照拓扑排序方式去掉一层一层叶子，但同层叶子必须一同去掉，所以不用bfs+队列
public class Solution {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) return Collections.singletonList(0);
		List<Integer> leaves = new ArrayList<>();
		List<Set<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		for (int i = 0; i < n; ++i) {
			if (adj.get(i).size() == 1) leaves.add(i);
		}
		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
				int t = adj.get(i).iterator().next();
				adj.get(t).remove(i);
				if (adj.get(t).size() == 1) newLeaves.add(t);
			}
			leaves = newLeaves;
		}
		return leaves;
	}
}
