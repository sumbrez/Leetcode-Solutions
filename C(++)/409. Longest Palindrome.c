/*
409. Longest Palindrome
https://leetcode.com/problems/longest-palindrome/

c 0 ms
*/

/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

    Input:
    "abccccdd"

    Output:
    7

    Explanation:
    One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

int getidx(char ch)
{
    if ('A'<=ch&&ch<='Z')
        return ch-'A';
    else
        return ch-'a'+26;
}
int longestPalindrome(char* s)
{
    const int SCL=53;
    int cnt[SCL],ans=0,flag=0;
    memset(cnt,0,sizeof(cnt));
    while (*s!='\0')
        cnt[getidx(*s++)]++;
    for (int i=0;i<SCL;i++)
        if (cnt[i]&1)
        {
            ans+=cnt[i]-1;
            flag=1;
        }
        else
            ans+=cnt[i];
    return ans+(flag==1?1:0);
}
