/*
386. Lexicographical Numbers
https://leetcode.com/problems/lexicographical-numbers/
*/

// 192ms
import java.util.*;

public class Solution {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> ret=new ArrayList<Integer>();
		int v=1;
		for (int i=0;i<n;i++)
		{
			ret.add(v);
			// 先尽量补0
			if (v*10<=n)
				v*=10;
			else
			{
				// 如果补0大于n，先判断原来v是否>=n，这里的=是避免重复值
				if (v>=n)
					v/=10;
				// 补0不行则加1
				v++;
				// 如果加到进位，则去除末尾的0保证字典序
				while (v%10==0)
					v/=10;
			}
		}
		return ret;
	}
}
