/*
071. Simplify Path
https://leetcode.com/problems/simplify-path/

c 3 ms
*/

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

/*
"/JD/nA/./tXa/./././DFaiU/l/..///../nPwm"
"/xmtgE/./imKv/P///uDhoh/w/vWFR/kdJOi///tKI///k/NJ/zoUnW"
这两个数据挨着输入会出现double free or corruption (fasttop)
然而各自出现两次则正常……
很可能是realloc的问题，尤其是leetcode自身对传入数据的free机制
最后只好新开一份内存，并手动复制
*/
char* simplifyPath(char* path) {
    int len=strlen(path);
    char *p;
    // 不扩大path的话添加的符号可能有问题（后面地址有数据？）
    if (path[len-1]!='/')
    {
        p=malloc(sizeof(char)*(len+2)); // 注意是+2
        p=(char*)memcpy(p,path,len+1);
        p[len++]='/';
        p[len]='\0';
        //path=realloc(path,sizeof(char)*(len+2));
    }
    else
        p=path;
        
    int lens[1000],lcnt=0,cnt=0,pret=1;
    char *ret=(char*)malloc(sizeof(char)*(len+2));
    ret[0]='/';
    p++;
    while (*p!='\0')
    {
        if (*p=='/')
        {
            if (cnt==2&&ret[pret-1]=='.'&&ret[pret-2]=='.')
            {
                pret-=2;
                if (lcnt>0)
                    pret-=lens[--lcnt];
            }
            else if (cnt==1&&ret[pret-1]=='.')
                pret--;
            else if (cnt!=0)
            {
                ret[pret++]=*p;
                lens[lcnt++]=cnt+1;
            }
            cnt=0;
        }
        else
        {
            ret[pret++]=*p;
            cnt++;
        }
        p++;
    }
    ret[pret]='\0';
    if (pret>1&&ret[pret-1]=='/')
        ret[pret-1]='\0';
    return ret;
}
