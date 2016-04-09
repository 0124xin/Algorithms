package Num1_1_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * P132 T8 ��HashMap�������ݣ� 1��1��1 ��һ��1�� 1��1��1��1 ������1
 * 
 * ����ö��ֲ��ұ���Ҫ�޸Ķ��ֲ��ҵ�first�±�ֵ����Ȼ�������ҵ�key���±�Ϊԭ�����±�
 * 
 * @author he
 *
 */
public class Num_1_04_08 {
	public static void count(int a[]) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (map.get(a[i]) == null) {
				map.put(a[i], 1);
			} else {
				map.put(a[i], map.get(a[i]) + 1);
			}
		}
		Set<Integer> set = map.keySet();
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			int i = iterator.next();
			System.out.println(i + " ��" + (map.get(i) / 2) + " ��");
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 1, 2, 1, 1 };
		count(a); // 1 ��2 �� ��2 ��1 �� ��3 ��0 ��
	}

}
