/*
075. Sort Colors
https://leetcode.com/problems/sort-colors/

c 3 ms
*/

/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/

void sortColors(int* nums, int numsSize) {
    int cnt[3]={0},n=numsSize;
    for (int i=0;i<n;i++)
        cnt[nums[i]]++;
    int idx[3]={0,cnt[0],cnt[0]+cnt[1]},temp[n];
    for (int i=0;i<n;i++)
        temp[idx[nums[i]]++]=nums[i];
    memcpy(nums,temp,sizeof(int)*n);
}
