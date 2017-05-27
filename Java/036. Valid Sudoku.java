/*
036. Valid Sudoku
https://leetcode.com/problems/valid-sudoku/

Java 48 ms
*/

public class Solution {
	boolean linecheck(char board[][],boolean row1st)
	{
		char ch;
		for (int i=0;i<9;i++)
		{
			boolean flag[]=new boolean[9];
			for (int j=0;j<9;j++)
			{
				if (row1st)
					ch=board[i][j];
				else
					ch=board[j][i];
				if (ch!='.')
				{
					if (flag[ch-'1'])
						return false;
					flag[ch-'1']=true;
				}
			}
		}
		return true;
	}
	boolean blockcheck(char board[][])
	{
		char ch;
		for (int k=0;k<9;k++)
		{
			int rowst=k/3*3,colst=k%3*3;
			boolean flag[]=new boolean[9];
			for (int i=0;i<3;i++)
				for (int j=0;j<3;j++)
				{
					ch=board[i+rowst][j+colst];
					if (ch!='.')
					{
						if (flag[ch-'1'])
							return false;
						flag[ch-'1']=true;
					}
				}
		}
		return true;
	}
	public boolean isValidSudoku(char[][] board) {
		if (!linecheck(board,true))
			return false;
		if (!linecheck(board,false))
			return false;
		if (!blockcheck(board))
			return false;
		return true;
	}
}
