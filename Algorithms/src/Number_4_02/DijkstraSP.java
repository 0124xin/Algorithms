package Number_4_02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * P423 �㷨4.9 ���·����Dijkstra�㷨���ܹ������Ȩ�طǸ��ļ�Ȩ����ͼ�ĵ�������·������
 * 
 * args[0]:tinyEWD.txt 
 * args[1]:0
 * 
 * @author he
 *
 */
public class DijkstraSP {
	private double distTo[];// ����Ȩ�أ����·������Ȩ�أ�distTo[w]��ʾ��㵽w���·������Ȩ��
	private DirectedEdge edgeTo[];// ���·���ı�
	private IndexMinPQ<Double> pq;// ���涥�����㵽��ö����ۼӵ�Ȩ��

	/**
	 * 
	 * @param G
	 *            �����Ȩͼ
	 * @param s
	 *            ���s
	 */
	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for (int i = 0; i < distTo.length; i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq.insert(s, distTo[s]);

		while (!pq.isEmpty()) {
			relax(G, pq.delMin());
		}

	}

	/**
	 * �ߵķ���
	 * 
	 * @param G
	 * @param v
	 */
	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {

			int w = e.to();
			// ������Ϣ
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			}
		}
	}

	/**
	 * �Ӷ���s��v��Ȩ��
	 * 
	 * @param v
	 * @return
	 */
	public double distTo(int v) {
		return distTo[v];

	}

	/**
	 * �Ƿ���ڶ���s��v��·��
	 * 
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	/**
	 * �Ӷ��㵽s��·��
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = Integer.valueOf(args[1]);
		DijkstraSP sp = new DijkstraSP(G, s);

		for (int t = 0; t < G.V(); t++) {
			System.out.print(s + " to " + t);
			System.out.printf(" (%4.2f): ", sp.distTo(t));
			if (sp.hasPathTo(t))
				for (DirectedEdge e : sp.pathTo(t))
					System.out.print(e + " ");
			System.out.println();
		}

	}

}
