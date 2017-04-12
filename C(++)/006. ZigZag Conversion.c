/*
006. ZigZag Conversion
https://leetcode.com/problems/zigzag-conversion/

c 75 ms
*/

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

char* convert(char* s, int numRows) {
    if (numRows==1) return s;
    int len=strlen(s);
    //char (*g)[numRows];
    //g=(char(*)[numRows])malloc(sizeof(char)*len);
    char g[numRows][len];
    memset(g,'\0',sizeof(g));
    int r=0,c=0,mode=0,cnt=0;
    while (*s!='\0')
    {
        if (!mode)
        {
            g[r++][c]=*s;
            if (r==numRows)
            {
                r-=2;
                c++;
                mode^=1;
            }
        }
        else
        {
            g[r--][c++]=*s;
            if (r<0)
            {
                r=1;
                c--;
                mode^=1;
            }
        }
        s++;
    }
    s-=len;
    for (int i=0;i<numRows;i++)
        for (int j=0;j<len;j++)
            if (g[i][j]!='\0')
                s[cnt++]=g[i][j];
    s[len]='\0';
    return s;
}
