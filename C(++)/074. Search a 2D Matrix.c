/*
074. Search a 2D Matrix
https://leetcode.com/problems/search-a-2d-matrix/

c 3 ms
*/

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

bool searchMatrix(int** matrix, int matrixRowSize, int matrixColSize, int target) {
    int rn=matrixRowSize,cn=matrixColSize;
    int st=0,ed=rn*cn-1,mid;
    while (st<=ed)
    {
        mid=st+ed>>1;
        int t,r=mid/cn,c=mid%cn;
        if (target>matrix[r][c])
            st=mid+1;
        else if (target<matrix[r][c])
            ed=mid-1;
        else
            break;
    }
    if (st>ed) return 0;
    return 1;
}
