package Num1_1_05;

import java.util.HashSet;
import java.util.Set;

/**
 * P151 T18 
 * ��ȡ����û��Ҫ��Connetcion��ֻҪ����Set�Ϳ����ˣ�
 * �����Ҫ��Connection��Ҫд�ܶ�û�õĴ��룬Ч������һ����
 * 
 * @author he
 *
 */
class RandomGrid {
	private static Set<String> set = new HashSet<String>();

	public static String generate(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				set.add("(" + i + "," + j + ")");
			}
		}
		return set.toString();
	}
}

public class Num_1_05_18 {
	public static void main(String[] args) {
		System.out.println(RandomGrid.generate(2));
	}
}
