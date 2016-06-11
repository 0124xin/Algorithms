package Num1_3_02;

/**
 * P265 T13
 * 
 * @author he
 *
 */

class BST2<Key extends Comparable<Key>, Value> {
	private Node root;// ���ڵ�

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

	}

	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else {
				return x.value;
			}
		}
		return null;
	}

	public void put(Key key, Value value) {
		Node t = new Node(key, value);
		if (root == null) {
			root = t;
			return;
		}
		Node x = root;
		Node parent = null;// x���ĸ�����������Ĳ������
		while (x != null) {
			parent = x;// ������x==null���� parent��x�ĸ���������жϲ������λ��
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else {
				x.value = value;
				return;
			}
		}

		int cmp = key.compareTo(parent.key);
		if (cmp < 0) {
			parent.left = t;
		} else {
			parent.right = t;
		}

	}

}

public class Num_3_02_13 {
	public static void main(String[] args) {
		BST2<String, Integer> bst = new BST2<String, Integer>();
		bst.put("A", 1);
		bst.put("S", 0);
		bst.put("E", 1);
		bst.put("A", 2);
		bst.put("E", 6);
		System.out.println(bst.get("S"));
		System.out.println(bst.get("A"));
	}
}
