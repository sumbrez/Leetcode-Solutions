import java.util.*;

public class Solution {
	int pre[],w[],cnt;
	Map<TreeNode,Integer> mp;
	Map<Integer,TreeNode> rmp;
	boolean visit[];
	TreeNode p,q,ret;
	
	void cntdfs(TreeNode node)
	{
		if (node==null) return;
		mp.put(node,cnt);
		rmp.put(cnt++,node);
		cntdfs(node.left);
		cntdfs(node.right);
	}
	
	int find(int u)
	{
		int fa=u;
		while (pre[fa]!=fa)
			fa=pre[fa];
		while (pre[u]!=fa)
		{
			int temp=pre[u];
			pre[u]=fa;
			u=temp;
		}
		return fa;
	}
	void join(int id1,int id2)
	{
		int fa1=find(id1),fa2=find(id2);
		if (fa1==fa2) return;
		if (w[fa1]<w[fa2])
		{
			pre[fa1]=fa2;
			w[fa2]+=w[fa1];
		}
		else
		{
			pre[fa2]=fa1;
			w[fa1]+=w[fa2];
		}
	}
	
	void tarjan(TreeNode node)
	{
		if (ret!=null) return;
		int u=mp.get(node);
		pre[u]=u;
		if (node.left!=null)
		{
			tarjan(node.left);
			join(u,mp.get(node.left));
		}
		if (node.right!=null)
		{
			tarjan(node.right);
			join(u,mp.get(node.right));
		}
		pre[find(u)]=u;
		visit[u]=true;
		if (node==p)
		{
			int id=mp.get(q);
			if (visit[id])
				ret=rmp.get(pre[find(id)]);
		}
		if (node==q)
		{
			int id=mp.get(p);
			if (visit[id])
				ret=rmp.get(pre[find(id)]);
		}
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root==null||p==null||q==null) return null;
		mp=new HashMap<TreeNode,Integer>();
		rmp=new HashMap<Integer,TreeNode>();
		cnt=0;
		cntdfs(root);
		pre=new int[cnt];
		w=new int[cnt];
		visit=new boolean[cnt];
		this.p=p;
		this.q=q;
		for (int i=0;i<cnt;i++)
			pre[i]=i;
		tarjan(root);
		return ret;
	}
}
