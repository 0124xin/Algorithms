package Number_4_02;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P415 ��Ȩ����ͼ����������
 * 
 * @author he arhs[0]:tinyEWD.txt
 */
public class EdgeWeightedDigraph {

	private final int V;// ��������
	private int E;// �ߵ�����
	private Bag<DirectedEdge> adj[];

	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int v) {
		this.V = v;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int i = 0; i < V; i++)
			adj[i] = new Bag<DirectedEdge>();

	}

	public EdgeWeightedDigraph(In in) {
		this(in.readInt());
		int E = in.readInt();

		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			addEdge(new DirectedEdge(v, w, weight));
		}
	}

	/**
	 * ��ӱ�
	 */
	public void addEdge(DirectedEdge e) {
		int v = e.from();
		adj[v].add(e);
		E++;
	}

	/**
	 * ���ض�����
	 * 
	 * @return
	 */
	public int V() {
		return V;
	}

	/**
	 * ���رߵ�����
	 * 
	 * @return
	 */
	public int E() {
		return E;

	}

	/**
	 * ��vָ���ı�
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

	/**
	 * ����ͼ���еı�
	 * 
	 * @return
	 */
	public Iterable<DirectedEdge> edges() {
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for (int v = 0; v < V; v++)
			for (DirectedEdge e : adj[v])
				bag.add(e);
		return bag;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("��" + V + "������ " + E + "����" + "\n");
		for (int i = 0; i < V; i++) {
			sb.append(i + ":");
			for (DirectedEdge e : adj[i])
				sb.append(e+"  ");
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		System.out.println(G.toString());
	}

}
