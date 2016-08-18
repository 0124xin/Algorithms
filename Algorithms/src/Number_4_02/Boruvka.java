package Number_4_02;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.UF;

/**
 * P411 Boruvka�㷨��Boruvka�㷨���� ����˼�룺�ҳ������������ò�ͬ������Ȩ����С�ıߣ���������ȫ��������С������
 * args[0]:tinyEWG.txt
 * 
 * @author he
 *
 */
public class Boruvka {
	private Bag<Edge> mst = new Bag<Edge>();// ������С������
	private double weight;// ��������Ȩ��

	public Boruvka(EdgeWeightedGraph G) {
		UF uf = new UF(G.V());
		Edge closest[] = new Edge[G.V()];

		// �ҵ�Ȩ����С�ıߣ�����i=index,closet[index]����Ķ����붥��i���������С�ļ�Ȩ��
		// ��Ϊ����i��������һ��Ȩ�رȽϴ�ļ�Ȩ�߿���Ҳ����С��������һ���֣���֤����������ͨ��,�������������0-2�ߣ��������Ҫѭ��
		// 0-2 ������closet[4]��
		for (int t = 1; t < G.V() && mst.size() < G.V() - 1; t = t + t) {
			for (Edge e : G.edges()) {
				int v = e.either(), w = e.other(v);
				int i = uf.find(v), j = uf.find(w);
				if (i == j)// ��ʾ��ͬһ����
					continue;
				if (closest[i] == null || less(e, closest[i]))
					closest[i] = e;
				if (closest[j] == null || less(e, closest[j]))
					closest[j] = e;

			}

			// ��һ�α����Ѿ���ÿ�������������С��Ȩ����ӵ���С��������
			for (int i = 0; i < G.V(); i++) {
				Edge e = closest[i];
				int v = e.either();
				int w = e.other(v);
				if (!uf.connected(v, w)) {// �����ظ���
					mst.add(e);
					weight += e.weight();
					uf.union(v, w);
				}
			}

		}

	}

	private boolean less(Edge e, Edge t) {
		return e.weight() < t.weight();
	}

	public double weight() {
		return weight;
	}

	public Iterable<Edge> mst() {
		return mst;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		Boruvka mst = new Boruvka(G);
		for (Edge e : mst.mst())
			System.out.println(e);
	}

}
