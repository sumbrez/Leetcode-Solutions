/*
082. Remove Duplicates from Sorted List II
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

c 3 ms
*/

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    if (head==NULL) return head;
    
    struct ListNode *ans=NULL,*tail=NULL,*pre=head,*now;

    // 在末尾添加额外的必定不同的节点
    while (pre->next!=NULL)
        pre=pre->next;
    pre->next=(struct ListNode *)malloc(sizeof(struct ListNode));
    pre->next->val=0x7fffffff;
    pre->next->next=NULL;

    pre=head;
    now=head->next;

    int prev=head->val,cnt=1;
    while (now!=NULL)
    {
        int v=now->val;
        if (v!=prev)
        {
            if (cnt==1) // 记录
            {
                if (ans==NULL) // 首次记录
                {
                    ans=(struct ListNode*)malloc(sizeof(struct ListNode));
                    ans->val=pre->val;
                    ans->next=NULL;
                    tail=ans;
                }
                else // 非首次记录，末尾添加
                {
                    tail->next=(struct ListNode*)malloc(sizeof(struct ListNode));
                    tail=tail->next;
                    tail->val=pre->val;
                    tail->next=NULL;
                }
            }
            pre=now; // 前一个数字处理完毕
            
            prev=v;
            cnt=1;
        }
        else
            cnt++;
        
        now=now->next;
    }
    return ans;
}
