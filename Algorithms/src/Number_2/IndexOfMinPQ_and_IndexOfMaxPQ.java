package Number_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * ���������� �������ȶ��� P203
 * 
 * @author he
 *
 */
public class IndexOfMinPQ_and_IndexOfMaxPQ<Key extends Comparable<Key>> {
	private int N = 0;// PQ�е�Ԫ������
	private int[] pq;// ��������ѣ���1��ʼ
	private int[] qp;// ���� qp[pq[i]]=pq[qp[i]]=i
						// qp�����pqֵ����������Ҫ����pq�����������change()
	private Key[] keys;// �����ȼ�֮�ֵ�Ԫ��

	@SuppressWarnings("unchecked")
	public IndexOfMinPQ_and_IndexOfMaxPQ(int maxN) {
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for (int i = 0; i <= maxN; i++) {
			qp[i] = -1;
		}
	}

	// �ϸ�
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	// �³�
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1)) {
				j++;
			}

			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}

	}

	/**
	 * ����һ��Ԫ�ؽ���������k�����
	 * 
	 * @param k
	 * @param key
	 */
	public void insert(int k, Key key) {
		N++;
		pq[N] = k;// pq��index=N ��ֵΪk
		qp[k] = N;// qp��index=k ��ֵΪN
		keys[k] = key;
		swim(N);
	}

	/**
	 * ������СԪ��
	 * 
	 * @return
	 */
	public Key min() {
		return keys[pq[1]];
	}

	/**
	 * ɾ����СԪ�ز���������
	 * 
	 * @return
	 */
	public int delMin() {
		int indexOfMin = pq[1];
		exch(1, N--);// ����Сindex��ĩβ����
		sink(1);
		keys[pq[N + 1]] = null;// ��ֹ��������
		qp[pq[N + 1]] = -1;// �������
		return indexOfMin;
	}

	/**
	 * ������СԪ�ض�Ӧ��index
	 * 
	 * @return
	 */
	public int minIndex() {
		return pq[1];
	}

	/**
	 * ������k��Ԫ������Ϊkey
	 * 
	 * @return
	 */

	public void change(int k, Key key) {
		keys[k] = key;
		// ͨ��qp�ҵ���pq��k��Ӧ��N����ִ����Ӧ����
		swim(qp[k]);
		sink(qp[k]);
	}

	/**
	 * ɾ������Ϊk��Ԫ��
	 * 
	 * @return
	 */
	public void delete(int k) {
		int index = qp[k];
		exch(index, N--);
		swim(index);
		sink(index);
		keys[k] = null;
		qp[k] = -1;

	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean contains(int k) {
		return qp[k] != -1;
	}

	public int size() {
		return N;
	}

	/**
	 * ʹkeys[] ���������У����Ӧ���Ƴ���СԪ��
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	private boolean less(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}

	/**
	 * ʹkeys[] �������������Ӧ�������ɾ�����Ԫ�� �� IndexMaxPQ ֻ��Ҫ�Ķ��˴�����
	 * 
	 * @param i
	 * @param j
	 * @return
	 */

	// private boolean less(int i, int j) {
	// return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	// }

	
	private void exch(int i, int j) {
		//pq[]�����е�pq[i]��pq[j]����
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
		//ͬʱ����qp[]����,��֤qp[]��pq[]������
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	public static void main(String[] args) {
		String a[] = { "A","X","Z","C","B","E" };
		IndexOfMinPQ_and_IndexOfMaxPQ<String> pq = new IndexOfMinPQ_and_IndexOfMaxPQ<String>(a.length);
		for (int i = 0; i < a.length; i++) {
			pq.insert(i, a[i]);
		}
		System.out.println(pq.min());
		// ɾ����СԪ�أ������СԪ�ض�Ӧ���±��Ԫ��
		while (!pq.isEmpty()) {
			int i = pq.delMin();
			StdOut.println(i + " " + a[i]);
		}

	}
}
