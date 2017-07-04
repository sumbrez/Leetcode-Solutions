/*
309. Best Time to Buy and Sell Stock with Cooldown
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
*/


// O(1)空间
public class Solution {
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	public int maxProfit(int[] prices) {
		int len=prices.length;
		if (len<=1) return 0;
		int buy,sell=0,sellnew,idle=0,idlenew;
		buy=-prices[0];
		int ret=Integer.MIN_VALUE,maxbuy=buy;
		for (int i=1;i<len;i++)
		{
			buy=idle-prices[i];
			maxbuy=imax(maxbuy,buy);
			sellnew=maxbuy+prices[i];
			idlenew=imax(sell,idle);
			ret=imax(ret,sellnew);
			
			sell=sellnew;
			idle=idlenew;
		}
		return ret;
	}
}

// 15ms
public class Solution {
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	public int maxProfit(int[] prices) {
		int len=prices.length;
		if (len<=1) return 0;
		int buy[]=new int[len],sell[]=new int[len],idle[]=new int[len];
		buy[0]=-prices[0];
		int ret=Integer.MIN_VALUE,maxbuy=buy[0];
		for (int i=1;i<len;i++)
		{
			buy[i]=idle[i-1]-prices[i];
			maxbuy=imax(maxbuy,buy[i]);
			sell[i]=maxbuy+prices[i];
			idle[i]=imax(sell[i-1],idle[i-1]);
			ret=imax(ret,sell[i]);
		}
		return ret;
	}
}

// 49ms
public class Solution {
	int imax(int a,int b)
	{
		return a>b?a:b;
	}
	public int maxProfit(int[] prices) {
		int len=prices.length;
		if (len<=1) return 0;
		// 某天买、卖、什么都不干的最大收益
		int buy[]=new int[len],sell[]=new int[len],idle[]=new int[len];
		buy[0]=-prices[0];
		int ret=Integer.MIN_VALUE;
		for (int i=1;i<len;i++)
		{
			buy[i]=idle[i-1]-prices[i];
			for (int j=0;j<i;j++)
				sell[i]=imax(sell[i],buy[j]+prices[i]);
			idle[i]=imax(sell[i-1],idle[i-1]);
			// 最大收益一定以卖或什么都不干结束，而什么都不干不影响收益
			if (sell[i]>ret) ret=sell[i];
		}
		return ret;
	}
}
