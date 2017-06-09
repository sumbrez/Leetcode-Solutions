/*
134. Gas Station
https://leetcode.com/problems/gas-station/
*/

// 从耗时和用例数来看输入数据范围很小，直接暴力没问题
// 一个优化是，将连续的正/负net合并

// 1ms
// 解唯一，则minidx后的下一个正net即为解
public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len=gas.length,net[]=new int[len];
		int min=0x3f3f3f3f,minidx=-1,sum=0;
		for (int i=0;i<len;i++)
		{
			net[i]=gas[i]-cost[i];
			sum+=net[i];
			if (net[i]<min)
			{
				min=net[i];
				minidx=i;
			}
		}
		if (sum<0) return -1;
		for (int i=0;i<len;i++)
		{
			int idx=minidx+i;
			if (idx>=len) idx%=len;
			if (net[idx]>=0) return idx;
		}
		return -1;
	}
}

//----------
public class Solution {
	int len,net[];
	boolean judge(int st) // 判断从st位置出发是否可行
	{
		int sum=0;
		for (int i=0;i<len;i++)
		{
			int idx=st+i;
			if (idx>=len) idx%=len;
			sum+=net[idx];
			if (sum<0) return false;
		}
		return true;
	}
	public int canCompleteCircuit(int[] gas, int[] cost) {
		len=gas.length;
		net=new int[len];
		int min=0x3f3f3f3f,minidx=-1,sum=0;
		for (int i=0;i<len;i++)
		{
			net[i]=gas[i]-cost[i];
			sum+=net[i];
			if (net[i]<min)
			{
				min=net[i];
				minidx=i;
			}
		}
		if (sum<0) return -1;
		for (int i=0;i<len;i++)
		{
		// 从net最小位置开始找，因为这个位置很有可能位于可行解的末尾几站
			int idx=minidx+i;
			if (idx>=len) idx%=len;
			if (net[idx]>=0)
			{
				boolean flag=judge(idx);
				if (flag) return idx;
			}
		}
		return -1;
	}
}
