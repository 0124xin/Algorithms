package Number_5;

import edu.princeton.cs.algs4.In;

/**
 * P479 �㷨5.4 ���ڵ��ʲ������ķ��ű�
 * 
 * args[0]:shellsST.txt
 * 
 * @author he
 *
 */
public class TrieST<Value> {
	private static final int R = 256;// ��ĸ��Ĵ�С��8λ��ASCII����Ԫ�ظ���
	private Node root;// ���ʲ������ĸ����
	private int N;// �������м�������

	public TrieST() {
	}

	private static class Node {
		private Object val;// ����Ӧ��ֵ
		private Node next[] = new Node[R];// ����ָ������Node���������

	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		if (x == null)
			x = new Node();
		// ��ֵ���浽�������һ���ַ����ڽ��
		if (d == key.length()) {
			if (x.val == null)
				N++;
			x.val = val;
			return x;
		}
		char c = key.charAt(d);// �ҵ�d���ַ���Ӧ���ӵ��ʲ�����
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	@SuppressWarnings("unchecked")
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);// �ҵ�d���ַ�����Ӧ���ӵ��ʲ�����
		return get(x.next[c], key, d + 1);
	}

	public int size() {
		return N;
	}

	/**
	 * public int size() { return size(root); }
	 * 
	 * private int size(Node x) { if (x == null) return 0; int cn = 0; if (x.val
	 * != null) cn++; for (char r = 0; r < R; r++) cn += size(x.next[r]); return
	 * cn;
	 * 
	 * }
	 * 
	 * 
	 */

	public static void main(String[] args) {
		TrieST<Integer> trieST = new TrieST<Integer>();
		In in = new In(args[0]);
		int i = 0;
		while (!in.isEmpty()) {
			String key = in.readString();
			System.out.println(key);
			trieST.put(key, i++);
		}

		System.out.println(trieST.get("sea"));

	}

}
