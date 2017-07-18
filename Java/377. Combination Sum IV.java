/*
377. Combination Sum IV
https://leetcode.com/problems/combination-sum-iv/
*/

// 4ms
import java.util.*;

public class Solution {
	public int combinationSum4(int[] nums, int target) {
		int len=nums.length;
		Arrays.sort(nums);
		int dp[]=new int[target+1];
		dp[0]=1;
		for (int i=1;i<=target;i++)
			for (int e:nums)
			{
				if (e>i) break;
				dp[i]+=dp[i-e];
			}
		return dp[target];
	}
}
