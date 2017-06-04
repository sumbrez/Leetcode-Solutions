/*
120. Triangle
https://leetcode.com/problems/triangle/

Java 11 ms
*/

public class Solution {
	int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public int minimumTotal(List<List<Integer>> triangle) {
		int size=triangle.get(triangle.size()-1).size();
		int dp[][]=new int[size][size];
		for (int i=0;i<size;i++)
		{
			List<Integer> lst=triangle.get(i);
			for (int j=0;j<=i;j++)
				dp[i][j]=lst.get(j);
		}
		for (int i=size-2;i>=0;i--)
			for (int j=0;j<=i;j++)
				dp[i][j]+=imin(dp[i+1][j],dp[i+1][j+1]);
		return dp[0][0];
	}
}
