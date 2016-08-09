package Num2_4_02;

import java.util.LinkedList;
import java.util.List;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;

/**
 * P387 T21 ����������밴�涨���룬���ⲻ���ж�
 * 
 * @author he
 *
 */

class LAC {
	private Digraph G;// ͼG�ķ���ͼ
	private boolean marked[];

	public LAC(Digraph G) {
		this.G = G.reverse();
	}

	/**
	 * ������ͼG�ж���v
	 * 
	 * 
	 * ��Ϊʹ�ù����������������linkedlist�����˳����Ƕ���vָ�������Ķ����˳��
	 * 
	 * @param v
	 */
	public Iterable<Integer> find(Digraph G, int v) {
		marked = new boolean[G.V()];// ����
		Queue<Integer> queue = new Queue<Integer>();
		List<Integer> l = new LinkedList<Integer>();
		marked[v] = true;
		queue.enqueue(v);
		while (!queue.isEmpty()) {
			int t = queue.dequeue();
			for (int w : G.adj(t)) {
				if (!marked[w]) {
					l.add(w);
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
		return l;
	}

	/**
	 * �ҳ�����v�Ͷ���w�������ͬ����
	 * 
	 * @param v
	 * @param w
	 * @return
	 */
	public int findLAC(int v, int w) {
		List<Integer> lv = (List<Integer>) find(G, v);
		List<Integer> lw = (List<Integer>) find(G, w);
		if (lv.size() > lw.size()) {
			for (int t : lw) {
				if (lv.contains(t))
					return t;
			}
		} else {

			for (int t : lv) {
				if (lw.contains(t))
					return t;
			}
		}
		return -1;
	}

}

public class Num_4_02_21 {
	public static void main(String[] args) {
		Digraph G = new Digraph(6);
		G.addEdge(2, 3);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(1, 4);
		G.addEdge(1, 3);
		G.addEdge(3, 5);
		LAC lac = new LAC(G);
		System.out.println(lac.findLAC(3, 4));

	}

}
