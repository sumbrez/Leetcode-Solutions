/*
200. Number of Islands
https://leetcode.com/problems/number-of-islands/
*/

// 5ms
import java.util.*;

public class Solution {
	char grid[][];
	int dr[]={0,1,0,-1},dc[]={1,0,-1,0};
	int nr,nc;
	boolean visit[][];
	void dfs(int r,int c)
	{
		visit[r][c]=true;
		for (int i=0;i<4;i++)
		{
			int newr=r+dr[i],newc=c+dc[i];
			if (0<=newr&&newr<nr&&0<=newc&&newc<nc
					&&!visit[newr][newc]&&grid[newr][newc]=='1')
				dfs(newr,newc);
		}
	}
	public int numIslands(char[][] grid) {
		int ret=0;
		this.grid=grid;
		nr=grid.length;
		if (nr==0) return 0;
		nc=grid[0].length;
		visit=new boolean[nr][nc];
		for (int i=0;i<nr;i++)
			for (int j=0;j<nc;j++)
				if (!visit[i][j]&&grid[i][j]=='1')
				{
					dfs(i,j);
					ret++;
				}
		return ret;
	}
}
