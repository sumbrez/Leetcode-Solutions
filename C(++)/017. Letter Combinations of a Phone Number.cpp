/*
017. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

cpp 3 ms
*/

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

1 2 3
4 5 6
7 8 9
* 0 #
(https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
public:
    vector<string> v;
    string d;
    int dlen;
    char mp[8][4]={
                            {'a','b','c'},      {'d','e','f'},
        {'g','h','i'},      {'j','k','l'},      {'m','n','o'},
        {'p','q','r','s'},  {'t','u','v'},  {'w','x','y','z'}
    };
    void cat(int pos,string s)
    {
        if (pos==dlen)
        {
            v.push_back(s);
            return;
        }
        int idx=d[pos]-'2';
        s[pos]=mp[idx][0];
        cat(pos+1,s);
        s[pos]=mp[idx][1];
        cat(pos+1,s);
        s[pos]=mp[idx][2];
        cat(pos+1,s);
        if (d[pos]=='7'||d[pos]=='9')
        {
            s[pos]=mp[idx][3];
            cat(pos+1,s);
        }
    }
    vector<string> letterCombinations(string digits) {
        v.clear();
        d=digits;
        dlen=d.length();
        if (dlen==0||d.find('1')!=string::npos||d.find('0')!=string::npos)
            return v;
        string s(dlen+1,'\0');
        cat(0,s);
        return v;
    }
};
