package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P372 Ѱ������ͼ�еĻ��������������������
 * 
 * @author he
 *  args[0]:tinyDG.txt
 */
public class DirectedCycle {
	private boolean marked[];// ��Ƕ���
	private int edgeTo[];// �����Ի�·���ϵĶ���
	private boolean onStack[];// �ݹ���õ�ջ�ϵ����ж���
	private Stack<Integer> cycle;// �����������Ի�·��

	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];

		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v);
		}

	}

	private void dfs(Digraph G, int v) {

		onStack[v] = true;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (this.hasCycle())// �ҵ�һ�����Ժ���˳�
				return;
			else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
			// ���Ǵ���w-v�ı�
			else if (onStack[w]) {
				cycle = new Stack<Integer>();
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}

		}
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<Integer> cycle() {
		return cycle;
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		DirectedCycle d = new DirectedCycle(G);
		if (d.hasCycle()) {
			for (int x : d.cycle())
				System.out.print(x + " ");
		}
	}

}
