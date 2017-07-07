/*
355. Design Twitter
https://leetcode.com/problems/design-twitter/
*/

// 202ms
// 很有意思的题，leetcode上竟然可以有工程风的题
import java.util.*;

public class Twitter {

	// 因为需要操作各List，为了应对userId不连续或不从0开始的情况
	// 额外加uidmp构建新id
	// 同时题目的tid不是发帖时间，所以也需要构建新id，rtidmp为逆map
	Map<Integer,Integer> uidmp,tidmp,rtidmp;
	int usize,tsize;
	// tweets放的是原tid（内容）
	List<List<Integer>> tweets;
	// feeds放的是新tid
	List<TreeSet<Integer>> feeds;
	// flwers和flwing总是同步操作
	List<List<Integer>> flwers,flwing;
	
	/** Initialize your data structure here. */
	public Twitter() {
		uidmp=new HashMap<Integer,Integer>();
		tidmp=new HashMap<Integer,Integer>();
		rtidmp=new HashMap<Integer,Integer>();
		usize=tsize=0;
		tweets=new ArrayList<List<Integer>>();
		feeds=new ArrayList<TreeSet<Integer>>();
		flwers=new ArrayList<List<Integer>>();
		flwing=new ArrayList<List<Integer>>();
	}

	// 用于feeds中newtid从大到小排序
	class Cmp implements Comparator<Integer>
	{
		@Override
		public int compare(Integer a, Integer b) {
			if (a==b) return 0;
			else if (a<b) return 1;
			else return -1;
		}
	}
	// 检查用户是否存在（创建用户），并返回uid
	int checkAndGetUid(int userId)
	{
		Integer uid=uidmp.get(userId);
		if (uid==null)
			uid=newUser(userId);
		return uid;
	}
	// 创建用户并返回uid
	int newUser(int userId)
	{
		uidmp.put(userId,usize);
		tweets.add(new ArrayList<Integer>());
		feeds.add(new TreeSet<Integer>(new Cmp()));
		flwers.add(new ArrayList<Integer>());
		flwing.add(new ArrayList<Integer>());
		follow(userId,userId);
		return usize++;
	}
	// 将某个tweet更新到用户的feeds中
	void updateFeed(int erid,int tid)
	{
//		if (tidmp.get(tid)==null)
//			tidmp.put(tid,tsize++);
		TreeSet<Integer> ts=feeds.get(erid);
		ts.add(tidmp.get(tid));
		// feeds始终最多保留10条内容
		if (ts.size()==11)
			ts.remove(ts.last());
	}
	// 重新构建某个用户的feeds，用于unfollow，频繁unfollow则效率低
	void rebuildFeeds(int erid)
	{
		feeds.get(erid).clear();
		for (int eeid:flwing.get(erid))
			for (int tid:tweets.get(eeid))
				updateFeed(erid,tid);
	}
	
	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		int eeid=checkAndGetUid(userId);
		tidmp.put(tweetId,tsize);
		rtidmp.put(tsize++, tweetId);
		tweets.get(eeid).add(tweetId);
		for (int erid:flwers.get(eeid))
			updateFeed(erid,tweetId);
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
		int uid=checkAndGetUid(userId);
		List<Integer> ret=new ArrayList<Integer>();
		for (int tid:feeds.get(uid))
			ret.add(rtidmp.get(tid));
		return ret;
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		int erid=checkAndGetUid(followerId),eeid=checkAndGetUid(followeeId);
		int ee_er_idx=flwers.get(eeid).indexOf(erid);
		if (ee_er_idx!=-1) return; // 如果erid已经关注eeid
		flwers.get(eeid).add(erid);
		flwing.get(erid).add(eeid);
		for (int tid:tweets.get(eeid))
			updateFeed(erid,tid);
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		int erid=checkAndGetUid(followerId),eeid=checkAndGetUid(followeeId);
		if (erid==eeid) return; // 不允许
		int ee_er_idx=flwers.get(eeid).indexOf(erid);
		if (ee_er_idx==-1) return; // 如果erid没有关注eeid
		// remove有参数为index何Ojbect两个版本，因为各id本身为int
		// 所以必须先用indexOf（即使id为Integer也不行）
		flwers.get(eeid).remove(flwers.get(eeid).indexOf(erid));
		flwing.get(erid).remove(flwing.get(erid).indexOf(eeid));
		rebuildFeeds(erid);
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
