/*
098. Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/

c 6 ms
*/

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.

Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/*
简单直观的做法是检查是否合法和寻找子树最大最小值分开进行，
但这样会有重复的递归。这个做法中，找最值和检查合法合并起来。
当前节点需要知道左子树的最大值和右子树的最小值以判断是否合法，
需要知道左子树的最小值和右子树的最大值作为整棵子树的最值。
（子树不合法则不再用到这些最值，所以尽管将*mi=lmin，*mx=rmax）
（leetcode竟然卡了一次int max……）
*/
#define TN struct TreeNode
#define LL long long
int valid(TN *p,LL *mi,LL *mx)
{
    if (p==NULL) return 1;
    
    LL lmin,lmax,rmin,rmax;
    int lret=valid(p->left,&lmin,&lmax)
        ,rret=valid(p->right,&rmin,&rmax);
    
    if (lret==0||rret==0) return 0;
    
    if (p->left==NULL)
    {
        lmin=p->val;
        lmax=(LL)p->val-1; // 子树为空则合法
    }
    if (p->right==NULL)
    {
        rmin=(LL)p->val+1; // 子树为空则合法
        rmax=p->val;
    }
    
    *mi=lmin;
    *mx=rmax;
    
    if (lmax<p->val&&p->val<rmin)
        return 1;
    else
        return 0;
}
bool isValidBST(struct TreeNode* root) {
    LL mi,mx;
    int ret=valid(root,&mi,&mx);
    return ret;
}
