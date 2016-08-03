package Num2_4_01;

import edu.princeton.cs.algs4.In;

/**
 * ʹ���޸Ĺ���Graph�֧࣬��ɾ��һ���� args[0]:G.txt
 * 
 * @author he
 * 
 */

class GC {
	private boolean marked[];
	private int id[];
	private int count;
	private GraphX t[];
	private boolean lg;// �ж��Ƿ�Ϊ����ͨͼ
	private String bridge;// ��¼��
	private String b[];// ��

	public GC(String filename) {
		GraphX G = new GraphX(new In(filename));
		marked = new boolean[G.V()];
		id = new int[G.V()];
		b = G.b;
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				dfs(G, i);
				count++;
			}
		}

		if (count != 1) {
			throw new RuntimeException("ͼG������ͨͼ");
		}

		t = new GraphX[G.E()];
		for (int i = 0; i < G.E(); i++)
			t[i] = new GraphX(new In(filename));
	}

	private void dfs(GraphX G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
		}
	}

	public int count() {
		return count;
	}

	// �ж��Ƿ��Ǳ���ͨͼ
	public boolean isELG() {
		find(t);
		return lg;
	}

	// ������
	public String bridge() {
		return bridge;
	}

	// ����ÿ���ٲ�ͬ�ߵ�ͼ
	private void find(GraphX[] G) {

		for (int i = 0; i < G.length; i++) {
			int a = Integer.valueOf(b[i].split("\\.")[0]);
			int  k = Integer.valueOf(b[i].split("\\.")[1]);
			G[i].delEdge(a, k);// ɾ����
			marked = new boolean[G[i].V()];// ����
			count = 0;// ����
			for (int j = 0; j < G[i].V(); j++) {
				if (!marked[j]) {
					dfs(G[i], j);
					count++;
				}
			}
			if (count != 1) {
				lg = true;
				bridge = a + "--" + i;
				return;
			}
		}
	}
}

public class Num_4_01_35 {
	public static void main(String[] args) {
		String filename = args[0];
		GC c = new GC(filename);
		System.out.println(c.isELG());
		System.out.println(c.bridge());
	}

}
