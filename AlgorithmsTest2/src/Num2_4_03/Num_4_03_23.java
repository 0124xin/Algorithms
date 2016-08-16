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
	private EdgeWeightedGraph G2;//�������С������

	public Vyssotsky(EdgeWeightedGraph G) {
		pq = new MaxPQ<Edge>();
		G2 = new EdgeWeightedGraph(G.V());
		for (Edge e : G.edges()) {
			G2.addEdge(e);
			cycle = new Cycle(G2);//ÿ���һ���߾ͼ��һ��
			if (cycle.hasCycle()) {//����γɻ����������ļ�Ȩ��ɾ��
				pq = new MaxPQ<Edge>();
				for (Edge t : cycle.path()) {
					pq.insert(t);
				}
				G2.delEdge(pq.max());// ��Ȩ����ͼ���Ƴ�Ҫɾ���ı�
			}
		}
	}

	public Iterable<Edge> edges() {
		return G2.edges();
	}

}

public class Num_4_03_23 {
	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In(args[0]));
		Vyssotsky v = new Vyssotsky(G);
		for (Edge e : v.edges())
			System.out.println(e);
	}

}
