package Num1_3_01;

import edu.princeton.cs.algs4.Merge;

/**
 * P247 T12 
 * ��һ��ʵ���ౣ���-ֵ�� ʹ�ù鲢�����ԭ�򣺹鲢�������ȶ����򣬼���P218
 * 
 * @author he
 *
 */

class BinarySearchST2<Key extends Comparable<Key>, Value> {

	private Item[] temp;// ���ڱ����ֵ��
	private Item[] t;// ����������Ϊ�鲢������������ȫ����ֵ,�����ָ���쳣
	private int N = 0;// �����ֵ�Ե�����

	public BinarySearchST2() {
		temp = new Item[100000];
	}

	private void Merge(Item[] temp) {
		t = new Item[N];
		for (int i = 0; i < N; i++) {
			t[i] = temp[i];
		}
		Merge.sort(t);
	}

	@SuppressWarnings("hiding")
	private class Item<Key extends Comparable<Key>, Value> implements Comparable<Key> {
		Key key;
		Value value;

		public Item(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Key o) {
			return o.compareTo(this.key);
		}

	}

	@SuppressWarnings("unchecked")
	public void put(Key key, Value value) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		if (rank(key) != -1) {
			temp[rank(key)].value = value;
		} else {
			temp[N++] = new Item<Key, Value>(key, value);
		}

	}

	@SuppressWarnings("unchecked")
	public Value get(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		if (isEmpty()) {
			return null;
		}

		if (rank(key) != -1) {
			return (Value) temp[rank(key)].value;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Key min() {
		Merge(temp);
		return (Key) t[0].key;
	}

	@SuppressWarnings("unchecked")
	public Key max() {
		Merge(temp);
		return (Key) t[N - 1].key;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	// �������
	public Key select(int k) {
		if (k >= N) {
			throw new NullPointerException();
		}
		Merge(temp);
		return (Key) t[k].key;
	}

	public void delete(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		int i = rank(key);
		// ������key
		if (i == N || temp[i].key.compareTo(key) != 0) {
			return;
		}
		for (int j = i; j < N - 1; j++) {
			temp[j] = temp[j + 1];
		}
		temp[N - 1] = null;
		N--;
	}

	// �������鷵��index
	private int rank(Key key) {
		for (int i = 0; i < N; i++) {
			if (temp[i].key.equals(key)) {
				return i;
			}
		}
		return -1;
	}

}

public class Num_3_01_12 {
	public static void main(String[] args) {
		BinarySearchST2<String, Integer> st = new BinarySearchST2<String, Integer>();
		st.put("D", 1);
		st.put("C", 2);
		st.put("B", 3);
		st.put("B", 100);
		System.out.println(st.select(0));// B
		System.out.println(st.get("B"));// 100
		System.out.println(st.min());// B
		System.out.println(st.max());// D
		st.delete("C");
		System.out.println(st.get("C"));// null

	}

}
