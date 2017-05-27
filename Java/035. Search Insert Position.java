/*
035. Search Insert Position
https://leetcode.com/problems/search-insert-position/

Java 8 ms
*/

public class Solution {
	int bisearch(int nums[],int target)
	{
		int st=0,ed=nums.length-1,mid=0;
		while (st<=ed)
		{
			mid=(st+ed)/2;
			if (nums[mid]<target)
				st=mid+1;
			else if (nums[mid]>target)
				ed=mid-1;
			else
				break;
		}
		if (st<=ed)
			return mid;
		else
			return st;
	}
	public int searchInsert(int[] nums, int target) {
		int ret=bisearch(nums,target);
		return ret;
	}
}
