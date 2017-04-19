/*
018. 4Sum
https://leetcode.com/problems/4sum/

java 60 ms
*/

public class Solution {
	public HashSet<List<Integer>> hret;
	public List<List<Integer>> ret;
	public int nlen;
	public void twoSum(int nums[],int _pos,int pos,int target)
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
				int temp[]=new int[]{nums[_pos],nums[pos],nums[i++],nums[j--]};
				Arrays.sort(temp);
				lst.add(temp[0]);
				lst.add(temp[1]);
				lst.add(temp[2]);
				lst.add(temp[3]);
				hret.add(lst);
			}
		}
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		ret=new ArrayList<List<Integer>>();
		hret=new HashSet<List<Integer>>();
		nlen=nums.length;
		if (nlen<4) return ret;
		
		// 预先对个数大于4个的数去重至4个
		// 相同的数的个数记在第一个数的下标处
		int cnt[]=new int[nlen],last=0,delsum=0;
		cnt[last]=1;
		for (int i=1;i<nlen;i++)
			if (nums[last]==nums[i])
				cnt[last]++;
			else
				cnt[last=i]++;
		for (int i=0;i<nlen;i+=cnt[i])
			if (cnt[i]>4)
			{
				for (int j=4;j<cnt[i];j++)
					nums[i+j]=Integer.MAX_VALUE;
				delsum+=cnt[i]-4;
			}
		Arrays.sort(nums);
		nlen-=delsum;
		// 不加这一块儿预先去重，本地跑得全0数据挺快的啊……
		
		for (int i=0;i<nlen;i++) // 固定一个数
			for (int j=i+1;j<nlen;j++) // 固定第二个
				twoSum(nums,i,j,target-nums[i]-nums[j]);
		ret.addAll(hret);
		return ret;
	}
}
