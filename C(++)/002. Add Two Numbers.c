/*
002. Add Two Numbers
https://leetcode.com/problems/add-two-numbers/

c 19 ms
*/

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *pt=(struct ListNode *)malloc(sizeof(struct ListNode));
    struct ListNode *p=pt;
    p->val=0;
    p->next=NULL;
    int d,stp=0;
    while (true)
    {
        if (l1==NULL) d=0;
        else
        {
            d=l1->val;
            l1=l1->next;
        }
        if (l2==NULL) d+=0;
        else
        {
            d+=l2->val;
            l2=l2->next;
        }
        p->val=d+stp;
        stp=0;
        if (p->val>9)
        {
            stp=1;
            p->val-=10;
        }
        if (l1==NULL&&l2==NULL&&stp==0) break;
        else
        {
            p->next=(struct ListNode *)malloc(sizeof(struct ListNode));
            p=p->next;
            p->val=0;
            p->next=NULL;
        }
    }
    return pt;
}
