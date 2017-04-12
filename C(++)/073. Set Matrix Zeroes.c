/*
073. Set Matrix Zeroes
https://leetcode.com/problems/set-matrix-zeroes/

c 19 ms
*/

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

void setZeroes(int** matrix, int matrixRowSize, int matrixColSize) {
    int rsize=matrixRowSize,csize=matrixColSize;
    bool rows[rsize],cols[csize];
    // C语言中长度由变量指定的数组不能在定义时初始化
    memset(rows,0,sizeof(rows));
    memset(cols,0,sizeof(cols));
    for (int i=0;i<rsize;i++)
        for (int j=0;j<csize;j++)
            if (matrix[i][j]==0)
            {
                rows[i]=1;
                cols[j]=1;
            }
    for (int i=0;i<rsize;i++)
        if (rows[i])
            for (int j=0;j<csize;j++)
                matrix[i][j]=0;
    for (int i=0;i<csize;i++)
        if (cols[i])
            for (int j=0;j<rsize;j++)
                matrix[j][i]=0;
}
