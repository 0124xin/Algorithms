package Num2_4_02;

import java.util.LinkedList;
import java.util.List;
import edu.princeton.cs.algs4.Digraph;

/**
 * P387 T21 
 * ����v��w�Ĺ�ͬ���ȣ�����㵽v����㵽w��·������ָ�������������ͬ�Ķ��� (ͼGû�л�) 
 * ����������밴�涨���룬���ⲻ���ж�
 * 
 * @author he
 *
 */

class LAC {
	private boolean marked[];
	private int edgeTo[];
	private int s;// ���

	public LAC(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	// �ɴ��Է���
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
	}

	private boolean hasPath(int v) {
		return marked[v];
	}

	/**
	 * ָ�����㵽����·��
	 * 
	 * @return
	 */
	private Iterable<Integer> pathTo(int v) {
		if (!hasPath(v))
			return null;
		List<Integer> list = new LinkedList<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			list.add(x);
		}
		list.add(s);
		// �����·��������β
		return list;
	}

	/**
	 * ���������ͬ����
	 * 
	 * @return
	 */
	public int findLCA(int v, int w) {
		if (!hasPath(v) || !hasPath(w))
			throw new RuntimeException("v�� wû�й�ͬ����");
		List<Integer> lv = (List<Integer>) pathTo(v);
		List<Integer> lw = (List<Integer>) pathTo(w);
		if (lv.size() > lw.size()) {
			for (int t : lw) {
				if (lv.contains(t))
					return t;
			}
		} else {
			for (int t : lv) {
				if (lw.contains(t))
					return t;
			}
		}
		return -1;
	}

}

public class Num_4_02_21 {
	public static void main(String[] args) {
		Digraph G = new Digraph(5);
		G.addEdge(0, 2);
		G.addEdge(0, 1);
		G.addEdge(1, 4);
		G.addEdge(1, 3);
		LAC lac = new LAC(G, 0);
		System.out.println(lac.findLCA(3, 4));// 1
	}

}
