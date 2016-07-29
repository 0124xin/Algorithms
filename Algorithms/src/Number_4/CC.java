package Number_4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * P349 �㷨4.3 
 * ʹ��������������ҳ�ͼ������ͨ������
 * �ж�ͼ�Ƿ��л�(����ͼ�������Ի���ƽ�б�)�Լ�ͼ�Ƿ��Ƕ���ͼ 
 * args[0]:tinyG.txt
 * 
 * @author he
 *
 */
public class CC {
	private boolean marked[];// ���ڱ����̽�����ĵ�
	private int id[];// ���ڴ�����ͨ�������ö���Ϊindex,��������ֵ��ͬ����Ϊ������һ����ͨ������
	private int count;// ��ͨ����������
	private Graph G;
	private boolean hasCycle;// ����ͼ�������Ի���ƽ�б�
	private boolean[] color;// ���涥�����ɫ
	private boolean isTwoColorable = true;// �ж��Ƿ��Ƕ���ͼ

	public CC(Graph G) {
		this.G = G;
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		id = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v, v);
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
	public void dfs(Graph G, int v, int u) {
		marked[v] = true;
		id[v] = count;// �洢��ͨ��������Ϣ
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				color[w] = !color[v];
				dfs(G, w, v);
			} else if (w != u)
				//�������ͨ����������ݹ������v����Ϊ�л�
				hasCycle = true;
			if (color[w] == color[v])
				isTwoColorable = false;
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

	/**
	 * ��ӡ��ͨ����
	 * 
	 * @return
	 */
	public String printComponents() {
		StringBuilder sb = new StringBuilder();
		@SuppressWarnings("unchecked")
		// ʹ��bag������ͬһ����ͨ�����ϵĶ���
		Bag<Integer> bag[] = (Bag<Integer>[]) new Bag[count];
		for (int i = 0; i < count; i++) {
			bag[i] = new Bag<Integer>();
		}
		// ����ͬһ����ͨ�����ϵĶ�����ӵ����ڵ�bag��
		for (int v = 0; v < G.V(); v++) {
			bag[id(v)].add(v);
		}
		for (int v = 0; v < count; v++) {
			for (int w : bag[v]) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * �ж�ͼ�Ƿ��л� ����ͼ�������Ի���ƽ�б�
	 * 
	 * @return
	 */
	public boolean hasCycle() {
		return hasCycle;
	}

	/**
	 * �ж�ͼ�Ƿ��Ƕ���ͼ
	 * 
	 * @return
	 */
	public boolean isBipartite() {
		return isTwoColorable;
	}

	public static void main(String[] args) {
//		Graph G = new Graph(new In(args[0]));
		Graph G=new Graph(3);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		CC c = new CC(G);

		int M = c.count;
		System.out.println("�ܹ���" + M + "����ͨ����");
		System.out.println(c.printComponents());
		System.out.println(c.hasCycle);// true
		System.out.println(c.isTwoColorable);// false
	}

}
