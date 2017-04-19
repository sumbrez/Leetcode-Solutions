/*
004. Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/

java 65 ms
*/

// lsum=p1-st1+1+p2-st2，并且比较时使用lsum<=k-1会TLE
public class Solution {
	public double direct(int temp[])
	{
		int len=temp.length;
		if (len%2==1) return temp[len/2];
		else return (temp[len/2-1]+temp[len/2])/2.;
	}
	public int kthmin(int arr1[],int arr2[],int k)
	{
        int st1=0,ed1=arr1.length-1,p1=arr1.length/2;
        int st2=0,ed2=arr2.length-1,p2=arr2.length/2;
        while (true)
        {
        	// 如果总个数正好为k，那么最大的那个就是
        	if (ed1-st1+1+ed2-st2+1==k)
        		return arr1[ed1]>arr2[ed2]?arr1[ed1]:arr2[ed2];
        	int lsum=p1-st1+1+p2-st2+1; // 有lsum个数比arr2[p2]或arr1[p1]小
        	if (arr1[p1]<arr2[p2])
        	{
        		/* 这里如果lsum==k-1，并不能直接返回arr2[p2]
        		因为arr1[p1+1~ed1]和arr2[p2]的大小关系未知，例如{1,2,3}和{4,5} */
        		
        		// 比arr2[p2]小的数不够k-1个，意味着答案是比arr2[p2]大的数
        		// 等号放在这里，因为arr1[p1+1~ed1]不确定，而确定去除arr1[st1~p1]
        		if (lsum<=k)
        		{
        			k-=p1-st1+1; // 这些数都比arr2[p2]小，以后不关心
        			st1=p1+1;
        			p1=(st1+ed1)/2;
        		}
        		else // 答案在arr1[0~p1]和arr2[0~p2-1]中
        		{
        			ed2=p2-1;
        			p2=(st2+ed2)/2;
        		}
        	}
        	else if (arr1[p1]>=arr2[p2])
        	{
        		if (lsum<=k)
        		{
        			k-=p2-st2+1;
        			st2=p2+1;
        			p2=(st2+ed2)/2;
        		}
        		else
        		{
        			ed1=p1-1;
        			p1=(st1+ed1)/2;
        		}
        	}
        	// 如果其中一个去处完了，那么答案在另一个数组中的位置直接确定
        	if (st1>ed1) return arr2[st2+k-1];
        	if (st2>ed2) return arr1[st1+k-1];
        }
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0)
        	return direct(nums2);
        if (nums2.length==0)
        	return direct(nums1);
        
        int sumlen=nums1.length+nums2.length;
        double ret=kthmin(nums1,nums2,sumlen/2+1)*1.;
        if (sumlen%2==0)
        	ret=(ret+kthmin(nums1,nums2,sumlen/2))/2.;
        return ret;
    }
}
