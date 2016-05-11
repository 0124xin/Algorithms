package Number_2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P182 ��������
 * 
 * @author he
 *
 */
public class Quick {
	// ����������з�
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;// ����ɨ��ָ��
		Comparable v = a[lo];// �з�Ԫ��
		while (true) {
			// ���a[i]С��vʱ������i
			while (less(a[++i], v)) {
				if (i == hi)
					break;
			}
			// ���a[j]����vʱ����Сj
			while (less(v, a[--j])) {
				// ��ȥ�� �����
				// if (j == lo)
				// break;
			}

			if (i >= j) {
				break;
			}
			exch(a, i, j);// ����i,j��λ��
		}

		exch(a, lo, j);// ��v=a[j]������ȷ��λ��
		return j;
	}

	// ����
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);// ���������,���������������
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);// �з�
		sort(a, lo, j - 1);// �������
		sort(a, j + 1, hi);// �ұ�����

	}

	// Ԫ��֮����бȽ�
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0; // ���v<w��Ϊtrue
	}

	// ����Ԫ��λ��
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// �����д�ӡ����
	public static void show(Comparable a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// ���������Ƿ�����
	public static boolean isShorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = { "A", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		sort(a);
		assert isShorted(a);// ���� ��ֹ���������ѭ������ϵͳ����
		show(a);
		System.out.println(isShorted(a));
	}
}
