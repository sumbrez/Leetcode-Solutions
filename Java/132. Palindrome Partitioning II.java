/*
132. Palindrome Partitioning II
https://leetcode.com/problems/palindrome-partitioning-ii/
*/

// 16ms
public class Solution {
	int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public int minCut(String s) {
		char ch[]=s.toCharArray();
		int slen=s.length();
		int dp[]=new int[slen+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0]=0;
		for(int i=0;i<slen;i++)
		{
			dp[i+1]=imin(dp[i+1],dp[i]+1);
			for(int j=1;i-j>=0&&i+j<=slen-1;j++)
			{
				if (ch[i-j]!=ch[i+j])
					break;
				dp[i+j+1]=imin(dp[i+j+1],dp[i-j]+1);
			}
			for(int j=0;i-j>=0&&i+j+1<=slen-1;j++) {
				if (ch[i-j]!=ch[i+j+1]) break;
				dp[i+j+2]=imin(dp[i+j+2],dp[i-j]+1);
			}
		}
		return dp[slen]-1;
	}
}
