/*
201. Bitwise AND of Numbers Range
https://leetcode.com/problems/bitwise-and-of-numbers-range/
*/

// 10ms
public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		if (m==0) return 0;
		int len1=0,mm=m;
		while (mm>0)
		{
			len1++;
			mm>>=1;
		}
		long mx=1<<len1; // 1<<31会变为-1，所以用long
		if (mx>n) mx=n;
		int sumcnt=0;
		for (long i=m;i<=mx;i++)
		{
			m&=i;
			mm=m;
			int cnt=0;
			// 某一位为0则之后一定为0，但记录所有的0反而复杂，所以记录末尾的0
			while (mm>0&&(mm&1)==0)
			{
				mm>>=1;
				cnt++; // 本次末尾0的个数
			}
			i>>=cnt; // 不再考虑这些0
			m>>=cnt;
			mx>>=cnt;
			sumcnt+=cnt; // 一共去掉了多少个0
		}
		return m<<sumcnt; // 补上去掉的0
	}
}
