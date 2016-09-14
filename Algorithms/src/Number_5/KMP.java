package Number_5;

/**
 * P501 �㷨 5.6 KMP�ַ��������㷨
 * args[0]:AACAA
 * args[1]:AABRAACADABRAACAADABRA
 * @author he
 *
 */
public class KMP {
	private String pat;// ����ģʽ
	private int[][] dfa;// ��������״̬�Զ���

	public KMP(String pat) {
		// ��ģʽ�ַ�������DFA������״̬�Զ�����
		this.pat = pat;
		int M = pat.length();
		int R = 256;// 8λASCII���ű���ַ�����
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;// ����ĸ��״̬Ϊ1
		// ÿ���ַ�dfa[][j]��¼״̬X
		for (int X = 0, j = 1; j < M; j++) {
			// ����dfa[][j]
			for (char c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];// ����ƥ��ʧ������µ�ֵ��״̬��
			dfa[pat.charAt(j)][j] = j + 1;// ����ƥ��ɹ����ֵ��״̬��
			X = dfa[pat.charAt(j)][X];// ��������״̬
		}

	}

	public int search(String txt) {
		int i, N = txt.length();
		int j, M = pat.length();

		for (i = 0, j = 0; i < N && j < M; i++)
			j = dfa[txt.charAt(i)][j];
		if (j == M)
			return i - M;// �ҵ�ƥ�䣨����ģʽ�ַ�����ĩβ��
		else
			return N;// δ�ҵ�ƥ�䣨�����ı��ַ�����ĩβ��

	}

	public static void main(String[] args) {
		String pat = args[0];
		String txt = args[1];
		KMP kmp = new KMP(pat);
		System.out.println("text:   " + txt);
		int offset = kmp.search(txt);
		System.out.print("pattern:");
		for (int i = 0; i < offset; i++)
			System.out.print(" ");
		System.out.println(pat);
	}

}
