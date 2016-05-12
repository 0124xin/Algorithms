package Number_2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * P189 �����зֵĿ�������
 * 
 * �������Ϊ�����֣�С�ڡ����ڡ������з�Ԫ�ص�����Ԫ�أ�
 *  ά��һ��ָ��ltʹ��a[lo...lt-1]�е�Ԫ�ض�С��v��
 * һ��ָ��gtʹ��a[gt+1...hi]�����е�Ԫ�ض�����v 
 * һ��ָ��iʹ��a[lt...i-1]�е�Ԫ�ض�����v 
 * a[i...gt]�е�Ԫ��δȷ��
 * 
 * @author he
 *
 *         �����зִ���������£� 
 *         1��a[i]С��v����a[lt]��a[i]��������lt��i��һ
 *         2��a[i]����v����a[gt]��a[i]��������gt��һ 
 *         3��a[i]����v����i��һ
 *
 *
 */
public class Quick3way {
	// ����
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);// ���������,���������������
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0)
				exch(a, i++, lt++);
			else if (cmp > 0)
				exch(a, i, gt--);
			else
				i++;
		}

		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);

	}

	// ����Ԫ��λ��
	private static void exch(Comparable[] a, int i, int j) {
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
	
	public static void main(String[] args) {
//		String[] a = { "A", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		Integer a[] = { 1,1,2,2,2,2,2,2,3,4,99,5,6,7 };
		sort(a);
		show(a);
	}

}
