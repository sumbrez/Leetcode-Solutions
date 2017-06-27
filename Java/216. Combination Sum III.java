/*
216. Combination Sum III
https://leetcode.com/problems/combination-sum-iii/
*/

// 2ms
// 数据很小，直接暴力dfs。去重依旧是包含1的所有情况在dfs到2时都不用再考虑
import java.util.*;

public class Solution {
	int k,n;
	List<List<Integer>> ret;
	boolean flag[];
	void dfs(int pos,int cnt,int sum,List<Integer> lst)
	{
		if (cnt==k&&sum==n)
		{
			List<Integer> t=new ArrayList<Integer>(lst);
			ret.add(t);
			return;
		}
		if (cnt>k||sum>n) return;
		for (int i=pos+1;i<10;i++)
		{
			if (flag[i]) continue;
			lst.add(i);
			flag[i]=true;
			dfs(i,cnt+1,sum+i,lst);
			lst.remove(lst.size()-1);
			flag[i]=false;
		}
	}
	public List<List<Integer>> combinationSum3(int k, int n) {
		this.k=k;
		this.n=n;
		ret=new ArrayList<List<Integer>>();
		flag=new boolean[10];
		if (k<1||k>9||n<1||n>45) return ret;
		List<Integer> lst=new ArrayList<Integer>();
		for (int i=1;i<10;i++)
		{
			lst.add(i);
			dfs(i,1,i,lst);
			lst.remove(lst.size()-1);
		}
		return ret;
	}
}
