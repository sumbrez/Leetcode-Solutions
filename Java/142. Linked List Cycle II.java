/*
142. Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/
*/

// 1ms
/*
从表头出发，fast一次走两个，slow一次一个，假设环的长度为n，
环之前的长度为m，那么m步后slow到达环入口，fast在环中的m点，
即经过n-m步后fast追上slow（相遇），即相遇处距环入口为m，所以
一个指针从表头出发，一个从相遇处出发，都为一次一步，再相遇的地方即为环入口
*/
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head==null) return null;
		ListNode fast=head,slow=head;
		while (slow!=null&&fast!=null)
		{
			if (fast.next==null) return null;
			fast=fast.next.next;
			slow=slow.next;
			if (fast==slow)
				break;
		}
		if (slow==null||fast==null)
			return null;
		slow=head;
		while (slow!=fast)
		{
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
}


// 13ms
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head==null) return null;
		ListNode temp=head;
		Set<ListNode> st=new HashSet<ListNode>();
		while (temp!=null)
		{
			if (st.contains(temp))
				return temp;
			st.add(temp);
			temp=temp.next;
		}
		return null;
	}
}
