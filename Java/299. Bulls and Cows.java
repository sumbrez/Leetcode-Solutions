/*
299. Bulls and Cows
https://leetcode.com/problems/bulls-and-cows/
*/

// 3ms
public class Solution {
	public String getHint(String secret, String guess) {
		String s=secret,g=guess;
		int len=secret.length();
		if (len==0) return "0A0B";
		// 用cnt记录s中未匹配的0-9个数，用flag标记g中各位是否匹配过
		int bull=0,cow=0,cnt[]=new int[10];
		boolean gflag[]=new boolean[len];
		for (int i=0;i<len;i++)
		{
			int sint=s.charAt(i)-'0',gint=g.charAt(i)-'0';
			if (sint==gint)
			{
				bull++;
				gflag[i]=true;
			}
			else
			{
                // 如果不是bull匹配
				cnt[sint]++; // 记录s[i]的个数
				if (cnt[gint]>0) // s中之前出现过g[i]
				{
					cow++;
					cnt[gint]--;
					gflag[i]=true;
				}
			}
		}
        // 再遍历没有匹配的g[i]以免漏掉出现在g开头的数，例如012和102，102中的1被漏掉
		for (int i=0;i<len;i++)
		{
			int gint=g.charAt(i)-'0';
			if (!gflag[i]&&cnt[gint]>0)
			{
				cow++;
				cnt[gint]--;
			}
		}
		return String.valueOf(bull)+"A"+String.valueOf(cow)+"B";
	}
}
