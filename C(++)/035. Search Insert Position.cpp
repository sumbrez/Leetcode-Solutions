/*
035. Search Insert Position
https://leetcode.com/problems/search-insert-position/

cpp 6 ms
*/

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

class Solution {
public:
    vector<int> n;
    int tg,len;
    int imin(int a,int b)
    {
        return a<b?a:b;
    }
    int go(int l,int r)
    {
        bool flag;
        while (l<=r)
        {
            int m=l+r>>1;
            if (tg<n[m])
                r=m-1,flag=true;
            else if (tg>n[m])
                l=m+1,flag=false;
            else
            {
                if (m-1>=0&&n[m-1]==tg)
                    return go(l,m-1);
                return m;
            }
        }
        // 没找到一定发生在初始层，更深的层不用考虑没找到的情况
        // 没找到时，要么r移到第一个的左边（-1），这时插在0位置
        // 要么l移到最后一个的右边（len），这是插在len位置
        if (flag)
        {
            if (r<0) r=0;
            else if (tg>n[r-1]) r++;
            return r;
        }
        return l;
    }
    int searchInsert(vector<int>& nums, int target) {
        n=nums;
        tg=target;
        len=n.size();
        return go(0,len-1);
    }
};
