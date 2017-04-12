/*
091. Decode Ways
https://leetcode.com/problems/decode-ways/

c 3 ms
*/

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

// cnt[i]：从下标i开始构成的子串支持多少种解法
int cnt[10000];
int stoi(char a,char b)
{
    if (b=='\0') return a-'0';
    return (a-'0')*10+b-'0';
}
void dfs(int depth,char *s)
{
    // 最后一个数，则为1种
    if (*(s+1)=='\0')
    {
        cnt[depth]=(*s>'0');
        return;
    }
    dfs(depth+1,s+1); // 从末尾开始找
    
    // 当前位作为一个字母，则至少等同于depth+1开始的子串的解法数
    if (*s>'0')
        cnt[depth]=cnt[depth+1];
    else
        cnt[depth]=0;
    
    // 如果当前和下一位构成10~26的数，那么这两个数作为一个字母
    // 之后的数的解法数即为这种情况下的解法数（第一位不能为0）
    int val=stoi(*s,*(s+1));
    if (10<=val&&val<=26)
        cnt[depth]+=cnt[depth+2];
}
int numDecodings(char* s) {
    if (s==NULL||*s=='\0') return 0;
    
    char *temp=s;
    int len=0;
    while (*temp++!='\0')
        len++;
    cnt[len]=1; // 结束符为1种解法，方便dfs
    
    dfs(0,s);
    return cnt[0];
}
