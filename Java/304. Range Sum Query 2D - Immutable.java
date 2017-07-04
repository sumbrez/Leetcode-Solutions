/*
304. Range Sum Query 2D - Immutable
https://leetcode.com/problems/range-sum-query-2d-immutable/
*/

// 147ms
// 容斥
public class NumMatrix {
	int sum[][];
	boolean empty;
	public NumMatrix(int[][] matrix) {
		int mtx[][]=matrix;
		int rlen=mtx.length;
		if (rlen==0)
		{
			empty=true;
			return;
		}
		int clen=mtx[0].length;
		sum=new int[rlen][clen];
		sum[0][0]=mtx[0][0];
		for (int i=1;i<rlen;i++)
			sum[i][0]=sum[i-1][0]+mtx[i][0];
		for (int i=1;i<clen;i++)
			sum[0][i]=sum[0][i-1]+mtx[0][i];
		for (int i=1;i<rlen;i++)
			for (int j=1;j<clen;j++)
				sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+mtx[i][j];
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (empty) return 0;
		int p1=sum[row2][col2],p2=0,p3=0,p4=0;
		if (row1>0)
			p2=sum[row1-1][col2];
		if (col1>0)
			p3=sum[row2][col1-1];
		if (row1>0&&col1>0)
			p4=sum[row1-1][col1-1];
		return p1-p2-p3+p4;
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
