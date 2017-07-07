/*
347. Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/
*/

// 18ms
import java.util.*;

public class Solution {
	class Int implements Comparable<Int>
	{
		int val,cnt;
		Int(int val,int cnt)
		{
			this.val=val;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Int o2) {
			if (this.cnt<((Int)o2).cnt)
				return 1;
			// JDK 7：相等必须返回0，否则报比较器错误
			else if (this.cnt==((Int)o2).cnt)
				return 0;
			else
				return -1;
		}
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> ret=new ArrayList<Integer>();
		Arrays.sort(nums);
		int len=nums.length;
		List<Int> lst=new ArrayList<Int>();
		for (int i=0;i<len;)
		{
			int st=i,pre=nums[i++];
			while (i<len&&pre==nums[i])
				i++;
			lst.add(new Int(pre,i-st));
		}
		Int arr[]=new Int[lst.size()];
		arr=lst.toArray(arr);
		Arrays.sort(arr);
		for (int i=0;i<k;i++)
			ret.add(arr[i].val);
		return ret;
	}
}
