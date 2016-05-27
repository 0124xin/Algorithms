package Num1_2_04;

/**
 * P211 T29
 * 
 * @author he
 *
 */

class PQ {
	private int maxPq[];// ����ɾ�����Ԫ�صĶ�
	private int minPq[];// ����ɾ����СԪ�صĶ�
	private int MaxN = 0;// max���е�Ԫ��
	private int MinN = 0;// min���е�Ԫ��

	private int max = -99999;// ����������Ԫ��
	private int min = 99999;// ��������С��Ԫ��

	public PQ(int maxN) {
		maxPq = new int[maxN + 1];
		minPq = new int[maxN + 1];
	}

	/**
	 * �ϸ�
	 * 
	 * @param k
	 *            Ϊ����
	 * @param a
	 *            Ϊָ������
	 * @param t
	 *            tΪtrueʱ����max�ѽ����ϸ�������t=falseʱ��min�ѽ����ϸ�����
	 */
	private void swim(int k, int a[], boolean t) {
		// ���Ԫ������index=1��λ��
		if (t == true) {
			while (k > 1 && less(k / 2, k, a)) {
				exch(k / 2, k, a);
				k = k / 2;
			}
		}

		// ��СԪ������index=1��λ��
		if (t == false) {
			while (k > 1 && !less(k / 2, k, a)) {
				exch(k / 2, k, a);
				k = k / 2;
			}
		}

	}

	/**
	 * �³�
	 * 
	 * @param k
	 *            Ϊ����
	 * @param a
	 *            Ϊָ������
	 * @param N
	 *            ָ����N
	 * @param t
	 *            tΪtrueʱ����max�ѽ����³�������t=falseʱ��min�ѽ����³�����
	 */
	private void sink(int k, int a[], int N, boolean t) {

		if (t == true) {
			while (2 * k <= N) {
				int j = 2 * k;
				if (j < N && less(j, j + 1, a)) {
					j++;
				}
				if (!less(k, j, a)) {
					break;
				}
				exch(k, j, a);
				k = j;
			}
		}

		if (t == false) {
			while (2 * k <= N) {
				int j = 2 * k;
				if (j < N && !less(j, j + 1, a)) {
					j++;
				}
				if (less(k, j, a)) {
					break;
				}
				exch(k, j, a);
				k = j;
			}
		}

	}

	private boolean less(int i, int j, int a[]) {
		return a[i] < a[j];
	}

	private void exch(int i, int j, int a[]) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public void insert(int v) {

		max = max < v ? v : max;
		min = min < v ? min : v;

		maxPq[++MaxN] = v;
		minPq[++MinN] = v;
		swim(MaxN, maxPq, true);
		swim(MinN, minPq, false);
	}

	// ɾ�����Ԫ��
	public int delMax() {
		int max = maxPq[1];
		exch(1, MaxN--, maxPq);
		maxPq[MaxN + 1] = -1;
		sink(1, maxPq, MaxN, true);
		return max;
	}

	// ɾ����СԪ��
	public int delMin() {
		int min = minPq[1];
		exch(1, MinN--, minPq);
		minPq[MinN + 1] = -1;
		sink(1, minPq, MinN, false);
		return min;
	}

	// �������Ԫ��
	public int max() {
		return max;
	}

	// ������СԪ��
	public int min() {
		return min;
	}

	public boolean maxisEmpty() {
		return MaxN == 0;
	}

	public boolean minisEmpty() {
		return MinN == 0;
	}

}

public class Num_2_04_29 {
	public static void main(String[] args) {
		PQ mPq = new PQ(10);
		for (int i = 0; i < 10; i++) {
			mPq.insert(i);
		}

		System.out.println("max: " + mPq.max() + " min: " + mPq.min());

		while (!mPq.maxisEmpty()) {
			System.out.println("delMax: " + mPq.delMax());
			System.out.println("delMin: " + mPq.delMin());
		}

		// while (!mPq.minisEmpty()) {
		// System.out.println("min: "+mPq.delMin());
		// }

	}
}
