/*
011. Container With Most Water
https://leetcode.com/problems/container-with-most-water/

c 9 ms
*/

/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

int imin(int a,int b)
{
    return a<b?a:b;
}
int imax(int a,int b)
{
    return a>b?a:b;
}
#define VOL (imin(*s,*e)*(ei-si))
int maxArea(int* height, int heightSize) {
    int *s=height,*e=s+heightSize-1,si=1,ei=heightSize,ans=VOL;
    int c=1;
    while (si<ei)
    {
        while (si<ei&&*s<=*e)
        {
            s++;
            si++;
            ans=imax(ans,VOL);
        }
        while (si<ei&&*s>*e)
        {
            e--;
            ei--;
            ans=imax(ans,VOL);
        }
    }
    return ans;
}
