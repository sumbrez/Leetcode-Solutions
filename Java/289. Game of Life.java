/*
289. Game of Life
https://leetcode.com/problems/game-of-life/
*/

// 1ms
public class Solution {
	public void gameOfLife(int[][] board) {
		int m=board.length;
		if (m==0) return;
		int n=board[0].length;
		int temp[][]=new int[m][n];
		int dr[]=new int[]{-1,-1,0,1,1,1,0,-1},
			dc[]=new int[]{0,1,1,1,0,-1,-1,-1};
		for (int i=0;i<m;i++)
			for (int j=0;j<n;j++)
			{
				int live=0;
				for (int k=0;k<8;k++)
				{
					int r=i+dr[k],c=j+dc[k];
					if (!(0<=r&&r<m&&0<=c&&c<n))
						continue;
					if (board[r][c]==1)
						live++;
				}
				if (board[i][j]==1)
				{
					if (live<2||live>3)
						temp[i][j]=0;
					else
						temp[i][j]=1;
				}
				else
				{
					if (live==3)
						temp[i][j]=1;
					else
						temp[i][j]=0;
				}
			}
		for (int i=0;i<m;i++)
			board[i]=temp[i].clone();
	}
}
