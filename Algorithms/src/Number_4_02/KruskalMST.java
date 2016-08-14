package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * P406 �㷨4.8��С��������Kruskal�㷨�����ߵ�Ȩ��˳����
 * Kruskal�㷨һ���Prim�㷨������Ϊ����ÿ����ʱҪ����һ��connect��������, ��Ҫʹ��1.5�ڵ�union-find�㷨����Ƿ��γɻ�
 * 
 * @author he
 *
 */
public class KruskalMST {
	private Queue<Edge> mst;// ��С������
	private MinPQ<Edge> pq;

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		UF uf = new UF(G.V());// ���ڼ���Ƿ���γɻ�
		for (Edge e : G.edges())
			pq.insert(e);

		// ������ֻ��V-1����
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (uf.connected(v, w))
				continue; // ������Ч�ı�
			uf.union(v, w);
			mst.enqueue(e);
		}

	}

	public Iterable<Edge> edges() {
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
		KruskalMST mst = new KruskalMST(G);
		for (Edge e : mst.edges())
			System.out.println(e);
		System.out.println("��Ȩ�أ�"+mst.weight());
	}

}
