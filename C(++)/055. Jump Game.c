/*
055. Jump Game
https://leetcode.com/problems/jump-game/

c 16 ms
*/

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

bool canJump(int* nums, int numsSize) {
    int n=numsSize;
    if (!n) return true;
    bool flag[n];
    memset(flag,0,sizeof(flag));
    for (int i=0;i<n-1;i++)
        memset(flag+i+1,1,nums[i]*sizeof(bool));
    for (int i=1;i<n;i++)
        if (!flag[i])
            return false;
    return true;
}
