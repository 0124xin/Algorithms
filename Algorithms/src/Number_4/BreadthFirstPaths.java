package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * P346 �㷨4.2 ���������������ͼ�е�·�� args[0]:tinyCG.txt args[1]:0
 * 
 * @author he
 *
 */
public class BreadthFirstPaths {
	private boolean[] marked;// ���汻��ǵĶ���
	private int[] edgeTo;// ������㵽��֮��ͨ�Ķ���֮������·��
	private final int s;// ���

	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	/**
	 * �ȱ���ÿ�������ֱ�������Ķ��㣨1���������α�����ö��㣨1�������ĵ�
	 * 
	 * @param G
	 * @param s
	 */
	public void bfs(Graph G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			// �����붥��sֱ�������ĵ�
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;// ���
					edgeTo[w] = v;// �������·���Ľ��
					queue.enqueue(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s = Integer.valueOf(args[1]);// ���
		BreadthFirstPaths dfp = new BreadthFirstPaths(G, s);
		for (int i = 0; i < G.V(); i++) {
			System.out.print(s + " to " + i + " : ");
			if (dfp.hasPathTo(i)) {
				for (int w : dfp.pathTo(i)) {
					if (w == s)
						System.out.print(s);
					else
						System.out.print("-" + w);
				}
			}
			System.out.println();
		}

	}

}
