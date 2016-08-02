package Num2_4_01;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P361 T28
 * args[0]:tinyCG.txt
 * 
 * @author he
 *
 */

class Cycle {
	private boolean marked[];
	private int edgeTo[];// ���ڱ��滷
	private Stack<Integer> path;

	public Cycle(Graph G) {
		if (hasSelfLoop(G))
			return;
		if (hasParallelEdges(G))
			return;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v, v);
		}

	}

	/**
	 * �ж��Ƿ����Ի�
	 * 
	 * @param G
	 * @return
	 */
	private boolean hasSelfLoop(Graph G) {
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (w == v) {
					path = new Stack<Integer>();
					path.push(w);
					path.push(v);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * �ж��Ƿ���ƽ�б�
	 * 
	 * @param G
	 * @return
	 */
	private boolean hasParallelEdges(Graph G) {
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			for (int w : G.adj(i)) {
				// ƽ�бߣ�����i�������ߵ��ﶥ��w�����һ�������Ѿ�����ǹ�����������������ߵ���ͬһ����
				if (marked[w]) {
					path = new Stack<Integer>();
					path.push(i);
					path.push(w);
					path.push(i);
					return true;
				}
				marked[w] = true;
			}

			// ����marked����,����ָ�����ʼ״̬
			for (int w : G.adj(i))
				marked[w] = false;

		}
		return false;
	}

	private void dfs(Graph G, int u, int v) {
		marked[v] = true;

		for (int w : G.adj(v)) {
			// �ѷ��ֻ�
			if (path != null)
				return;
			if (!marked[w]) {
				marked[w] = true;
				edgeTo[w] = v;
				dfs(G, v, w);
			}
			// ��Ϊ������ȱ����������������ͨ����������ݹ������v����Ϊ�л�
			else if (w != u) {
				path = new Stack<Integer>();
				for (int x = v; x != w; x = edgeTo[x]) {
					path.push(x);
				}
				path.push(w);
				path.push(v);
			}
		}
	}

	public Iterable<Integer> path() {
		return path;
	}

	public boolean hasCycle() {
		return path != null;
	}

}

public class Num_4_01_28 {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		Cycle cycle = new Cycle(G);
		if (cycle.hasCycle()) {
			for (int i : cycle.path()) {
				System.out.print(" " + i);//1 0 2 1
			}
		}
	}

}
