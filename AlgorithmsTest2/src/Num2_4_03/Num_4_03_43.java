package Num2_4_03;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.UF;

/**
 * P411 T43
 * 
 * @author he
 *
 */

/**
 * Boruvka�㷨���ҳ��޻������Ȩ��ͨͼ����С������ ����˼�룺�ҳ������������ò�ͬ������Ȩ����С�ıߣ���������ȫ��������С������
 * 
 * @author he
 *
 */
class Boruvka {
	private Bag<Edge> mst = new Bag<Edge>();// ��С������
	private double weight;// Ȩ��

	public Boruvka(EdgeWeightedGraph G) {
		UF uf = new UF(G.V());
		Edge closet[] = new Edge[G.V()];

		// �ҵ�Ȩ����С�ıߣ�����i=index,closet[index]����Ķ����붥��i���������С�ļ�Ȩ��
		// ��Ϊ����i��������һ��Ȩ�رȽϴ�ļ�Ȩ�߿���Ҳ����С��������һ���֣���֤����������ͨ�ԣ��������Ҫѭ��
		//0-2 ������closet[4]��
		for (int t = 1; t< G.V() && mst.size() < G.V() - 1; t = t + t) {
			for (Edge e : G.edges()) {
				int v = e.either();
				int w = e.other(v);
				int i = uf.find(v);
				int j = uf.find(w);
				if (i == j) // ��ʾ��ͬһ����
					continue;
				if (closet[i] == null || less(e, closet[i]))
					closet[i] = e;
				if (closet[j] == null || less(e, closet[j]))
					closet[j] = e;
			}

			//��һ�α����Ѿ���ÿ�������������С��Ȩ����ӵ���С��������
			for (int i = 0; i < G.V(); i++) {
				Edge e = closet[i];
				if (e != null) {
					int v = e.either();
					int w = e.other(v);
					if (!uf.connected(v, w)) {// �����ظ���
						mst.add(e);
						uf.union(v, w);
						weight += e.weight();
					}

				}
			}
		}

	}

	// �ж���С��Ȩ��
	private boolean less(Edge e, Edge t) {
		return e.weight() < t.weight();
	}

	public Iterable<Edge> mst() {
		return mst;
	}

	public double weight() {
		return weight;
	}

}

public class Num_4_03_43 {
	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		Boruvka mst = new Boruvka(G);
		for (Edge e : mst.mst())
			System.out.println(e);
	}

}
