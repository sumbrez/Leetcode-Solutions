/*
322. Coin Change
https://leetcode.com/problems/coin-change/
*/

// 23sm
import java.util.Arrays;

public class Solution {
	int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public int coinChange(int[] coins, int amount) {
		int len=coins.length;
		if (amount==0||len==0) return -1;
		int dp[]=new int[amount+1];
		Arrays.fill(dp,0x3f3f3f3f);
		Arrays.sort(coins);
		dp[0]=0;
		for (int i=1;i<=amount;i++)
			for (int j=0;j<len;j++)
			{
				if (i<coins[j]) break;
				dp[i]=imin(dp[i],dp[i-coins[j]]+1);
			}
		if (dp[amount]==0x3f3f3f3f) return -1;
		return dp[amount];
	}
}
