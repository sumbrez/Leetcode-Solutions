/*
006. ZigZag Conversion
https://leetcode.com/problems/zigzag-conversion/

java 87 ms
*/

public class Solution {
    public String convert(String s, int numRows) {
    	if (numRows==1) return s;
    	
    	int nr=numRows,slen=s.length(),cnt[]=new int[slen];
    	char zig[][]=new char[nr][slen];
    	for (int i=0,col=0;i<slen;col++)
    	{
    		int mod=col%(nr-1),row=nr-1-mod;
    		if (mod==0)
    			for (int j=0;j<nr&&i<slen;j++)
    				zig[j][cnt[j]++]=s.charAt(i++);
    		else
    			zig[row][cnt[row]++]=s.charAt(i++);
    	}
    	
    	if (slen<nr) nr=slen;
    	
    	char ret[]=new char[slen];
    	for (int i=0,idx=0;i<nr;i++)
    		for (int j=0;j<cnt[i];j++)
    			ret[idx++]=zig[i][j];
        return String.valueOf(ret);
    }
}
