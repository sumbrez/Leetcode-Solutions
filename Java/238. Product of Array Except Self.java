/*
238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/
*/

// ms
public class Solution {
	public int[] productExceptSelf(int[] nums) {
		int len=nums.length;
		if (len==1) return new int[]{1};
		int ret[]=new int[len];
		int leftp[]=new int[len],rightp[]=new int[len];
		leftp[0]=nums[0];
		rightp[len-1]=nums[len-1];
		for (int i=1;i<len;i++)
			leftp[i]=leftp[i-1]*nums[i];
		for (int i=len-2;i>=0;i--)
			rightp[i]=rightp[i+1]*nums[i];
		ret[0]=rightp[1];
		ret[len-1]=leftp[len-2];
		for (int i=1;i<len-1;i++)
			ret[i]=leftp[i-1]*rightp[i+1];
		return ret;
	}
}
