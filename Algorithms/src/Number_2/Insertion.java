package Number_2;

/**
 * P157 ��������
 * 
 * @author he
 *
 */
public class Insertion {
	// ����
	public static void sort(Comparable[] a) {
		// ��a[]����������
		int N = a.length;
		for (int i = 1; i < N; i++) {
			/**
			 * ��a[i]���뵽a[i-1] a[i-2] a[i-3]֮��
			 * ���a[j]<a[j-1],�򽻻�λ�ã���ʱa[j]�е�Ԫ�ظ���a[j-1]���ٽ�a[j-1]��a[j-2]�Ƚϣ�����ظ���
			 * ֱ����СԪ�ص��������
			 */

			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
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
		Integer a[] = { 2, 3, 4, 1, 55, 6, 3, 6, 7, 8 };
		sort(a);
		System.out.println(isShorted(a));
		show(a);
	}
}
