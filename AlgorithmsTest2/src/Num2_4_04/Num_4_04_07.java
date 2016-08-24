package Num2_4_04;

import java.text.DecimalFormat;
import java.util.LinkedList;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * P446 T07 ��Ȩ����ͼ�д���㵽��ָ������������Ȩ����ͬ�ı� 
 * ע��double�ڼ����ʱ��С���������16λ������ڱȽϵ�ʱ��Ҫǿת
 * ��д��ֻ�ʺ���㵽ĳ�����㣨ֻ����һ�����㣩����������ͬ�����·��
 * @author he
 *	args[0]:tinyEWDsame.txt
 */

class Dijkdtra {
	private DirectedEdge edgeTo[];
	private LinkedList<DirectedEdge> q;// ��¼��һ�����·��
	private double distTo[];
	private IndexMinPQ<Double> pq;
	DecimalFormat d;// ָ��double�ڼ���ʱ������λ��

	/**
	 * 
	 * @param G
	 *            ������Ȩ�ص�����ͼ
	 * @param s
	 *            ���
	 * @param bit
	 *            ָ��Ȩ���ڼ���ʱ������λ��
	 */
	public Dijkdtra(EdgeWeightedDigraph G, int s, int bit) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		q = new LinkedList<DirectedEdge>();
		String b = "0.";
		for (int i = 0; i < bit; i++) {
			b += "0";
		}
		d = new DecimalFormat("###" + b);

		for (int i = 0; i < G.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		pq.insert(s, distTo[s]);

		while (!pq.isEmpty()) {
			relax(G, pq.delMin());
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] == Double.valueOf(d.format(distTo[v] + e.weight()))) {
				for (DirectedEdge t : path(v)) {
					q.add(t);
				}
				q.add(e);
			}
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			} else if (distTo[w] == distTo[v] + e.weight()) {
				System.out.println("xxxx");
			}
		}
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> path(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasOtherPath(int v) {
		if (q.size() == 0)
			return false;
		DirectedEdge e = q.getLast();
		int w = e.to();
		return w == v;
	}

	public Iterable<DirectedEdge> otherPath(int v) {
		if (!hasPathTo(v))
			return null;
		if (!hasOtherPath(v))
			return null;
		return q;

	}

}

public class Num_4_04_07 {
	public static void main(String[] args) {
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(args[0]));
		int s = 0;
		Dijkdtra sp = new Dijkdtra(G, s, 2);
		for (int t = 0; t < G.V(); t++) {
			System.out.print(s + " to " + t);
			System.out.printf(" (%4.2f): ", sp.distTo(t));
			if (sp.hasPathTo(t))
				for (DirectedEdge e : sp.path(t))
					System.out.print(e + " ");
			System.out.println();
			if (sp.hasOtherPath(t)) {
				System.out.println("other path:");
				System.out.print("    " + s + " to " + t);
				System.out.printf(" (%4.2f): ", sp.distTo(t));
				for (DirectedEdge e : sp.otherPath(t))
					System.out.print(e + " ");
				System.out.println();
			}
		}
	}

}
