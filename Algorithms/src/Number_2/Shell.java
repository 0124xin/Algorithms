package Number_2;

/**
 * P163 ϣ������
 * 
 * @author he
 *
 */
public class Shell {
	// ����
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				// ��a[i]���뵽a[i-h],a[i-2*h],....��
				for (int j = i; j - h >= 0 && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;// ��Сh�ķ�Χ
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
		Integer a[] = { 2, 3, 4, 1, 55, 6, 3, 6, 7 };
		sort(a);
		System.out.println(isShorted(a));
		show(a);
	}

}
