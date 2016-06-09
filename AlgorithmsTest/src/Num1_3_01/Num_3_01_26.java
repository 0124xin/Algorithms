package Num1_3_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * P248 T26
 * args:tinyTale.txt
 * @author he
 *
 */

/**
 * �Զ���Ƚ��������ڰ�value����
 * 
 * @author he
 *
 */
class myCom implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		Integer t1 = Integer.valueOf(o1.split("-->")[0]);//�зֻ�ȡƵ�ȣ���o1=10-->it�� ��ȡ 10
		Integer t2 = Integer.valueOf(o2.split("-->")[0]);//�зֻ�ȡƵ��
		return t2.compareTo(t1);// ����������
	}

}

class FrequencyCounter {
	private ST<String, Integer> st;
	private List<String> keyList = new ArrayList<String>();// ���ڱ���key
	private List<String> valList = new ArrayList<String>();// ���ڱ���value

	private void save(String path) {
		st = new ST<String, Integer>();
		In a = new In(path); // tinyTale.txt
		while (!a.isEmpty()) {
			String word = a.readString();
			if (!st.contains(word)) {
				st.put(word, 1);
			} else {
				st.put(word, st.get(word) + 1);
			}
		}
	}

	// ���ֵ�˳��
	public String keyTable(String path) {
		save(path);
		for (String s : st.keys()) {
			keyList.add(s + "-->" + st.get(s) + "\n");
		}
		return keyList.toString();
	}

	// ��Ƶ��˳��
	public String valTable(String path) {
		save(path);
		for (String s : st.keys()) {
			valList.add(st.get(s) + "-->" + s + "\n");
			Collections.sort(valList, new myCom());// ����,ָ���Ƚ���
		}
		return valList.toString();
	}

}

public class Num_3_01_26 {
	public static void main(String[] args) {
		String path = args[0];// tinyTale.txt;
		FrequencyCounter f = new FrequencyCounter();
		System.out.println("���ֵ�����"+f.keyTable(path));
		System.out.println("----------------");
		System.out.println("��Ƶ������ "+f.valTable(path));
	}
}
