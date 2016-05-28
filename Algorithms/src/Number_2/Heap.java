package Number_2;

/**
 * P206 ������
 * 
 * @author he
 *
 */
public class Heap {
	public static void sort(Comparable[] a) {
		int N = a.length;
		// ���������
		for (int i = N / 2; i >= 1; i--) {
			sink(a, i, N);
		}

		// ����
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}

	}

	// �³�
	private static void sink(Comparable[] a, int i, int N) {
		while (2 * i <= N) {
			int j = 2 * i;
			if (j < N && less(a, j, j + 1)) {
				j++;
			}
			if (!less(a, i, j)) {
				break;
			}
			exch(a, i, j);
			i = j;
		}
	}

	/**
	 * exch() �� less () ��������һʵ��a[0]��a[N-1]����
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = temp;
	}

	private static boolean less(Comparable a[], int i, int j) {
		return a[i - 1].compareTo(a[j - 1]) < 0;
	}

	public static void show(Comparable a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		Integer a[] = { 1, 4, 5, 2, 6, 9, 7, 3, 8 };
		sort(a);
		show(a);
	}

}
