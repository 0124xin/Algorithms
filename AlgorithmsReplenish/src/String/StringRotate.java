package String;

/**
 * �ַ�����ת�� ����һ���ַ��� abcdefgh,����ת3��λ�� ��Ϊ defghabc n=8,i=3 Ҫ��ռ���������ڴ�ռ�
 * 
 * ����˼·�� 
 * �� a[0]���浽һ����ʱ����t�� Ȼ���ƶ�a[i]��a[0]��a[2i]��a[i] 
 * a[1]���浽��ʱ����t �ƶ�a[i+1]��a[1]����������
 * 
 * 
 * @author he
 *
 */

public class StringRotate {
	public static String rotate(String text, int rotdist) {

		int n = text.length();
		int end = gcd(rotdist, n);
		char x[] = text.toCharArray();
		char t;
		int j;
		int k;

		// ѭ������
		for (int i = 0; i < end; i++) {
			t = x[i];
			j = i;
			while (true) {
				k = j + rotdist;
				if (k >= n) {
					k -= n;
				}
				if (k == i) {
					break;
				}
				x[j] = x[k];
				j = k;
			}
			x[j] = t;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x.length; i++) {
			sb.append(x[i]);
		}
		return sb.toString();
	}

	/**
	 * �����Լ������תrotdist��λ�ú�n�����Լ����������û�����
	 * 
	 * @param rotdist
	 * @param n
	 * @return
	 */
	private static int gcd(int rotdist, int n) {
		if (n == 0) {
			return rotdist;
		}
		int r = rotdist % n;
		
		return gcd(n, r);
	}

	public static void main(String[] args) {

		System.out.println(rotate("abcdefghigk", 3));

	}

}
