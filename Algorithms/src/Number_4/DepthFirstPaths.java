package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P343 �㷨4.1 ʹ�����������������ͼ�е�·�� args[0]:tinyCG.txt args[1]:0
 * 
 * @author he
 *
 */
public class DepthFirstPaths {
	private boolean marked[];// ���ڴ�ű���ǹ��Ķ���
	private int edgeTo[];// ÿ��Ԫ�����ڴ��һ���������һ����ͨ�Ķ��㣬�Ӷ��������������ж��㵽����·��
	private final int s;// ���
	private int count;// �ѱ������������

	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	/**
	 * ����ÿ������ͱ�
	 * 
	 * @param G
	 * @param s
	 */
	public void dfs(Graph G, int s) {
		marked[s] = true;
		count++;
		for (int w : G.adj(s)) {
			if (!marked[w]) {
				edgeTo[w] = s;
				dfs(G, w);
			}
		}
	}

	/**
	 * ����ͼ�Ƿ�����ͨ������ͼ
	 * 
	 * @return
	 */
	public boolean isConnectedGraoh() {
		return count == marked.length;
	}

	/**
	 * �Ƿ���ڵ��ﶥ��v��·��
	 * 
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	

	/**
	 * ���ص��ﶥ��v��·��
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> stack = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			stack.push(x);
		stack.push(s);
		return stack;
	}

	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s = Integer.valueOf(args[1]);// ���
		DepthFirstPaths dfp = new DepthFirstPaths(G, s);
		for (int i = 0; i < G.V(); i++) {
			System.out.print(s + " to " + i + " : ");
			if (dfp.hasPathTo(i)) {
				for (int w : dfp.pathTo(i)) {
					if (w == s)
						System.out.print(s);
					else
						System.out.print("-" + w);
				}

			}
			System.out.println();
		}

	}
}
