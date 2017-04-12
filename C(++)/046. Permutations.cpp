/*
046. Permutations
https://leetcode.com/problems/permutations/

cpp 16 ms
*/

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
public:
    vector<vector<int>> ans;
    vector<int> arr;
    int len;
    vector<bool> flag;
    void dfs(int p,vector<int> v)
    {
        if (p==len)
        {
            ans.push_back(v);
            return;
        }
        for (int i=0;i<len;i++)
        {
            if (!flag[i])
            {
                v.push_back(arr[i]);
                flag[i]=true;
                dfs(p+1,v);
                v.erase(v.end()-1);
                flag[i]=false;
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        ans.clear();
        arr=nums;
        len=arr.size();
        flag=vector<bool>(len,false);
        sort(arr.begin(),arr.end());
        dfs(0,vector<int>());
        return ans;
    }
};
