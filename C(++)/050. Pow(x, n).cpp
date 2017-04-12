/*
050. Pow(x, n)
https://leetcode.com/problems/powx-n/

cpp 9 ms
*/

/*
Implement pow(x, n).
*/

class Solution {
public:
    // 快速幂
    double myPow(double x, int n) {
        long long e=n;
        if (n<0) e=-e;
        double ans=1;
        while (e)
        {
            if (e&1)
                ans*=x;
            x*=x;
            e>>=1;
        }
        if (n<0) ans=1/ans;
        return ans;
    }
};
