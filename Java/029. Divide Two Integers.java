/*
029. Divide Two Integers
https://leetcode.com/problems/divide-two-integers/

java 39 ms
*/

public class Solution {
	public int divide(int dividend, int divisor) {
		long a=dividend,b=divisor;
		if (b==0||a==Integer.MIN_VALUE&&b==-1)
			return Integer.MAX_VALUE;
		long flag=0,ret=0,r=1;
		if (a<0)
		{
			flag^=1;
			a=-a;
		}
		if (b<0)
		{
			flag^=1;
			b=-b;
		}
		
		long _b=b;
		if (b==1) ret=a;
		else if (b==2) ret=a>>1;
		else
			while (b<=a)
			{
				// 快速减的思路
				while (b<=a)
				{
					ret+=r;
					a-=b;
					r+=r;
					b+=b;
				}
				// b大到一定数会大于余下的a
				// 但此时a可能大于原来的b，所以重复从_b开始
				b=_b;
				r=1;
			}
		if (flag==1) ret=-ret;
		return (int)ret;
	}
}
