/*
382. Linked List Random Node
https://leetcode.com/problems/linked-list-random-node/
*/

// 130ms
// 又是可以很简单
import java.util.*;
public class Solution {

	/** @param head The linked list's head.
		Note that the head is guaranteed to be not null, so it contains at least one node. */
	ListNode head;
	int len;
	Random rnd;
	public Solution(ListNode head) {
		this.head=head;
		len=0;
		rnd=new Random();
		while (head!=null)
		{
			head=head.next;
			len++;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int n=rnd.nextInt(len);
		ListNode temp=head;
		for (int i=0;i<n;i++)
			temp=temp.next;
		return temp.val;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
