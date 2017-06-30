/*
260. Single Number III
https://leetcode.com/problems/single-number-iii/
*/

// 1ms
public class Solution {
	public int[] singleNumber(int[] nums) {
		int ret[]=new int[2];
		int len=nums.length;
		int xor=0; // 任何数异或0保持不变
		for (int i=0;i<len;i++)
			xor^=nums[i];
		// xor最终即两个只出现一个的数的xor结果
		// -xor为xor补码，相&则为保留xor低位第一个1，其余为0
		// 这一位就是两个数第一个不同的位，根据这一位将数组分为两组，分别异或
		xor&=-xor;
		for (int i=0;i<len;i++)
			if ((xor&nums[i])==0)
				ret[0]^=nums[i];
			else
				ret[1]^=nums[i];
		return ret;
	}
}
