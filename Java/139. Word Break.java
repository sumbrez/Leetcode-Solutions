/*
139. Word Break
https://leetcode.com/problems/word-break/
*/

// 16ms
public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int len=s.length(),dp[]=new int[len];
		// dp[j]：0~j（含）是否可以被切分，-1否，0未知，1是
		List<String> wdict=wordDict;
		for (int i=0;i<len;i++)
		{
			if (wdict.contains(s.substring(0,i+1)))
				dp[i]=1;
			for (int j=wdict.size()-1;j>=0&&dp[i]!=1;j--)
			{
				String word=wdict.get(j);
				int idx=i-word.length()+1;
				if (idx-1>=0&&dp[idx-1]==1
						&&word.equals(s.substring(idx,idx+word.length())))
					dp[i]=1;
			}
		}
		return dp[len-1]==1;
	}
}

//----------
// 21ms
public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int len=s.length(),dp[]=new int[len];
		// dp[j]：0~j（含）是否可以被切分，-1否，0未知，1是
		Set<String> wdict=new HashSet<String>(wordDict);
		for (int i=0;i<len;i++)
		{
			if (wdict.contains(s.substring(0,i+1)))
				dp[i]=1;
			// 通过判断0~j和j+1~i是否可以被切分来确定0~i
			for (int j=0;j<i&&dp[i]!=1;j++)
			{
				// dp[<i]已经判断过，所以只可能为1或-1
				if (dp[j]!=1) continue;
				// j+1~i也可以是拼凑而成，但这种情况在i>j+1时被考虑
				// 例如j+1~i是codecode，则在i位于第二个c时被考虑
				if (wdict.contains(s.substring(j+1,i+1)))
					dp[i]=1;
				else
					dp[i]=-1;
			}
		}
		return dp[len-1]==1;
	}
}
