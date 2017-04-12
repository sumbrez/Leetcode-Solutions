/*
063. Unique Paths II
https://leetcode.com/problems/unique-paths-ii/

c 3 ms
*/

/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

int cac[101][101],**maze,m,n;
int getv(int r,int c)
{
    if (r==0||c==0) return 0;
    if (maze[m-r][n-c]) return 0;
    if (r==1&&c==1) return 1;
    if (cac[r][c]!=-1) return cac[r][c];
    int v1=getv(r-1,c),v2=getv(r,c-1);
    return cac[r][c]=v1+v2;
}
int uniquePathsWithObstacles(int** obstacleGrid, int obstacleGridRowSize, int obstacleGridColSize) {
    maze=obstacleGrid,m=obstacleGridRowSize,n=obstacleGridColSize;
    if (m==1&&n==1) return !maze[0][0];
    if (maze[0][0]) return 0;
    memset(cac,-1,sizeof(cac));
    return getv(m-1,n)+getv(m,n-1);
}
