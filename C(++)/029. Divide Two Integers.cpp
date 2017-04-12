/*
029. Divide Two Integers
https://leetcode.com/problems/divide-two-integers/

cpp 6 ms
*/

/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

class Solution {
#define LL long long
#define INF 0x7fffffff
#define MNF -2147483648
public:
    LL iabs(LL a)
    {
        return a<0?-a:a;
    }
    int divide(int dividend, int divisor) {
        LL a=dividend,b=divisor,sign=1;
        if (a<0&&b>0||a>0&&b<0)
            sign=-1;
        a=iabs(a);
        b=iabs(b);
        if (a<b) return 0;
        if (b==0) return INF;
        LL ret=0;
        while (a>=b)
        {
            LL t=b,d=1;
            while (a>=t)
            {
                ret+=d;
                a-=t;
                t<<=1;
                d<<=1;
            }
        }
        if (ret>INF&&sign==1) return INF;
        if (ret<MNF&&sign==-1) return MNF;
        if (sign==-1) ret-=ret+ret;
        return ret;
    }
};
