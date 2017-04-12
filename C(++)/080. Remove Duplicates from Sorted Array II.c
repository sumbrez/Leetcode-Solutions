/*
080. Remove Duplicates from Sorted Array II
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

c 6 ms
*/

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

int removeDuplicates(int* nums, int numsSize) {
    if (numsSize<3) return numsSize;
    
    int del=0,cnt=1,pre=nums[0],t,move,size=numsSize;
    for (int i=1;i<=size;i++)
    {
        // 在末尾假设一个必定不同的数字
        if (i<size) t=nums[i];
        else t=0x7fffffff;
        
        if (pre!=t)
        {
            if (cnt>2) // 如果前一个数字个数大于2
            {
                move=cnt-2;
                del+=move; // 需要移除的总个数
                // 从当前位置i开始将后边有效的数字全部前移
                memmove(nums+i-move,nums+i,sizeof(int)*(size-i));
                // 更新
                size-=move;
                i-=move;
            }
            pre=t;
            cnt=1;
        }
        else
            cnt++;
    }
    return numsSize-del; // 剩余长度
}
