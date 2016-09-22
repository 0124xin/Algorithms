package Number_5;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

/**
 * P524 ������ʽ��ģʽƥ�䣨grep�� �ο���P520��521
 * 
 * @author he
 *
 */
public class NFA {
	private char re[];// ƥ��ת��
	private Digraph G;// epsilonת��
	private int M;

	// ����NFA����ȷ������״̬������ת��Ϊ����ͼ

	/**
	 * ע��ע�⣡��������������ĸָ���һ���ַ��Ŀɴ��Զ����ڷ���recognizes����ӵģ����÷�����������������
	 * ����P525��ͼ��ִ���˹��캯��NFA��String pre���ͷ���recognizes����ܲ�����NFA��ִֻ�й��캯���м���״̬�ǲ��ɴ��
	 * ���磺2-->3����һ���ߣ�4-->5��6-->7��7-->8��9-->10��ֻ����ִ����recognizes������ž��пɴ��ԣ�
	 * ���е�ͼ��һ��������
	 * 
	 * @param pre
	 */
	public NFA(String pre) {
		Stack<Integer> ops = new Stack<Integer>();
		re = pre.toCharArray();
		M = re.length;
		G = new Digraph(M + 1);

		for (int i = 0; i < M; i++) {
			int lp = i;
			if (re[i] == '(' || re[i] == '|')
				ops.push(i);
			else if (re[i] == ')') {
				int or = ops.pop();
				if (re[or] == '|') {
					lp = ops.pop();
					G.addEdge(lp, or + 1);
					G.addEdge(or, i);
				} else
					lp = or;
			}

			if (i < M - 1 && re[i + 1] == '*') {
				G.addEdge(lp, i + 1);
				G.addEdge(i + 1, lp);
			}
			if (re[i] == '(' || re[i] == '*' || re[i] == ')')
				G.addEdge(i, i + 1);

		}

		// ִֻ�й��캯��9-->10 ���ɴ�
		// DirectedDFS dfs = new DirectedDFS(G, 9);
		// System.out.println(dfs.marked(10));

	}

	/**
	 * �ж�NFA�ܷ�ʶ���ı� ��������ͼ�Ŀ����Լ�⣨����㣬����㣩��������εĿɴ��Լ�⣨��һ���ַ��Ƿ�����ǰһ���ַ��ɴ�ܷ񵽴�ɽ���״̬M��
	 * ����ɴ����ʾ���ı��ܱ�ģʽʶ��
	 * 
	 * @param txt
	 * @return
	 */
	public boolean recognizes(String txt) {
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		for (int v = 0; v < G.V(); v++)
			if (dfs.marked(v))
				pc.add(v);// �ɴ�����ӣ�������г�ʼ״̬0�Ŀɴ�״̬

		for (int i = 0; i < txt.length(); i++) {
			Bag<Integer> match = new Bag<Integer>();// ���ڼ�¼�ַ����еĿ�ת��״̬������A�Ŀ�ת��״̬��3��7
			for (int v : pc) {
				if (v < M) {// δ����ɽ���״̬M��M��ֵ��ʾ�ɽ���״̬
					if (re[v] == txt.charAt(i) || re[v] == '.') {
						// ���re[v]����ĸ������ô���Եõ�v��v+1��ת���������ַ�A����״̬2��״̬6����״̬����ô���Եõ�����ת��״̬3��7
						// ����P521
						//
						// �ڴ˴��������ĸָ���һ���ַ��Ŀɴ��ԣ���������
						//
						match.add(v + 1);
					}
				}
			}

			pc = new Bag<Integer>();// ����
			dfs = new DirectedDFS(G, match);

			// �����ɴ��Լ�⣬�����ַ�A��ת��״̬��{3,7}������{3,7}Ϊ�����пɴ��Լ�Ⲣ���ɴ��״̬��ӵ�pc��
			for (int v = 0; v < G.V(); v++)
				if (dfs.marked(v))
					pc.add(v);

		}

		for (int v : pc)
			if (v == M)
				return true;// ����ɽ���״̬����NFA��ʶ���ı�
		return false;
	}

	public static void main(String[] args) {
		String regexp = "(.*" + args[0] + ".*)";
		// String regexp = "((A*B|AC)D)";
		NFA nfa = new NFA(regexp);

		In in = new In(args[1]);
		while (!in.isEmpty()) {
			String txt = in.readLine();
			if (nfa.recognizes(txt))
				System.out.println(txt);
		}

	}

}
