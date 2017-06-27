/*
209. Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/
*/

// 2ms
// 记录从head到tail的sum，不够sum则tail++，够s则进行head--知道再次不够sum
public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		int len=nums.length;
		if (len==0) return 0;
		int ret=Integer.MAX_VALUE;
		for (int i=0;i<len;i++)
			if (nums[i]>=s)
				return 1;
		int head=0,tail=0,sum=0,cnt=0;
		for (;tail<len;tail++)
		{
			sum+=nums[tail];
			cnt++;
			boolean flag=false; // 是否进行while循环的标记
			if (sum>=s)
			{
				if (cnt<ret) ret=cnt;
				flag=true;
			}
			while (sum>=s&&head<=tail)
			{
				sum-=nums[head++];
				cnt--;
			}
			// 结束while循环意味着最后减去的那个数使得sum<s
			// 也有可能是head>tail，这种情况一定是ret为1，此处不必考虑
			if (flag&&cnt+1<ret)
				ret=cnt+1;
		}
		if (ret<Integer.MAX_VALUE)
			return ret;
		else
			return 0;
	}
}
