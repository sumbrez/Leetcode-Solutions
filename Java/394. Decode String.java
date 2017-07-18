/*
394. Decode String
https://leetcode.com/problems/decode-string/
*/

// 3ms
public class Solution {
	char ch[];
	int slen,pos;
	// 以数字或字母（重复1次）开始进行处理
	boolean isNextDigit()
	{
		if ('0'<=ch[pos]&&ch[pos]<='9')
			return true;
		return false;
	}
	boolean isNextaz()
	{
		if ('a'<=ch[pos]&&ch[pos]<='z')
			return true;
		return false;
	}
	int getInt()
	{
		int dup=0;
		while (isNextDigit())
			dup=dup*10+ch[pos++]-'0';
		pos++; // 跳过数字后边的'['
		return dup;
	}
	StringBuffer getStr()
	{
		StringBuffer ret=new StringBuffer();
		while (pos<slen&&isNextaz())
			ret.append(ch[pos++]);
		return ret;
	}
	StringBuffer f()
	{
		if (pos>=slen) return new StringBuffer();

		int dup=1; // 重复次数，默认没有数字，即重复1次
		boolean brk=false; // 是否有中括号
		if (isNextDigit())
		{
			dup=getInt(); // pos已跳过数字后的'['
			brk=true;
		}

		StringBuffer ret=getStr(); // 获取不包含嵌套内容的重复内容
		if (pos<slen&&isNextDigit())// 数字，嵌套内容
			ret.append(f());

		String seg=ret.toString(); // 包含嵌套的重复内容
		for (int i=1;i<dup;i++)
			ret.append(seg);

		// 如果这一层有括号则去掉
		if (brk) pos++;
		// 同级内容
		while (pos<slen&&ch[pos]!=']')
			ret.append(f());
		return ret;
	}
	public String decodeString(String s) {
		ch=s.toCharArray();
		slen=s.length();
		pos=0;
		StringBuffer ret=f();
		return ret.toString();
	}
}
