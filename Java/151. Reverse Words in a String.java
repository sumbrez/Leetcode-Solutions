/*
151. Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/
*/

// 3ms
public class Solution {
	public String reverseWords(String s) {
		String[] ss=s.split(" ");
		StringBuffer sb=new StringBuffer();
		for (int cnt=0,i=ss.length-1;i>=0;i--)
		{
			if (ss[i].length()==0) continue;
			if (cnt++>0) sb.append(" ");
			sb.append(ss[i]);
		}
		return sb.toString();
	}
}
