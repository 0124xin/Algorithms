package Number_3;

/**
 * P281 �㷨3.4 ����� �ú����ӽ�����2-��㹹��2-3���
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
		System.out.println(bst.size());
		System.out.println(bst.get("E"));
	}

}
