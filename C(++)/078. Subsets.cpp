/*
078. Subsets
https://leetcode.com/problems/subsets/

cpp 6 ms
*/

/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
public:
    bool used[1000];
    vector<vector<int>> ret;
    vector<int> arr;
    // last: 上一次用到的最后一个数字的下标，确保从小到大
    void dfs(vector<int> temp,int depth,int n,int last)
    {
        ret.push_back(temp);
        if (depth==n)
            return;
        int i;
        for (int i=last+1;i<n;i++)
            if (!used[i])
            {
                temp.push_back(arr[i]);
                used[i]=true;
                dfs(temp,depth+1,n,i);
                // temp.erase(temp.rbegin())不行？
                vector<int>::iterator it=temp.begin(),it2;
                while (it!=temp.end())
                {
                    it2=it;
                    it++;
                }
                //temp.erase(temp.begin());
                temp.erase(it2);
                used[i]=false;
            }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        memset(used,0,sizeof(used));
        ret.clear();
        sort(nums.begin(),nums.end());
        arr=nums;
        dfs(vector<int>(),0,nums.size(),-1);
        return ret;
    }
};
