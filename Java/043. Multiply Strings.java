/*
043. Multiply Strings
https://leetcode.com/problems/multiply-strings/

Java 38 ms
*/

public class Solution {
	int MX=218;
	public String multiply(String num1, String num2) {
		int len1=num1.length(),len2=num2.length();
		int temp1[]=new int[MX];
		for (int i=len1-1;i>=0;i--)
		{
			int temp2[]=new int[MX];
			int digit1=num1.charAt(i)-'0';
			for (int j=len2-1,pos=MX-1-(len1-1-i);j>=0;j--,pos--)
				temp2[pos]=digit1*(num2.charAt(j)-'0');
			for (int j=MX-1-(len1-1-i);j>=0;j--)
				temp1[j]+=temp2[j];
		}
		for (int i=MX-1;i>0;i--)
			if (temp1[i]>9)
			{
				temp1[i-1]+=temp1[i]/10;
				temp1[i]%=10;
			}
		int st=0;
		while (st<MX&&temp1[st]==0) st++;
		if (st==MX) return String.valueOf('0');
		
		char ret[]=new char[MX-st];
		for (int i=MX-st-1;i>=0;i--)
			ret[i]=(char)(temp1[i+st]+'0');
		return String.valueOf(ret);
	}
}
