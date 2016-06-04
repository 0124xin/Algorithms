package Number_3;

import edu.princeton.cs.algs4.Queue;

/**
 * �㷨 3.1
 * P236 ˳����ң������������� ������ջ����ʽ������keys()���ص���put()������
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

	/**
	 * ���ݼ�ɾ��ָ����ֵ��
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (key == null) {
			throw new NullPointerException("key can't be null");
		}

		for (Node x = first; x.next != null; x = x.next) {
			if (x.next.key.equals(key)) {
				x.next.value = null;
				x.next = x.next.next;
				N--;
			}
		}
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (Node x = first; x != null; x = x.next)
			queue.enqueue(x.key);
		return queue;
	}

	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("A", 3);
		st.put("B", 2);
		st.put("C", 1);

		System.out.println(st.get("A"));
		st.delete("B");
		System.out.println(st.size());// 2
		System.out.println(st.get("B"));// null

		for (String s : st.keys()) {
			System.out.println(s);
		}

	}

}
