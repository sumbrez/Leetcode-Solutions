/*
334. Increasing Triplet Subsequence
https://leetcode.com/problems/increasing-triplet-subsequence/
*/

// 13ms
public class Solution {
	public boolean increasingTriplet(int[] nums) {
		int min=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
		int len=nums.length;
		if (len<=2) return false;
		// 对于2,3,1,6数据
		for (int i=0;i<len;i++)
			// 这里只判断了nums[i]和min2，如果min被替换为更小的则没影响
			if (nums[i]>min2)
				return true;
			else if (nums[i]<min)
				min=nums[i];
			else if (nums[i]<min2&&nums[i]>min)
				min2=nums[i];
		return false;
	}
}
