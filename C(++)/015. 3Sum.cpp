/*
015. 3Sum
https://leetcode.com/problems/3sum/

cpp 112ms
*/

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        set<vector<int>> st;
        vector<vector<int>> v;
        sort(nums.begin(),nums.end());
        int l=nums.size();
        for (int i=0;i<l;i++)
        {
            if (i>0&&nums[i]==nums[i-1]) continue;
            int s=i+1,e=l-1;
            while (s<e)
            {
                if (s==i) { s++; continue; }
                if (e==i) { e--; continue; }
                if (nums[s]+nums[e]>-nums[i])
                    e--;
                else if (nums[s]+nums[e]<-nums[i])
                    s++;
                else
                {
                    vector<int> t;
                    t.push_back(nums[i]);
                    t.push_back(nums[s]);
                    t.push_back(nums[e]);
                    sort(t.begin(),t.end());
                    st.insert(t);
                    s++;
                    e--;
                }
            }
        }
        set<vector<int>>::iterator it=st.begin();
        for (;it!=st.end();it++)
            v.push_back(*it);
        return v;
    }
};
