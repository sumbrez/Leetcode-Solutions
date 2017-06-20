/*
179. Largest Number
https://leetcode.com/problems/largest-number/
*/

// 6ms
#include <stdio.h>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string itos(int a)
{
    if (a==0) return "0";
    int t=a,len=0;
    while (t)
    {
        len++;
        t/=10;
    }
    char s[len+1];
    for (int i=len-1;i>=0;i--,a/=10)
        s[i]=a%10+'0';
    s[len]='\0';
    return string(s);
}
bool cmp(int a,int b)
{
    if (a==0) return false;
    if (b==0) return true;
    string s1=itos(a),s2=itos(b);
    int len1=s1.length(),len2=s2.length();
    int i=0;
    while (i<len1&&i<len2)
    {
        if (s1[i]>s2[i])
            return true;
        if (s1[i]<s2[i])
            return false;
        i++;
    }
    // a==b则以下任意一个都可行
    while (i<len1||i<len2)
    {
        if (i>=len1) // a走到头，则b的i位和j位比
            for (int j=0;j<i;j++)
                if (s2[i]!=s2[j])
                    return s2[i]<s2[j];
        if (i>=len2) // 相反b走到头
            for (int j=0;j<i;j++)
                if (s1[i]!=s1[j])
                    return s1[i]>s1[j];
        i++;
    }
    return true;
}
class Solution {
public:
    string largestNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end(),cmp);
        int len=nums.size();
        if (nums[0]==0) return "0"; // 全为0
        string ret="";
        for (int i=0;i<len;i++)
            ret.append(itos(nums[i]));
        return ret;
    }
};
