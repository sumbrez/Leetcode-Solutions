/*
022. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/

cpp 325 ms
*/

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
public:
    set<string> st;
    int depth;
    void step(string s,int p)
    {
        if (depth==p)
        {
            st.insert(s);
            return;
        }
        int len=s.length(),le2=len/2;
        for (int i=0;i<=len;i++)
        {
            if (i-2>0&&s[i-2]=='('&&s[i-1]==')')
                continue;
            string t=s;
            t.insert(i,"()");
            step(t,p+1);
        }
    }
    vector<string> generateParenthesis(int n) {
        st.clear();
        depth=n;
        step(string(""),0);
        vector<string> ret;
        set<string>::iterator it=st.begin();
        for (;it!=st.end();it++)
            ret.push_back(*it);
        return ret;
    }
};
