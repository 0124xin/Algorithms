package Num2_4_03;

import java.util.Collections;
import java.util.LinkedList;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.UF;

/**
 * P410 T24
 * 
 * @author he
 *
 */

class EWG_ {
	private UF uf;
	private LinkedList<Edge> list;// �������еļ�Ȩ��,Ĭ����������
	private int E;
	private final int V;

	public EWG_(EdgeWeightedGraph G) {
		list = new LinkedList<Edge>();
		this.E = G.E();
		this.V = G.V();
		for (Edge e : G.edges()) {
			list.add(e);
		}
		Collections.sort(list);//����
		find(list);
	}

	/**
	 * �ҵ���С������
	 * 
	 * @param G
	 * @param set
	 */
	private void find(LinkedList<Edge> list) {
		int index = E;
		while (list.size() > V - 1) {
			Edge t = list.get(index - 1);// �Ӻ���ǰ��ȡ��
			uf = new UF(V);
			int v = t.either();
			int w = t.other(v);
			for (Edge e : list) {
				if (e == t)
					continue;// ����t,���t�������˵㻹����ͨ��ʾt����remove()
				int tv = e.either();
				int tw = e.other(tv);
				uf.union(tv, tw);
			}
			if (uf.connected(v, w)) {
				list.remove(t);
				index--;// list.size��С,index--
			} else {
				index--;// �����޷�remove�ı�
			}

		}

	}

	/**
	 * ������С������
	 * @return
	 */
	public String mst() {
		return list.toString();
	}

}

public class Num_4_03_24 {
	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		EWG_ e = new EWG_(G);
		System.out.println(e.mst());
	}

}
