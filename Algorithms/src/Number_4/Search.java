package Number_4;

/**
 * 	P337 API
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Search {
	private WeightedQuickUnionUF uf;
	private int s;// ���
	private int V;// ��������

	// �ҵ������s��ͨ�����ж��㣨��������
	public Search(Graph G, int s) {
		uf = new WeightedQuickUnionUF(G.V());
		this.s = s;
		this.V = G.V();
		// ��ͼG���еı���ӵ�uf��
		for (int i = 0; i < G.V(); i++) {
			for (int w : G.adj(i)) {
				uf.union(w, i);
			}
		}
	}

	// v��s�Ƿ���ͨ
	public boolean marked(int v) {
		return uf.connected(v, s);
	}

	// �������ͨ�Ķ�������
	public int count() {
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (marked(i))
				count++;
		}
		return count;
	}
}
