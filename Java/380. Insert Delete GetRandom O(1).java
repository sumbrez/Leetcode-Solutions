/*
380. Insert Delete GetRandom O(1)
https://leetcode.com/problems/insert-delete-getrandom-o1/
*/

// 129ms
import java.util.*;

public class RandomizedSet {

	// mp存放<值,在lst中的下标>
	Map<Integer,Integer> mp;
	List<Integer> lst;
	int size;
	Random rnd;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		mp=new HashMap<Integer,Integer>();
		lst=new ArrayList<Integer>();
		size=0;
		rnd=new Random();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (mp.containsKey(val))
			return false;
		mp.put(val,size++);
		lst.add(val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!mp.containsKey(val))
			return false;
		int idx=mp.remove(val);
		// 如果remove的不是最后一个元素
		if (idx<--size)
		{
			// 将lst的最后一个元素移动到去除的元素的位置
			int last=lst.get(size);
			lst.set(idx,last);
			mp.put(last,idx);
		}
		// 如果是最后一个元素则直接移除，避免再次添加到mp中
		lst.remove(size);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int idx=rnd.nextInt(size);
		return lst.get(idx);
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
