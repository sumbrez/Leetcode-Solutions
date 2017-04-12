/*
090. Subsets II
https://leetcode.com/problems/subsets-ii/

cpp 12 ms
*/

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

// 借用set容器去重的简单做法
class Solution {
public:
    bool used[1000];
    vector<vector<int>> ret;
    set<vector<int>> sret;
    vector<int> arr;
    // last: 上一次用到的最后一个数字的下标，确保从小到大
    void dfs(vector<int> temp,int depth,int n,int last)
    {
        //ret.push_back(temp);
        sret.insert(temp);
        if (depth==n)
            return;
        int i;
        for (int i=last+1;i<n;i++)
            if (!used[i])
            {
                temp.push_back(arr[i]);
                used[i]=true;
                dfs(temp,depth+1,n,i);
                // rbegin()为reverse_iterator不能用于erase
                temp.erase(temp.end()-1);
                used[i]=false;
            }
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        memset(used,0,sizeof(used));
        ret.clear();
        sret.clear();
        sort(nums.begin(),nums.end());
        arr=nums;
        dfs(vector<int>(),0,nums.size(),-1);
        set<vector<int>>::iterator it=sret.begin();
        for (;it!=sret.end();it++)
            ret.push_back(*it);
        return ret;
    }
};
