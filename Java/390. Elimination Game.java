/*
390. Elimination Game
https://leetcode.com/problems/elimination-game/
*/

// 89ms
// 删除奇数，剩下偶数，将偶数/2变为奇数，其返回值的对称位置*2为结果
public class Solution {
	public int lastRemaining(int n) {
        if (n==1) return 1;
        int ret=2*(n/2-lastRemaining(n/2)+1);
		return ret;
	}
}

// n为大于1的奇数则可以先n--，第一次以步长为2删除若干数，然后求出下一次开始的位置，
// 然后以步长为4删除若干数，直到剩下一个，麻烦点为求下一次开始的位置
