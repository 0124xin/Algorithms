package Number_3;

import edu.princeton.cs.algs4.Queue;

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
		if (cmp == 0) {
			return x;
		}
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

	// �����������Ҽ�
	public Key select(int k) {
		if (k < 0 || k >= size())
			throw new IllegalArgumentException();
		return select(root, k).key;
	}

	/**
	 * ����������Ľ��������k����ݹ�����������в�������Ϊk�ļ��� ���t����k���ڷ��ظ����ļ���
	 * ���tС��k���ݹ�����������в�������Ϊ��k-t-1���ļ�
	 * 
	 * @param x
	 * @param k
	 * @return
	 */
	private Node select(Node x, int k) {
		// ��������Ϊk�Ľ��
		if (x == null) {
			return null;
		}
		int t = size(x.left);
		if (t > k) {
			return select(x.left, k);
		} else if (t < k) {
			return select(x.right, k - t - 1);
		} else {
			return x;
		}
	}

	// ���ݼ��������±꣨������
	public int rank(Key key) {
		return rank(root, key);
	}

	/**
	 * ��������ļ��͸����ļ���ȣ����ظ��ڵ��������Ľ������t size(x.left); ��������ļ��ȸ����ļ�С,�ݹ��������������������
	 * ��������ļ��ȸ����ļ��󣬷��ظ�����������������t+1+����������������
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private int rank(Node x, Key key) {
		if (x == null) {
			return 0;
		}

		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return rank(x.left, key);
		} else if (cmp > 0) {
			return 1 + size(x.left) + rank(x.right, key);
		} else {
			return size(x.left);
		}

	}

	// ɾ����С�Ľ��
	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	// ɾ�����Ľ��
	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) {
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	// ɾ��ָ�����
	public void delete(Key key) {
		root = delete(root, key);
	}

	/**
	 * ����ý��ֻ�е��ߣ��ο�deleteMin(),deleteMax(),�ڸý�������ҽ�������£�
	 * ���ĺ�̽�����������������С�Ľ�㣬������֤�˶������������� 1����ִ�м�����ɾ���Ľ���������Ϊt��
	 * 2����xָ�����ĺ�̽��min(t.right); 3����x��������ָ��deleteMin(t.right); 4��x.left=t.left;
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	// �����������еļ�,�����������-->��-��-��
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	// ����ָ����Χ�ڵļ�
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) {
			return;
		}

		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);

		if (cmplo < 0) {
			keys(x.left, queue, lo, hi);
		}
		if (cmplo <= 0 && cmphi >= 0) {
			queue.enqueue(x.key);
		}
		if (cmphi > 0) {
			keys(x.right, queue, lo, hi);
		}

	}

	public static void main(String[] args) {
		BST<String, Integer> bst = new BST<String, Integer>();
		bst.put("S", 0);
		bst.put("E", 1);
		bst.put("A", 2);
		bst.put("C", 3);
		bst.put("R", 4);
		bst.put("X", 5);
		bst.put("H", 6);
		bst.put("M", 7);
		System.out.println(bst.get("E"));
		bst.deleteMin();
		System.out.println(bst.min());
		System.out.println(bst.max());
		System.out.println(bst.floor("G"));
		System.out.println("ceiling:" + bst.ceiling("A"));
		System.out.println(bst.select(1));
		System.out.println(bst.rank("S"));
		bst.deleteMin();
		System.out.println(bst.select(0));
		bst.deleteMax();
		System.out.println(bst.select(bst.size() - 1));
		bst.delete("X");
		System.out.println(bst.get("X"));
		for (String s : bst.keys()) {
			System.out.print(s + " ");
		}
	}
}
