/*
264. Ugly Number II
https://leetcode.com/problems/ugly-number-ii/
*/

// 8ms
import java.util.*;

public class Solution {
	int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public int nthUglyNumber(int n) {
		int arr[]=new int[n],size=1;
		arr[0]=1;
		int i2=0,i3=0,i5=0;
		while (size<n)
		{
			int m2=arr[i2]*2,m3=arr[i3]*3,m5=arr[i5]*5;
			int mn=imin(m2,imin(m3,m5));
			if (mn==m2) i2++; // 这个数乘过2了
			if (mn==m3) i3++;
			if (mn==m5) i5++;
			arr[size++]=mn;
		}
		return arr[size-1];
	}
}
