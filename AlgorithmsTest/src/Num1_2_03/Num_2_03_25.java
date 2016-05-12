package Num1_2_03;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

/**
 * P193 T25
 * 
 * @author he
 *
 */
class QuickInsetion {
	private static final int M = 8;// �����鳤��Ϊ8��Ϊ����

	public static void sort(Comparable a[]) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);

	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo + M) {
			Insertion.sort(a);// ����С����ʹ�ò�������
			return;
		}
		int j = part(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int part(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable temp = a[lo];
		while (true) {
			while (less(a[++i], temp)) {
				if (i == hi)
					break;
			}
			while (less(temp, a[--j])) {
			}
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, i);// ���j����i��һ���ģ�ָ����ײi=j
		return j;
	}

	// Ԫ��֮����бȽ�
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0; // ���v<w��Ϊtrue
	}

	// ����Ԫ��λ��
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void show(Comparable a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}

public class Num_2_03_25 {
	public static void main(String[] args) {
		Integer a[]={2,3,4,5,9,6,7,8,1};
		QuickInsetion.sort(a);
		QuickInsetion.show(a);
	}

}
