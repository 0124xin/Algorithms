package E01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��һ�鵥�ʣ����дһ���������������ҳ����������ַ�����ɵ���Ĵ�A����A��������������ɵ�(���ظ�)��ĵ��ʡ�
 * ����һ��string����str��ͬʱ��������Ĵ�Сn���뷵������ʵĳ��ȣ���֤��������������ʴ��ڡ� ����������
 * ["a","b","c","ab","bc","abc"],6 ���أ�3
 * ����ͨ��
 * 
 * @author he
 *
 */
public class LongestString {
	public static int getLongest(String[] str, int n) {
		//����������
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		String temp = str[--n];
		int i = 0;
		while (!check(str, temp, ++i)) {
			temp = str[--n];
			check(str, temp, ++i);
		}
		return temp.length();
	}

	//����ַ����Ƿ����Ҫ�󣬼�temp���������ڵ�Ԫ�����
	public static boolean check(String[] str, String temp, int count) {
		for (int i = str.length - count-1; i >=0 ; i--) {
			if (temp.contains(str[i])) {
				temp = temp.replace(str[i], "");// ȥ���Ѿ�������Ԫ��
				i = str.length - count-1;// ����
			}
		}
		if (temp.length() > 0)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {

		String str[] = { "fvcm", "kebh", "xro", "qk", "jalfoux", "zo", "k", "nil", "tjuy", "k", "pexi", "cznvz", "il",
				"lxqkke", "zom", "fvcmm", "lewvjw", "q", "vuns", "alfoux", "tjuyq", "xtotfmftjuy", "smhvoe", "vb",
				"vkf", "gwq", "npmavlz", "ebh", "xtotfmf", "j", "k", "n", "wtp", "smhvoeq", "dbgj", "m", "y", "avh",
				"zok", "xrofvcm", "p" };
		System.out.println(getLongest(str, 41));
	}

}
