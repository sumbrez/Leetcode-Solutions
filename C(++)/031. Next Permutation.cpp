/*
031. Next Permutation
https://leetcode.com/problems/next-permutation/

cpp 12 ms
*/

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int len=nums.size(),i=len-1;
        if (len==1) return;
        while (i>0&&nums[i-1]>=nums[i])
            i--;
        if (i==0)
        {
            sort(nums.begin(),nums.end());
            return;
        }
        int p=i,mi=nums[i];
        for (int j=i+1;j<len;j++)
            if (mi>nums[j]&&nums[i-1]<nums[j])
                p=j;
        int t=nums[i-1];
        nums[i-1]=nums[p];
        nums[p]=t;
        sort(nums.begin()+i,nums.end());
    }
};
