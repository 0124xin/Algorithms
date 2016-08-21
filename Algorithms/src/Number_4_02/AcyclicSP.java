package Number_4_02;

import edu.princeton.cs.algs4.Topological;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.DirectedEdge;

/**
 * P427 �㷨 4.10 �޻���Ȩ����ͼ�����·���㷨�� �����ڼ�Ȩ�����޻�ͼ���ܹ�����Ȩ�صı��Լ��ҳ��·��
 * �����Ȩ�����޻�ͼ��Dijkstra�㷨��
 *
 * @author he args[0]:tinyEWDAG.txt args[1]:5
 */
public class AcyclicSP {
	private double distTo[];// ����Ȩ�أ����·������Ȩ�أ�distTo[w]��ʾ��㵽w���·������Ȩ��
	private DirectedEdge edgeTo[];// ���·���ı�
	private double longDist[];// �����·������Ȩ��
	private DirectedEdge longEdge[];// �·���ı�

	// sΪ���
	public AcyclicSP(EdgeWeightedDigraph G, int s) {
		// ���·��
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];

		// �·��
		longDist = new double[G.V()];
		longEdge = new DirectedEdge[G.V()];

		for (int i = 0; i < G.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;// ���漫���doubleֵ
			longDist[i] = Double.MIN_VALUE;// ���漫С��doubleֵ
		}
		distTo[s] = 0.0;
		longDist[s] = 0.0;
		Topological top = new Topological(G);
		for (int v : top.order()) {
			relax(G, v);
			shrink(G, v);
		}
	}

	// ��֤distTo[w]����㵽ָ��������С����Ȩ��
	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
		}
	}

	// ��֤longDist[w]����㵽ָ������������Ȩ��
	private void shrink(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (longDist[w] < longDist[v] + e.weight()) {
				longDist[w] = longDist[v] + e.weight();
				longEdge[w] = e;
			}
		}
	}

	/**
	 * ������㵽����v���·������Ȩ��
	 * 
	 * @param v
	 * @return
	 */
	public double distTo(int v) {
		return distTo[v];
	}

	/**
	 * ������㵽����v�·������Ȩ��
	 * 
	 * @param v
	 * @return
	 */
	public double longDist(int v) {
		return longDist[v];
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
	 * ����㵽v�����·��
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

	/**
	 * ����㵽����v�·��
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<DirectedEdge> longPathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = longEdge[v]; e != null; e = longEdge[e.from()])
			path.push(e);
		return path;

	}

	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = Integer.valueOf(args[1]);// ���
		AcyclicSP sp = new AcyclicSP(G, s);

		for (int t = 0; t < G.V(); t++) {
			System.out.print(s + " to " + t);
			System.out.printf(" (%.2f): ", sp.distTo(t));
			if (sp.hasPathTo(t))
				for (DirectedEdge e : sp.pathTo(t))
					System.out.print(e + " ");
			System.out.println();
		}
		System.out.println("---------------------�·��-------------------");
		for (int t = 0; t < G.V(); t++) {
			System.out.print(s + " to " + t);
			System.out.printf(" (%.2f): ", sp.longDist(t));
			if (sp.hasPathTo(t))
				for (DirectedEdge e : sp.longPathTo(t))
					System.out.print(e + " ");
			System.out.println();
		}
		
		
	}

}
