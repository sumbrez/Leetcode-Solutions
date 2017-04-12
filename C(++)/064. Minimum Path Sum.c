/*
064. Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/

c 13 ms
*/

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

int cac[501][501],**maze,m,n;
#define INF 0x7fffffff
int imin(int a,int b)
{
    return a<b?a:b;
}
int getv(int r,int c)
{
    if (r==0||c==0) return INF;
    if (r==1&&c==1) return maze[m-1][n-1];
    if (cac[r][c]!=-1) return cac[r][c];
    int v1=getv(r-1,c),v2=getv(r,c-1);
    return cac[r][c]=maze[m-r][n-c]+imin(v1,v2);
}
int minPathSum(int** grid, int gridRowSize, int gridColSize) {
    maze=grid,m=gridRowSize,n=gridColSize;
    if (m==1&&n==1) return maze[0][0];
    memset(cac,-1,sizeof(cac));
    return getv(m,n);
}
