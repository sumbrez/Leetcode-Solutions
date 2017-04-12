/*
096. Unique Binary Search Trees
https://leetcode.com/problems/unique-binary-search-trees/

c 3 ms
*/

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/


//此做法属巧合
//如果知道数据范围，可以提前跑一边最大的n，buf不清空
int buf[100]; // 缓存（记忆）数组

// 包含i个数的子树有多少种结构
int dfs(int n)
{
    if (n<=1)
        return 1;
    int ret=0,ret1,ret2;//,m=n-1;
    n--;
    for (int i=0;i<=n/2;i++)
    {
        // 左子树包含i个数有多少种结构
        if (buf[i]==-1)
            ret1=buf[i]=dfs(i);
        else
            ret1=buf[i];
        
        // 右子树包含n-i个数有多少种结构
        if (buf[n-i]==-1)
            ret2=buf[n-i]=dfs(n-i);
        else
            ret2=buf[n-i];
        
        ret+=ret1*ret2;
        if (!((n&1)==0&&i==n/2)) // !(n为偶数且i为一半)
            ret+=ret1*ret2; // 左右交换
    }
    return ret;
}
int numTrees(int n) {
    memset(buf,-1,sizeof(buf));
    int ret=dfs(n);
    return ret;
}
