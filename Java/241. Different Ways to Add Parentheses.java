/*
241. Different Ways to Add Parentheses
https://leetcode.com/problems/different-ways-to-add-parentheses/
*/

// 5ms
import java.util.*;

public class Solution {
	List<Integer> ret,nums;
	List<Character> op;
	String s;
	int slen,size;
	int[] getval(int pos)
	{
		int val=0;
		for (;pos<slen;pos++)
		{
			int d=s.charAt(pos)-'0';
			if (d<0) break; // +-*
			val=val*10+d;
		}
		int ret[]=new int[]{val,pos};
		return ret;
	}
	List<Integer> dfs(int left,int right) // op下标
	{
		List<Integer> ret=new ArrayList<Integer>();
		if (left>right) return ret;
		char ch=op.get(left);
		for (int i=left;i<=right;i++)
		{
			List<Integer> llst=dfs(left,i-1);
			List<Integer> rlst=dfs(i+1,right);
			ch=op.get(i);
			if (llst.isEmpty())
				llst.add(nums.get(i));
			if (rlst.isEmpty())
				rlst.add(nums.get(i+1));
			if (ch=='+')
				for (int l:llst)
					for (int r:rlst)
						ret.add(l+r);
			else if (ch=='-')
				for (int l:llst)
					for (int r:rlst)
						ret.add(l-r);
			else
				for (int l:llst)
					for (int r:rlst)
						ret.add(l*r);
		}
		return ret;
	}
	public List<Integer> diffWaysToCompute(String input) {
		nums=new ArrayList<Integer>();
		op=new ArrayList<Character>();
		s=input;
		slen=s.length();
		if (slen==0) return new ArrayList<Integer>();
		int pos=0;
		size=0;
		while (pos<slen)
		{
			char ch=s.charAt(pos);
			if (ch>='0')
			{
				int t[]=getval(pos);
				pos=t[1];
				nums.add(t[0]);
				size++;
			}
			else
			{
				pos++;
				op.add(ch);
			}
		}
		if (size==1)
		{
			ret=new ArrayList<Integer>();
			ret.add(nums.get(0));
		}
		else
			ret=dfs(0,size-2);
		return ret;
	}
}
