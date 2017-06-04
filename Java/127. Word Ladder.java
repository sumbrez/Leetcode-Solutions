/*
127. Word Ladder
https://leetcode.com/problems/word-ladder/

Java 492 ms 560 ms
*/

// 可以直接转化为最短路

// ----------
public class Solution {
	List<List<Integer>> ajlist; // 相邻：只有一个字母不同
	List<String> wlist; // 加入beginWord的wordList
	String eword;
	boolean onediff(String word,String word2)
	{
		int count=0;
		for (int i=word.length()-1;i>=0;i--)
			if (word.charAt(i)!=word2.charAt(i))
				count++;
		if (count==1) return true;
		else return false;
	}
	// 模拟队列在多组数据下会出现MLE的情况
	int bfs()
	{
		int size=wlist.size();
		Queue<Integer> qu=new LinkedList<Integer>(),
			step=new LinkedList<Integer>(),
			pre=new LinkedList<Integer>();
		boolean in[]=new boolean[size];
		qu.offer(wlist.size()-1);
		step.offer(1);
		pre.offer(-1);
		in[wlist.size()-1]=true;
		while (!qu.isEmpty())
		{
			int u=qu.poll(),ustep=step.poll(),upre=pre.poll();
			in[u]=false;
			if (eword.equals(wlist.get(u)))
				return ustep;
			List<Integer> temp=ajlist.get(u);
			for (int i=temp.size()-1;i>=0;i--)
			{
				int v=temp.get(i);
				if (v==upre) continue; // 避免回环
				if (in[v]==false)
				{
					qu.offer(v);
					step.offer(ustep+1);
					pre.offer(u);
					in[v]=true;
				}
			}
		}
		return 0;
	}
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) return 0;
		eword=endWord;
		ajlist=new ArrayList<List<Integer>>();
		wlist=wordList;
		wlist.add(beginWord);
		int size=wlist.size();
		for (int i=0;i<size;i++)
			ajlist.add(new ArrayList<Integer>());
		for (int i=0;i<size;i++)
		{
			String word=wlist.get(i);
			for (int j=0;j<i;j++)
			{
				String word2=wlist.get(j);
				if (onediff(word,word2))
				{
					ajlist.get(i).add(j);
					ajlist.get(j).add(i);
				}
			}
		}
		int ret=bfs();
		return ret;
	}
}


// ----------
// 尝试回溯ret的dfs()失败，问题在于，从u->v时[u][v]的值可能还没算出来，
// 而此时dfs会再次出现u->v的情况，加入bool flag作辅助也不行
public class Solution {
	List<List<Integer>> ajlst; // 相邻：只有一个字母不同
	List<String> wlist; // 加入beginWord的wordList
	String eword;
	boolean onediff(String word,String word2)
	{
		int count=0;
		for (int i=word.length()-1;i>=0;i--)
			if (word.charAt(i)!=word2.charAt(i))
				count++;
		if (count==1) return true;
		else return false;
	}
	// 模拟队列在多组数据下会出现MLE的情况
//	int qu[],steps[],pre[],qsize;
	Queue<Integer> qu,steps,pre;
	boolean in[];
	int bfs()
	{
//		int fr=0,bk=0;
//		qu[bk]=wlist.size()-1;
//		steps[bk]=1;
//		pre[bk++]=-1;
		qu.offer(wlist.size()-1);
		steps.offer(1);
		pre.offer(-1);
		in[wlist.size()-1]=true;
//		while (fr<bk)
		while (!qu.isEmpty())
		{
//			int u=qu[fr],ustep=steps[fr],upre=pre[fr++];
			int u=qu.poll(),ustep=steps.poll(),upre=pre.poll();
			in[u]=false;
			if (eword.equals(wlist.get(u)))
				return ustep;
			List<Integer> temp=ajlst.get(u);
			for (int i=temp.size()-1;i>=0;i--)
			{
				int v=temp.get(i);
				if (v==upre) continue; // 避免回环
				// 模拟队列需要bk<qsize，即所有可能的中间步骤都尝试过了
				// 理论上Queue也可以用同样的判断机制
				if (in[v]==false)//&&bk<qsize)
				{
//					steps[bk]=ustep+1;
//					pre[bk]=u;
//					qu[bk++]=v;
					steps.offer(ustep+1);
					pre.offer(u);
					qu.offer(v);
					in[v]=true;
				}
			}
		}
		return 0;
	}
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) return 0;
		eword=endWord;
		ajlst=new ArrayList<List<Integer>>();
		wlist=wordList;
		wlist.add(beginWord);
		int size=wlist.size();
//		qsize=size*size;
//		qu=new int[qsize];
//		steps=new int[qsize];
//		pre=new int[qsize];
		qu=new LinkedList<Integer>();
		steps=new LinkedList<Integer>();
		pre=new LinkedList<Integer>();
		in=new boolean[size];
		for (int i=0;i<size;i++)
			ajlst.add(new ArrayList<Integer>());
		for (int i=0;i<size;i++)
		{
			String word=wlist.get(i);
			for (int j=0;j<i;j++)
			{
				String word2=wlist.get(j);
				if (onediff(word,word2))
				{
					ajlst.get(i).add(j);
					ajlst.get(j).add(i);
				}
			}
		}
		int ret=bfs();
		return ret;
	}
}
