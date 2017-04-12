/*
089. Gray Code
https://leetcode.com/problems/gray-code/

c 6 ms
*/

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* grayCode(int n, int* returnSize) {
    int *len=returnSize;
    *len=1<<n;
    int *flag=(int*)malloc(sizeof(int)*(*len)),
        *ret=(int*)malloc(sizeof(int)*(*len));
    memset(flag,0,sizeof(int)*(*len));
    int pre=0;
    ret[0]=pre;
    flag[pre]=1;
    for (int i=1;i<*len;i++)
    {
        int temp=1,now;
        for (int j=0;j<*len;j++)
        {
            now=pre^temp;
            if (!flag[now])
            {
                flag[now]=1;
                ret[i]=now;
                pre=now;
                break;
            }
            temp<<=1;
        }
    }
    return ret;
}
