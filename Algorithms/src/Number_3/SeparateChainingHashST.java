package Number_3;

import edu.princeton.cs.algs4.Queue;

/**
 * P297 �㷨3.5 ������������ɢ�б�����֮ǰд��������ʵ�ֵ�������ű�,���鱣���������
 * 
 * @author he
 *
 */
public class SeparateChainingHashST<Key extends Comparable<Key>, Value> {
	private int N;// ��ֵ������
	private int M;// ɢ�б��С
	private SequentialSearchST<Key, Value>[] st;// ���������������

	public SeparateChainingHashST() {
		this(997);// 997Ϊ����
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int M) {
		// ����M������
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}

	// ���������±�
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	// ����ֵ����ӵ���Ӧ����λ�õ�������
	public void put(Key key, Value value) {
		if (key == null)
			throw new NullPointerException("key ����Ϊnull");
		int i = hash(key);
		if (!st[i].contains(key))
			N++;
		st[hash(key)].put(key, value);
	}

	public Value get(Key key) {
		return st[hash(key)].get(key);
	}

	public int size() {
		return N;
	}

	/**
	 * ɾ������
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		int i = hash(key);
		if (st[i].contains(key))
			N--;
		st[i].delete(key);
	}

	/**
	 * �������м�
	 * 
	 * @return
	 */
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		keys(queue);
		return queue;
	}

	private void keys(Queue<Key> queue) {
		for (int i = 0; i < M; i++) {
			for (Key key : st[i].keys()) {
				queue.enqueue(key);
			}
		}
	}

	public static void main(String[] args) {
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
		st.put("A", 1);
		st.put("B", 2);
		st.put("A", 3);
		st.put("D", 4);
		st.put("E", 5);
		System.out.println(st.get("A"));
		System.out.println(st.get("B"));
		st.delete("A");
		System.out.println(st.get("A"));
		System.out.println(st.size());
		System.out.println(st.keys());

	}

}
