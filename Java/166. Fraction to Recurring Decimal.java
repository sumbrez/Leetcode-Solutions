/*
166. Fraction to Recurring Decimal
https://leetcode.com/problems/fraction-to-recurring-decimal/
*/

// 6ms
public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		long n=(long)numerator,d=(long)denominator,z=0,neg=0;
		if (n==0) return "0";
		if (n<0) { n=-n; neg^=1; }
		if (d<0) { d=-d; neg^=1; }
		StringBuffer dm=new StringBuffer();
		if (neg==1) dm.append("-");
		if (n>=d)
		{
			z=n/d; // 整数部分
			n%=d;
		}
		dm.append(z);
		if (n==0) return dm.toString();
		dm.append(".");
		// mp: Map<上次余数*10（本次被除数）,本次商在dm中的下标>
		Map<Long,Integer> mp=new HashMap<Long,Integer>();
		int cnt=dm.length();
		while (n>0)
		{
			n*=10; // 本次被除数
			if (mp.containsKey(n)) // 如果出现过，说明循环小数部分已出现
			{
				dm.insert(mp.get(n),"(");
				dm.append(")");
				break;
			}
			else
				mp.put(n,cnt); // 记录这个被除数的商在dm中的下标
			dm.append(n/d);
			n%=d;
			cnt++;
		}
		return dm.toString();
	}
}
