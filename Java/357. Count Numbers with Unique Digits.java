/*
357. Count Numbers with Unique Digits
https://leetcode.com/problems/count-numbers-with-unique-digits/
*/

// 0ms
public class Solution {
	public int countNumbersWithUniqueDigits(int n) {
		if (n==0) return 1;
		if (n==1) return 10;
		if (n>=10) n=10;
		int ret=91,cnt=81,d=8;
		for (int i=3;i<=n;i++)
			ret+=cnt*=d--;
		return ret;
	}
}
