/*
002. Add Two Numbers
https://leetcode.com/problems/add-two-numbers/

Java 73 ms
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null) return null;
        
        ListNode ret=null,temp=null;
        int val1,val2,r=0;
        while (l1!=null||l2!=null)
        {
        	if (ret==null)
        	{
        		ret=new ListNode(0);
        		temp=ret;
        	}
        	else
        	{
        		// =temp.next放在后边，因为next还不存在
                temp.next=new ListNode(0);
                temp=temp.next;
        	}
        	
            if (l1==null) val1=0;
            else val1=l1.val;
            if (l2==null) val2=0;
            else val2=l2.val;
            
            temp.val=(val1+val2+r)%10;
            r=(val1+val2+r)/10;
            
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
        }
        if (r!=0)
        {
            temp.next=new ListNode(r);
            temp=temp.next;
        }
        
        return ret;
    }
}
