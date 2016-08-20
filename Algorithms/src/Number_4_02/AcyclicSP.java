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

	// sΪ���
	public AcyclicSP(EdgeWeightedDigraph G, int s) {
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];

		for (int i = 0; i < G.V(); i++)
			distTo[i] = Double.POSITIVE_INFINITY;

		distTo[s] = 0.0;
		Topological top = new Topological(G);
		for (int v : top.order())// ������ͼ���з��ɱ�
			relax(G, v);
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
		}
	}

	/**
	 * �Ƿ���ڶ���s��v��·��
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
	 * ����㵽v��·��
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
	}

}
