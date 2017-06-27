/*
223. Rectangle Area
https://leetcode.com/problems/rectangle-area/
*/

// 10ms
public class Solution {
	class ID implements Comparable<ID>
	{
		int id,val;
		ID(){}
		ID(int id,int val)
		{
			this.id=id;
			this.val=val;
		}
		// 从小到大排序
		public int compareTo(ID o)
		{
			return val-o.val;
		}
	}
	int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		ID x[]=new ID[4];
		x[0]=new ID(1,A); x[1]=new ID(1,C); x[2]=new ID(2,E); x[3]=new ID(2,G);
		Arrays.sort(x);

		ID y[]=new ID[4];
		y[0]=new ID(1,B); y[1]=new ID(1,D); y[2]=new ID(2,F); y[3]=new ID(2,H);
		Arrays.sort(y);
		// 如果两个矩形不相交
		if (x[0].id==x[1].id&&x[0].val<x[1].val||
			y[0].id==y[1].id&&y[0].val<y[1].val)
			return (C-A)*(D-B)+(G-E)*(H-F);
		// 如果相交则用面积和-相交面积
		int dx=imin(x[2].val,x[3].val)-x[1].val;
		int dy=imin(y[2].val,y[3].val)-y[1].val;
		return (C-A)*(D-B)+(G-E)*(H-F)-dx*dy;
	}
}
