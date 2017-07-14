/*
373. Find K Pairs with Smallest Sums
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
*/

// 8ms
import java.util.*;

public class Solution {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<int[]>();
		int len1 = nums1.length,len2 = nums2.length;
		if (len1 == 0 || len2 == 0) return ret;
		boolean visit[][] = new boolean[len1][len2];
		Queue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] i, int[] j) {
				return (nums1[i[0]] + nums2[i[1]] - ( nums1[j[0]] + nums2[j[1]]));
			}
		});

		heap.add(new int[] { 0, 0 });
		visit[0][0] = true;

		while (!heap.isEmpty() && ret.size() < k) {
			int d[] = heap.poll();
			ret.add(new int[] { nums1[d[0]], nums2[d[1]] });

			if (d[1] + 1 < len2 && visit[d[0]][d[1] + 1] == false) {
				heap.add(new int[] { d[0], d[1] + 1 });
				visit[d[0]][d[1] + 1] = true;
			}
			if (d[0] + 1 < len1 && visit[d[0]+1][d[1]] == false) {
				heap.add(new int[] { d[0]+1, d[1]});
				visit[d[0]+1][d[1]] = true;
			}
		}
		return ret;
	}
}

// 原始做法：维护下标，记录nums1中的i个数匹配到nums2中第pos[i]个数
import java.util.*;

public class Solution {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret=new ArrayList<int[]>();
		int len1=nums1.length,len2=nums2.length;
		if (len1==0||len2==0) return ret;
		int cnt=0,rem=len1;
		int pos[]=new int[len1];
		boolean flag[]=new boolean[len1];
		while (cnt<k&&rem>0)
		for (int i=0;i<len1&&cnt<k;i++)
		{
			int th;
			int j=i+1;
			//while (j<len1&&pos[j]>=len2)
			while (j%len1!=i&&!flag[j%len1]&&pos[j%len1]==len2)
			{
				if (pos[j%len1]==len2&&!flag[j%len1])
				{
					rem--;
					flag[j%len1]=true;
				}
				j++;
				if (j==len2) j=0;
			}
			if (j%len1==i) continue;
			if (j==len1) j=0;
//			if (j>=len1) continue;
			th=nums1[j]+nums2[pos[j]];
			for (;pos[i]<len2&&cnt<k;pos[i]++)
			{
				int val=nums1[i]+nums2[pos[i]];
				if (val>th)
					break;
				ret.add(new int[]{nums1[i],nums2[pos[i]]});
				cnt++;
			}
		}
		return ret;
	}
}
