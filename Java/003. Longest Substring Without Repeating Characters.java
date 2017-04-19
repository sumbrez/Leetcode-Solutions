/*
003. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Java 66 ms
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int []len=new int[s.length()];
    	boolean []flag=new boolean[128];
    	int tail=0,ret=0;
    	for (int i=0;i<s.length();i++)
    	{
    		if (i>0) len[i]=len[i-1]-1;
    		for (;tail<s.length();tail++)
    		{
    			int idx=s.charAt(tail);
                if (flag[idx]==false)
                {
                    len[i]++;
                    flag[idx]=true;
                }
                else
                {
                    flag[s.charAt(i)]=false;
                    break;
                }
            }
            if (len[i]>ret) ret=len[i];
        }
        return ret;
    }
}
