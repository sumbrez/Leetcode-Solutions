/*
279. Perfect Squares
https://leetcode.com/problems/perfect-squares/
*/

// 4ms
public class Solution {
	public int numSquares(int n) {
		// 任何正整数都可由4个数的平方构成
		// 满足4^k(8m+7)之外的数可由3个数构成
		int t=n;
		while ((t&3)==0) // 后两位为0
			t>>=2;
		if ((t-7)%8==0) // 满足条件则为4
			return 4;
		int floor=(int)Math.floor(Math.sqrt(n));
		// 开方结果为整数
		if (floor==(int)Math.ceil(Math.sqrt(n)))
			return 1;
		while (floor>0)
		{
			t=n-floor*floor;
			if ((int)Math.floor(Math.sqrt(t))==
				(int)Math.ceil(Math.sqrt(t)))
				return 2;
			floor--;
		}
		return 3;
	}
}
