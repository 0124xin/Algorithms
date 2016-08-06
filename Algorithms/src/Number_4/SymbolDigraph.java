package Number_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolDigraph {
	private ST<String, Integer> st;// ����ķ�����-->index
	private String keys[];// index--->����ķ�����
	private Digraph G;// ͼ

	/**
	 * 
	 * @param filename
	 *            �ļ�������
	 * @param sp
	 *            �ָ���
	 */
	public SymbolDigraph(String filename, String sp) {
		st = new ST<String, Integer>();
		In in = new In(filename);
		while (in.hasNextLine()) {
			String a[] = in.readLine().split(sp);// ��ÿ�е���Ϣ���зָ�
			for (int i = 0; i < a.length; i++) {
				if (!st.contains(a[i]))
					st.put(a[i], st.size());// Ϊÿ��������һ������
			}
		}

		// index--->���������
		keys = new String[st.size()];
		for (String name : st.keys())
			keys[st.get(name)] = name;

		G = new Digraph(st.size());
		in = new In(filename);
		while (in.hasNextLine()) {
			String a[] = in.readLine().split(sp);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));// ��ÿ�еĵ�һ�����������������������
			}
		}

	}

	/**
	 * ����ͼ���Ƿ�����ü�
	 * 
	 * @param s
	 * @return
	 */
	public boolean contains(String s) {
		return st.contains(s);
	}

	/**
	 * ���ط�����s��index
	 * 
	 * @param s
	 * @return
	 */
	public int index(String s) {
		return st.get(s);
	}

	/**
	 * ����index��Ӧ�ķ�����
	 * 
	 * @param index
	 * @return
	 */
	public String name(int index) {
		return keys[index];
	}

	/**
	 * ��������ͼG
	 * 
	 * @return
	 */
	public Digraph G() {
		return G;
	}
}
