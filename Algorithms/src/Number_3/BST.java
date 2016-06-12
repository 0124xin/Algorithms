package Number_3;

import java.util.concurrent.ForkJoinPool.ManagedBlocker;

/**
 * P252 �㷨3.3 ���ڶ���������ķ��ű�(����)
 * 
 * @author he
 *
 */
public class BST<Key extends Comparable<Key>, Value> {

	private Node root;// �����

	/**
	 * ����࣬���ڴ����-ֵ�ԡ����ҽ���Լ��������� size(x)=size(x.left)+size(x.right)+1;
	 * 
	 * @author he
	 *
	 */
	private class Node {
		private Key key;// ��
		private Value value;// ֵ
		private Node left, right;// ָ����������������
		private int N;// �Ըý��Ϊ���������еĽ����

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.N;
		}
	}

	// ���ݼ�����ֵ
	public Value get(Key key) {
		return get(root, key);
	}

	// �ݹ�������������
	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		} else {
			return x.value;
		}

	}

	// ��Ӽ�ֵ��
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	// ʼ�շ��ص��Ǹ����
	private Node put(Node x, Key key, Value value) {
		// ���key��������£���������½��
		if (x == null) {
			return new Node(key, value, 1);
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	// ������С��
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null) {
			return x;
		}
		return min(x.left);
	}

	// ��������
	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null) {
			return x;
		} else {
			return max(x.right);
		}
	}

	// ����ȡ����С�ڵ���key������
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}

	/**
	 * ���keyС�ڸ��ڵ�������ȡ��һ���������У� ������ڸ���㣬������������������û�У��������������������key
	 *
	 * @param x
	 * @param key
	 * @return
	 */
	private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return floor(x.left, key);
		}

		Node t = floor(x.right, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}

	}

	// ����ȡ��,���ڵ���key����С��
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}

	/**
	 * ���key���ڸ����������ȡ��һ�����������У����keyС�ڸ���㣬��������������У� ���Ϊδ���У��������������ȡ����ֵ
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Node ceiling(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp > 0) {
			return ceiling(x.right, key);
		}

		Node t = ceiling(x.left, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}

	}

	public static void main(String[] args) {
		BST<String, Integer> bst = new BST<String, Integer>();
		bst.put("S", 0);
		bst.put("E", 1);
		bst.put("B", 2);
		bst.put("E", 6);
		System.out.println(bst.get("E"));
		System.out.println(bst.min());
		System.out.println(bst.max());
		System.out.println(bst.floor("A"));
		System.out.println(bst.ceiling("C"));

	}
}
