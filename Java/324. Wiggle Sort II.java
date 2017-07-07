/*
324. Wiggle Sort II
https://leetcode.com/problems/wiggle-sort-ii/
*/

// 5ms
import java.util.Arrays;

public class Solution {
	public void wiggleSort(int[] nums) {
		int len=nums.length;
		if (len==0) return;
		Arrays.sort(nums);
		int temp[]=new int[len],half=(len+1)/2;
		// 大、小数都从小到大放则某些有重复值的数据出错，例如4,5,5,6
		for (int i=len-1,j=1;i>=half;i--,j+=2)
			temp[j]=nums[i];
		for (int i=half-1,j=0;i>=0;i--,j+=2)
			temp[j]=nums[i];
		for (int i=0;i<len;i++)
			nums[i]=temp[i];
	}
}
