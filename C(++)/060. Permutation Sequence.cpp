/*
060. Permutation Sequence
https://leetcode.com/problems/permutation-sequence/

cpp 3 ms
*/

/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    1. "123"
    2. "132"
    3. "213"
    4. "231"
    5. "312"
    6. "321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

class Solution {
public:
    int fac(int n) // 阶乘
    {
        if (n==0) return 1;
        int ans=n;
        while (--n)
            ans*=n;
        return ans;
    }
    int mod1(int a,int b) // 非0结果模
    {
        a%=b;
        if (a==0) a=b;
        return a;
    }
    string getPermutation(int n, int k) {
        string ans="";
        bool flag[10]={0};
        // 依次找到第i位应该是几
        for (int i=1;i<=n;i++)
        {
            int amt=fac(n-i),th=(k-1)/amt+1,j=1;
            // 找到第th小的未使用的数
            for (;j<=n;j++)
                if (!flag[j])
                    if (--th==0)
                    {
                        flag[j]=true;
                        break;
                    }
            ans.append(1,j+'0');
            k=mod1(k,amt); // 对应在下一阶段第几个
        }
        return ans;
    }
};
