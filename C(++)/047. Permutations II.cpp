/*
047. Permutations II
https://leetcode.com/problems/permutations-ii/

cpp 43 ms
*/

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution {
public:
    vector<vector<int>> ans;
    set<vector<int>> st;
    vector<int> arr;
    int len;
    //vector<bool> flag;
    //vector<vector<bool>> vst; // visited
    bool flag[100];
    bool vst[100][100];
    void dfs(int p,vector<int> v)
    {
        if (p==len)
        {
            //ans.push_back(v);
            st.insert(v);
            return;
        }
        for (int i=0;i<len;i++)
        {
            if (i&&!flag[i-1]&&arr[i-1]==arr[i]&&vst[p][i-1])
            {
                vst[p][i]=true;
                continue;
            }
            if (!flag[i])
            {
                vst[p][i]=true;
                v.push_back(arr[i]);
                flag[i]=true;
                dfs(p+1,v);
                v.erase(v.end()-1);
                flag[i]=false;
            }
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        ans.clear();
        st.clear();
        arr=nums;
        len=arr.size();
        //flag=vector<bool>(len,false);
        //vst=vector<vector<bool>>(len,vector<bool>(len,false));
        memset(flag,0,sizeof(flag));
        memset(vst,0,sizeof(vst));
        sort(arr.begin(),arr.end());
        dfs(0,vector<int>());
        for (set<vector<int>>::iterator it=st.begin();it!=st.end();it++)
            ans.push_back(*it);
        return ans;
    }
};
