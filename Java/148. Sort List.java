/*
148. Sort List
https://leetcode.com/problems/sort-list/
*/

// 12ms
public class Solution {
	ListNode merge(ListNode node1,ListNode node2)
	{
		if (node1==null) return node2;
		if (node2==null) return node1;
		ListNode node=null,head=null;
		while (node1!=null&&node2!=null)
		{
			if (node1.val<=node2.val)
			{
				if (node==null)
				{
					node=node1;
					head=node;
				}
				else
				{
					node.next=node1;
					node=node.next;
				}
				node1=node1.next;
			}
			else
			{
				if (node==null)
				{
					node=node2;
					head=node;
				}
				else
				{
					node.next=node2;
					node=node.next;
				}
				node2=node2.next;
			}
		}
		if (node1!=null) node.next=node1;
		else if (node2!=null) node.next=node2;
		return head;
	}
	public ListNode sortList(ListNode head) {
		if (head==null||head.next==null) return head;
		ListNode fast=head,slow=head;
		while (fast.next!=null)
		{
			fast=fast.next.next;
			if (fast==null) break;
			slow=slow.next;
		}
		ListNode right=slow.next;
		slow.next=null;
		ListNode left=sortList(head);
		right=sortList(right);
		return merge(left,right);
	}
}
