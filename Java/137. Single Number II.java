/*
137. Single Number II
https://leetcode.com/problems/single-number-ii/
*/

// 15ms
// 计数法不可行，因为nums值的范围超过int
public class Solution {
	public int singleNumber(int[] nums) {
		Map<Integer,Integer> mp=new HashMap<Integer,Integer>();
		for (int n:nums)
			mp.put(n,0);
		for (int n:nums)
			mp.put(n,mp.get(n)+1);
		for (Map.Entry<Integer,Integer> e:mp.entrySet())
			if (e.getValue()==1)
				return e.getKey();
		return 1;
	}
}
