/*
034. Search for a Range
https://leetcode.com/problems/search-for-a-range/

Java 8 ms
*/

public class Solution {
	// offset：-1表示找最左边的target，1表示找最右边的
	int bisearch(int nums[],int target,int offset)
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
			{
				int pos=mid+offset;
				// 如果在offset一侧还有target，则继续找
				if (0<=pos&&pos<nums.length&&nums[pos]==target)
				{
					if (offset==-1)
						ed=mid-1;
					else
						st=mid+1;
				}
				else
					break;
			}
		}
		if (st<=ed)
			return mid;
		else
			return -1;
	}
	public int[] searchRange(int[] nums, int target) {
		int ret[]=new int[2];
		ret[0]=bisearch(nums,target,-1);
		ret[1]=bisearch(nums,target,1);
		return ret;
	}
}
