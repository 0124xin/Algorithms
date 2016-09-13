package Number_5;

/**
 * P494 �������ַ�������
 * 
 * @author he
 *
 */
public class Search {
	/**
	 * δƥ�䵽����txt.length 
	 * ƥ�䵽����ģʽpat������ĸ��txt�ж�Ӧ��index
	 * 
	 * @param txt
	 *            �ı�
	 * @param pat
	 *            ƥ��ģʽ
	 * @return
	 */
	public static int search(String txt, String pat) {
		int N = txt.length();
		int M = pat.length();
		for (int i = 0; i <= N - M; i++) {
			int j;
			for (j = 0; j < M; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == M)
				return i;// �ҵ�ƥ��
		}
		return N;// δ�ҵ�ƥ��
	}

	/**
	 * �������ַ�ƥ���㷨����һ��ʵ�֣���ʽ���ˣ�
	 *  δƥ�䵽����txt.length 
	 *  ƥ�䵽����ģʽpat������ĸ��txt�ж�Ӧ��index
	 * 
	 * @param txt
	 * @param pat
	 * @return
	 */
	public static int search2(String txt, String pat) {
		int j, M = pat.length();
		int i, N = txt.length();
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (txt.charAt(i) == pat.charAt(j))
				j++;
			else {
				i -= j;// ����
				j = 0;// ����
			}
		}
		if (j == M)
			return i - M;// �ҵ�ƥ��
		else
			return N;// δ�ҵ�ƥ��
	}

	public static void main(String[] args) {
		System.out.println(search2("ABACADABRAC", "ABRA"));
	}

}
