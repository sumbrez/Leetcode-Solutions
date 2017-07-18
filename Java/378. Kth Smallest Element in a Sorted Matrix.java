/*
378. Kth Smallest Element in a Sorted Matrix
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
*/

// 4ms
public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int r=matrix.length,c=matrix[0].length;
		int st=matrix[0][0],ed=matrix[r-1][c-1],mid;
		while (st<ed)
		{
			mid=(st+ed)/2;
			int cnt=0;
			// 第i行中
			for (int i=0;i<r;i++)
			{
				int j=c-1;
				// <=mid的有j+1个
				while (j>=0&&matrix[i][j]>mid)
					j--;
				cnt+=j+1;
			}
			// 如果<=mid的个数小于k则加大mid以找到更多
			if (cnt<k) st=mid+1;
			// 否则减小mid，ed不能=mid-1，因为可能就是结果
			// 所以在左闭右开区间中查找，ed初值为mtx[][]+1，while条件为st<ed
			else ed=mid;
			// cnt==k可能是全小于mid，此时mid比实际结果偏大
		}
		return st;
	}
}
