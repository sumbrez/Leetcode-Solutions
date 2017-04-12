/*
043. Multiply Strings
https://leetcode.com/problems/multiply-strings/

cpp 26 ms
*/

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
public:
    string multiply(string num1, string num2) {
        string oprA=num1,oprB=num2,antp,ans="";
        const int ZE=48;
        int tc,lenA=oprA.length(),lenB=oprB.length();
        int cnt=1;//we can use i to replace cnt //偏移量
        for (int i=lenB-1;i>=0;i--)
        {
            //计算本次
            tc=0;
            antp="";
            for (int j=lenA-1;j>=0;j--)
            {
                int temp=(oprA[j]-ZE)*(oprB[i]-ZE)+tc;
                tc=temp/10;
                antp=(char)(temp%10+ZE)+antp;
            }
            antp=(char)(tc+ZE)+antp;//temp answer
            //将本次计算结果和之前结果相加，cnt控制对齐 
            int alen=ans.length(),tlen=antp.length();
            if (alen==0)
            {
                ans=antp;
                continue;
            }
            int mlen=min(tlen+cnt,alen);
            for (int j=1;j<mlen;j++)
                if (alen-cnt-j>=0&&tlen-j>=0)
                    ans[alen-cnt-j]+=antp[tlen-j]-ZE;
            if (tlen+cnt>alen)
                ans=antp.substr(0,tlen+cnt-alen)+ans;
            cnt++;
            //处理ans自身进位，此前ans的每位允许>'9'，从后向前，不会二次进位
            int addlen=0;
            for (int j=0;j<ans.length();j++)
            {
                alen=ans.length()+addlen-cnt-j;
                if (alen>=0&&ans[alen]>=ZE+9)
                {
    				char ch=(char)((ans[alen]-ZE)/10+ZE);
    				ans[alen]=(char)((ans[alen]-ZE)%10+ZE);
    				if (alen==0)
                    {
                        ans=ch+ans;
                        addlen++;
                    }
                    else
                        ans[alen-1]+=ch-ZE;
                }
            }
        }	
        while (ans[0]==ZE&&ans.length()>1)
            ans=ans.substr(1,ans.length()-1);
        return ans;
    }
};
