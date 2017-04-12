/*
048. Rotate Image
https://leetcode.com/problems/rotate-image/

cpp 6 ms
*/

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n=matrix.size();
        int temp[n][n];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                temp[j][n-1-i]=matrix[i][j];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                matrix[i][j]=temp[i][j];
    }
};
