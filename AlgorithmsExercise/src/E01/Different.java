package E01;

/**
 * ƥ���ַ������ȫ����ͬ����true���������ͬ�ķ���false
 * 
 * @author he
 *
 */
public class Different {

	public static boolean check(String string) {
		//       \\i ���õ�i��������
		return !string.matches(".*(.)(.*\\1)");
	}

	public static void main(String[] args) {
		System.out.println(check("ADFFFFF"));
		System.out.println(check("asdfg"));
	}

}
