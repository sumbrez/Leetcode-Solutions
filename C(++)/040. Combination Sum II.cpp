/*
040. Combination Sum II
https://leetcode.com/problems/combination-sum-ii/

cpp 46 ms
*/

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

class Solution {
public:
    /*class Cmp  
    {
    public:
        bool operator() (const vector<int> &a,const vector<int> &b) const
        {
            int al=a.size(),bl=b.size();
            for (int i=0;i<al&&i<bl;i++)
                if (a[i]<b[i]) return true;
                else if (a[i]>b[i]) return false;
            return true;
        }
    };*/
    
    int len,TG;
    vector<int> arr;
    set<vector<int>> ret;
    void go(int p,int tg,vector<int> t,int sum)
    {
        if (p>=len||tg<arr[p])
        {
            if (sum==TG)
                ret.insert(t);
            return;
        }
        if (tg>=arr[p])
            for (int i=0;i<=1;i++)
            {
                if (i)
                    t.push_back(arr[p]);
                go(p+1,tg-i*arr[p],t,sum+i*arr[p]);
                if (i)
                    t.erase(t.end()-1);
            }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        ret.clear();
        arr.clear();
        vector<int> tmp=candidates;
        len=tmp.size();
        int tg=TG=target;
        for (int i=0;i<len;i++)
            if (tmp[i]<=tg)
                arr.push_back(tmp[i]);
        len=arr.size();
        sort(arr.begin(),arr.end());
        
        go(0,tg,vector<int>(),0);
        //sort(ret.begin(),ret.end(),cmp);
        vector<vector<int>> ans;
        set<vector<int>>::iterator it=ret.begin();
        for (;it!=ret.end();it++)
            ans.push_back(*it);
        return ans;
    }
};
