package Number_3;

import edu.princeton.cs.algs4.In;

/**
 * P234 ���ű������ 
 * ʹ�������в�����ȡ�ļ�
 * args:1 tinyTale.txt
 * @author he
 *
 */
public class FrequencyCounter {
	public static void main(String[] args) {
		int minlen = Integer.valueOf(args[0]);// ������С���� ,1
		ST<String, Integer> st = new ST<String, Integer>();
		In a = new In(args[1]); // tinyTale.txt
		while (!a.isEmpty()) {
			String word = a.readString();
			if (word.length() < minlen) {
				continue;
			}
			if (!st.contains(word)) {
				st.put(word, 1);
			} else {
				st.put(word, st.get(word) + 1);
			}

		}
		String max = " ";
		st.put(max, 0);
		for (String word : st.key()) {
			if (st.get(word) > st.get(max)) {
				max = word;
			}
		}
		System.out.println(max + " " + st.get(max));//it 10

	}
}
