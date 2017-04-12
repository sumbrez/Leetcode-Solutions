/*
079. Word Search
https://leetcode.com/problems/word-search/

c 16 ms
*/

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

bool flag,used[1000][1000];//**used;
int rn,cn,wlen,dr[]={-1,0,1,0},dc[]={0,1,0,-1};
char **brd,*wrd;
void dfs(int depth,int r,int c)
{
    // 首先要判断depth是否在范围内，这也是常规dfs的做法
    if (depth==wlen-1)
    {
        if (brd[r][c]==wrd[depth])
            flag=true;
        return;
    }
    if (flag) return; // 忘了加这句，超时了
    if (brd[r][c]!=wrd[depth])
        return;
    used[r][c]=true;
    for (int i=0;i<4;i++)
    {
        int newr=r+dr[i],newc=c+dc[i];
        if (newr>=0&&newr<rn&&newc>=0&&newc<cn&&!used[newr][newc])
            dfs(depth+1,newr,newc);
    }
    used[r][c]=false;
}
bool exist(char** board, int boardRowSize, int boardColSize, char* word) {
    flag=false;
    /*used=(bool**)malloc(sizeof(bool*)*rn);
    for (int i=0;i<rn;i++)
        used[i]=(bool*)malloc(sizeof(bool)*cn);*/
    memset(used,0,sizeof(used));
    rn=boardRowSize;
    cn=boardColSize;
    wlen=strlen(word);
    brd=board;
    wrd=word;
    
    if (wlen>rn*cn) return false;
    //char *str=(char*)malloc(sizeof(char)*(wlen+1));
    for (int i=0;!flag&&i<rn;i++)
        for (int j=0;!flag&&j<cn;j++)
            dfs(0,i,j);
    //for (int i=0;i<rn;i++) free(used[i]);
    return flag;
}
