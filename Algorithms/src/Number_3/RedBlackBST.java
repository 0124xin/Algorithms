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
	private boolean isRead(Node x) {
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

}
