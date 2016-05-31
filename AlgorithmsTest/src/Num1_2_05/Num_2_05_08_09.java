package Num1_2_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * P224 T08 T09 ����ʹ��һ������ȴ�ɽ����ʹ��JAVA API
 * 
 * @author he
 *
 */

/**
 * �����Լ��ıȽ���
 * 
 * @author he
 *
 */

class myComparable implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o2.getValue().compareTo(o1.getValue());// �����ǰ���������
//		 return o1.getValue().compareTo(o2.getValue());//�����ǰ���������
	}
}

class Frequency {
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	private static List<Entry<String, Integer>> list;

	// ���ڵ�8��ķ���
	public static void put(String k) {

		if (map.get(k) == null) {
			map.put(k, 1);
		} else {
			map.put(k, map.get(k) + 1);
		}

	}

	// ���ڵ�9��ķ���
	public static void put(String k, Integer v) {
		map.put(k, v);
	}

	public static void sort() {
		list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());// ��map�ļ�ֵ��ӳ��浽list��
		Collections.sort(list, new myComparable());// ָ���Զ���Ƚ�����list����
		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}

public class Num_2_05_08_09 {
	public static void main(String[] args) {
		// Frequency.put("a");
		// Frequency.put("b");
		// Frequency.put("b");
		// Frequency.put("c");
		// Frequency.sort();

		Frequency.put("19-aug-40", 130000);
		Frequency.put("10-aug-42", 210000);
		Frequency.put("24-jul-40", 200000);
		Frequency.sort();
	}

}
