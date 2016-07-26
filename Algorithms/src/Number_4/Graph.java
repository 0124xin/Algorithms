package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P336 Graph(����ͼ)��������
 *  ʹ���ڽӱ����飬�����������Ӧ���㣬ÿ�������е�Ԫ������ö������ӵĶ����б� ʹ��Bag���� ÿ���߶����������
 *  v-w �� w-v
 *  args[0]:tinyG.txt
 * @author he
 *
 */
public class Graph {
	private final int V;// �������
	private int E;// �ߵ���Ŀ
	private Bag<Integer> adj[];// �ڽӱ�

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();
		}
	}

	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			// ���һ����
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	/**
	 * ���һ���� v-w
	 * 
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		// ÿ�������������
		adj[v].add(w);// ��w��ӵ�v��������
		adj[w].add(v);// ��v��ӵ�w��������
		E++;
	}

	/**
	 * ���غ�v���ڵ����ж���
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	/**
	 * ����v�Ķ���,��v�ı���
	 * 
	 * @param G
	 * @param v
	 * @return
	 */
	public static int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v)) {
			degree++;
		}
		return degree;
	}

	/**
	 * �������ж����������
	 * 
	 * @param G
	 * @return
	 */
	public static int maxDegree(Graph G) {
		int max = 0;
		for (int v = 0; v < G.V; v++) {
			for (int w : G.adj(v)) {
				if (w > max)
					max = w;
			}
		}
		return max;
	}

	/**
	 * �������ж����ƽ������
	 * 
	 * @param G
	 * @return
	 */
	public static double avgDegree(Graph G) {
		return 2.0 * G.E / G.V;
	}

	/**
	 * �����Ի�����
	 * 
	 * @param G
	 * @return
	 */
	public static int numOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V; v++) {
			for (int w : G.adj(v))
				if (w == v)
					count++;
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + "������" + E + "����" + "\n");
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : this.adj(v))
				s.append(w + " ");
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		System.out.println("����������: " + maxDegree(G));
		System.out.println(G.toString());
		System.out.println("�Ի�����: "+numOfSelfLoops(G));
	}

}
