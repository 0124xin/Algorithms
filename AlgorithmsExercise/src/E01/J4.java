package E01;

/**
 * ���ַ����еĿո��滻Ϊ%20
 * 
 * @author he
 *
 */
public class J4 {
	public static String change(String s) {
		StringBuilder sb = new StringBuilder();
		char a[] = s.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == ' ') {
				sb.append("%20");
			} else {
				sb.append(a[i]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(change("A   D  FF  D"));
	}

}
