package Numbe_1;

/**
 * �ж�һ���ַ����ǲ��ǻ��� P50
 * 
 * @author he
 *
 */
public class isPalindrome {
	public static boolean ispalindrome(String string) {
		int len = string.length();
		boolean b = false;
		for (int i = 0; i < len / 2; i++) {
			b = string.charAt(i) != string.charAt(len - 1 - i) ? false : true;
			// if (string.charAt(i) != string.charAt(len - 1 - i)) {
			// return false;
			// }
		}
		return b;
	}

	public static void main(String[] args) {

		System.out.println(ispalindrome("abcdcba"));
	}
}
