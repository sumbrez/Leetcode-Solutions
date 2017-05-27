/*
039. Combination Sum
https://leetcode.com/problems/combination-sum/

Java 28 ms
*/

public class Solution {
	List<List<Integer>> ret;
	int nums[];
	int len;
	void dfs(int pos,int tg,ArrayList<Integer> lst)
	{
		if (tg==0)
		{
			Collections.sort(lst);
			ArrayList<Integer> temp=(ArrayList<Integer>)lst.clone();
			ret.add(temp);
			return;
		}
		if (tg<0) return;
		for (int i=pos;i<len;i++)
		{
			int lstlen=lst.size();
			lst.add(nums[i]);
			// 此处用i而不是pos
			dfs(i,tg-nums[i],lst);
			lst.remove(lstlen);
		}
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// “外层”List需要指定为Array，“内层”由其自己决定
		ret=new ArrayList<List<Integer>>();
		nums=candidates;
		len=nums.length;
		Arrays.sort(nums);
		for (int i=0;i<len;i++)
		{
			ArrayList<Integer> tmp=new ArrayList<Integer>();
			tmp.add(nums[i]);
			// 包含i之前的数的结果已经找完
			dfs(i,target-nums[i],tmp);
		}
		return ret;
	}
}
