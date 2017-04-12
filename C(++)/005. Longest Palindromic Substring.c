/*
005. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/

c 3 ms
*/

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.

Example:

Input: "cbbd"

Output: "bb"
*/

int imin(int a,int b)
{
    return a<b?a:b;
}
char* longestPalindrome(char* s) {
    char *ss=(char*)malloc(2005*sizeof(char));
    int l=strlen(s);
    for (int i=0;i<l;i++)
    {
        ss[i<<1]='\0';
        ss[i<<1|1]=s[i];
    }
    ss[l<<1]='\0';
    l=l<<1|1;
    int mr=0,le,r,id,R[2005];
    for (int i=0;i<l;i++)
    {
        if (mr>i) R[i]=imin(R[id*2-i],mr-i+1);
        else R[i]=1;
        while ((le=i-R[i])>=0&&(r=i+R[i])<l&&ss[le]==ss[r])
            R[i]++;
        if (i+R[i]-1>mr)
        {
            mr=i+R[i]-1;
            id=i;
        }
    }
    mr=0; // most right / max radius
    for (int i=0;i<l;i++)
    {
        if (R[i]>mr)
        {
            id=i;
            mr=R[i];
        }
    }
    int p=0;
    for (int i=id-R[id]+1;i<id+R[id];i++)
        if (ss[i]!='\0')
            s[p++]=ss[i];
    s[p]='\0';
    return s;
}
