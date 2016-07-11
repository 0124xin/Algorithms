package Number_3;

import java.awt.RenderingHints.Key;

import edu.princeton.cs.algs4.Queue;

/**
 * P301 �㷨3.6 ��������̽��ķ��ű� M>N,����ϴ������,ʹ�������������飬һ������keyһ������value
 * 
 * @author he
 *
 */
public class LinearProbingHashST<Key, Value> {
	private int N;// ���ű��м�ֵ�Ե�����
	private int M = 16;// ���ű�Ĵ�С
	private Key[] keys;// ����key
	private Value[] values;// �洢value

	@SuppressWarnings("unchecked")
	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}

	// ��������
	private void resize(int cap) {

	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public void put(Key key, Value value) {
		if (N >= M / 2)
			resize(2 * M);
		int i;
		// �������������index�� 1
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}

	public Value get(Key key) {
		if (key == null)
			throw new NullPointerException();
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key))
				return values[i];
		}
		return null;
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

	public static void main(String[] args) {
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
		st.put("S", 0);
		st.put("E", 1);
		st.put("A", 2);
		st.put("R", 3);
		st.put("H", 4);
		st.put("E", 5);
		System.out.println(st.get("A"));
		System.out.println(st.get("H"));
		System.out.println(st.get("E"));
		System.out.println(st.keys());

	}

}
