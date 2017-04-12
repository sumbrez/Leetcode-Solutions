/*
062. Unique Paths
https://leetcode.com/problems/unique-paths/

c 0 ms
*/

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

(https://leetcode.com/static/images/problemset/robot_maze.png)
Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/

int cac[101][101];
int getv(int r,int c)
{
    if (r==0||c==0) return 0;
    if (r==1||c==1) return 1;
    if (cac[r][c]!=-1) return cac[r][c];
    int v1=getv(r-1,c),v2=getv(r,c-1);
    return cac[r][c]=v1+v2;
}
int uniquePaths(int m, int n) {
    if (m==1&&n==1) return 1;
    memset(cac,-1,sizeof(cac));
    return getv(m-1,n)+getv(m,n-1);
}
