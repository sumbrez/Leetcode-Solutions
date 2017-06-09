/*
138. Copy List with Random Pointer
https://leetcode.com/problems/copy-list-with-random-pointer/
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// 36ms
// 将各对象和对象的random先存为数组可以明显加速
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head==null) return null;
		RandomListNode temp=head;
		int len=0;
		while (temp!=null)
		{
			len++;
			temp=temp.next;
		}
		int rndto[]=new int[len]; // random所指对象的下标
		RandomListNode ptrs[]=new RandomListNode[len],
				rnds[]=new RandomListNode[len];
		temp=head;
		for (int i=0;i<len;i++)
		{
			ptrs[i]=temp;
			rnds[i]=temp.random;
			temp=temp.next;
		}
		for (int i=0;i<len;i++)
		{
			if (rnds[i]==null) rndto[i]=-1;
			else
				for (int j=0;j<len;j++)
					if (rnds[i]==ptrs[j])
					{
						rndto[i]=j;
						break;
					}
		}
		// 多开一个以便之后的循环不用判断是否是最后一个
		RandomListNode news[]=new RandomListNode[len+1];
		for (int i=0;i<=len;i++)
			news[i]=new RandomListNode(0);
		for (int i=0;i<len;i++)
		{
			news[i].label=ptrs[i].label;
			news[i].next=news[i+1];
			if (rndto[i]==-1)
				news[i].random=null;
			else
				news[i].random=news[rndto[i]];
		}
		news[len-1].next=null;
		return news[0];
	}
}
