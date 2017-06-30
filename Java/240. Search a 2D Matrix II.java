/*
240. Search a 2D Matrix II
https://leetcode.com/problems/search-a-2d-matrix-ii/
*/

// 17ms
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int mt[][]=matrix;
		int rlen=mt.length;
		if (rlen==0) return false;
		int clen=mt[0].length;
		for (int i=0;i<rlen;i++)
		{
			int st=0,ed=clen-1,mid=-1;
			while (st<=ed)
			{
				mid=(st+ed)/2;
				if (target<mt[i][mid])
					ed=mid-1;
				else if (target>mt[i][mid])
					st=mid+1;
				else
					return true;
			}
		}
		return false;
	}
}
