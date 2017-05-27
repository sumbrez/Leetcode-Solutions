/*
031. Next Permutation
https://leetcode.com/problems/next-permutation/

java 25 ms
*/

public class Solution {
	public void nextPermutation(int[] nums) {
		int len=nums.length,from=0;
		boolean flag=false;
		// 依次放宽寻找界限，没有外层界限的话例如1,3,4,2会出错
		for (int i=len-2;i>=0&&!flag;i--)
			for (int j=len-1;j>i&&!flag;j--) // 此次考虑哪一位
				for (int k=j-1;k>=i;k--) // 这一位是否比前边某一位大
					if (nums[j]>nums[k]) // 是则交换这两位
					{
						from=k+1;
						int temp=nums[k];
						nums[k]=nums[j];
						nums[j]=temp;
						flag=true;
						break;
					}
		Arrays.sort(nums,from,len); // 重新排序之后的部分
	}
}
