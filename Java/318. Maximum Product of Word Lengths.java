/*
318. Maximum Product of Word Lengths
https://leetcode.com/problems/maximum-product-of-word-lengths/
*/

// 34ms
public class Solution {
	public int maxProduct(String[] words) {
		int len=words.length;
		if (len<=1) return 0;
		int bits[]=new int[len],ret=0;
		for (int i=0;i<len;i++)
		{
			char ch[]=words[i].toCharArray();
			for (int j=0;j<ch.length;j++)
				bits[i]|=1<<(ch[j]-'a');
			for (int j=0;j<i;j++)
				if ((bits[i]&bits[j])==0)
				{
					int temp=words[i].length()*words[j].length();
					if (temp>ret)
						ret=temp;
				}
		}
		return ret;
	}
}
