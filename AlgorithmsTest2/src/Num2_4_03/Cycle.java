package Num2_4_03;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * �����Ȩͼ�Ļ����
 * 
 * @author he
 *
 */
public class Cycle {
	private boolean marked[];
	private int edgeTo[];// ���ڱ��滷
	private Stack<Edge> path;
	private Edge edge[];// �����
	private Edge t;

	public Cycle(EdgeWeightedGraph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		edge = new Edge[G.V() * G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v, v);
		}

	}

	private void dfs(EdgeWeightedGraph G, int u, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			// �ѷ��ֻ�
			if (edge[v] == null)
				edge[v] = e;
			else
				t = e;
			if (path != null)
				return;
			if (!marked[w]) {
				marked[w] = true;
				edgeTo[w] = v;
				edge[w] = e;
				dfs(G, v, w);
			}
			// ��Ϊ������ȱ����������������ͨ����������ݹ������v����Ϊ�л�
			else if (w != u) {
				path = new Stack<Edge>();
				for (int x = v; x != w; x = edgeTo[x]) {
					path.push(edge[x]);
				}
				path.push(t);
			}
		}
	}

	public Iterable<Edge> path() {
		return path;
	}

	public boolean hasCycle() {
		return path != null;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		Cycle cycle = new Cycle(G);
		if (cycle.hasCycle()) {
			for (Edge e : cycle.path()) {
				System.out.println(e);
			}
		}
	}

}
