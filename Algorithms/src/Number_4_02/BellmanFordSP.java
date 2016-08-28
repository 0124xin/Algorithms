package Number_4_02;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.EdgeWeightedDirectedCycle;
import edu.princeton.cs.algs4.In;

/**
 * P438 �㷨4.11 ���ڶ��е�Bellman-Ford�㷨��Ѱ��һ������ͼ��·��������ʱ���EV�����ȣ��ռ��V������
 * 
 * @author he args[0]:tinyEWDnc.txt args[1]:0
 */
public class BellmanFordSP {
	private DirectedEdge edgeTo[];// ����㵽ĳ���������·���ϵı�
	private double distTo[];// ����㵽ĳ�����Ȩ��
	private Queue<Integer> queue;// �������ڷ��ɵĶ���
	private boolean onQ[];// ��֤�����в����ظ���Ԫ��

	private int cost;// relac()�ĵ��ô���
	private Iterable<DirectedEdge> cycle;// edgeTo[]���Ƿ񺬸�Ȩ�ػ�

	public BellmanFordSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		queue = new Queue<Integer>();
		onQ = new boolean[G.V()];

		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;

		while (!queue.isEmpty() && !hasNegativeCycle()) {
			int v = queue.dequeue();
			onQ[v] = false;
			relax(G, v);
		}

	}

	/**
	 * ���ɱ�
	 * 
	 * @param G
	 * @param s
	 */
	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (!onQ[w]) {
					queue.enqueue(w);// ������ڸ�Ȩ�ػ����������Զ����Ϊ��
					onQ[w] = true;
				}
			}

			// ������и�Ȩ�ػ���edgeTo[index]��ǹ��ı߻Ậ������ͼG����һ��Ļ���edgeTo[index]��ǹ��ı߲��Ậ��
			if (cost++ % G.V() == 0) {
				findNegativeCycle();
				if (hasNegativeCycle()) {
					return;
				}
			}
		}

	}

	/**
	 * ������㵽�ﶥ��v��Ȩ��
	 * 
	 * @param v
	 * @return
	 */
	public double distTo(int v) {
		if (hasNegativeCycle())
			throw new UnsupportedOperationException("Negative cost cycle exists");
		return distTo[v];

	}

	/**
	 * �ж�����ܷ񵽴�ָ������
	 * 
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	/**
	 * ���ش���㵽��ָ����������·��
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<DirectedEdge> pathTo(int v) {
		if (hasNegativeCycle())
			throw new UnsupportedOperationException("Negative cost cycle exists");
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			stack.push(e);
		}
		return stack;
	}

	/**
	 * ���Ҹ�Ȩ�ػ���ֻ��һ��Ļ����
	 */
	private void findNegativeCycle() {
		int V = edgeTo.length;
		EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
		for (int i = 0; i < V; i++) {
			if (edgeTo[i] != null)
				spt.addEdge(edgeTo[i]);
		}

		EdgeWeightedDirectedCycle c = new EdgeWeightedDirectedCycle(spt);
		cycle = c.cycle();
	}

	/**
	 * �ж��Ƿ񺬸�Ȩ�ػ�
	 * 
	 * @return
	 */
	public boolean hasNegativeCycle() {
		return cycle != null;
	}

	/**
	 * ���ظ�Ȩ�ػ�
	 * 
	 * @return
	 */
	public Iterable<DirectedEdge> negativeCycle() {
		return cycle;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		int s = Integer.parseInt(args[1]);
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

		BellmanFordSP sp = new BellmanFordSP(G, s);

		if (sp.hasNegativeCycle()) {
			for (DirectedEdge e : sp.negativeCycle())
				StdOut.println(e);
		}

		else {
			for (int v = 0; v < G.V(); v++) {
				if (sp.hasPathTo(v)) {
					StdOut.printf("%d to %d (%5.2f)  ", s, v, sp.distTo(v));
					for (DirectedEdge e : sp.pathTo(v)) {
						StdOut.print(e + "   ");
					}
					StdOut.println();
				} else {
					StdOut.printf("%d to %d           no path\n", s, v);
				}
			}
		}

	}
}
