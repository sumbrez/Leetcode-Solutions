/*
152. Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/
*/

// 9ms
public class Solution {
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public int maxProduct(int[] nums) {
		int len=nums.length,ret;
		int dpmx[]=new int[len],dpmi[]=new int[len];
		ret=dpmx[0]=dpmi[0]=nums[0];
		for (int i=1;i<len;i++)
		{
			dpmx[i]=imax(dpmx[i],dpmx[i-1]*nums[i]);
			dpmx[i]=imax(dpmx[i],dpmi[i-1]*nums[i]);
			dpmx[i]=imax(dpmx[i],nums[i]);
			dpmi[i]=imin(dpmi[i],dpmi[i-1]*nums[i]);
			dpmi[i]=imin(dpmi[i],dpmx[i-1]*nums[i]);
			dpmi[i]=imin(dpmi[i],nums[i]);
			if (dpmx[i]>ret) ret=dpmx[i];
		}
		return ret;
	}
}
