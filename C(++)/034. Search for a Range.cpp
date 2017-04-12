/*
034. Search for a Range
https://leetcode.com/problems/search-for-a-range/

cpp 9 ms
*/

/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

class Solution {
public:
    vector<int> n;
    int tg;
    int INF=0x7fffffff;
    int imin(int a,int b)
    {
        return a<b?a:b;
    }
    int imax(int a,int b)
    {
        return a>b?a:b;
    }
    void go(int l,int r,int *al,int *ar)
    {
        while (l<r)
        {
            int m=(l+r)/2,v=n[m];
            if (v>tg)
                r--;
            else if (v<tg)
                l++;
            else
            {
                *al=*ar=m;
                int tal,tar;
                if (m-1>=l&&n[m-1]==tg)
                {
                    go(l,m-1,&tal,&tar);
                    *al=imin(*al,tal);
                    *ar=imax(*ar,tar);
                }
                if (m+1<=r&&n[m+1]==tg)
                {
                    go(m+1,r,&tal,&tar);
                    *al=imin(*al,tal);
                    *ar=imax(*ar,tar);
                }
                break;
            }
        }
        if (l==r&&n[l]==tg)
            *al=*ar=l;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        n=nums;
        tg=target;
        int al=-1,ar=-1;
        go(0,n.size()-1,&al,&ar);
        vector<int> ans;
        ans.push_back(al);
        ans.push_back(ar);
        return ans;
    }
};
