package Number_4_02;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P395 ��Ȩ����ͼ����������
 * 
 * @author he
 *
 */
public class EdgeWeightedGraph {
	private final int V;// ��������
	private int E;// �ߵ�����
	private Bag<Edge> adj[];// ��ӱ�

	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for (int i = 0; i < V; i++)
			adj[i] = new Bag<Edge>();
	}

	public EdgeWeightedGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int w = in.readInt();
			int v = in.readInt();
			double weight = in.readDouble();
			addEdge(new Edge(w, v, weight));
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	/**
	 * ���һ����
	 * 
	 * @param e
	 */
	public void addEdge(Edge e) {
		int w = e.either();
		int v = e.other(w);
		adj[w].add(e);
		adj[v].add(e);
		E++;
	}

	/**
	 * ���غ�v�����ı�
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	/**
	 * ����ͼ���еı�,����ͳ���Ի�
	 * 
	 * @return
	 */
	public Iterable<Edge> edges() {
		Bag<Edge> bag = new Bag<Edge>();
		for (int v = 0; v < V; v++)
			for (Edge e : adj[v])
				if (e.other(v) > v)// ��֤ÿ����ֻ�����һ��
					bag.add(e);
		return bag;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("�ܹ���" + V + "������ " + E + "����" + "\n");
		for (int v = 0; v < V; v++) {
			sb.append("��" + v + "�����ı�:");
			for (Edge e : adj[v]) {
				sb.append(e.toString() + "  ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		System.out.println(G.toString());

	}

}
