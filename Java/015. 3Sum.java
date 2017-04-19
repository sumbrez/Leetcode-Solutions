/*
015. 3Sum
https://leetcode.com/problems/3sum/

java 147 ms
*/

public class Solution {
	public HashSet<List<Integer>> hret;
	public List<List<Integer>> ret;
	public int nlen;
	public void twoSum(int nums[],int pos,int target)
	{
		// 已排序，所以从两端向中间找
		// 包含nums[0~i-1]中的数的结果已经找完，不用再考虑
		int i=pos+1,j=nlen-1;
		while (i<j)
		{
			int sum=nums[i]+nums[j];
			if (sum<target) i++;
			else if (sum>target) j--;
			else
			{
				List<Integer> lst=new ArrayList<Integer>();
				int temp[]=new int[]{nums[pos],nums[i++],nums[j--]};
				Arrays.sort(temp);
				lst.add(temp[0]);
				lst.add(temp[1]);
				lst.add(temp[2]);
				hret.add(lst);
			}
		}
	}
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		ret=new ArrayList<List<Integer>>();
		hret=new HashSet<List<Integer>>();
		nlen=nums.length;
		if (nlen<3) return ret;
		
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
		
		for (int i=0;i<nlen;i++) // 固定一个数
			twoSum(nums,i,-nums[i]);
		ret.addAll(hret);
		return ret;
	}
}
