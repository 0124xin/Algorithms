package Number_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * P479 �㷨5.4 ���ڵ��ʲ������ķ��ű� ע�⣺����d==key.length��Ӧ�����鱣��Ľ����ֵ�������еĽ�㲻����ֵ�ģ���key-->she
 * ��Ӧ��ֵΪ0��'s' 'h' 'e'
 * ��Ӧֻ��������±�(�ַ�ת��Ϊʮ������)���Ѷ�����Node.c=s�����л���ͼ��һ��ԲȦ������������е�һ��Ԫ����index=s(ת��Ϊʮ����)
 * args[0]:shellsST.txt
 * ֻ��R��ĵ��ʲ���������Ψһ��
 * @author he
 *
 */
public class TrieST<Value> {
	private static final int R = 256;// ��ĸ��Ĵ�С��8λ��ASCII����Ԫ�ظ���
	private Node root;// ���ʲ������ĸ����,root.val==null
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

	/*
	 * ���ص��ʲ����������еļ�
	 */
	public Iterable<String> keys() {
		return keysWithPrefix("");

	}

	/**
	 * ����������preΪǰ׺�ļ� ���絥�ʲ��������С�shells��,preΪ"shel"�򷵻�shells
	 * 
	 * @param pre
	 * @return
	 */
	public Iterable<String> keysWithPrefix(String pre) {
		Queue<String> q = new Queue<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}

	// ƥ����preΪǰ׺�ļ�
	private void collect(Node x, String pre, Queue<String> q) {
		if (x == null)
			return;
		if (x.val != null)
			q.enqueue(pre);
		for (char c = 0; c < R; c++)
			collect(x.next[c], pre + c, q);

	}

	/**
	 * ���к�patƥ��ļ������С�.����ʾ�ܹ�ƥ�������ַ� ���絥�ʲ��������С�shells��,preΪ"shel.."�򷵻�shells
	 * 
	 * @param pat
	 * @return
	 */
	public Iterable<String> keysThatMath(String pat) {
		Queue<String> q = new Queue<String>();
		collect(root, "", pat, q);
		if (q.size() == 0)
			throw new RuntimeException("δ�ҵ�ƥ����");
		return q;
	}

	private void collect(Node x, String pre, String pat, Queue<String> q) {
		if (x == null)
			return;
		int d = pre.length();
		if (d == pat.length() && x.val != null)
			q.enqueue(pre);
		// δƥ�䵽
		if (d == pat.length())
			return;
		char next = pat.charAt(d);
		for (char c = 0; c < R; c++)
			if (next == '.' || next == c)
				collect(x.next[c], pre + c, pat, q);
	}

	/**
	 * ����s��ǰ׺����ļ�,���絥�ʲ���������"she"����s="shell"������"she"
	 * 
	 * @param s
	 * @return
	 */
	public String longestPrefixOf(String s) {
		int length = search(root, s, 0, 0);// ���ʲ���������sƥ���key����󳤶�
		return s.substring(0, length);

	}

	// ��¼������s��ص�·�������ҵ�������ĳ���
	private int search(Node x, String s, int d, int length) {
		if (x == null)
			return length;
		if (x.val != null)
			length = d;// ���³���
		if (d == s.length())// ���ʲ������а���s
			return length;

		char c = s.charAt(d);
		return search(x.next[c], s, d + 1, length);

	}

	/**
	 * ɾ������
	 * 
	 * @param key
	 */
	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d) {
		if (x == null)
			return null;
		// ƥ�䵽Ҫɾ���ļ�
		if (d == key.length())
			x.val = null;
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		// �ǿս�㲻��ɾ��
		if (x.val != null)
			return x;
		// �ǿ����Ӳ���ɾ��
		for (char c = 0; c < R; c++)
			if (x.next[c] != null)
				return x;
		// �ý���ֵΪnull�����е�����ҲΪnull
		return null;

	}

	public int size() {
		return N;
	}

	/**
	 * ���п�ע�еķ�������ʱ�ݹ�ʵ�֣��ܺ�ʱ public int size() { return size(root); } private int
	 * size(Node x) { if (x == null) return 0; int cn = 0; if (x.val != null)
	 * cn++; for (char r = 0; r < R; r++) cn += size(x.next[r]); return cn;
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
			trieST.put(key, i++);
		}

		for (String s : trieST.keys())
			System.out.println(s);
		System.out.println("---------------");
		System.out.println(trieST.keysThatMath(".h."));
		System.out.println("longestPre:" + trieST.longestPrefixOf("shells"));
		trieST.delete("sea");
		for (String s : trieST.keys())
			System.out.println(s);
	}

}
