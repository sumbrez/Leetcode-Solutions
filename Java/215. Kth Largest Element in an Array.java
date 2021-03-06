/*
215. Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

// 3ms
import java.util.Arrays;

public class Solution {
	public int findKthLargest(int[] nums, int k) {
		if (nums.length==0) return -1;
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
}
