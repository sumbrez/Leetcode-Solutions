/*
154. Find Minimum in Rotated Sorted Array II
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
*/

// #153的做法不适用例如3 3 3 3 3的例子，无法知道该往左还是右，两边都考虑则退化为O(n)
// 1ms
public class Solution {
	public int findMin(int[] nums) {
		int ret=Integer.MAX_VALUE;
		for (int i=nums.length-1;i>=0;i--)
			if (ret>nums[i])
				ret=nums[i];
		return ret;
	}
}
