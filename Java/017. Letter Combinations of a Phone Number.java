/*
017. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

java 4 ms
*/

public class Solution {
	public String mp[]=new String[]{
		"abc","def",
		"ghi","jkl","mno",
		"pqrs","tuv","wxyz"};
	public List<String> ret;
	public String nums;
	public int nlen;
	public int getIdx(char ch)
	{
		return ch-'2';
	}
	public void dfs(char str[],int pos)
	{
		if (pos==nlen)
		{
			ret.add(String.valueOf(str));
			return;
		}
		int idx=getIdx(nums.charAt(pos));
		// 通过试验知出现2~9之外的数字时结果为空，所以不需要检查idx
		int len=mp[idx].length();
		for (int i=0;i<len;i++)
		{
			str[pos]=mp[idx].charAt(i);
			dfs(str,pos+1);
		}
	}
	public List<String> letterCombinations(String digits) {
		ret=new ArrayList<String>(); // LinkedList<String>();
		nums=digits;
		nlen=nums.length();
		if (nlen==0) return ret;
		for (int i=0;i<nlen;i++)
			if (!('2'<=nums.charAt(i)&&nums.charAt(i)<='9'))
				return ret;
		char str[]=new char[nlen];
		dfs(str,0);
		return ret;
	}
}
