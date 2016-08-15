package Num2_4_03;

import java.util.HashSet;
import java.util.Set;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;

/**
 * P410 T23 ɾ�������γɻ��е�Ȩ�����ı� 
 * �޸�Cycle�࣬ʵ�ּ���Ȩ����ͼ�Ļ���⣬
 * �޸������Ȩ�ߵ����ݽṹʵ�ֿ���ɾ��ָ����
 * 
 * @author he
 * args[0]:tinyEWG.txt
 *   ����ͨ��
 *
 */
class Vyssotsky {
	private MaxPQ<Edge> pq;
	private Cycle cycle;
	private Set<Edge> set;// ������С������
	private EdgeWeightedGraph G2;

	public Vyssotsky(EdgeWeightedGraph G) {
		pq = new MaxPQ<Edge>();
		G2 = new EdgeWeightedGraph(G.V());
		set = new HashSet<Edge>();
		for (Edge e : G.edges()) {
			G2.addEdge(e);
			cycle = new Cycle(G2);//ÿ�����һ���߾ͼ��һ��
			set.add(e);
			if (cycle.hasCycle()) {//����γɻ����������ļ�Ȩ��ɾ��
				pq = new MaxPQ<Edge>();
				for (Edge t : cycle.path()) {
					pq.insert(t);
				}
				set.remove(pq.max());// ���γɻ��ļ�Ȩ�ߴ���С��������ɾ��
				G2.delEdge(pq.max());// ��Ȩ����ͼ���Ƴ�Ҫɾ���ı�
			}
		}
	}

	public Iterable<Edge> edges() {
		return set;
	}

}

public class Num_4_02_23 {
	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		Vyssotsky v = new Vyssotsky(G);
		for (Edge e : v.edges())
			System.out.println(e);
	}

}
