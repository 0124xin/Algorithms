package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P349 �㷨4.3 ʹ��������������ҳ�ͼ������ͨ�������ж�ͼ�Ƿ��л��Լ�ͼ�Ƿ��Ƕ���ͼ args[0]:tinyG.txt
 * 
 * @author he
 *
 */
public class CC {
	private boolean marked[];// ���ڱ����̽�����ĵ�
	private int id[];// ���ڴ�����ͨ�������ö���Ϊindex,��������ֵ��ͬ����Ϊ������һ����ͨ������
	private int count;// ��ͨ����������

	public CC(Graph G) {
		marked = new boolean[G.V()];
		id=new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
				// ��Ϊ��dfs֮��ִ�У����Ե�ͼ�����ж��㶼���������ִ����count++��
				// ���Լ�ʹcount�Ǵ�0��ʼ������ʱcount��ֵҲ����ͨ�����ĸ�����ͬ
				count++;
			}
		}
	}

	/**
	 * ����������ͨ����
	 * 
	 * @param G
	 * @param v
	 */
	public void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;// �洢��ͨ��������Ϣ
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
		}
	}

	/**
	 * ��ͨ����������
	 * 
	 * @return
	 */
	public int count() {
		return count;
	}

	/**
	 * �ж����������Ƿ���ͨ
	 * 
	 * @param w
	 * @param v
	 * @return
	 */
	public boolean connected(int w, int v) {
		return id[w] == id[v];
	}

	/**
	 * ���ض���v��������ͨ����
	 * 
	 * @param v
	 * @return
	 */
	public int id(int v) {
		return id[v];
	}

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		CC c = new CC(G);

		int M = c.count;
		System.out.println("�ܹ���" + M + "����ͨ����");
		// ʹ��bag������ͬһ����ͨ�����ϵĶ���
		@SuppressWarnings("unchecked")
		Bag<Integer> bag[] = (Bag<Integer>[]) new Bag[M];
		for (int i = 0; i < M; i++)
			bag[i] = new Bag<Integer>();

		for (int v = 0; v < G.V(); v++)
			bag[c.id(v)].add(v);// ����ͬһ����ͨ�����Ķ�����ӵ�ͬһ��������

		// ��ӡ
		for (int i = 0; i < M; i++) {
			for (int x : bag[i]) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

}
