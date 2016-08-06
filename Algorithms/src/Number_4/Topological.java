package Number_4;

/**
 * P375 �㷨4.5 �������򣨽���������ͼ���޻����Ͷ������� 
 * �޻�����ͼ������������Ƕ�������������
 * 
 * @author he
 * args[0]:jobs.txt
 * args[1]:/
 */
public class Topological {
	private Iterable<Integer> order;// ���������˳��

	public Topological(Digraph G) {
		DirectedCycle cycle = new DirectedCycle(G);
		if (!cycle.hasCycle()) {
			DepthFirstOrder d = new DepthFirstOrder(G);
			order = d.reversePost();
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	public boolean isDAG() {
		return order != null;
	}

	public static void main(String[] args) {
		String filename = args[0];// �ļ���
		String sp = args[1];// �ָ���
		SymbolDigraph sg = new SymbolDigraph(filename, sp);
		Topological top = new Topological(sg.G());
		for (int w : top.order)
			System.out.println(sg.name(w));
	}
}
