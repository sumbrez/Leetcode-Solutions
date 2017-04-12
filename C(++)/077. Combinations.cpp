/*
077. Combinations
https://leetcode.com/problems/combinations/

cpp 193 ms
*/

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
public:
    bool used[1000];
    vector<vector<int>> ret;
    void dfs(vector<int> temp,int depth,int n,int k)
    {
        if (depth==k)
        {
            ret.push_back(temp);
            return;
        }
        int i;
        if (temp.size()==0) i=1; // 确保从小到大，去除重复
        else i=temp[temp.size()-1];
        for (;i<=n;i++)
            if (!used[i])
            {
                temp.push_back(i);
                used[i]=true;
                dfs(temp,depth+1,n,k);
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
    vector<vector<int>> combine(int n, int k) {
        memset(used,0,sizeof(used));
        ret.clear();
        if (n<k) return ret;
        dfs(vector<int>(),0,n,k);
        return ret;
    }
};
