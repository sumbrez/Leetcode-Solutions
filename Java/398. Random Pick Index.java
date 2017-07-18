/*
398. Random Pick Index
https://leetcode.com/problems/random-pick-index/
*/

// 567ms
import java.util.Arrays;
import java.util.Random;

public class Solution {

	class Num implements Comparable<Num>
	{
		int val,id;
		
		public Num(int val,int id)
		{
			this.val=val;
			this.id=id;
		}
		
		@Override
		public int compareTo(Num arg0) {
			if (val==arg0.val)
				return 0;
			else if (val>arg0.val)
				return 1;
			else
				return -1;
		}
	}
	
	Num arr[];
	int len;
	Random random=new Random();
	
    // left==true则寻找最左边的t，否则寻找最右边的t
	int bisearch(int t,boolean left)
	{
		int st=0,ed=len,mid=-1;
		while (st<ed)
		{
			mid=(st+ed)/2;
			if (t>arr[mid].val)
				st=mid+1;
			else if (t<arr[mid].val)
				ed=mid;
			else
			{
				if (left&&mid>0&&arr[mid-1].val==t)
					ed=mid;
				else if (!left&&mid<len-1&&arr[mid+1].val==t)
					st=mid+1;
				else
					break;
			}
		}
		return mid;
	}
	public Solution(int[] nums) {
		len=nums.length;
		arr=new Num[len];
		for (int i=0;i<len;i++)
			arr[i]=new Num(nums[i],i);
		Arrays.sort(arr);
	}

	public int pick(int target) {
		int left=bisearch(target,true);
		int right=bisearch(target,false);
		int pos=random.nextInt(right-left+1)+left;
		return arr[pos].id;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
