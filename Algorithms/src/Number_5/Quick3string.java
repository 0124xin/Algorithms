package Number_5;

/**
 * P469 �㷨5.3 �����ַ����������� �ʺϺ��д�����ֵ�����нϳ�����ǰ׺�ļ���ȡֵ��Χ��С�ļ���С����
 * 
 * @author he
 *
 */
public class Quick3string {

	private static final int M = 0;// �з�����Ĵ�С

	public Quick3string() {
	}

	private static int chatAt(String s, int d) {
		if (d < s.length())
			return s.charAt(d);
		else
			return -1;
	}

	public static void sort(String a[]) {
		sort(a, 0, a.length - 1, 0);
	}

	private static void sort(String a[], int lo, int hi, int d) {
		// if (hi <= lo)
		// return;
		// ����С����ʹ�ò�������
		if (hi <= lo + M) {
			Insterion(a, lo, hi, d);
			return;
		}

		int lt = lo, gt = hi, i = lo + 1;
		int v = chatAt(a[lo], d);

		while (i <= gt) {
			int t = chatAt(a[i], d);
			if (t < v)
				exch(a, lt++, i++);
			else if (t > v)
				exch(a, i, gt--);
			else
				i++;
		}

		sort(a, lo, lt - 1, d);
		if (v > 0)
			sort(a, lo, hi, d+1);
		sort(a, gt + 1, hi, d);
	}

	// ��������
	private static void Insterion(String a[], int lo, int hi, int d) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > 0 && less(a[j], a[j - 1], d); j--)
				exch(a, j, j - 1);
	}

	private static boolean less(String s, String v, int d) {
		for (int i = d; i < Math.min(s.length(), v.length()); i++) {
			if (s.charAt(i) < v.charAt(i))
				return true;
			if (s.charAt(i) > v.charAt(i))
				return false;
		}
		return s.length() < v.length();
	}

	private static void exch(String a[], int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		String a[] = { "com.cnn", "edu.uva.cs", "edu.uva.cs", "com.google" };
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

	}

}
