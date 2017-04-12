/*
061. Rotate List
https://leetcode.com/problems/rotate-list/

c 6 ms
*/

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    if (k==0) return head;
    int len=0;
    struct ListNode *pre,*p=head;
    while (p!=NULL)
    {
        pre=p;
        p=p->next;
        len++;
    }
    if (len==0) return head;
    pre->next=head;
    int ofs=len-k%len;
    while (ofs)
    {
        pre=head;
        head=head->next;
        ofs--;
    }
    pre->next=NULL;
    return head;
}
