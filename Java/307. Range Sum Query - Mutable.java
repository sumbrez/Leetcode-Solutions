/*
307. Range Sum Query - Mutable
https://leetcode.com/problems/range-sum-query-mutable/
*/

// 112ms
// 树状数组，C数组下标从1开始
public class NumArray {

	int nlen,A[],C[];
	int lowbit(int x)
	{
		return x&(-x);
	}
	int getsum(int pos) 
	{
		int ret=0;
		while(pos>0)
		{
			ret+=C[pos];
			pos-=lowbit(pos);
		}
		return ret;
	}
	void iupdate(int i,int d)
	{
		while(i<=nlen)
		{
			C[i]+=d;
			i+=lowbit(i);
		}
	}
	public void update(int i, int val) {
		int d=val-A[i];
		iupdate(i+1,d);
		A[i]=val;
	}
	
	public NumArray(int[] nums) {
		nlen=nums.length;
		A=nums;
		C=new int[nlen+1];
		for (int i=0;i<nlen;i++)
			iupdate(i+1,nums[i]);
	}

	public int sumRange(int i, int j) {
		int ret=getsum(j+1)-getsum(i);
		return ret;
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
