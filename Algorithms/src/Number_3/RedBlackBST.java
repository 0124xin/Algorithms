package Number_3;

import edu.princeton.cs.algs4.Queue;

/**
 * P281 �㷨3.4 ����� �ú����ӽ�����2-��㹹��2-3��� ���㷨3.3��ֻҪ�޸�put()����delete()����
 * 
 * @author he
 *
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

	private final static boolean RED = true;// true,��ʾ������
	private final static boolean BLACK = false;// false����ʾ��ͨ���ӺͿ�����

	private Node root;// �����

	private class Node {
		Key key;
		Value value;
		Node left, right;// ��������
		int N;// �������
		boolean color;// ���丸���ָ���������ӵ���ɫ

		public Node(Key key, Value value, int N, boolean color) {
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		else
			return min(x.left);
	}

	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null)
			return x;
		else
			return max(x.right);
	}

	// �ж��Ƿ�Ϊ������
	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	/**
	 * ����ת����һ����ɫ��������ת��Ϊ�����ӣ����ӵ���ɫ�Ǹý��ָ�򸸽�����ӵ���ɫ
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;// ����������ɫ
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);// ���½������
		return x;
	}

	/**
	 * ����ת����һ����ɫ��������ת��Ϊ�����ӣ����ӵ���ɫ�Ǹý��ָ�򸸽�����ӵ���ɫ
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);// ���½������
		return x;
	}

	/**
	 * ��ɫת�������ӽ�����ɫ�ɺ��ڣ�ͬʱ����������ɫ�ɺڱ��
	 * 
	 * @param x
	 */
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;// ÿ�β��붼����������Ϊ������
	}

	private Node put(Node h, Key key, Value value) {
		if (h == null)
			h = new Node(key, value, 1, RED);

		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, value);
		else if (cmp > 0)
			h.right = put(h.right, key, value);
		else
			h.value = value;

		// ������Ϊ�����ӣ�����ת
		if (!isRed(h.left) && isRed(h.right))
			h = rotateLeft(h);
		// ������Ϊ�����ӣ����������ӵ�������Ϊ������,����ת
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		// �������Ӷ�Ϊ�����ӣ���ɫ�滻
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		h.N = size(h.left) + size(h.right) + 1;// ���½������
		return h;

	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.value;
	}

	/**
	 * ����index ���Ҽ�
	 * 
	 * @param k
	 * @return
	 */
	public Key select(int k) {
		if (k < 0 || k >= size())
			throw new IllegalArgumentException();
		return select(root, k).key;
	}

	private Node select(Node x, int k) {
		if (x == null)
			return null;
		int t = size(x.left);
		if (t > k)
			return select(x.left, k);
		else if (t < k)
			return select(x.right, k - t - 1);
		else
			return x;

	}

	/**
	 * ���ؼ����±�
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		return rank(root, key);
	}

	private int rank(Node x, Key key) {
		if (x == null)
			return 0;
		int t = key.compareTo(x.key);
		if (t < 0)
			return rank(x.left, key);
		else if (t > 0)
			return 1 + size(x.left) + rank(x.right, key);
		else
			return size(x.left);
	}

	/**
	 * ����ȡ��
	 * 
	 * @return
	 */
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}

	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	/**
	 * ����ȡ��
	 * 
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null)
			return null;
		else
			return x.key;
	}

	private Node ceiling(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp > 0)
			return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if (t != null)
			return t;
		else
			return x;

	}

	/**
	 * �������м�
	 * 
	 * @return
	 */
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	/**
	 * ����ָ����Χ�ڵļ�
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;

	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null)
			return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);

		if (cmplo < 0)
			keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.enqueue(x.key);
		if (cmphi > 0)
			keys(x.right, queue, lo, hi);
	}

	public static void main(String[] args) {
		RedBlackBST<String, Integer> bst = new RedBlackBST<String, Integer>();
		bst.put("S", 0);
		bst.put("E", 1);
		bst.put("A", 2);
		bst.put("C", 3);
		bst.put("R", 4);
		bst.put("X", 5);
		bst.put("H", 6);
		bst.put("M", 7);
		bst.put("E", 12);
		System.out.println(bst.floor("A"));
		System.out.println(bst.ceiling("B"));
		System.out.println(bst.select(2));
		System.out.println(bst.rank("M"));
		System.out.println(bst.min());
		System.out.println(bst.size());
		System.out.println(bst.get("E"));
		System.out.println(bst.keys());
	}

}
