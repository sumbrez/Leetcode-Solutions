/*
130. Surrounded Regions
https://leetcode.com/problems/surrounded-regions/

Java 14 ms
*/

// dfs爆栈，且任意点出发寻找'O'链并判断是否需要变'X'较慢，因为遍历了所有的'O'
public class Solution {
	int rlen,clen;
	boolean visit[][],aj;
	int dr[]=new int[]{0,-1,0,1},dc[]=new int[]{1,0,-1,0};
	char board[][];
	void bfs(int srcr,int srcc)
	{
		visit[srcr][srcc]=true;
		Queue<Integer> rq=new LinkedList<Integer>(),cq=new LinkedList<Integer>();
		rq.offer(srcr);
		cq.offer(srcc);
		while (!rq.isEmpty())
		{
			int r=rq.poll(),c=cq.poll();
			board[r][c]='t'; // 从边界连过来的'O'链不需要变'X'
			for (int i=0;i<4;i++)
			{
				int newr=r+dr[i],newc=c+dc[i];
				if (0<=newr&&newr<rlen&&0<=newc&&newc<clen
						&&board[newr][newc]=='O'&&!visit[newr][newc])
				{
					rq.offer(newr);
					cq.offer(newc);
					visit[newr][newc]=true;
				}
			}			
		}
	}
	public void solve(char[][] board) {
		rlen=board.length;
		if (rlen==0) return;
		clen=board[0].length;
		visit=new boolean[rlen][clen];
		this.board=board;
        // 从边界开始寻找一条连续的'O'链
		for (int i=0;i<clen;i++) // 上下两条边
		{
			if (board[0][i]=='O'&&!visit[0][i])
				bfs(0,i);
			if (board[rlen-1][i]=='O'&&!visit[rlen-1][i])
				bfs(rlen-1,i);
		}
		for (int i=0;i<rlen;i++) // 左右两条边
		{
			if (board[i][0]=='O'&&!visit[i][0])
				bfs(i,0);
			if (board[i][clen-1]=='O'&&!visit[i][clen-1])
				bfs(i,clen-1);
		}
		for (int i=0;i<rlen;i++)
			for (int j=0;j<clen;j++)
				if (board[i][j]=='O') // 没被标记为't'的
					board[i][j]='X';
				else if (board[i][j]=='t') // 标记为't'的为连到边界的'O'链
					board[i][j]='O';
	}
}
