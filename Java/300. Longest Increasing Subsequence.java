/*
300. Longest Increasing Subsequence
https://leetcode.com/problems/longest-increasing-subsequence/
*/

// 68ms
import java.util.Arrays;

public class Solution {
	public int lengthOfLIS(int[] nums) {
		int len=nums.length;
		if (len==0) return 0;
		int dp[]=new int[len],ret=1;
		Arrays.fill(dp,1);
		for (int i=1;i<len;i++)
			for (int j=0;j<i;j++)
				if (nums[i]>nums[j]&&dp[j]+1>dp[i])
					dp[i]=dp[j]+1;
		for (int i=0;i<len;i++)
			if (dp[i]>ret)
				ret=dp[i];
		return ret;
	}
}
