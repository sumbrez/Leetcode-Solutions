/*
229. Majority Element II
https://leetcode.com/problems/majority-element-ii/
*/

// 3ms
import java.util.*;

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> ret=new ArrayList<Integer>();
		int len=nums.length,t=len/3,MAX=Integer.MAX_VALUE;
		int e1=MAX,cnt1=0,e2=MAX,cnt2=0;
		for (int i=0;i<len;i++)
		{
			// 优先检查是否是备选众数
			if (nums[i]==e1)
				cnt1++;
			else if (nums[i]==e2)
				cnt2++;
			// 其次检查众数是否为空
			else if (e1==MAX)
			{
				e1=nums[i];
				cnt1=1;
			}
			else if (e2==MAX)
			{
				e2=nums[i];
				cnt2=1;
			}
			else
			{
				if (--cnt1==0) e1=MAX;
				if (--cnt2==0) e2=MAX;
			}
		}
		// 检验是否>t次
		cnt1=cnt2=0;
		for (int i=0;i<len;i++)
			if (nums[i]==e1)
				cnt1++;
			else if (nums[i]==e2)
				cnt2++;
		if (cnt1>t) ret.add(e1);
		if (cnt2>t) ret.add(e2);
		return ret;
	}
}
