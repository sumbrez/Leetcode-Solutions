/*
093. Restore IP Addresses
https://leetcode.com/problems/restore-ip-addresses/

c 3 ms
*/

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
char *str,**ret;
int slen,cnt;
int valid(char *st,char *ed) // ed：结束位的下一位
{
    if (*st=='0'&&(st+1)!=ed) return 0; // 有前导0的数
    int seg=*st-'0';
    while (++st!=ed)
        seg=seg*10+*st-'0';
    if (0<=seg&&seg<=255)
        return 1;
    return 0;
}
void dfs(int depth,int stpos,char *ip,int iplen)
{
    if (depth==4)
    {
        if (iplen==slen+4) // 原长度+4个点
        {
            ip[iplen-1]='\0'; // 最后一个点变为'\0'
            ret[cnt]=(char*)malloc(sizeof(char)*iplen);
            memcpy(ret[cnt],ip,sizeof(char)*iplen);
            cnt++;
        }
    }
    for (int i=1;i<4;i++) // 分别尝试将接下来的i个数作为一小段
    {
        if (stpos+i<=slen // 结束位的下一位最多在第slen下标处（'\0'处）
            &&valid(str+stpos,str+stpos+i))
        {
            for (int j=0;j<i;j++)
                ip[iplen+j]=str[stpos+j];
            ip[iplen+i]='.'; // 此处第四小段之后也加'.'
            dfs(depth+1,stpos+i,ip,iplen+i+1);
        }
    }
}
char** restoreIpAddresses(char* s, int* returnSize) {
    str=s;
    slen=cnt=0;
    ret=(char**)malloc(sizeof(char*)*100);
    while (*s++!='\0')
        slen++;
    if (slen<4||slen>12)
    {
        *returnSize=0;
        return NULL;
    }
    
    char ip[16];
    dfs(0,0,ip,0);
    *returnSize=cnt;
    ret=(char**)realloc(ret,sizeof(char*)*cnt);
    return ret;
}
