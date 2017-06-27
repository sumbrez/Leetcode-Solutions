/*
228. Summary Ranges
https://leetcode.com/problems/summary-ranges/
*/

// 0ms
import java.util.*;

public class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> ret=new ArrayList<String>();
		int len=nums.length;
		if (len==0) return ret;
		for (int i=0;i<len;)
		{
			int st=nums[i++],ed=st;
			while (i<len&&ed+1==nums[i])
			{
				ed=nums[i];
				i++;
			}
			String s=null;
			if (st==ed)
				s=String.valueOf(st);
			else
				s=String.valueOf(st)+"->"+String.valueOf(ed);
			ret.add(s);
		}
		return ret;
	}
}
