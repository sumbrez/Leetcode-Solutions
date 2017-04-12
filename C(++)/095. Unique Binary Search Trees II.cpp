/*
095. Unique Binary Search Trees II
https://leetcode.com/problems/unique-binary-search-trees-ii/

cpp 29 ms
*/

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/*
问题：n=3时有一个结果为3 1 4 null 2
当3为根的值，进入3的左子树后，有1~2可选，问题在于
递归到depth==n才记录一种答案的做法，会漏掉3的左子树
以1为根的值，2为1的右子树的值的情况——因为此时depth==3，
所以返回到选1~2的那一层，然后3的左子树以2为根，这样
3 1 4 null 2的答案就漏掉了。所以需要将每一层的左右子树
的每一种构成方法都记录下来，在其上层拼接出所有左右子树
的结合方法（left.size*right.size），显然C++的容器会方便很多
这里就提交一下之前的做法记录一下
*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<TreeNode *> generateTrees(int n) {
        vector<TreeNode *> results;
        if (n==0)
            return results;
        return dfs(1,n);
    }
    
    vector<TreeNode *> dfs(int start, int end)  
    {
        vector<TreeNode *> results;
        if(start>end)
        {
            results.push_back(NULL);
            return results;
        }
        
        for(int k=start;k<=end;k++)
        {
            vector<TreeNode *> left = dfs(start,k-1);
            vector<TreeNode *> right = dfs(k+1,end);
            for(int i=0;i<left.size();i++)
            {
                for(int j=0;j<right.size();j++)
                {
                    TreeNode * root = new TreeNode(k);
                    root->left = left[i];
                    root->right = right[j];
                    results.push_back(root);
                }
            }
        }
        return results;
    }
};
