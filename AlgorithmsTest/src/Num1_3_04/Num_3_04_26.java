package Num1_3_04;

import edu.princeton.cs.algs4.Queue;

/**
 * P310 T26 ˼·����ʱɾ����Ҫ��֤���ܷ�����ײ����ײ�����ݣ�������ɾ��ʱ��ɾ���������Ԫ�ؾͲ������²���ɢ�б� ͬʱ������ʱ����M
 * 
 * @author he
 *
 */

class LiearPHST<Key, Value> {
	private final static int CAP = 2;// ��ʼMֵ
	private static int k = 1;// 2���ݴ�,�������� ���򴴽��¶���ᱻ����
	private final static int[] primes = { 0, 0, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191 };// С��2��k�η����������

	private int N;
	private int M;// ɢ�б��С
	private Key keys[];
	private Value var[];

	public LiearPHST() {
		this(CAP);
	}

	@SuppressWarnings("unchecked")
	public LiearPHST(int cap) {
		this.M = cap;
		keys = (Key[]) new Object[M];
		var = (Value[]) new Object[M];
	}

	private boolean contains(Key key) {
		return get(key) != null;
	}

	private void resize(int cap) {
		LiearPHST<Key, Value> temp = new LiearPHST<Key, Value>(cap);
		for (int i = 0; i < M; i++) {
			if (keys[i] != null)
				temp.put(keys[i], var[i]);
		}
		M = temp.M;
		keys = temp.keys;
		var = temp.var;

	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public void put(Key key, Value value) {

		int i = hash(key);
		// ������ײ������
		if (var[i] != null && !keys[i].equals(key)) {
			resize(primes[++k]);
		}

		if (keys[i] != null && keys[i].equals(key)) {
			var[i] = value;
			return;
		}

		keys[i] = key;
		var[i] = value;
		N++;
	}

	public Value get(Key key) {
		int i = hash(key);
		return var[i];
	}

	public void delete(Key key) {
		if (!contains(key))
			return;
		int i = hash(key);
		keys[i] = null;
		var[i] = null;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		keys(queue);
		return queue;
	}

	private void keys(Queue<Key> queue) {
		for (int i = 0; i < M; i++) {
			if (keys[i] != null)
				queue.enqueue(keys[i]);
		}

	}

}

public class Num_3_04_26 {
	public static void main(String[] args) {
		LiearPHST<String, Integer> st = new LiearPHST<String, Integer>();
		st.put("S", 0);
		st.put("E", 1);
		st.put("A", 3);
		st.put("R", 3);
		st.put("H", 4);
		st.put("E", 5);
		st.put("C", 6);
		 System.out.println(st.get("A"));
		 System.out.println(st.get("H"));
		 System.out.println(st.get("E"));
		 System.out.println(st.keys());
		 st.delete("C");
		 st.delete("E");
		 System.out.println(st.keys());
	}

}
