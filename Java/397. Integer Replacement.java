/*
397. Integer Replacement
https://leetcode.com/problems/integer-replacement/
*/

// 4ms
public class Solution {
	public int integerReplacement(int n) {
		int ret=0;
		while (n>1)
		{
			// 当前尾部0直接去掉
			while (n>1&&n%2==0)
			{
				ret++;
				n>>=1;
			}
			if (n==1)
				break;
			// 尾部为3
			else if (n==3)
			{
				ret+=2;
				break;
			}

			// 统计当前尾部1的个数
			int cnt1=0,nn=n;
			while (nn>=1&&nn%2==1)
			{
				cnt1++;
				nn>>=1;
			}

			// 如果1的个数大于1，则+1去0更优（这里1的个数一定大于2）
			if (cnt1>1)
			{
				ret+=1+cnt1;
				n=n+1>>cnt1;
			}
			else // 否则直接用两步去掉单独的1
			{
				ret+=2;
				n>>=1;
			}
		}
		return ret;
	}
}
