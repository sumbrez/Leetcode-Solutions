/*
150. Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation/
*/

// 12ms
public class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> opd=new Stack<Integer>();
		for (int i=0;i<tokens.length;i++)
		{
			char ch=tokens[i].charAt(0);
			if (tokens[i].length()==1&&
					(ch=='+'||ch=='-'||ch=='*'||ch=='/'))
			{
				int opd2=opd.pop(),opd1=opd.pop(),res=0;
				switch (ch)
				{
				case '+': res=opd1+opd2; break;
				case '-': res=opd1-opd2; break;
				case '*': res=opd1*opd2; break;
				case '/': res=opd1/opd2; break;
				}
				opd.push(res);
			}
			else
				opd.push(Integer.valueOf(tokens[i]));
		}
		return opd.pop();
	}
}
