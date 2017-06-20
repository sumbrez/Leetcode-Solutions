/*
187. Repeated DNA Sequences
https://leetcode.com/problems/repeated-dna-sequences/
*/

// 68ms
// class Trie内用TrieNode数组加速，1e4不够，1e5报RE，5e4报misaligned address
#include <stdio.h>
#include <string.h>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct TrieNode
{
    TrieNode *child[4],*fail;
    int cnt;
    TrieNode()
    {
        memset(child,0,sizeof(child));
        fail=NULL;
        cnt=0;
    }
};
class Trie
{
    TrieNode *root;
public:
    Trie()
    {
        root=new TrieNode();
    }
    int getidx(char c)
    {
        switch (c)
        {
        case 'A': return 0;break;
        case 'G': return 1;break;
        case 'C': return 2;break;
        case 'T': return 3;break;
        }
    }
    bool insert(string s) // true：记录下来
    {
        const char *word=s.c_str();
        TrieNode *temp=root;
        for (int i=strlen(word)-1;i>=0;i--)
        {
            int idx=getidx(word[i]);
            if (temp->child[idx]==NULL)
                temp->child[idx]=new TrieNode();
            temp=temp->child[idx];
        }
        temp->cnt++;
        if (temp->cnt==2) // 只需要输出一次
            return true;
        return false;
    }
};

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> ret;
        Trie trie;
        int len=s.length();
        for (int i=9;i<len;i++)
        {
            string subs=s.substr(i-9,10);
            if (trie.insert(subs))
                ret.push_back(subs);
        }
        return ret;
    }
};
