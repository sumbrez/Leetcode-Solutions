/*
022. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/

java 74 ms
*/

public class Solution {
	public HashSet<String> hret;
	public List<String> ret;
	public int _n;
	void move(char str[],int len,int p,int n)
	{
		for (int i=len-1;i>=p;i--)
			str[i+n]=str[i];
	}
	void dfs(int depth,char str[])
	{
		if (depth==_n)
		{
			hret.add(String.valueOf(str));
			return;
		}
		int len=depth*2;
		for (int i=0;i<len;i++)
		{
			char newstr[]=Arrays.copyOf(str,_n*2);
			move(newstr,len,i,2);
			newstr[i]='(';
			newstr[i+1]=')';
			dfs(depth+1,newstr);
		}
	}
	public List<String> generateParenthesis(int n) {
		hret=new HashSet<String>();
		ret=new ArrayList<String>();
		_n=n;
		if (n==0) return ret;
		
		char str[]=new char[n*2];
		str[0]='(';
		str[1]=')';
		dfs(1,str);
		ret.addAll(hret);
		return ret;
	}
}
