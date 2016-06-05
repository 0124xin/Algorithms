package Number_3;

/**
 * P239 �㷨3.2 ���ֲ��ң������������飩
 * 
 * @author he
 *
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key keys[];
	private Value values[];
	private int N = 0;// Ԫ������

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	/**
	 * ����Key���ض�Ӧ��Value
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		if (isEmpty()) {
			return null;
		}

		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			return values[i];
		} else {
			return null;
		}

	}

	/**
	 * ���ֲ��ң�������ڷ��ؼ���index����������ڷ���С�����ļ�������,��Ϊlo�ڵ���ʱ�ı�
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int t = key.compareTo(keys[mid]);
			if (t > 0) {
				lo = mid + 1;
			} else if (t < 0) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return lo;
	}

	/**
	 * ����ű�����Ӽ�ֵ��
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}

		int i = rank(key);
		// ���У��Ѵ��ڣ�����
		if (i < N && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}

		// δ�������,��ʱ���������

		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}

	/**
	 * ����keyɾ����ֵ�� ���ü�����ļ�ǰ��
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		if (key == null) {
			throw new RuntimeException("key can't be null");
		}
		int i = rank(key);
		for (int j = i; j < N - 1; j++) {
			keys[j] = keys[j + 1];
			values[j] = values[j + 1];
		}
		keys[N - 1] = null;
		values[N - 1] = null;
		N--;

	}

	// ������С��
	public Key min() {
		return keys[0];
	}

	public Key max() {
		return keys[N - 1];
	}

	/**
	 * �����±���key
	 * 
	 * @param k
	 *            �±�
	 * @return
	 */
	public Key select(int k) {
		return keys[k];
	}

	/**
	 * ���ڵ��ڸü�����С��
	 * 
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		// ��Ϊrank���˴������Լ�ʹδ�ҵ�key���ܷ��ظպñ�key���index
		int i = rank(key);
		return keys[i];

	}

	/**
	 * С�ڵ��ڸü�������
	 * 
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		// �иü�
		if (get(key) != null) {
			return keys[rank(key)];
		} else if (get(key) == null && rank(key) != 0) {// �����ڸü���rank(key)�������������
			return keys[rank(key) - 1];
		} else {
			return null;
		}

	}

	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(10);
		st.put("A", 3);
		st.put("B", 2);
		st.put("C", 1);
		System.out.println(st.get("B"));
		System.out.println(st.ceiling("D"));// null
		st.delete("A");
		System.out.println(st.get("A"));// null
		System.out.println(st.floor("A"));// null

	}

}
