package Num2_4_01;

import java.util.LinkedList;
import edu.princeton.cs.algs4.In;

/**
 * P336 GraphX(����ͼ)�������� ʹ���ڽӱ����飬�����������Ӧ���㣬ÿ�������е�Ԫ������ö������ӵĶ����б� ʹ��Bag���� ÿ���߶����������
 * v-w �� w-v args[0]:tinyG.txt
 * 
 * @author he
 *
 */
public class GraphX {
	private final int V;// �������
	private int E;// �ߵ���Ŀ
	private LinkedList<Integer> adj[];// �ڽӱ�
	public String b[];// ��¼��ӵı�

	@SuppressWarnings("unchecked")
	public GraphX(int v) {
		this.V = v;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public GraphX(In in) {
		this(in.readInt());
		int E = in.readInt();
		b = new String[E];
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
	 * ɾ��һ����
	 * 
	 * @param v
	 * @param w
	 */
	public void delEdge(int v, int w) {
		int indexW = -1;
		int indexV = -1;
		// ��Ϊ�������͵�adj[v].remove��ִ��adj[v].remove(index)����������remove(Oject o)
		if (adj[v].contains(w) && adj[w].contains(v)) {
			indexW = adj[v].indexOf(w);
			indexV = adj[w].indexOf(v);
		}
		if (indexV != -1 && indexW != -1) {
			adj[v].remove(indexW);
			adj[w].remove(indexV);
			E--;
		}		

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
		b[E++] = v + "." + w;

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
	public static int degree(GraphX G, int v) {
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
	public static int maxDegree(GraphX G) {
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
	public static double avgDegree(GraphX G) {
		return 2.0 * G.E / G.V;
	}

	/**
	 * �����Ի�����
	 * 
	 * @param G
	 * @return
	 */
	public static int numOfSelfLoops(GraphX G) {
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
		GraphX G = new GraphX(in);
		System.out.println("����������: " + maxDegree(G));
		System.out.println(G.toString());
		System.out.println("�Ի�����: " + numOfSelfLoops(G));
		G.delEdge(5, 4);
	}

}
