package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P380 �㷨4.6 ������ͼ��ǿ��ͨ���� ��ͼG�ķ���ͼ���������в�����ͨ������������ͼ����ͨ ������ͬ��
 * 
 * @author he args[0]:tinyDG.txt
 */
public class KosarajuSCC {
	private boolean marked[];// ���ڱ�Ƕ���
	private int count;// ǿ��ͨ����������
	private int id[];// indexΪ�����ֵ�����id[index]��ͬ���ʾ��ͬһ��ǿ��ͨ������

	public KosarajuSCC(Digraph G) {
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());// ��ȡͼG�ķ���ͼ
		marked = new boolean[G.V()];
		id = new int[G.V()];
		// ����ͼ����������򣬼�����ͼ������ͼ
		for (int v : order.reversePost()) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	// �ɴ��Է���,�ɴ�marked���true
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}

	/**
	 * ǿ��ͨ����������
	 * 
	 * @return
	 */
	public int count() {
		return count;
	}

	public boolean stronglyConnected(int v, int w) {
		return id[w] == id[v];
	}

	/**
	 * ���ض���v���ڵ�ǿ��ͨ����
	 * 
	 * @param v
	 * @return
	 */
	public int id(int v) {
		return id[v];
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		KosarajuSCC scc = new KosarajuSCC(G);
		int M = scc.count();
		@SuppressWarnings("unchecked")
		Bag<Integer> bag[] = (Bag<Integer>[]) new Bag[M];
		for (int i = 0; i < M; i++) {
			bag[i] = new Bag<Integer>();
		}
		for (int i = 0; i < G.V(); i++)
			bag[scc.id(i)].add(i);
		System.out.println("�ܹ���"+M+"��ǿ��ͨ����");
		System.out.println("��ӡ���е�ǿ��ͨ������");
		for (int i = 0; i < M; i++) {
			for (int w : bag[i])
				System.out.print(w + " ");
			System.out.println();
		}
	}

}
