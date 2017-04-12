/*
086. Partition List
https://leetcode.com/problems/partition-list/

c 3 ms
*/

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* partition(struct ListNode* head, int x) {
    struct ListNode *temp=head,*ret=NULL,*tail;
    for (int i=0;i<2;i++)
    {
        temp=head;
        while (temp!=NULL)
        {
            if ((temp->val<x)^i) // i为0时，val>x成立则if成立；i为1时相反
            {
                if (ret==NULL)
                {
                    ret=(struct ListNode*)malloc(sizeof(struct ListNode));
                    ret->val=temp->val;
                    ret->next=NULL;
                    tail=ret;
                }
                else
                {
                    tail->next=(struct ListNode*)malloc(sizeof(struct ListNode));
                    tail->next->val=temp->val;
                    tail->next->next=NULL;
                    tail=tail->next;
                }
            }
            temp=temp->next;
        }
    }
    return ret;
}
