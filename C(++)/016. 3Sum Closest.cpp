/*
016. 3Sum Closest
https://leetcode.com/problems/3sum-closest/

cpp 16 ms
*/

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

class Solution {
public:
    int iabs(int a)
    {
        return a<0?-a:a;
    }
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        int l=nums.size(),ans=0,dd=0x7fffffff;
        for (int i=0;i<l;i++)
        {
            int d=0x7fffffff;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int s=0,e=l-1;
            while (s<e)
            {
                if (s==i) { s++; continue; }
                if (e==i) { e--; continue; }
                int sum=nums[i]+nums[s]+nums[e],tmp=iabs(sum-target);
                if (tmp<d)
                    d=tmp;
                if (tmp<dd)
                {
                    ans=sum;
                    dd=tmp;
                }
                if (sum>target)
                    e--;
                else if (sum<target)
                    s++;
                else
                    return sum;
            }
        }
        return ans;
    }
};
