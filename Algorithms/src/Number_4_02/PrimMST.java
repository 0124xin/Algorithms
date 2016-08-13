package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * P403 �㷨4.7 ��С��������Prim�㷨����ʹ�汾���������Ч�ıߣ�
 * 
 * @author he
 *
 */
public class PrimMST {
	private Edge edgeTo[];// ����������ı�
	private double distTo[];// ���涥���Ȩֵ��disTo[v]=edgeTo[v].weight()
	private IndexMinPQ<Double> pq;// ������Ч�ĺ��бߣ����涥��Ͷ����Ӧ��Ȩ��
	private boolean marked[];

	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		for (int i = 0; i < G.V(); i++)
			distTo[i] = Double.POSITIVE_INFINITY;// ����Double�����������ֵ�ĳ���
		for (int v = 0; v < G.V(); v++) {
			prim(G, v);
		}
	}

	private void prim(EdgeWeightedGraph G, int v) {
		distTo[v] = 0.0;
		pq.insert(v, distTo[v]);
		while (!pq.isEmpty()) {
			int t = pq.delMin();
			visit(G, t);
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {

		marked[v] = true;// ���
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			if (marked[w])
				continue;// ������Ч�ı�
			if (e.weight() < distTo[w]) {
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if (pq.contains(w))
					pq.changeKey(w, e.weight());// �����������ȶ��ж���w��Ӧ��Ȩ��
				else
					pq.insert(w, e.weight());
			}
		}
	}

	public Iterable<Edge> edges() {
		Queue<Edge> mst = new Queue<Edge>();
		for (int i = 0; i < edgeTo.length; i++)
			if (edgeTo[i] != null)
				mst.enqueue(edgeTo[i]);
		return mst;
	}

	public double weight() {
		double weight = 0.0;
		for (Edge e : edges())
			weight += e.weight();
		return weight;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		PrimMST mst = new PrimMST(G);
		for (Edge e : mst.edges())
			System.out.println(e);
		System.out.printf("����Ȩ�أ�%.2f", mst.weight());
	}
}
