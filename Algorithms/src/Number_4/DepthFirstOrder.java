package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * P374 ����ͼ�л���������������Ķ���˳��
 * 
 * 1��ǰ���ڵݹ����֮ǰ�����������У�dfs�����ĵ���˳�� 2�������ڵݹ����֮�󽫶��������У����������ɵ�˳��
 * 3��������ڵݹ����֮�󽫶���ѹ��ջ����������ķ���
 * 
 * @author he
 * args[0]:tinyDAG.txt
 *
 */
public class DepthFirstOrder {
	private boolean marked[];// ��Ƕ���
	private Queue<Integer> pre;// ���ж����ǰ�����
	private Queue<Integer> post;// ���ж���ĺ������
	private Stack<Integer> reversePost;// ���ж������������

	public DepthFirstOrder(Digraph G) {
		marked = new boolean[G.V()];
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();

		for (int v = 0; v < G.V(); v++) {
			if (!marked[v])
				dfs(G, v);
		}

	}

	private void dfs(Digraph G, int v) {
		pre.enqueue(v);
        marked[v]=true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
		post.enqueue(v);
		reversePost.push(v);
	}

	// ������������
	public Iterable<Integer> pre() {
		return pre;
	}

	// ����ĺ������
	public Iterable<Integer> post() {
		return post;
	}

	// ��������
	public Iterable<Integer> reversePost() {
		return reversePost;
	}

	public static void main(String[] args) {
		Digraph G = new Digraph(new In(args[0]));
		DepthFirstOrder d = new DepthFirstOrder(G);
		System.out.println("ǰ�������");
		for (int x : d.pre())
			System.out.print(x + " ");
		System.out.println("\n"+"���������");
		for (int x : d.post())
			System.out.print(x + " ");
		System.out.println("\n"+"����������");
		for (int x : d.reversePost())
			System.out.print(x + " ");
	}

}
