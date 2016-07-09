package Number_3;

import edu.princeton.cs.algs4.Stack;

/**
 * �㷨 3.1 P236 ˳����ң�������������
 * 
 * @author he
 *
 */
public class SequentialSearchST<Key, Value> {
	private Node first;// �����׽��
	private int N; // ����Ԫ�ظ���

	private class Node {
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	/**
	 * ���ݼ���ȡֵ
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}
		for (Node x = first; x != null; x = x.next) {
			if (x.key.equals(key)) {
				return x.value; // ����
			}

		}
		return null;// δ����
	}

	/**
	 * ������������µļ�ֵ��
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.value = value;// ���� ����valueֵ
				return;
			}
		}
		first = new Node(key, value, first);// δ���У��½��
		N++;
	}

	// Ԫ�ظ���
	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean contains(Key key) {
		if (key == null)
			throw new NullPointerException("key ����Ϊnull");
		return get(key) != null;
	}

	/**
	 * ���ݼ�ɾ��ָ����ֵ��
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (key == null)
			throw new NullPointerException("key ����Ϊ null");
		first = delete(first, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		if (x.key.equals(key)) {
			N--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	/**
	 * ��Ϊ�����ʵ��ʱ��ջ����ʽ����������ʹ��ջ���������ܱ�֤return��õ���˳����putʱ��˳��
	 * 
	 * @return
	 */
	public Iterable<Key> keys() {
		Stack<Key> stack = new Stack<Key>();
		for (Node x = first; x != null; x = x.next)
			stack.push(x.key);
		return stack;
	}

	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("A", 3);
		st.put("B", 2);
		st.put("C", 1);

		System.out.println(st.get("A"));
		st.delete("A");
		System.out.println(st.size());// 2
		System.out.println(st.get("B"));// null

		for (String s : st.keys()) {
			System.out.print(s);
		}

	}

}
