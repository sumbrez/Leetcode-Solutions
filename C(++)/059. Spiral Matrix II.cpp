/*
059. Spiral Matrix II
https://leetcode.com/problems/spiral-matrix-ii/

cpp 3 ms
*/

/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
*/

class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> ans;
        if (n==0) return ans;
        int dr[]={0,1,0,-1},dc[]={1,0,-1,0},d=0,pr=0,pc=0,mp[n][n];
        bool vst[n][n];
        memset(vst,0,sizeof(vst));
        for (int i=1,mx=n*n;i<=mx;i++)
        {
            mp[pr][pc]=i;
            vst[pr][pc]=true;
            pr+=dr[d];
            pc+=dc[d];
            if (pr<0||pr>=n||pc<0||pc>=n||vst[pr][pc])
            {
                pr-=dr[d];
                pc-=dc[d];
                d=(d+1)%4;
                pr+=dr[d];
                pc+=dc[d];
            }
        }
        for (int i=0;i<n;i++)
        {
            vector<int> temp;
            for (int j=0;j<n;j++)
                temp.push_back(mp[i][j]);
            ans.push_back(temp);
        }
        return ans;
    }
};
