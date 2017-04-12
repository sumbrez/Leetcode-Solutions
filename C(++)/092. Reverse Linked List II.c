/*
092. Reverse Linked List II
https://leetcode.com/problems/reverse-linked-list-ii/

c 0 ms
*/

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#define LN struct ListNode
struct ListNode* reverseBetween(struct ListNode* head, int m, int n) {
    if (m==n) return head;
    // pm：指向第m个数，pmpre：指向第m个数的前一个数
    // pn：指向第n个数，pnnext：指向第n个数的下一个数
    LN *pm=head,*pmpre,*pn,*pnnext;
    int idx=1;
    while (idx<m)
    {
        pmpre=pm;
        pm=pm->next;
        idx++;
    }
    pn=pm;
    while (idx<n)
    {
        pn=pn->next;
        pnnext=pn->next;
        idx++;
    }
    
    // 先将reverse部分倒序
    int rlen=n-m; // 倒序对个数
    for (int i=0;i<rlen;i++)
    {
        // 倒序时需要从后向前
        LN *p=head,*pre;
        int j=n-i-1; // 本次移动j次移动到对应位置
        while (j--)
        {
            pre=p;
            p=p->next;
        }
        p->next=pre; // 将此位置的next指向原本的前一个
    }
    
    if (m==1) // 如果从第1个位置reverse
        head=pn;
    else
        pmpre->next=pn;
    // reverse至最后一个位置没影响，都是NULL
    pm->next=pnnext;
    return head;
}
