/*
003. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/

c 55 ms
*/

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

int lengthOfLongestSubstring(char* s)
{
    const int SCL=128;
    int abc[SCL][SCL],flag[SCL],len[SCL],ans=0,slen=strlen(s);
    memset(abc,0,sizeof(abc));
    memset(flag,0,sizeof(flag));
    memset(len,0,sizeof(len));
    if (slen>0) ans=1;
    for (int i=0;i<slen;i++)
    {
        int tag=0,idx=s[i];
        for (int j=0;j<SCL;j++)
        {
            if (flag[j])
                if (abc[j][idx])
                {
                    memset(abc[j],0,sizeof(abc[j]));
                    flag[j]=len[j]=0;
                }
                else
                {
                    abc[j][idx]=1;
                    len[j]++;
                    if (len[j]>ans)
                        ans=len[j];
                }
            else if (!tag)
                abc[j][idx]=flag[j]=len[j]=tag=1;
        }
    }
    return ans;
}
