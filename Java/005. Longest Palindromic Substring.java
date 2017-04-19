/*
005. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/

java 32 ms
*/

public class Solution {
	public int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public String longestPalindrome(String s) {
		int len=s.length();
		// Java String是静态的，无法赋值或者改长度
		char []ss=new char[len*2+1];
		ss[len*2]='#'; // 首尾添加#以方便最后取出原串
		for (int i=0;i<len;i++)
		{
			ss[i*2]='#';
			ss[i*2+1]=s.charAt(i);
		}
		len=len*2+1;
		int R[]=new int[len],right=1,rpos=0,mxR=1,mxpos=0;
		// 第一个位置('#')的信息直接确定
		for (int i=1;i<len;i++)
		{
			if (i<right)
				R[i]=imin(R[rpos*2-i],right-i+1);
			else
				R[i]=1;
			int idx=i+R[i];
			while (idx<len&&(i*2-idx)>=0
				&&ss[idx]==ss[i*2-idx])
			{
				R[i]++;
				idx++;
			}
			// right以当前走到的最右为基准，即idx
			// 同时需要记录rpos用于上边的imin
			if (right<idx-1)
			{
				right=idx-1;
				rpos=i;
			}
			if (mxR<R[i])
			{
				mxR=R[i];
				mxpos=i;
			}
		}
		char ret[]=new char[mxR-1];
		// 回文串的两端一定是'#'
		right=mxpos+mxR-2;
		System.out.printf("%d %d\n",mxpos,mxR);
		for (int i=mxpos-mxR+2,j=0;i<=right;i++)
			if (ss[i]!='#')
				ret[j++]=ss[i];
		// ret.toString();返回的是地址？
		return String.valueOf(ret); // 不需要以'\0'结尾
	}
}
