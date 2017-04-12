/*
056. Merge Intervals
https://leetcode.com/problems/merge-intervals/

cpp 89 ms
*/

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    int imax(int a,int b)
    {
        return a>b?a:b;
    }
    // 此处因为在结构体/类中所以需要加static？
    static bool cmp(const Interval &a,const Interval &b)
    {
        if (a.start!=b.start) return a.start<b.start;
        return a.end<b.end;
    }
    vector<Interval> merge(vector<Interval>& intervals) {
        vector<Interval> &ints=intervals;
        int len=ints.size();
        sort(ints.begin(),ints.end(),cmp);
        for (int i=1;i<len;i++)
        {
            if (ints[i-1].end>=ints[i].start)
            {
                ints[i].start=ints[i-1].start;
                ints[i].end=imax(ints[i-1].end,ints[i].end);
                ints[i-1].end=-1;
            }
        }
        vector<Interval>::iterator it=ints.begin();
        while (it!=ints.end())
            if (it->end==-1)
                it=ints.erase(it);
            else
                it++;
        return ints;
    }
};
