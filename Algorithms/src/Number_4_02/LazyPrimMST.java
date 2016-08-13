package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * P400 ��С��������Prim�㷨����ʱʵ�֣����ȶ����лᱣ��ʧЧ�ıߣ���Ҫɾ��ʱ(delMin())�ټ����Ч��
 *      �еݹ��˼��
 * @author he
 *   args[0]:tinyEWG.txt
 *
 */
public class LazyPrimMST {
	private boolean marked[];// �����С�������Ķ���
	private Queue<Edge> mst;// ��С�������ı�
	private MinPQ<Edge> pq;// ���ȶ��У�������б�
	private double Weight;// ��С����������Ȩ��

	// �еݹ��˼��
	public LazyPrimMST(EdgeWeightedGraph G) {
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				prim(G, v);
		}
	}

	private void prim(EdgeWeightedGraph G, int v) {
		visit(G, v);
		while (!pq.isEmpty()) {
			Edge e = pq.delMin();
			int w = e.either();
			int t = e.other(w);
			if (marked[w] && marked[t])
				continue;// ����ʧЧ�ı�
			mst.enqueue(e);// ��С��������ӱ�
			Weight += e.weight();
			if (!marked[t])
				visit(G, t);
			if (!marked[w])
				visit(G, w);
		}
	}

	// ����ָ����������ı�
	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;// ���
		for (Edge e : G.adj(v)) {
			if (!marked[e.other(v)])// �Ͷ���v��������һ������δ�����
				pq.insert(e);
		}
	}

	/**
	 * ������С���������еı�
	 * 
	 * @return
	 */
	public Iterable<Edge> edges() {
		return mst;
	}

	/**
	 * ������С����������Ȩ��
	 * 
	 * @return
	 */
	public double weight() {
		return Weight;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		LazyPrimMST mst = new LazyPrimMST(G);
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
		System.out.println(mst.weight());
	}

}
