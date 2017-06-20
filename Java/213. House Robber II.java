/*
213. House Robber II
https://leetcode.com/problems/house-robber-ii/
*/

// 1ms
public class Solution {
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	public int rob(int[] nums) {
		int len=nums.length;
		if (len==0) return 0;
		int dp0on[][]=new int[len][2]; // 固定选中第1个
		int dp0off[][]=new int[len][2]; // 固定不选第1个
		// dp0on/off[i][0/1]：不选/选第i个的情况下总额，dp0on/off[0]的意义略有变化
		dp0on[0][1]=nums[0];
		for (int i=1;i<len;i++)
		{
			dp0on[i][0]=imax(dp0on[i-1][0],dp0on[i-1][1]); // 不选这一个则前一个随便
			if (1<i&&i<len-1) // 在固定选第1个的情况下，第一个两边的不能选择
				dp0on[i][1]=dp0on[i-1][0]+nums[i];
			// 第1个不选则保持不变
			dp0off[i][0]=imax(dp0off[i-1][0],dp0off[i-1][1]);
			dp0off[i][1]=dp0off[i-1][0]+nums[i];
		}
		return imax(imax(dp0on[len-1][0],dp0on[len-1][1])
				,imax(dp0off[len-1][0],dp0off[len-1][1]));
	}
}
