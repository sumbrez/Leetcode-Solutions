/*
384. Shuffle an Array
https://leetcode.com/problems/shuffle-an-array/
*/

// 281ms
// 要求等概率返回一种排列，实现时每一位给一个随机数，表示这一位使用的还未使用的数的序号
import java.util.*;

public class Solution {

	int nums[],temp[],len;
	boolean flag[];
	Random rnd;
	public Solution(int[] nums) {
		this.nums=nums;
		temp=nums.clone();
		len=nums.length;
		flag=new boolean[len];
		rnd=new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		for (int i=0;i<len;i++)
			temp[i]=nums[i];
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		Arrays.fill(flag,false);
		for (int i=0;i<len;i++)
		{
			int r=rnd.nextInt(len-i),j=0;
			while (r>=0)
			{
				if (!flag[j])
					r--;
				j++;
			}
			j--;
			temp[i]=nums[j];
			flag[j]=true;
		}
		return temp;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
