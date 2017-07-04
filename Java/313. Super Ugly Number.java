/*
313. Super Ugly Number
https://leetcode.com/problems/super-ugly-number/
*/

// 37ms
public class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int plen=primes.length;
		if (n==1) return 1;
		int cnt[]=new int[plen],ret[]=new int[n];
		ret[0]=1;
		for (int i=1;i<n;i++)
		{
			int min=Integer.MAX_VALUE,minj=0;
			for (int j=0;j<plen;j++)
			{
				int temp=primes[j]*ret[cnt[j]];
				if (temp<min)
				{
					min=temp;
					minj=j;
				}
			}
			ret[i]=min;
			cnt[minj]++;
			if (ret[i]==ret[i-1]) i--;
		}
		return ret[n-1];
	}
}

// 63ms
// 用优先队列维护产生的最小ugly number反而慢……
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	class Node
	{
		int val,id;
		Node(int id,int val)
		{
			this.id=id;
			this.val=val;
		}
	}
	public int nthSuperUglyNumber(int n, int[] primes) {
		Comparator<Node> cmp = new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				if (n1.val>n2.val)
					return 1;
				else if (n1.val<n2.val)
					return -1;
				else
					return 0;
			}
		};
		int plen=primes.length;
		if (n==1) return 1;
		int cnt[]=new int[plen],ret[]=new int[n];
		ret[0]=1;
		Queue<Node> pq=new PriorityQueue<Node>(cmp);
		for (int j=0;j<plen;j++)
			pq.add(new Node(j,primes[j]*ret[cnt[j]]));
		for (int i=1;i<n;i++)
		{
			Node node=pq.poll();
			ret[i]=node.val;
			int id=node.id;
			cnt[id]++;
			pq.add(new Node(id,primes[id]*ret[cnt[id]]));
			if (ret[i]==ret[i-1]) i--;
		}
		return ret[n-1];
	}
}
