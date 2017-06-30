/*
274. H-Index
https://leetcode.com/problems/h-index/
*/

// 2ms
import java.util.Arrays;

public class Solution {
	public int hIndex(int[] citations) {
		int ct[]=citations;
		Arrays.sort(ct);
		int len=ct.length,i=len-1;
		while (i>=0&&ct[i]>=len-i)
			i--;
		return len-i-1;
	}
}
