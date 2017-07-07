/*
331. Verify Preorder Serialization of a Binary Tree
https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
*/

// 2ms
public class Solution {
	String str;
	int len;
	int[] isNextInt(int pos)
	{
		int ret[]=new int[2];
		if (pos>=len) return ret;
		char ch=str.charAt(pos++);
		if (ch=='#')
		{
			ret[1]=++pos; // 跳过逗号（如果有）
			return ret;
		}
		if (ch=='-')
			ch=str.charAt(pos++);
		while (pos<len&&ch!=',')
			ch=str.charAt(pos++);
		ret[0]=1;
		ret[1]=pos;
		return ret;
	}
	public boolean isValidSerialization(String preorder) {
		str=preorder;
		if (str==null) return false;
		len=str.length();
		int cnt=1,pos=0;
		while (pos<len)
		{
			int temp[]=isNextInt(pos);
			if (temp[0]==1) cnt++;
			else cnt--;
			pos=temp[1];
			if (cnt<0) return false;
			if (cnt==0&&pos<len) return false;
		}
		return cnt==0;
	}
}
