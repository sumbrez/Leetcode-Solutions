/*
392. Is Subsequence
https://leetcode.com/problems/is-subsequence/
*/

// 10ms
public class Solution {
	public boolean isSubsequence(String s, String t) {
		char ss[]=s.toCharArray(),tt[]=t.toCharArray();
		int slen=s.length(),tlen=t.length(),i=0,j=0;
		while (i<slen&&j<tlen)
			if (ss[i]==tt[j++])
				i++;
		if (i==slen) return true;
		return false;
	}
}

// follow-up的问题是s有很多个，而每个s需要单独判断，所以优化点在于tlen
