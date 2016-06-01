package Num1_2_05;

import java.util.ArrayList;
import java.util.List;

/**
 * P225 T15
 * 
 * @author he ÿ������֮���ÿո�" "���� ��������ͬ�������ʼ���ַ�鵽һ��
 * 
 */

public class Num_2_05_15 {
	private static List<String> list = new ArrayList<String>();

	// ��ȡ��������
	public static String counterfeit(String s) {
		String temp[] = s.split("\\ ");
		return same(temp);
	}

	// �ҳ���ͬ��������������һ��
	public static String same(String[] temp) {
		int N = temp.length;
		for (int i = 0; i < N; i++) {
			String t[] = temp[i].split("@");
			String domain = t[1];// ��ȡ����

			if (!list.contains(temp[i])) {
				list.add(temp[i]);// ���ʼ���ַ��ӵ�list
			}

			for (int j = i + 1; j < N; j++) {
				String t2[] = temp[j].split("@");
				String d = t2[1];// ��ȡ����
				// ���ظ���ӵ�list
				if (d.equals(domain) && !list.contains(temp[j])) {
					list.add(temp[j]);
					list.add("\n");
				}
			}
		}
		return list.toString();

	}

	public static void main(String[] args) {
		String s = "wayne@cs.princeton.edu wayne@cxx.princeton.edu "
				+ "rs@cs.princeton.edu wayne@csss.princeton.edu"
				+ " wa@cxx.princeton.edu";
		System.out.println(counterfeit(s));
	}

}
