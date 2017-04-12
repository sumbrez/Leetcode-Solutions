/*
018. 4Sum
https://leetcode.com/problems/4sum/

cpp 79 ms
*/

/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        set<vector<int>> st;
        vector<vector<int>> ret;
        sort(nums.begin(),nums.end());
        int len=nums.size();
        for (int i=0;i<len;i++)
            for (int j=i+1;j<len;j++)
            {
                int m=j+1,n=len-1,s=nums[i]+nums[j];
                while (m<n)
                {
                    if (m==i||m==j)
                    {
                        m++;
                        continue;
                    }
                    if (n==i||n==j)
                    {
                        n--;
                        continue;
                    }
                    int ss=s+nums[m]+nums[n];
                    if (ss==target)
                    {
                        vector<int> v;
                        v.push_back(nums[i]);
                        v.push_back(nums[j]);
                        v.push_back(nums[m]);
                        v.push_back(nums[n]);
                        st.insert(v);
                        m++;
                        n--;
                    }
                    else if (ss<target)
                        m++;
                    else
                        n--;
                }
            }
        set<vector<int>>::iterator it=st.begin();
        for (;it!=st.end();it++)
            ret.push_back(*it);
        return ret;
    }
};
