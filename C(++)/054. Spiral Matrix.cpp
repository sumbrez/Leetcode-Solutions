/*
054. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/

cpp 3 ms
*/

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
  [ 1, 2, 3 ],
  [ 4, 5, 6 ],
  [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> ans;
        int nr=matrix.size();
        if (nr==0) return ans;
        int nc=matrix[0].size(),n=nr*nc;
        if (nc==0) return ans;
        
        /*
        直接使用matrix[i][j]时，在[[1,2,3,4,5,6,7,8,9]]数据上出现reference
        binding to misaligned address ..., which requires 4 byte alignment
        
        int mtr[nr][nc];
        vector<vector<int>>::iterator ir=matrix.begin();
        for (int i=0;i<nr;i++,ir++)
        {
            vector<int>::iterator ic=ir->begin();
            for (int j=0;j<nc;j++,ic++)
                mtr[i][j]=*ic;
        }*/
        int dr[]={0,1,0,-1},dc[]={1,0,-1,0},d=0,pr=0,pc=0;
        bool vst[nr][nc];
        /*
        被vst[nr][nc]={0}形式的初值卡住了半天索引1越界
        直接用matrix[][]的问题也由这个引起……
        */
        memset(vst,0,sizeof(vst));
        for (int i=0;i<n;i++)
        {
            ans.push_back(matrix[pr][pc]);
            vst[pr][pc]=true;
            pr+=dr[d];
            pc+=dc[d];
            if (pr<0||pr>=nr||pc<0||pc>=nc||vst[pr][pc])
            {
                pr-=dr[d];
                pc-=dc[d];
                d=(d+1)%4;
                pr+=dr[d];
                pc+=dc[d];
            }
        }
        return ans;
    }
};
