/*
221. Maximal Square
https://leetcode.com/problems/maximal-square/
*/

// 21ms
public class Solution {
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public int maximalSquare(char[][] matrix) {
		char mtx[][]=matrix;
		int rlen=mtx.length;
		if (rlen==0) return 0;
		int clen=mtx[0].length;
		int dp[][]=new int[rlen][clen];
		int max=0;
		for (int i=0;i<rlen;i++)
		{
			dp[i][0]=mtx[i][0]-'0';
			max=imax(max,dp[i][0]);
		}
		for (int j=0;j<clen;j++)
		{
			dp[0][j]=mtx[0][j]-'0';
			max=imax(max,dp[0][j]);
		}
		/*
		1 1 1 0
		1 1 1 1
		1 1 1 1
		0 1 1 1
		*/
		for (int i=1;i<rlen;i++)
			for (int j=1;j<clen;j++)
				if (mtx[i][j]=='1')
				{
					// dp[i-1][j],dp[i][j-1]大小相等且dp[i-1][j-1]更大则当前点构成新的正方形
					// 各不相等则只能构成比最小的大一的正方形，包含上边的情况
					dp[i][j]=imin(dp[i-1][j-1],imin(dp[i-1][j],dp[i][j-1]))+1;
					max=imax(dp[i][j],max);
				}
		return max*max;
	}
}
