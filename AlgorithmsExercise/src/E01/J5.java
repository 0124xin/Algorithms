package E01;

/**
 * �ַ���ѹ���������ַ����ظ����ֵĴ��� �� aabcccccaaa ѹ��Ϊ a2bc5a3 ���ѹ������ַ�������ԭ����ͬ�� ��ѹ��
 * 
 * @author he
 *
 */
public class J5 {
	public static String zipString(String s) {

		char a[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		char ss = a[0];
		int count = 1;
		sb.append(ss);
		for (int i = 1; i < a.length; i++) {
			if (ss == a[i]) {
				++count;
			} else {
				sb.append(count);
				count = 1;
				sb.append(a[i]);
				ss = a[i];
			}
		}
		// �����һ���ַ��ĸ����ӵ�sb
		sb.append(count);
		// ���ѹ������ַ�������ԭ����ͬ�� ��ѹ��
		if (sb.length() == s.length()) {
			return s;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(zipString("aaee"));
		System.out.println(zipString("aarrrrrsssssssffff"));
	}

}
