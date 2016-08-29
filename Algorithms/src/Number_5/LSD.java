package Number_5;

/**
 * P459 ��λ���ȵ��ַ������򣨴������ң��ʺϼ�������ͬ���ַ�����
 * 
 * @author he
 *
 */
public class LSD {
	public LSD() {
	}

	public static void sort(String[] a, int W) {
		// ͨ��ǰW���ַ���a[]����
		int N = a.length;
		String aux[] = new String[N];
		int R = 256;// ASCII�ַ������ַ�������8λ��ASCII�ַ���
		for (int d = W - 1; d >= 0; d--) {
			int count[] = new int[R + 1];

			// ͳ��Ƶ��
			for (int i = 0; i < N; i++)
				count[a[i].charAt(d) + 1]++;
			// ��Ƶ��ת��Ϊ����
			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];
			// ��Ԫ�ط���
			for (int i = 0; i < N; i++)
				aux[count[a[i].charAt(d)]++] = a[i];
			// ��д
			for (int i = 0; i < N; i++)
				a[i] = aux[i];
		}

	}

	public static void main(String[] args) {
		String a[] = { "4PGC938", "2IYE230", "3CIO720", "1ICK750", "1OHV845" };
		int W = 7;
		sort(a, W);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);

	}

}
