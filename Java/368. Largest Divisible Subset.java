/*
368. Largest Divisible Subset
https://leetcode.com/problems/largest-divisible-subset/
*/

// 62ms
import java.util.*;

public class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> ret=new ArrayList<Integer>();
		Arrays.sort(nums);
		int len=nums.length;
		if (len==0)
			return ret;
		int dp[]=new int[len],pre[]=new int[len];
		for (int i=0;i<len;i++)
		{
			dp[i]=1;
			pre[i]=-1;
		}
		int mx=0,mxp=0;
		for (int i=0;i<len;i++)
		{
			for (int j=0;j<i;j++)
			{
				if (nums[i]%nums[j]==0&&dp[i]<dp[j]+1)
				{
					dp[i]=dp[j]+1;
					pre[i]=j;
				}
			}
			if (dp[i]>mx)
			{
				mx=dp[i];
				mxp=i;
			}
		}
		while (mxp!=-1)
		{
			ret.add(nums[mxp]);
			mxp=pre[mxp];
		}
		return ret;
	}
}
