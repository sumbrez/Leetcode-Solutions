/*
165. Compare Version Numbers
https://leetcode.com/problems/compare-version-numbers/
*/

// 3ms
public class Solution {
	public int compareVersion(String version1, String version2) {
		String v1[]=version1.split("\\."),v2[]=version2.split("\\.");
		int len1=v1.length,len2=v2.length,p1=0,p2=0;
		while (p1<len1&&p2<len2)
		{
			int subv1=Integer.valueOf(v1[p1]),
				subv2=Integer.valueOf(v2[p2]);
			if (subv1<subv2) return -1;
			else if (subv1>subv2) return 1;
			p1++;
			p2++;
		}
		while (p1<len1&&Integer.valueOf(v1[p1])==0)
			p1++;
		while (p2<len2&&Integer.valueOf(v2[p2])==0)
			p2++;
		if (p1==len1&&p2<len2)
			return -1;
		else if (p1<len1&&p2==len2)
			return 1;
		return 0;
	}
}
