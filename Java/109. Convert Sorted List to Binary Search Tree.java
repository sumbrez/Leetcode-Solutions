/*
109. Convert Sorted List to Binary Search Tree
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

Java 3 ms
*/

public class Solution {
	TreeNode dfs(int arr[],int st,int ed)
	{
		if (st>ed) return null;
		int mid=(st+ed)/2;
		TreeNode ret=new TreeNode(arr[mid]);
		ret.left=dfs(arr,st,mid-1);
		ret.right=dfs(arr,mid+1,ed);
		return ret;
	}
	public TreeNode sortedListToBST(ListNode head) {
		int len=0;
		ListNode temp=head;
		while (temp!=null)
		{
			len++;
			temp=temp.next;
		}
		if (len==0) return null;
		int arr[]=new int[len];
		int i=0;
		while (head!=null)
		{
			arr[i++]=head.val;
			head=head.next;
		}
		TreeNode ret=dfs(arr,0,len-1);
		return ret;
	}
}
