/*
388. Longest Absolute File Path
https://leetcode.com/problems/longest-absolute-file-path/
*/

// 3ms
import java.util.*;

public class Solution {
	public int lengthLongestPath(String input) {
		int slen=input.length();
		char in[]=input.toCharArray(); // 方便访问
		// 当前所处层级目录各层的名字长度
		List<Integer> lens=new ArrayList<Integer>();
		int st=0; // 记录根目录长度
		boolean file=false;
		while (st<slen&&in[st]!='\n')
			if (in[st++]=='.')
				file=true;
		if (file) return st; // 如果直接为当前目录下的文件
		// 根目录深度为0
		int predep=0,sumlen=st,ret=0;
		lens.add(st);
		for (int i=st+1;i<slen;i++) // st+1跳过第一个\n，i++跳过之后的各\n
		{
			int depth=0; // 当前层级深度
			while (i<slen&&in[i]=='\t')
			{
				depth++;
				i++;
			}
			
			// 获取当前层长度
			int temp=i;
			file=false;
			while (i<slen&&in[i]!='\n')
				if (in[i++]=='.')
					file=true;
			int curlen=i-temp;
			
			if (depth==predep+1) // 如果是前一次的下一级目录
			{
				if (lens.size()==depth)
					lens.add(curlen);
				else
					lens.set(depth,curlen);
			}
			else if (depth==predep) // 如果和前一次同目录
			{
				sumlen-=lens.get(depth);
				lens.set(depth,curlen);
			}
			else if (depth<predep) // 如果返回到某层上级目录
			{
				for (int j=predep;j>=depth;j--)
				{
					sumlen-=lens.get(j);
					lens.remove(j);
				}
				lens.add(curlen);
			}
			
			sumlen+=curlen;
			if (file&&sumlen+depth>ret) // 加上'/'的个数
				ret=sumlen+depth;
			predep=depth;
		}
		return ret;
	}
}
