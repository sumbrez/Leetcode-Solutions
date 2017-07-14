/*
376. Wiggle Subsequence
https://leetcode.com/problems/wiggle-subsequence/
*/

// 11ms
import java.util.Arrays;

public class Solution {
	public int wiggleMaxLength(int[] nums) {
		int len=nums.length,mx=1;
		if (len==0) return 0;
		if (len==1) return 1;
		int dp[][]=new int[len][2];
		Arrays.fill(dp[0],1);
		Arrays.fill(dp[1],1);
		for (int i=0;i<len;i++)
			for (int j=0;j<i;j++)
			{
				// 注意[0]/[1]的变换
				if (nums[j]<nums[i]&&dp[j][0]+1>dp[i][1])
				{
					dp[i][1]=dp[j][0]+1;
					if (dp[i][1]>mx) mx=dp[i][1];
				}
				if (nums[j]>nums[i]&&dp[j][1]+1>dp[i][0])
				{
					dp[i][0]=dp[j][1]+1;
					if (dp[i][0]>mx) mx=dp[i][0];
				}
			}
		return mx;
	}
}
