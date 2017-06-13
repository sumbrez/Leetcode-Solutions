/*
153. Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/

// 1ms
// O(logn)
public class Solution {
	public int findMin(int[] nums) {
		int retidx=0;
		int st=0,ed=nums.length-1,mid=0;
		while (st<ed)
		{
			mid=(st+ed)/2;
			if (nums[mid]>nums[ed])
				retidx=st=mid+1;
			else if (nums[st]>nums[mid])
				retidx=ed=mid;
			else
				return nums[st];
		}
		return nums[retidx];
	}
}
