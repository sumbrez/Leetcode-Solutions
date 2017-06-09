/*
143. Reorder List
https://leetcode.com/problems/reorder-list/
*/

// 2ms
public class Solution {
	public void reorderList(ListNode head) {
		if (head==null||head.next==null) return;
		int len=0;
		ListNode temp=head;
		while (temp!=null)
		{
			temp=temp.next;
			len++;
		}
		ListNode node[]=new ListNode[len];
		temp=head;
		for (int i=0;i<len;i++,temp=temp.next)
			node[i]=temp;
		for (int i=0,j=len-1;i<j;i++,j--)
		{
			node[j-1].next=node[j].next;
			node[j].next=node[i].next;
			node[i].next=node[j];
		}
	}
}
