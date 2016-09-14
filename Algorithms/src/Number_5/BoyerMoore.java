package Number_5;

/**
 * P504 �㷨5.7 Boyer-Moore�ַ���ƥ���㷨������ʽ�ش���ƥ����ַ��� ��������ɨ��ģʽ�ַ��������Լ���
 * args[0]:AACAA
 * args[1]:AABRAACADABRAACAADABRA
 * @author he
 *
 */
public class BoyerMoore {
	private int right[];
	private String pat;

	public BoyerMoore(String pat) {
		this.pat = pat;
		int R = 256;// ��λASCII�ַ����Ӧ���ַ�����
		int M = pat.length();
		right = new int[R];

		for (char c = 0; c < R; c++)
			right[c] = -1; // �ı��в�������ģʽ�ַ����е��ַ���Ϊ-1��ԭ���skip=j-right[txt.charAt(i+j)]��ע��
		for (int j = 0; j < M; j++)
			right[pat.charAt(j)] = j;// ������ģʽ�ַ����е��ַ���ֵΪ����ģʽ�г��ֵ�����λ��,skip=j-right[txt.charAt(i+j)]�����skip<1�����
	}

	public int search(String txt) {
		int i, N = txt.length();
		int j, M = pat.length();
		int skip;
		for (i = 0; i < N - M; i += skip) {
			skip = 0;
			for (j = M - 1; j >= 0; j--) {
				if (txt.charAt(i + j) != pat.charAt(j)) {
					/**
					 * ���right[index]=-1��skip=j+1,��i+skip�ĺ�������ı����������ң���������ģʽ�ȳ����ֶ�
					 */
					skip = j - right[txt.charAt(i + j)];
					/**
					 * skip<1��������ǰj��Ӧ��ֵС��j��Ӧ���ַ���ģʽ�г��ֵ����ұߵ�λ�ã�index������ʱi=i+1,
					 * �ı�����һλ
					 */
					if (skip < 1)
						skip = 1;

				}

			}

			if (skip == 0)
				return i; // �ҵ�ƥ��

		}
		return N;// δ�ҵ�ƥ��
	}

	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		BoyerMoore kmp = new BoyerMoore(pat);
		System.out.println("text:   " + txt);
		int offset = kmp.search(txt);
		System.out.print("pattern:");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pat);
	}

}
