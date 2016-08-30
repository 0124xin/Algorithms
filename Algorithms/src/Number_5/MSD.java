package Number_5;

/**
 * P462 �㷨5.2 ��λ���ȵ��ַ������򣨴������ң��ַ������Ȳ�һ����ͬ��
 * 
 * @author he
 *
 */
public class MSD {
	private static int R = 256;// 8ΪASCII���е��ַ�����
	private static final int M = 15;// С������з�
	private static String aux[];// ��������

	public MSD() {

	}

	private static int charAt(String s, int d) {
		if (d < s.length())
			return s.charAt(d);
		else {
			return -1;
		}
	}

	public static void sort(String a[]) {
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N - 1, 0);
	}

	private static void sort(String a[], int lo, int hi, int d) {
		// ����С��һ�����ȵ�������в�������
		if (hi <= lo + M) {
			insertion(a, lo, hi, d);
			return;
		}

		int count[] = new int[R + 2];// count[0]�����涫����count[1]������ǳ��Ȳ�����d���ַ�������
		// ����Ƶ��
		for (int i = lo; i <= hi; i++) {
			int t = charAt(a[i], d);
			count[t + 2]++;
		}

		// ת��Ϊ����
		for (int r = 0; r < R + 1; r++)
			count[r + 1] += count[r];

		// ����
		for (int i = lo; i <= hi; i++) {
			int t = charAt(a[i], d);
			aux[count[t + 1]++] = a[i];
		}

		for (int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];

		// �ݹ���ÿ���ַ�Ϊ����������,���￴����
		for (int r = 0; r < R; r++)
			sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);

	}

	private static void insertion(String a[], int lo, int hi, int d) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
				exch(a, j, j - 1);
	}

	private static boolean less(String w, String v, int d) {
		for (int i = d; i < Math.min(w.length(), v.length()); i++) {
			if (w.charAt(i) < v.charAt(i))
				return true;
			if (w.charAt(i) > v.charAt(i)) {
				return false;
			}
		}

		return w.length() < v.length();
	}

	private static void exch(String a[], int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		String[] a = { "by", "are", "seashells", "seashells", "sells" };
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

	}

}
