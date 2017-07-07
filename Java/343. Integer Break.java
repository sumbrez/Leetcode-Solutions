/*
343. Integer Break
https://leetcode.com/problems/integer-break/
*/

// 0ms
// 证明尽可能分出更多的3，避免分出1
public class Solution {
	public int integerBreak(int n) {
		if (n<=3) return n-1;
		int ret=1;
		while (n>4)
		{
			ret*=3;
			n-=3;
		}
		ret*=n;
		return ret;
	}
}
