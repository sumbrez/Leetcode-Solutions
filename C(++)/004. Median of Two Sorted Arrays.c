/*
004. Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/

c 19 ms
*/

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

int work(int *a1,int l1,int *a2,int l2,int k)
{
    int s1=0,e1=l1-1,s2=0,e2=l2-1,p1=l1/2,p2=l2/2,lsum;
    while (1)
    {
        if (e1-s1+1+e2-s2+1==k) return a1[e1]>a2[e2]?a1[e1]:a2[e2];
        lsum=p1-s1+1+p2-s2+1;
        if (a1[p1]<a2[p2])
        {
            if (lsum>k)
            {
                e2=p2-1;
                p2=s2+(e2-s2+1)/2;
            }
            else if (lsum<=k)
            {
                k-=(p1-s1+1);
                s1=p1+1;
                p1=s1+(e1-s1+1)/2;
            }
        }
        else
        {
            if (lsum>k)
            {
                e1=p1-1;
                p1=s1+(e1-s1+1)/2;
            }
            else if (lsum<=k)
            {
                k-=(p2-s2+1);
                s2=p2+1;
                p2=s2+(e2-s2+1)/2;
            }
        }
        if (s1>e1) return a2[s2+k-1];
        if (s2>e2) return a1[s1+k-1];
    }
}
double direct(int *a,int l)
{
    if (l&1) return (double)a[l/2];
    else return ((double)a[l/2-1]+a[l/2])/2;
}
double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int *a1=nums1,l1=nums1Size,*a2=nums2,l2=nums2Size,n=l1+l2;
    if (l1==0)
        return direct(a2,l2);
    if (l2==0)
        return direct(a1,l1);
    double ans=work(a1,l1,a2,l2,(n+1)/2);
    if (!(n&1))
        ans=(ans+work(a1,l1,a2,l2,n/2+1))/2;
    return ans;
}
