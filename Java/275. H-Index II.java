/*
275. H-Index II
https://leetcode.com/problems/h-index-ii/
*/

// 14ms
public class Solution {
	public int hIndex(int[] citations) {
		int ct[]=citations;
		int len=ct.length,i=len-1;
		while (i>=0&&ct[i]>=len-i)
			i--;
		return len-i-1;
	}
}
