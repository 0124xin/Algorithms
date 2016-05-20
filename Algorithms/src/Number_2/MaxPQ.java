package Number_2;

/**
 * P202 ���ڶѵ����ȶ���
 * 
 * @author he
 *
 */
public class MaxPQ<key extends Comparable<key>> {
	private key[] pq;
	private int N = 0;

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	public MaxPQ(int maxN) {
		pq = (key[]) new Comparable[maxN + 1];
	}

	/**
	 * �ϸ����ڲ����������ñ�֤�ѵ�������
	 * 
	 * @param k
	 */
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	/**
	 * �³�����ɾ�����Ԫ�غ���ã���֤������
	 * 
	 * @return
	 */

	private void sink(int k) {
		while (k * 2 <= N) {
			int i = 2 * k;
			// �ҵ��ӽ��������һ�����
			if (i < N && less(i, i + 1)) {
				i++;
			}
			// ����λ�����м�
			if (!less(k, i)) {
				break;
			}
			exch(k, i);
			k = i;
		}
	}

	public void insert(key v) {
		pq[++N] = v;
		swim(N);
	}

	public key delMax() {
		key max = pq[1];// �Ӹ��ڵ�õ�����Ԫ��
		exch(1, N--);// ��������һ��Ԫ�ؽ���
		pq[N + 1] = null;// ��ֹ��������
		sink(1);
		return max;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public static void main(String[] args) {
		MaxPQ<Integer> mPq = new MaxPQ<Integer>(10);
		mPq.insert(4);
		mPq.insert(100);
		mPq.insert(0);
		mPq.insert(99);

		while (!mPq.isEmpty()) {
			System.out.println(mPq.delMax());
		}
	}

}
