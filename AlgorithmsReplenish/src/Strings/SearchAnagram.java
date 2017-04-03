package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * ���ұ�λ�ʣ��������ʺ��ֵ䣬����Ԥ���� ��λ�ʣ��絥�� deposit ��dopiest��posited��topside ��Ϊ��λ��
 * 
 * @author he
 * 
 * ˼·��
 *1�����ʵ��е�ÿ�����ʽ��б�ʶ�������ʰ�������ĸ˳�����򣩲����ֵ�����
 *2�������ʵı�ʶ����ĸ��Ӧ���� 
 *3������������ʵı�ʶ
 *4�����ö����������Ҹ������ʵı�λ��
 * 
 *         ������ֱ����HashMap
 *
 *
 */
public class SearchAnagram {

	private static final String[] dictionary = { "dopiest", "posited", "hello", "topside", "world", "make" };
	private static Map<String, List<String>> map = new HashMap<>();

	static {
		preprocess();
	}

	private static String find(String word) {
		String key = sort(word);
		String temp = "";
		for (String s : map.get(key)) {
			temp += s + " ";
		}
		return temp;
	}

	/**
	 * Ԥ����
	 */
	private static void preprocess() {
		for (int i = 0; i < dictionary.length; i++) {

			String key = sort(dictionary[i]);
			if (map.get(key) == null) {
				List<String> list = new ArrayList<>();
				list.add(dictionary[i]);
				map.put(key, list);
			} else {
				List<String> l = map.get(key);
				l.add(dictionary[i]);
				map.put(key, l);
			}

		}
	}

	private static String sort(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		String temp = "";
		for (int i = 0; i < a.length; i++) {
			temp += a[i];
		}
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(find("dopiest"));

	}

}
