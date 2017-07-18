/*
399. Evaluate Division
https://leetcode.com/problems/evaluate-division/
*/

// 4ms
import java.util.*;

public class Solution {
	class Edge
	{
		int v;
		double val;
		Edge(int v,double val)
		{
			this.v=v;
			this.val=val;
		}
	}
	Map<String,Integer> mp;
	List<Edge> ajlst[];
	int n;

	// bfs寻找路径，如果有路径则唯一，所以不涉及更新dist，也不用in数组
	// 也没有了根据距离是否更近来避免回环，但是一个公式最多用一次，所以用这一点避免重复回环
	double getRes(int src,int des)
	{
		Queue<Integer> qu=new LinkedList<Integer>();
		qu.offer(src);
		double dist[]=new double[n];
		dist[src]=1;
		boolean visit[][]=new boolean[n][n];
		while (!qu.isEmpty())
		{
			int u=qu.poll();
			if (u==des) return dist[des];
			for (Edge e:ajlst[u])
			{
				int v=e.v;
				if (visit[u][v]) continue;
				dist[v]=dist[u]*e.val;
				qu.offer(v);
				visit[u][v]=visit[v][u]=true;
			}
		}
		return -1.0;
	}
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		mp=new HashMap<String,Integer>();
		String equ[][]=equations;
		
		// 统计节点数
		n=0;
		int eqlen=equ.length;
		for (int i=0;i<eqlen;i++)
		{
			if (mp.containsKey(equ[i][0])==false)
				mp.put(equ[i][0],n++);
			if (mp.containsKey(equ[i][1])==false)
				mp.put(equ[i][1],n++);
		}
		
		// 邻接表构图
		ajlst=new List[n];
		for (int i=0;i<n;i++)
			ajlst[i]=new ArrayList<Edge>();
		for (int i=0;i<eqlen;i++)
		{
			int u=mp.get(equ[i][0]),v=mp.get(equ[i][1]);
			ajlst[u].add(new Edge(v,values[i]));
			ajlst[v].add(new Edge(u,1/values[i]));
		}
		
		// 处理询问
		int qlen=queries.length;
		double ret[]=new double[qlen];
		for (int i=0;i<qlen;i++)
		{
			String us=queries[i][0],vs=queries[i][1];
			if (mp.containsKey(us)==false||mp.containsKey(vs)==false)
				ret[i]=-1.0;
			else
				ret[i]=getRes(mp.get(us),mp.get(vs));
		}
		return ret;
	}
}
