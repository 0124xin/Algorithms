package Num2_4_02;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.KosarajuSharirSCC;

/**
 * P387 T20
 * 
 * @author he
 *
 */

class Euler {
	private KosarajuSharirSCC scc;
	private int count1;// ͼG�ĳ���
	private int count2;// ͼG�ķ���ͼ�ĳ���

	public Euler(Digraph G){
		scc = new KosarajuSharirSCC(G);
		Digraph G2 = G.reverse();
		if (scc.count() != 1)
			throw new RuntimeException("G��������ŷ����");
		for (int i = 0; i < G.V(); i++) {
			for (int w : G.adj(i))
				count1++;
			for (int w : G2.adj(i))
				count2++;
			if (count1 != count2)
				throw new RuntimeException("G��������ŷ����");
		}
		System.out.println("ͼGӵ��ŷ����");
	}

}

public class Num_4_02_20 {
	public static void main(String[] args) {
		Digraph G=new Digraph(3);
		G.addEdge(0, 1);
		G.addEdge(1, 2);
		G.addEdge(2, 0);
		Euler e=new Euler(G);
		
	}
}
