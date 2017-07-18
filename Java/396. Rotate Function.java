/*
396. Rotate Function
https://leetcode.com/problems/rotate-function/
*/

// 8ms
// 找rotate一个数字时F变化规律
// coef 0 1 2 3
//      4 3 2 6 = 25
//      6 4 3 2 = 25 + (4 3 2) - 6 * 3 = 16
//      2 6 4 3 = 16 + (6 4 3) - 2 * 3 = 23
public class Solution {
	public int maxRotateFunction(int[] A) {
		int len=A.length;
		int ret=0,sumA=0;
		for (int i=0;i<len;i++)
		{
			ret+=A[i]*i;
			sumA+=A[i];
		}
		int F=ret;
		for (int i=len-1;i>=0;i--)
		{
			int plusD=sumA-A[i];
			int minusD=A[i]*(len-1);
			int newF=F+plusD-minusD;
			if (newF>ret) ret=newF;
			F=newF;
		}
		return ret;
	}
}
