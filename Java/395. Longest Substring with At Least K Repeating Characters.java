/*
395. Longest Substring with At Least K Repeating Characters
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
*/

// 90+ms
public class Solution {
	public int longestSubstring(String s, int k) {
		int slen=s.length();
		if (k>slen) return 0;
		int ret=0;
		for (int i=slen-k;i>=0;i--)
		{
			int cnt[]=new int[26],bits=0;
			for (int j=i;j<slen;j++)
			{
				int idx=s.charAt(j)-'a';
				cnt[idx]++;
				if (cnt[idx]<k)
					bits|=1<<idx;
				else
					bits&=~(1<<idx);
				if (bits==0)
					if (j-i+1>ret) ret=j-i+1;
			}
		}
		return ret;
	}
}

public class Solution {
	public int longestSubstring(String s, int k) {
		int slen=s.length();
		if (k>slen) return 0;
		int ret=0;
		for (int i=0;i<=slen-k;)
		{
			int cnt[]=new int[26],bits=0,pos=i;
			for (int j=i;j<slen;j++)
			{
				int idx=s.charAt(j)-'a';
				cnt[idx]++;
				if (cnt[idx]<k)
					bits|=1<<idx;
				else
					bits&=~(1<<idx);
				if (bits==0)
					if (j-i+1>ret)
					{
						ret=j-i+1;
						pos=j;
					}
			}
			i=pos+1;
		}
		return ret;
	}
}
