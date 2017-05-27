/*
024. Swap Nodes in Pairs
https://leetcode.com/problems/swap-nodes-in-pairs/

java 4 ms
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head==null||head.next==null) return head;
		ListNode ret=head.next;
		ListNode temp=ret.next;
		ret.next=head;
		head.next=temp;
		
		ListNode pre=head;
		while (pre.next!=null&&pre.next.next!=null)
		{
			ListNode p=pre.next,pnext=p.next;
			temp=pnext.next;
			pnext.next=p;
			p.next=temp;
			pre.next=pnext;
			pre=p;
		}
		return ret;
	}
}
