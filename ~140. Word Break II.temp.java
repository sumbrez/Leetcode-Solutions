import java.util.*;

public class Solution {
	List<String> ret;
	int slen;
	List<String> dp[];
	void dfs(int pos,List<String> lst)
	{
		if (pos==slen)
		{
			StringBuffer sb=new StringBuffer();
			for (int i=0;i<lst.size();i++)
			{
				if (i>0) sb.append(' ');
				sb.append(lst.get(i));
			}
			ret.add(sb.toString());
			return;
		}
		for (int i=dp[pos].size()-1;i>=0;i--)
		{
			String word=dp[i].get(i);
			int wlen=word.length();
			if (pos+wlen<=slen)
			{
				lst.add(word);
				dfs(pos+wlen,lst);
				lst.remove(lst.size()-1);
			}
		}
	}
	public List<String> wordBreak(String s, List<String> wordDict) {
		ret=new ArrayList<String>();
		slen=s.length();
		List<String> wdict=wordDict;
		dp=new ArrayList[slen];
		for (int i=0;i<slen;i++)
		{
			dp[i]=new ArrayList<String>();
			for (int j=wdict.size()-1;j>=0;j--)
			{
				String word=wdict.get(j);
				int idx=i+word.length();
				if (idx<=slen&&word.equals(s.substring(i,idx)))
					dp[i].add(word);
			}
		}
		dfs(0,new ArrayList<String>());
		return ret;
	}
}


public class Solution {
	List<String> wdict,ret;
	String s;
	int slen;
	void dfs(int pos,List<Integer> lst)
	{
		if (pos==slen)
		{
			StringBuffer sb=new StringBuffer();
			for (int i=0;i<lst.size();i++)
			{
				if (i>0) sb.append(' ');
				sb.append(wdict.get(lst.get(i)));
			}
			ret.add(sb.toString());
			return;
		}
		for (int i=wdict.size()-1;i>=0;i--)
		{
			String word=wdict.get(i);
			int wlen=word.length();
			if (pos+wlen<=slen&&s.substring(pos,pos+word.length()).equals(word))
			{
				lst.add(i);
				dfs(pos+word.length(),lst);
				lst.remove(lst.size()-1);
			}
		}
	}
	public List<String> wordBreak(String s, List<String> wordDict) {
		this.s=s;
		slen=s.length();
		wdict=wordDict;
		ret=new ArrayList<String>();
		dfs(0,new ArrayList<Integer>());
		return ret;
	}
}
