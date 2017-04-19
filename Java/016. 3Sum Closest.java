/*
016. 3Sum Closest
https://leetcode.com/problems/3sum-closest/

java 19 ms
*/

public class Solution {
	public int nlen;
	public int tg;
	public int min_d;
	public int ret;
	public int iabs(int a)
	{
		return a<0?-a:a;
	}
	public void twoSumClosest(int nums[],int pos)
	{
		// 已排序，所以从两端向中间找
		// 包含nums[0~i-1]中的数的结果已经找完，不用再考虑
		int i=pos+1,j=nlen-1;
		while (i<j)
		{
			int sum=nums[pos]+nums[i]+nums[j]
				,delta=iabs(sum-tg);
			if (delta<min_d)
			{
				min_d=delta;
				ret=sum;
			}
			
			if (sum<tg) i++;
			else if (sum>tg) j--;
			else return;
		}
	}
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		nlen=nums.length;
		tg=target;
		min_d=Integer.MAX_VALUE;
		ret=Integer.MAX_VALUE;
		
		// 预先对个数大于3个的数去重至3个
		// 相同的数的个数记在第一个数的下标处
		int cnt[]=new int[nlen],last=0,delsum=0;
		cnt[last]=1;
		for (int i=1;i<nlen;i++)
			if (nums[last]==nums[i])
				cnt[last]++;
			else
				cnt[last=i]++;
		for (int i=0;i<nlen;i+=cnt[i])
			if (cnt[i]>3)
			{
				for (int j=3;j<cnt[i];j++)
					nums[i+j]=Integer.MAX_VALUE;
				delsum+=cnt[i]-3;
			}
		Arrays.sort(nums);
		nlen-=delsum;
		// 不加这一块儿预先去重，本地跑得全0数据挺快的啊……
		
		for (int i=0;i<nlen&&ret!=target;i++) // 固定一个数
			twoSumClosest(nums,i);
		return ret;
	}
}
