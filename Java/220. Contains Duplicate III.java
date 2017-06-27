/*
220. Contains Duplicate III
https://leetcode.com/problems/contains-duplicate-iii/
*/

// 69ms
public class Solution {
	// 值差为t，坐标差为k
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0) return false;
		// 用TreeSet维护一个大小为k的动态窗口记录nums的值
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			// 检查窗口中的值是否满足t
			Object fl=set.floor(n),ce=set.ceiling(n);
			if (fl != null && n <= t + (int)fl || ce != null && (int)ce <= t + n)
				return true;
			set.add(n);
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}
}
