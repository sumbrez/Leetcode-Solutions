/*
287. Find the Duplicate Number
https://leetcode.com/problems/find-the-duplicate-number/
*/

// 1ms
public class Solution {
	public int findDuplicate(int[] nums) {
		int slow=0,fast=0;
		do
		{
			slow=nums[slow];
			fast=nums[nums[fast]];
		}
		while (slow!=fast);
		fast=0;
		while (slow!=fast)
		{
			slow=nums[slow];
			fast=nums[fast];
		}
		return fast;
	}
}
