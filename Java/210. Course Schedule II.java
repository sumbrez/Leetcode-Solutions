/*
210. Course Schedule II
https://leetcode.com/problems/course-schedule-ii/
*/

// 10ms
import java.util.*;

public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int n=numCourses,edge[][]=prerequisites,elen=edge.length;;
		int degr[]=new int[n]; // 入度
		List<Integer> lst=new ArrayList<Integer>();
		List<Integer> aj[]=new List[n]; // 把边信息变为邻接表
		for (int i=0;i<n;i++)
			aj[i]=new ArrayList<Integer>();
		for (int i=0;i<elen;i++)
		{
			int u=edge[i][1],v=edge[i][0];
			aj[u].add(v);
			degr[v]++;
		}
		Queue<Integer> qu=new LinkedList<Integer>();
		for (int i=0;i<n;i++)
			if (degr[i]==0)
				qu.offer(i);
		while (!qu.isEmpty())
		{
			int u=qu.poll();
			lst.add(u);
			for (int v:aj[u])
				if (--degr[v]==0)
					qu.offer(v);
		}
		for (int i=0;i<n;i++)
			if (degr[i]>0)
				return new int[0];
		int ret[]=new int[lst.size()];
		for (int i=lst.size()-1;i>=0;i--)
			ret[i]=lst.get(i);
		return ret;
	}
}
