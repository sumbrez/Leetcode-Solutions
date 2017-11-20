/*
402. Remove K Digits
https://leetcode.com/problems/remove-k-digits/
*/

// 25ms
import java.util.Stack;

public class Solution {
	public String removeKdigits(String num, int k) {
		Stack<Character> stk=new Stack<Character>();
		int n=k,len=num.length(),cnt=0;
		for(char ch:num.toCharArray())
		{
			while(!stk.isEmpty()&&n>0&&ch<stk.peek())
			{
				n--;
				stk.pop();
			}
			stk.push(ch);
		}
		StringBuffer sb=new StringBuffer();
		while(cnt<stk.size()&&stk.get(cnt)=='0')
            cnt++;
		for (int i=0;i<cnt;i++)
			stk.remove(0);
		if (stk.isEmpty())
			return "0";
		for (int i=0;i<len-k-cnt;i++)
			sb.append(stk.get(i));
		if (sb.length()==0)
			return "0";
		return sb.toString();
	}
}

// 119ms
public class Solution {
	public String removeKdigits(String num, int k) {
		StringBuffer n=new StringBuffer(num);
		if (n.length()==k) return "0";

		int cnt=0;
		if (n.length()>1&&n.charAt(1)=='0')
		{
			n.deleteCharAt(0);
			cnt++;
		}
		boolean found=true;
		while (cnt<k&&found)
		{
			found=false;
			for (int i=0;i<n.length()-1;i++)
				if (n.charAt(i)>n.charAt(i+1))
				{
					n.deleteCharAt(i);
					found=true;
					cnt++;
					break;
				}
		}
		for (int i=n.length()-1;i>=0&&cnt<k;i--)
			if (n.charAt(i)>'0')
			{
				n.deleteCharAt(i);
				cnt++;
			}
		
		while (n.length()>1&&n.charAt(0)=='0')
			n.deleteCharAt(0);
		return n.toString();
	}
}
