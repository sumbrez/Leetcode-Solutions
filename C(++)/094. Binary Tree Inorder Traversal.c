/*
094. Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/

c 0 ms
*/

/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
#define TN struct TreeNode
int len,*ret;
void dfs(TN *p)
{
    if (p==NULL) return;
    dfs(p->left);
    ret[len++]=p->val;
    dfs(p->right);
}
int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    len=0;
    ret=(int*)malloc(sizeof(int)*1000);
    
    dfs(root);
    
    ret=(int*)realloc(ret,sizeof(int)*len);
    *returnSize=len;
    return ret;
}
