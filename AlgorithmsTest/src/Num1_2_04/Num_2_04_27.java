package Num1_2_04;

/**
 * P211 T27
 * 
 * @author he
 *
 */

class MaxPQ {
	private int a[];
	private int N = 0;
	private int min = 10000000;

	public MaxPQ(int maxN) {
		a = new int[maxN + 1];
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
			// ����λ�����м�
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	public void insert(int v) {
		min = v < min ? v : min;//�ҵ�min
		a[++N] = v;
		swim(N);
	}

	public int delMax() {
		int max = a[1];
		exch(1, N--);
		sink(1);
		return max;

	}

	public int min() {
		return min;
	}

	private boolean less(int i, int j) {
		return a[i] < a[j];
	}

	private void exch(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void show() {
		for (int i = 1; i <= N; i++) {
			System.out.println(a[i]);
		}
	}

}

public class Num_2_04_27 {

	public static void main(String[] args) {
		MaxPQ mPq = new MaxPQ(16);
		for (int i = 16; i > 0; i--) {
			mPq.insert(i);
		}
		// mPq.show();
		System.out.println("min: " + mPq.min());// 1
		while (!mPq.isEmpty()) {
			System.out.println(mPq.delMax());
		}

	}
}
