/*
406. Queue Reconstruction by Height
https://leetcode.com/problems/queue-reconstruction-by-height/
*/

// 20ms
import java.util.*;

public class Solution {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<Object>() {
			@Override
			public int compare(Object oa, Object ob) {
				int[] a = (int[]) oa;
				int[] b = (int[]) ob;
				if (a[0] < b[0])
					return 1;
				else if (a[0] > b[0])
					return -1;
				else
				{
					if (a[1] > b[1])
						return 1;
					else if (a[1] < b[1])
						return -1;
					else
						return 0;
				}
			}
		});
		List<int[]> lst=new ArrayList<int[]>();
		for (int i=0;i<people.length;i++)
		{
			int p[]=people[i];
			lst.add(p[1],p);
		}
		return lst.toArray(new int[people.length][2]);
	}
}
