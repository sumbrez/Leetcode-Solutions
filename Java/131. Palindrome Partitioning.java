/*
131. Palindrome Partitioning
https://leetcode.com/problems/palindrome-partitioning/
*/

// 23ms
// bfs做法，有大量的容器操作甚如Queue<List<.>>
public class Solution {
	List<List<String>> ret;
	List<List<Integer>> llst; // i位置开始的各palin的长度
	boolean isPalin(String s)
	{
		int slen=s.length();
		if (slen==1) return true;
		for (int i=slen/2;i<slen;i++)
			if (s.charAt(i)!=s.charAt(slen-1-i))
				return false;
		return true;
	}
	void findAllPalin(String s)
	{
		int slen=s.length();
		for (int i=0;i<slen;i++)
			for (int j=i;j<slen;j++)
				if (isPalin(s.substring(i,j+1)))
					llst.get(i).add(j+1-i); // i位置开始的各palin的长度
	}
	void bfs(String s)
	{
		// 考虑到哪个位置
		Queue<Integer> pos=new LinkedList<Integer>();
		// 从0到当前位置经过的各段palin的长度
		Queue<List<Integer>> lens=new LinkedList<List<Integer>>();
		// lst：llst的元素；qlst：放入Queue lens的元素
		List<Integer> lst=llst.get(0);
		for (int len:lst)
		{
			pos.offer(len);
			List<Integer> qlst=new ArrayList<Integer>();
			qlst.add(len);
			lens.offer(qlst);
		}
		
		int slen=s.length();
		while (!pos.isEmpty())
		{
			int upos=pos.poll();
			List<Integer> qlst=lens.poll();
			if (upos==slen)
			{
				int st=0,ed;
				List<String> strlst=new ArrayList<String>();
				for (int len:qlst)
				{
					ed=st+len;
					strlst.add(s.substring(st,ed));
					st=ed;
				}
				ret.add(strlst);
				continue;
			}
			lst=llst.get(upos);
			for (int len:lst)
			{
				pos.offer(upos+len);
				List<Integer> temp=new ArrayList<Integer>(qlst);
				temp.add(len);
				lens.offer(temp);
			}
		}
	}
	public List<List<String>> partition(String s) {
		ret=new ArrayList<List<String>>();
		llst=new ArrayList<List<Integer>>();
		int slen=s.length();
		if (slen==0) return ret;
		for (int i=0;i<slen;i++)
			llst.add(new ArrayList<Integer>());
		findAllPalin(s);
		bfs(s);
		return ret;
	}
}
