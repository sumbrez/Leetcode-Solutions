/*
227. Basic Calculator II
https://leetcode.com/problems/basic-calculator-ii/
*/

// 32ms
public class Solution {
	String s;
	int slen;
	int[] getval(int pos)
	{
		int val=0;
		for (;pos<slen;pos++)
		{
			int d=s.charAt(pos)-'0';
			if (d==' '-'0') continue;
			if (d<0) break; // +-*/
			val=val*10+d;
		}
		int ret[]=new int[]{val,pos};
		return ret;
	}
	public int calculate(String s) {
		this.s=s;
		slen=s.length();
		if (slen==0) return 0;
		// 伪数值栈
		List<Integer> lst=new ArrayList<Integer>();
		// 伪+-符号栈，乘除法直接计算
		List<Character> op=new ArrayList<Character>();
		int size=0,pos=0;
		while (pos<slen)
		{
			char ch=s.charAt(pos);
			if (ch>='0')
			{
				int t[]=getval(pos);
				pos=t[1];
				lst.add(t[0]);
				size++;
			}
			else
			{
				pos++;
				if (ch==' ')
					continue;
				else if (ch=='*'||ch=='/')
				{
					int t[]=getval(pos);
					pos=t[1];
					if (ch=='*')
						lst.set(size-1,lst.get(size-1)*t[0]);
					else if (ch=='/')
						lst.set(size-1,lst.get(size-1)/t[0]);
				}
				else
					op.add(ch);
			}
		}
		for (int i=1;i<size;i++)
		{
			int val1=lst.get(i-1),val2=lst.get(i);
			if (op.get(i-1)=='+')
				lst.set(i,val1+val2);
			else
				lst.set(i,val1-val2);
		}
		return lst.get(size-1);
	}
}
