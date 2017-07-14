/*
365. Water and Jug Problem
https://leetcode.com/problems/water-and-jug-problem/
*/

// 0ms
public class Solution {
	// z必须可以除尽x和y的最大公约数
	int gcd(int a,int b)
	{
		int r;
		while (b>0)
		{
			r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
	public boolean canMeasureWater(int x, int y, int z) {
		if (z==0) return true;
		if (z>(x+y)) return false;
		if (x%2==0&&y%2==0&&z%2==1) return false;
		return z%gcd(x,y)==0;
	}
}
