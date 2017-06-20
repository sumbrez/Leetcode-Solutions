/*
198. House Robber
https://leetcode.com/problems/house-robber/
*/

// 0ms
public class Solution {
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	public int rob(int[] nums) {
		int len=nums.length;
		if (len==0) return 0;
		int dp[][]=new int[len][2]; // dp[i][0/1]：不选/选第i位的情况下总额
		dp[0][1]=nums[0];
		for (int i=1;i<len;i++)
		{
			dp[i][0]=imax(dp[i-1][0],dp[i-1][1]);
			dp[i][1]=dp[i-1][0]+nums[i];
		}
		return imax(dp[len-1][0],dp[len-1][1]);
	}
}
