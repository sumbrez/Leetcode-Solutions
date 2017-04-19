/*
011. Container With Most Water
https://leetcode.com/problems/container-with-most-water/

java 11 ms
*/

public class Solution {
	public int imin(int a,int b)
	{
		return a<b?a:b;
	}
	public int maxArea(int[] height) {
		int ret=-1,ht[]=height,head=0,tail=ht.length-1;
		/*
		一端h的高度小于另一端t的高度，那么如果选择h端作为一条边，结果就确定了，
		t向左移动只会让结果变小；然而t端的高度没有充分利用，所以可以尝试将h端右移。
		较低的那一端总是被充分利用，所以将较低的一端“移向”较高的一端以寻找更好的结果。
		*/
		while (head<tail)
		{
			int area=(tail-head)*imin(ht[head],ht[tail]);
			if (ret<area) ret=area;
			
			if (ht[head]<ht[tail]) head++;
			else tail--;
		}
		return ret;
	}
}
