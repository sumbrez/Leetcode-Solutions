/*
039. Combination Sum
https://leetcode.com/problems/combination-sum/

cpp 185 ms
*/

/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

class Solution {
public:
    int mul=1e5,len,tgt;
    vector<int> arr;
    vector<vector<int>> ans;
    static bool cmp(const vector<int> &a,vector<int> &b)
    {
        int al=a.size(),bl=b.size();
        for (int i=0;i<al&&i<bl;i++)
            if (a[i]<b[i]) return true;
            else if (a[i]>b[i]) return false;
        return true;
    }
    void go(int p,int tg,vector<int> ret)
    {
        if (p>=len)
        {
            if (ret.size()>0)
            {
                int sum=0;
                vector<int> t;
                for (int tlen=ret.size(),i=0;i<tlen;i++)
                {
                    int cnt=ret[i]/mul,num=ret[i]%mul;
                    sum+=cnt*num;
                    while (cnt--)
                        t.push_back(num);
                }
                if (sum==tgt)
                    ans.push_back(t);
            }
            return;
        }
        int tlen=tg/arr[p];
        for (int i=0;i<=tlen;i++)
        {
            ret.push_back(i*mul+arr[p]);
            go(p+1,tg-i*arr[p],ret);
            ret.erase(ret.end()-1);
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        ans.clear();
        arr.clear();
        vector<int> tmp=candidates;
        len=tmp.size();
        int tg=tgt=target;
        for (int i=0;i<len;i++)
            if (tmp[i]<=tg)
                arr.push_back(tmp[i]);
        len=arr.size();
        sort(arr.begin(),arr.end());
        
        go(0,tg,vector<int>());
        sort(ans.begin(),ans.end(),cmp);
        return ans;
    }
};
