/*
341. Flatten Nested List Iterator
https://leetcode.com/problems/flatten-nested-list-iterator/
*/

// 6ms
import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

	List<NestedInteger> lst;
	int size,pos; // nestedList的size和当前pos
	NestedIterator it; // 递归iterator
	int val; // next()要返回的值
	boolean flag; // val是否被使用，用于重复hasNext()
	public NestedIterator(List<NestedInteger> nestedList) {
		lst=nestedList;
		size=lst.size();
		pos=0;
		it=null;
		flag=false;
	}

	@Override
	public Integer next() {
		flag=false;
		return val;
	}

	@Override
	public boolean hasNext() {
		if (size==0) return false;
		if (flag) return flag;
		if (it==null||!it.hasNext())
		{
			if (pos>=size) return false;
			NestedInteger t=lst.get(pos++);
			if (t.isInteger())
			{
				it=null;
				val=t.getInteger();
			}
			else
			{
				it=new NestedIterator(t.getList());
				if (!it.hasNext()) // 意味着空list
				{
					it=null;
					flag=hasNext(); // 递归
					return flag;
				}
				val=it.next();
			}
		}
		else
			val=it.next();
		flag=true;
		return true;
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
